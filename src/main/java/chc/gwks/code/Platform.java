package chc.gwks.code;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.ToString;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
@ToString
public enum Platform {
    KAKAO("KAKAO", "카카오");

    private String code;
    private String description;

    Platform(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
