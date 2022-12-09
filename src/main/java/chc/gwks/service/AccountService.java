package chc.gwks.service;

import chc.gwks.code.UserState;
import chc.gwks.entity.Users;
import chc.gwks.exception.NotFoundUsersException;
import chc.gwks.payload.request.JoinUsersRequest;
import chc.gwks.payload.response.UserAccountInfoResponse;
import chc.gwks.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AccountService {

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
                .build()
        ).orElseThrow(NullPointerException::new);
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
