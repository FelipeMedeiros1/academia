package medeiros.felipe.service;

import medeiros.felipe.domain.model.Aluno;
import medeiros.felipe.domain.model.AvaliacaoFisica;
import medeiros.felipe.domain.model.form.AlunoAtualizacaoForm;
import medeiros.felipe.domain.model.form.AlunoForm;

import java.util.List;
import java.util.Optional;

public interface IAlunoService {
    /**
     * Cria um Aluno e salva no banco de dados.
     * @param form formulário referente aos dados para criação de um Aluno no banco de dados.
     * @return Aluno recém-criado.
     */
    Aluno criar(AlunoForm form);

    /**
     * Retorna um Aluno que está no banco de dados de acordo com seu Id.
     *
     * @param id id do Aluno que será exibido.
     * @return Aluno de acordo com o Id fornecido.
     */
    Optional<Aluno> buscarPorId(Long id);

    /**
     * Retorna os Alunos que estão no banco de dados.
     * @return Uma lista os Alunos que estão salvas no DB.
     */
    List<Aluno> buscarTodos();

    /**
     * Atualiza o Aluno.
     * @param id id do Aluno que será atualizado.
     * @param formUpdate formulário referente aos dados necessários para atualização do Aluno
     * no banco de dados.
     * @return Aluno recém-atualizado.
     */
    Aluno atualizar(Long id, AlunoAtualizacaoForm formUpdate);

    /**
     * Deleta um Aluno específico.
     * @param id id do Aluno que será removido.
     */
    void deletar(Long id);

    /**
     *
     * @param id id do aluno que será recuperada a lista de avaliações
     * @return uma lista com todas as avaliações do aluno de acordo com o Id
     */
    List<AvaliacaoFisica> buscarTodasAvaliacoesPorId(Long id);
}
