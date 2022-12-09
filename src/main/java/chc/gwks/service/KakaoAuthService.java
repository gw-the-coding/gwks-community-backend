package chc.gwks.service;

import chc.gwks.code.AuthorizationCode;
import chc.gwks.code.CommunityCode;
import chc.gwks.code.Platform;
import chc.gwks.code.UserState;
import chc.gwks.entity.Users;
import chc.gwks.payload.request.KakaoAuthorizationRequest;
import chc.gwks.payload.response.KakaoUserInfoResponse;
import chc.gwks.payload.response.KakaoUserTokenResponse;
import chc.gwks.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class KakaoAuthService {

    private UsersRepository usersRepository;

    @Autowired
    public KakaoAuthService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    private final static String KAKAO_AUTH_URL = "https://kauth.kakao.com/oauth";

    public Long getUserProfile(KakaoAuthorizationRequest request) throws JSONException {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        LinkedMultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id","5c7fe0d39ddd530bb8c5588ef3c1452a");
        params.add("redirect_uri", "http://localhost:8080/api/v1/accounts/kakao/");
        params.add("client_secret", "IwKQJvbH6UN40GOyG6VWSCKrPVBcIUic");
        params.add("code", request.getCode());

        HttpEntity httpEntity = new HttpEntity(params, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<KakaoUserTokenResponse> exchange = restTemplate.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                httpEntity,
                KakaoUserTokenResponse.class
        );
        String accessToken = exchange.getBody().getAccess_token();

        //-------------------------------------------------------------------

        HttpHeaders header = new HttpHeaders();
        header.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
        header.add("Authorization", "Bearer "+accessToken);

        HttpEntity reqHeader = new HttpEntity(null, header);
        ResponseEntity<KakaoUserInfoResponse> getUserData = restTemplate.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                reqHeader,
                KakaoUserInfoResponse.class
        );
        KakaoUserInfoResponse body = getUserData.getBody();
        String userEmail = body.getKakao_account().getEmail();
        Users userVerify = this.usersRepository.findByEmail(userEmail);
        if (userVerify == null) {
            Users newUsers = Users.creator()
                    .email(userEmail)
                    .profileImage(body.getProperties().getProfile_image())
                    .name(null)
                    .nickName(null)
                    .birthyear(null)
                    .platform(Platform.KAKAO)
                    .authority(AuthorizationCode.USER)
                    .community(CommunityCode.NOT_YET)
                    .state(UserState.BEFORE_SIGN)
                    .build();
            userVerify = this.usersRepository.save(newUsers);
        }
        return userVerify.getUserSysId();


        // 1. 이메일을 기준으로 검색해본다.
        // 2. 이메일이 존재할 시에 계정이 있는 사람으로 간주한다.
        // 2-1. 이메일이 있어도 상태값에 따라서 회원가입을 마쳤는지를 검사한다.



    }

}
