package medeiros.felipe.service.impl;

import medeiros.felipe.domain.model.Aluno;
import medeiros.felipe.domain.model.AvaliacaoFisica;
import medeiros.felipe.domain.model.form.AlunoAtualizacaoForm;
import medeiros.felipe.domain.model.form.AlunoForm;
import medeiros.felipe.domain.repository.AlunoRepository;
import medeiros.felipe.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl implements IAlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Aluno criar(AlunoForm form) {
        Aluno aluno = new Aluno();
        aluno.setNome(form.getNome());
        aluno.setCpf(form.getCpf());
        aluno.setBairro(form.getBairro());
        aluno.setDataDeNascimento(form.getDataDeNascimento());

        return alunoRepository.save(aluno);
    }

    @Override
    public Optional<Aluno> buscarPorId(Long id) {
        return alunoRepository.findById(id);
    }

    @Override
    public List<Aluno> buscarTodos() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno atualizar(Long id, AlunoAtualizacaoForm form) {
        return alunoRepository.findById(id)
                .map(aluno -> {
                    if (form.getNome() != null) {
                        aluno.setNome(form.getNome());
                    }

                    if (form.getBairro() != null) {
                        aluno.setBairro(form.getBairro());
                    }

                    if (form.getDataDeNascimento() != null) {
                        aluno.setDataDeNascimento(form.getDataDeNascimento());
                    }

                    return alunoRepository.save(aluno);
                })
                .orElse(null);
    }

    @Override
    public void deletar(Long id) {
        alunoRepository.deleteById(id);
    }

    @Override
    public List<AvaliacaoFisica> buscarTodasAvaliacoesPorId(Long id) {
        return alunoRepository.findById(id)
                .map(Aluno::getAvaliacoes)
                .orElse(null);
    }
}
