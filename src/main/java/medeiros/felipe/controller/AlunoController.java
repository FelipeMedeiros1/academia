package medeiros.felipe.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import medeiros.felipe.domain.model.Aluno;
import medeiros.felipe.domain.model.AvaliacaoFisica;
import medeiros.felipe.domain.model.form.AlunoForm;
import medeiros.felipe.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl service;



    @PostMapping
    public ResponseEntity<Aluno> criarAluno(@Valid @RequestBody AlunoForm alunoForm) {
        Aluno alunoCriado = service.criar(alunoForm);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoCriado);
    }

    @GetMapping("/avaliacoes/{id}")
    public ResponseEntity<List<AvaliacaoFisica>> buscarAvaliacoesPorId(@PathVariable Long id) {
        List<AvaliacaoFisica> avaliacoes = service.buscarTodasAvaliacoesPorId(id);
        return ResponseEntity.ok(avaliacoes);
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> buscarTodosAlunos() {
        List<Aluno> alunos = service.buscarTodos();
        return ResponseEntity.ok(alunos);
    }

}