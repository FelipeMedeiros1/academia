package medeiros.felipe.domain.model.form;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class MatriculaForm {

    /**
     * ID do aluno associado à matrícula.
     */
    @NotNull(message = "O ID do aluno não pode estar em branco.")
    @Positive(message = "O ID do aluno precisa ser um valor positivo.")
    private Long alunoId;
}
