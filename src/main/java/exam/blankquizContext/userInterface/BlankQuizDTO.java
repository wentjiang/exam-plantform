package exam.blankquizContext.userInterface;

import exam.blankquizContext.domain.model.blankquiz.BlankQuizId;

import java.time.LocalDateTime;

public class BlankQuizDTO {
    private BlankQuizId blankQuizId;
    private String teacherId;
    private String content;
    private String referenceAnswer;
    private int score;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
