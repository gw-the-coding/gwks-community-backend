package chc.gwks.service;

import chc.gwks.code.UserState;
import chc.gwks.entity.Users;
import chc.gwks.exception.NotFoundUsersException;
import chc.gwks.payload.request.JoinUsersRequest;
import chc.gwks.payload.response.UserAccountInfoResponse;
import chc.gwks.repository.UsersRepository;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.security.Key;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Date;
import java.util.Optional;

@Service
public class AccountService {

    @Value("${jwt.secretKey}")
    private String jwtSecretKey;

    @Value("${jwt.encryptString}")
    private String encryptString;

    private UsersRepository usersRepository;

    @Autowired
    public AccountService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UserAccountInfoResponse getUserInfo(Long userSysId) {
        Optional<Users> findUser = this.usersRepository.findById(userSysId);
        return findUser.map(dto -> UserAccountInfoResponse.builder()
                .userSysId(dto.getUserSysId())
                .name(dto.getName())
                .nickName(dto.getNickName())
                .email(dto.getEmail())
                .profileImage(dto.getProfileImage())
                .birthyear(dto.getBirthyear())
                .platform(dto.getPlatform())
                .community(dto.getCommunity())
                .authority(dto.getAuthority())
                .state(dto.getState())
                .createdAt(dto.getCreatedAt())
                .lastModifiedAt(dto.getLastModifiedAt())
                .accessToken(this.generateJwtToken())
                .build()
        ).orElseThrow(NullPointerException::new);
    }

    private String generateJwtToken() {
        long curTime = System.currentTimeMillis();
        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setIssuer("gwks")
                .setIssuedAt(new Date())
                .setExpiration(new Date(curTime + 86500))
                .setSubject("GWKS-Token")
                .signWith(SignatureAlgorithm.HS256, this.generateSignKey())
                .compact();

    }

    private Key generateSignKey() {
        return Keys.hmacShaKeyFor(this.encryptString.getBytes());
    }



    public void joinUsers(Long userSysId, JoinUsersRequest request) {
        Users users = this.usersRepository
                .findById(userSysId)
                .orElseThrow(() -> new NotFoundUsersException("사용자를 찾을 수 없습니다."));
        users.setName(request.getName());
        users.setNickName(request.getNickName());
        users.setBirthyear(request.getBirthyear());
        users.setState(UserState.ACTIVE);
        users.setCommunity(request.getCommunity());
        users.setLastModifiedAt(LocalDateTime.now(Clock.systemDefaultZone()));
        this.usersRepository.save(users);
    }
}
