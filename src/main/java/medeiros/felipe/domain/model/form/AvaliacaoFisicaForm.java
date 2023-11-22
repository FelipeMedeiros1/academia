package medeiros.felipe.domain.model.form;


import jakarta.validation.constraints.DecimalMin;
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
public class AvaliacaoFisicaForm {

    /**
     * ID do aluno associado à avaliação física.
     */
    //@Positive(message = "O ID do aluno precisa ser positivo.")
    private Long alunoId;

    /**
     * Peso da avaliação física.
     */
    @NotNull(message = "O peso não pode estar em branco.")
    @Positive(message = "O peso precisa ser um valor positivo.")
    private double peso;

    /**
     * Altura da avaliação física.
     */
    @NotNull(message = "A altura não pode estar em branco.")
    @Positive(message = "A altura precisa ser um valor positivo.")
    @DecimalMin(value = "150", message = "A altura precisa ser no mínimo {value}.")
    private double altura;
}