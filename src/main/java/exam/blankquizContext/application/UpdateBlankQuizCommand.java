package exam.blankquizContext.application;

import exam.blankquizContext.domain.model.blankquiz.BlankQuizId;
import lombok.Data;

@Data
public class UpdateBlankQuizCommand {
    private String teacherId;
    private String content;
    private String referenceAnswer;
    private int score;
}
