package chc.gwks.code;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.ToString;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
@ToString
public enum Category {
    HUMOR("HUMOR", "잡담/유머"),
    OPEN_COMMUNITY("OPEN_COMMUNITY", "오픈모임"),
    INFOMATION("INFOMATION", "정보"),
    ETC("ETC", "기타");

    private String code;
    private String description;

    Category(String code, String description) {
        this.code = code;
        this.description = description;
    }

}
