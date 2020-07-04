package exam.blankquizContext.userInterface;

import exam.blankquizContext.application.BlankQuizApplicationService;
import exam.blankquizContext.application.CreateBlankQuizCommand;
import exam.blankquizContext.application.UpdateBlankQuizCommand;
import exam.blankquizContext.domain.model.blankquiz.BlankQuiz;
import exam.blankquizContext.domain.model.blankquiz.BlankQuizId;
import exam.blankquizContext.domain.model.blankquiz.BlankQuizRepository;
import exam.paperContext.application.AssemblePaperCommand;
import exam.paperContext.domain.model.paper.PaperId;
import exam.paperContext.userInterface.PaperDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blankQuizzes")
public class BlankQuizController {

    private BlankQuizApplicationService blankQuizApplicationService;
    private BlankQuizRepository blankQuizRepository;

    /**
     * 添加填空题
     */
    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    BlankQuizDTO create(@RequestBody CreateBlankQuizCommand command) {
        return blankQuizApplicationService.createBlankQuiz(command);
    }

    /**
     * 修改填空题
     */
    @PutMapping("/{blankQuizId}")
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    BlankQuizDTO revise(@RequestBody UpdateBlankQuizCommand command,
                        @PathVariable String blankQuizId) {
        BlankQuizId id = new BlankQuizId(blankQuizId);
        return blankQuizApplicationService.reviseBlankQuiz(command,id);
    }

    /**
     * 删除填空题
     */
    @DeleteMapping("/{blankQuizId}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable String blankQuizId){
        blankQuizApplicationService.deleteBlankQuiz(blankQuizId);
    }

    /**
     * 获取所有
     */
    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    List<BlankQuizDTO> getAll(){
        return blankQuizApplicationService.getAll();
    }

    /**
     * 获取单个
     */
    @GetMapping("/{blankQuizId}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    BlankQuizDTO get(@PathVariable String blankQuizId){
        return blankQuizApplicationService.get(blankQuizId);
    }
}
