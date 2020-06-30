package exam.blankquizContext.infrastructure;

import exam.blankquizContext.application.UpdateBlankQuizCommand;
import exam.blankquizContext.domain.model.blankquiz.BlankQuiz;
import exam.blankquizContext.domain.model.blankquiz.BlankQuizId;
import exam.blankquizContext.domain.model.blankquiz.BlankQuizRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class MemoryBlankQuizRepository implements BlankQuizRepository {

    private Set<BlankQuiz> blankQuizSet = new HashSet<>();

    @Override
    public BlankQuiz addBlankQuiz(BlankQuiz blankQuiz) {
        blankQuizSet.add(blankQuiz);
        return blankQuiz;
    }

    @Override
    public BlankQuiz updateBlankQuiz(UpdateBlankQuizCommand command) {
        BlankQuiz blankQuiz = getById(command.getBlankQuizId());
        blankQuiz.revise(command.getTeacherId(),command.getContent(),command.getReferenceAnswer(),
                command.getScore());
        return blankQuiz;
    }

    @Override
    public void deleteBlankQuiz(BlankQuizId id) {
        BlankQuiz deleteBlankQuiz = getById(id);
        if (deleteBlankQuiz != null) {
            blankQuizSet.remove(deleteBlankQuiz);
        }
    }

    @Override
    public List<BlankQuiz> getAll() {
        return new ArrayList<>(blankQuizSet);
    }

    @Override
    public BlankQuiz getById(BlankQuizId blankQuizId) {
       return blankQuizSet.stream().filter(blankQuiz -> blankQuiz.getBlankQuizId()
               .sameValueAs(blankQuizId)).findFirst().get();
    }
}
