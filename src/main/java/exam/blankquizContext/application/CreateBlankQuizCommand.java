package exam.blankquizContext.application;

import exam.blankquizContext.domain.model.blankquiz.BlankQuizId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateBlankQuizCommand {
    private String teacherId;
    private String content;
    private String referenceAnswer;
    private int score;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
