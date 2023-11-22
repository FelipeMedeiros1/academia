package medeiros.felipe.service;

import medeiros.felipe.domain.model.AvaliacaoFisica;
import medeiros.felipe.domain.model.form.AvaliacaoFisicaAtualizacaoForm;
import medeiros.felipe.domain.model.form.AvaliacaoFisicaForm;

import java.util.List;

public interface IAvaliacaoFisicaService {
    /**
     * Cria uma Avaliação Física e salva no banco de dados.
     * @param form - formulário referente aos dados para criação da Avaliação Física no banco de dados.
     * @return - Avaliação Física recém-criada.
     */
    AvaliacaoFisica criar(AvaliacaoFisicaForm form);

    /**
     * Retorna uma Avaliação Física que está no banco de dados de acordo com seu Id.
     * @param id - id da Avaliação Física que será exibida.
     * @return - Avaliação Física de acordo com o Id fornecido.
     */
    AvaliacaoFisica buscarPorId(Long id);

    /**
     * Retorna todas as Avaliações Física que estão no banco de dados.
     * @return - Uma lista com todas as Avaliações Física que estão salvas no DB.
     */
    List<AvaliacaoFisica> buscarTodos();

    /**
     * Atualiza a avaliação física.
     * @param id - id da Avaliação Física que será atualizada.
     * @param formUpdate - formulário referente aos dados necessários para atualização da Avaliação
     * Física no banco de dados.
     * @return - Avaliação Física recém-atualizada.
     */
    AvaliacaoFisica atualizar(Long id, AvaliacaoFisicaAtualizacaoForm formUpdate);

    /**
     * Deleta uma Avaliação Física específica.
     * @param id - id da Avaliação Física que será removida.
     */
    void deletar(Long id);
}
