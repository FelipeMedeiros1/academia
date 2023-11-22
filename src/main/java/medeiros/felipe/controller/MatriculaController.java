package medeiros.felipe.controller;

import jakarta.validation.Valid;
import medeiros.felipe.domain.model.Matricula;
import medeiros.felipe.domain.model.form.MatriculaForm;
import medeiros.felipe.service.impl.MatriculaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaServiceImpl service;

    @PostMapping
    public ResponseEntity<Matricula> criarMatricula(@Valid @RequestBody MatriculaForm matriculaForm) {
        Matricula matriculaCriada = service.criar(matriculaForm);
        return ResponseEntity.status(HttpStatus.CREATED).body(matriculaCriada);
    }

    @GetMapping
    public ResponseEntity<List<Matricula>> buscarTodasMatriculas(@RequestParam(value = "bairro", required = false) String bairro) {
        List<Matricula> matriculas = service.buscarTodos(bairro);
        return ResponseEntity.ok(matriculas);
    }

}