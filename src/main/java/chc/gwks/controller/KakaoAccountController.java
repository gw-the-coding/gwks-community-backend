package chc.gwks.controller;

import chc.gwks.payload.request.KakaoAuthorizationRequest;
import chc.gwks.service.KakaoAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/accounts/kakao/")
public class KakaoAccountController {

    private KakaoAuthService kakaoAuthService;

    @Autowired
    KakaoAccountController(KakaoAuthService kakaoAuthService) {
        this.kakaoAuthService = kakaoAuthService;
    }

    @GetMapping
    public ResponseEntity getKakaoCallback(KakaoAuthorizationRequest request) throws JSONException {
        Long userProfile = this.kakaoAuthService.getUserProfile(request);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(URI.create("http://localhost:3000/login/kakao/callback?userSysId=" + userProfile));
        return new ResponseEntity(httpHeaders, HttpStatus.MOVED_PERMANENTLY);
    }

}
