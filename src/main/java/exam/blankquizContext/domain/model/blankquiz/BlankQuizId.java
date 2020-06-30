package exam.blankquizContext.domain.model.blankquiz;

import exam.paperContext.domain.model.paper.PaperId;
import exam.paperContext.domain.shared.ValueObject;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class BlankQuizId implements ValueObject<BlankQuizId> {
    private String id;

    public String nextId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public boolean sameValueAs(BlankQuizId other) {
        return this.id.equals(other.id);
    }
}
