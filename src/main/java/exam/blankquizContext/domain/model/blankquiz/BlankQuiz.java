package exam.blankquizContext.domain.model.blankquiz;

import exam.paperContext.domain.model.paper.Paper;
import exam.paperContext.domain.shared.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@EqualsAndHashCode(of = {"blankQuizId"})
public class BlankQuiz implements Entity<BlankQuiz> {
    @Getter
    private BlankQuizId blankQuizId;
    private String teacherId;
    private String content;
    private String referenceAnswer;
    private int score;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    @Override
    public boolean sameIdentityAs(BlankQuiz other) {
        return this.blankQuizId == other.blankQuizId;
    }

    private BlankQuiz(String teacherId, String content, String referenceAnswer, int score) {
        this.blankQuizId = new BlankQuizId(UUID.randomUUID().toString());
        this.teacherId = teacherId;
        this.content = content;
        this.referenceAnswer = referenceAnswer;
        this.score = score;
    }

    public static BlankQuiz create(String teacherId, String content, String referenceAnswer, int score){
        BlankQuiz blankQuiz = new BlankQuiz(teacherId, content, referenceAnswer, score);
        return blankQuiz;
    }

    public void revise(String teacherId, String content, String referenceAnswer, int score){
        if (!StringUtils.isEmpty(teacherId)){
            this.teacherId = teacherId;
        }
        if (!StringUtils.isEmpty(content)){
            this.content = content;
        }
        if (!StringUtils.isEmpty(referenceAnswer)){
            this.referenceAnswer = referenceAnswer;
        }
        if (score != 0){
            this.score = score;
        }
    }
}
