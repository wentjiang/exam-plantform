package exam.blankquizContext.userInterface;

import exam.blankquizContext.application.BlankQuizApplicationService;
import exam.blankquizContext.application.CreateBlankQuizCommand;
import exam.blankquizContext.application.UpdateBlankQuizCommand;
import exam.blankquizContext.domain.model.blankquiz.BlankQuiz;
import exam.blankquizContext.domain.model.blankquiz.BlankQuizRepository;
import exam.paperContext.application.AssemblePaperCommand;
import exam.paperContext.domain.model.paper.PaperId;
import exam.paperContext.userInterface.PaperDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlankQuizController {

    private BlankQuizApplicationService blankQuizApplicationService;
    private BlankQuizRepository blankQuizRepository;

    /**
     * 添加填空题
     */
    @PostMapping("/BlankQuiz")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    BlankQuizDTO create(@RequestBody CreateBlankQuizCommand command) {
        return blankQuizApplicationService.createBlankQuiz(command);
    }

    /**
     * 修改填空题
     */
    @PutMapping("/BlankQuiz")
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    BlankQuizDTO update(@RequestBody UpdateBlankQuizCommand command) {
        return blankQuizApplicationService.updateBlankQuiz(command);
    }

    /**
     * 删除填空题
     */
    @DeleteMapping("BlankQuiz/{blankQuizId}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable String blankQuizId){
        blankQuizApplicationService.deleteBlankQuiz(blankQuizId);
    }

    /**
     * 获取所有
     */
    @GetMapping("BlankQuizes")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    List<BlankQuizDTO> getAll(){
        return blankQuizApplicationService.getAll();
    }

    /**
     * 获取单个
     */
    @GetMapping("BlankQuiz/{blankQuizId}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    BlankQuizDTO get(@PathVariable String blankQuizId){
        return blankQuizApplicationService.get(blankQuizId);
    }
}
