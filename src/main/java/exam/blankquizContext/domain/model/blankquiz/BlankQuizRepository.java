package exam.blankquizContext.domain.model.blankquiz;

import exam.blankquizContext.application.UpdateBlankQuizCommand;

import java.util.List;

public interface BlankQuizRepository {
    BlankQuiz addBlankQuiz(BlankQuiz blankQuiz);

    void deleteBlankQuiz(BlankQuizId id);

    List<BlankQuiz> getAll();

    BlankQuiz getById(BlankQuizId blankQuizId);

    BlankQuiz save(BlankQuiz blankQuiz);
}
