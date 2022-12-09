package chc.gwks.code;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.ToString;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
@ToString
public enum UserState {
    BEFORE_SIGN("BEFORE_SIGN", "회원가입 전"),
    ACTIVE("ACTIVE", "사용중"),
    DORMANT("DORMANT", "휴면"),
    VAN("VAN", "강제휴면"),
    EXIT("EXIT", "탈퇴");

    private String code;
    private String description;

    UserState(String code, String description) {
        this.code = code;
        this.description =description;
    }

}
