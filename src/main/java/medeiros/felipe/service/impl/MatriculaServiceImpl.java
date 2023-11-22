package medeiros.felipe.service.impl;

import medeiros.felipe.domain.model.Aluno;
import medeiros.felipe.domain.model.Matricula;
import medeiros.felipe.domain.model.form.MatriculaForm;
import medeiros.felipe.domain.repository.AlunoRepository;
import medeiros.felipe.domain.repository.MatriculaRepository;
import medeiros.felipe.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Matricula criar(MatriculaForm form) {
        Optional<Aluno> optionalAluno = alunoRepository.findById(form.getAlunoId());

        if (optionalAluno.isPresent()) {
            Matricula matricula = new Matricula();
            matricula.setAluno(optionalAluno.get());
            return matriculaRepository.save(matricula);
        } else {
            // Lida com a situação em que o aluno não é encontrado
            throw new RuntimeException("Aluno não encontrado com o ID: " + form.getAlunoId());
        }
    }

    @Override
    public Matricula buscarPorId(Long id) {
        return matriculaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Matricula> buscarTodos(String bairro) {
        return matriculaRepository.findAll();
    }

    @Override
    public void deletar(Long id) {
        matriculaRepository.deleteById(id);
    }
}
