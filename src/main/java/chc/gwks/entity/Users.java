package chc.gwks.entity;

import chc.gwks.code.AuthorizationCode;
import chc.gwks.code.CommunityCode;
import chc.gwks.code.Platform;
import chc.gwks.code.UserState;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id @GeneratedValue
    private Long userSysId;

    private String name;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "profile_image")
    private String profileImage;

    private String email;

    private String birthyear;

    @Enumerated(EnumType.STRING)
    @Column(name = "community")
    private CommunityCode community;

    @Enumerated(EnumType.STRING)
    private AuthorizationCode authority;

    @Enumerated(EnumType.STRING)
    private UserState state;

    @Enumerated(EnumType.STRING)
    private Platform platform;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "last_modified_at")
    private LocalDateTime lastModifiedAt;

    @Builder(builderMethodName = "creator")
    public Users(
            String name,
            String nickName,
            String email,
            String profileImage,
            Platform platform,
            String birthyear,
            CommunityCode community,
            AuthorizationCode authority,
            UserState state
    ){
        this.name = name;
        this.nickName =nickName;
        this.email =email;
        this.profileImage = profileImage;
        this.platform = platform;
        this.birthyear = birthyear;
        this.community = community;
        this.authority = authority;
        this.state = state;
        this.createdAt = LocalDateTime.now();
    }


}
