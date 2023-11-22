package medeiros.felipe.domain.model.form;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisicaAtualizacaoForm {

    /**
     * Peso da avaliação física.
     */
    @PositiveOrZero(message = "O peso deve ser um valor não negativo.")
    private double peso;

    /**
     * Altura da avaliação física.
     */
    @PositiveOrZero(message = "A altura deve ser um valor não negativo.")
    private double altura;
}