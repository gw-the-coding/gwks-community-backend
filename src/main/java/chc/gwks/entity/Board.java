package chc.gwks.entity;

import chc.gwks.code.Category;
import chc.gwks.code.OperationState;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    @Id @GeneratedValue
    private Long boardSysId;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String boardId;

    private String title;

    private String description;

    private Boolean isNotice;

    @Enumerated(EnumType.STRING)
    private OperationState state;

    private LocalDateTime createdAt;

    private Long createdBy;

    private LocalDateTime lastModifiedAt;

    private Long lastModifiedBy;

    @Builder(builderMethodName = "creator")
    public Board(
            Category category,
            String boardId,
            String title,
            String description,
            Boolean isNotice,
            OperationState state,
            Long createdBy
    ) {
        this.category = category;
        this.boardId = boardId;
        this.title = title;
        this.description = description;
        this.isNotice = isNotice;
        this.state = state;
        this.createdAt = LocalDateTime.now(ZoneId.systemDefault());
        this.createdBy = createdBy;
    }
}
