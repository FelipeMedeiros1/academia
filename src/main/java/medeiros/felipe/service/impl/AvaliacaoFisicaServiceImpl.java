package medeiros.felipe.service.impl;

import medeiros.felipe.domain.model.Aluno;
import medeiros.felipe.domain.model.AvaliacaoFisica;
import medeiros.felipe.domain.model.form.AvaliacaoFisicaAtualizacaoForm;
import medeiros.felipe.domain.model.form.AvaliacaoFisicaForm;
import medeiros.felipe.domain.repository.AlunoRepository;
import medeiros.felipe.domain.repository.AvaliacaoFisicaRepository;
import medeiros.felipe.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

    @Autowired
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public AvaliacaoFisica criar(AvaliacaoFisicaForm form) {
        Aluno aluno = alunoRepository.findById(form.getAlunoId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: " + form.getAlunoId()));

        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setPeso(form.getPeso());
        avaliacaoFisica.setAltura(form.getAltura());

        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    @Override
    public AvaliacaoFisica buscarPorId(Long id) {
        return avaliacaoFisicaRepository.findById(id).orElse(null);
    }

    @Override
    public List<AvaliacaoFisica> buscarTodos() {
        return avaliacaoFisicaRepository.findAll();
    }

    @Override
    public AvaliacaoFisica atualizar(Long id, AvaliacaoFisicaAtualizacaoForm formUpdate) {
        return avaliacaoFisicaRepository.findById(id)
                .map(avaliacaoFisica -> {
                    avaliacaoFisica.setPeso(formUpdate.getPeso());
                    avaliacaoFisica.setAltura(formUpdate.getAltura());
                    return avaliacaoFisicaRepository.save(avaliacaoFisica);
                })
                .orElse(null);
    }

    @Override
    public void deletar(Long id) {
        avaliacaoFisicaRepository.deleteById(id);
    }
}
