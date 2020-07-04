package exam.blankquizContext.application;

import exam.blankquizContext.domain.model.blankquiz.BlankQuiz;
import exam.blankquizContext.domain.model.blankquiz.BlankQuizId;
import exam.blankquizContext.domain.model.blankquiz.BlankQuizRepository;
import exam.blankquizContext.userInterface.BlankQuizDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlankQuizApplicationService {

    private final BlankQuizRepository blankQuizRepository;

    public BlankQuizApplicationService(BlankQuizRepository blankQuizRepository) {
        this.blankQuizRepository = blankQuizRepository;
    }

    public List<BlankQuizDTO> getAll() {
        return blankQuizRepository.getAll().parallelStream().map(blankQuiz -> {
            BlankQuizDTO dto = new BlankQuizDTO();
            BeanUtils.copyProperties(blankQuiz, dto);
            return dto;
        }).collect(Collectors.toList());
    }

    public BlankQuizDTO get(String blankQuizId) {
        BlankQuiz blankQuiz = blankQuizRepository.getById(new BlankQuizId(blankQuizId));
        if (blankQuiz == null) {
            throw new RuntimeException("not found");
        }
        BlankQuizDTO dto = new BlankQuizDTO();
        BeanUtils.copyProperties(blankQuiz, dto);
        return dto;
    }

    public void deleteBlankQuiz(String blankQuizId) {
        blankQuizRepository.deleteBlankQuiz(new BlankQuizId(blankQuizId));
    }

    public BlankQuizDTO createBlankQuiz(CreateBlankQuizCommand command) {
        BlankQuiz blankQuiz = BlankQuiz.create(command.getTeacherId(), command.getContent(),
                command.getReferenceAnswer(), command.getScore());
        blankQuiz = blankQuizRepository.addBlankQuiz(blankQuiz);
        if (blankQuiz != null) {
            BlankQuizDTO dto = new BlankQuizDTO();
            BeanUtils.copyProperties(blankQuiz, dto);
            return dto;
        }
        return null;
    }

    public BlankQuizDTO reviseBlankQuiz(UpdateBlankQuizCommand command, BlankQuizId id) {
        BlankQuiz blankQuiz = blankQuizRepository.getById(id);
        blankQuiz.revise(command.getTeacherId(), command.getContent(),
                command.getReferenceAnswer(), command.getScore());
        blankQuiz = blankQuizRepository.save(blankQuiz);
        if (blankQuiz != null) {
            BlankQuizDTO dto = new BlankQuizDTO();
            BeanUtils.copyProperties(blankQuiz, dto);
            return dto;
        }
        return null;
    }
}
