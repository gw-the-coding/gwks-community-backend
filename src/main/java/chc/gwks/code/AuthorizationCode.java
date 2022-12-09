package chc.gwks.code;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.ToString;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
@ToString
public enum AuthorizationCode {
    SUPER_ADMIN("SUPER_ADMIN", "최고관리자"),
    ADMIN("ADMIN", "관리자"),
    USER("USER", "일반사용자");

    private String code;
    private String description;

    AuthorizationCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

}
