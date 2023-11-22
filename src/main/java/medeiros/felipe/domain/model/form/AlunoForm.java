package medeiros.felipe.domain.model.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoForm {

    /**
     * Nome do aluno.
     */
    @NotEmpty(message = "O nome não pode estar em branco.")
    @Size(min = 3, max = 50, message = "O nome precisa estar entre {min} e {max} caracteres.")
    private String nome;

    /**
     * CPF do aluno.
     */
    @NotEmpty(message = "O CPF não pode estar em branco.")
    //@CPF(message = "CPF inválido.")
    private String cpf;

    /**
     * Bairro do aluno.
     */
    @NotEmpty(message = "O bairro não pode estar em branco.")
    @Size(min = 3, max = 50, message = "O bairro precisa estar entre {min} e {max} caracteres.")
    private String bairro;

    /**
     * Data de nascimento do aluno.
     */
    @NotNull(message = "A data de nascimento não pode estar em branco.")
    @Past(message = "Data de nascimento inválida.")
    private LocalDate dataDeNascimento;


}