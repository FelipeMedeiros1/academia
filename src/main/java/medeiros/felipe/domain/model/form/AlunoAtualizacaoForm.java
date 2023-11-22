package medeiros.felipe.domain.model.form;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoAtualizacaoForm {

    /**
     * Nome do aluno.
     */
    @NotBlank(message = "O nome não pode estar em branco")
    private String nome;

    private String bairro;

    private LocalDate dataDeNascimento;
}