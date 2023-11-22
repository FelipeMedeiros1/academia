package medeiros.felipe.controller;

import medeiros.felipe.domain.model.AvaliacaoFisica;
import medeiros.felipe.domain.model.form.AvaliacaoFisicaForm;
import medeiros.felipe.service.impl.AvaliacaoFisicaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {
    @Autowired
    private AvaliacaoFisicaServiceImpl service;

    @PostMapping
    public ResponseEntity<AvaliacaoFisica> criarAvaliacao(@RequestBody AvaliacaoFisicaForm avaliacaoForm) {
        AvaliacaoFisica avaliacaoCriada = service.criar(avaliacaoForm);
        return ResponseEntity.status(HttpStatus.CREATED).body(avaliacaoCriada);
    }

    @GetMapping
    public ResponseEntity<List<AvaliacaoFisica>> buscarTodasAvaliacoes() {
        List<AvaliacaoFisica> avaliacoes = service.buscarTodos();
        return ResponseEntity.ok(avaliacoes);
    }

}
