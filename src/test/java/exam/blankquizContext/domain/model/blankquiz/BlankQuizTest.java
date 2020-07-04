package exam.blankquizContext.domain.model.blankquiz;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class BlankQuizTest {

    @Test
    public void new_by_create_method_success(){
        BlankQuiz blankQuiz = BlankQuiz.create("teacherId","the question",
                "the reference answer",0);
        assertThat(blankQuiz, is(notNullValue()));
        assertThat(blankQuiz.getBlankQuizId(),is(notNullValue()));
        assertThat(blankQuiz.getTeacherId(),is("teacherId"));
        assertThat(blankQuiz.getContent(),is("the question"));
        assertThat(blankQuiz.getReferenceAnswer(),is("the reference answer"));
        assertThat(blankQuiz.getScore(),is(0));
    }
}
