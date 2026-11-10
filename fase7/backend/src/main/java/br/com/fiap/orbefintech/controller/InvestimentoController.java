package br.com.fiap.orbefintech.controller;

import br.com.fiap.orbefintech.model.Investimento;
import br.com.fiap.orbefintech.service.InvestimentoService;
import br.com.fiap.orbefintech.repository.InvestimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/investimentos")
@CrossOrigin(origins = "http://localhost:5173")
public class InvestimentoController {

    @Autowired
    private InvestimentoService investimentoService;

    @GetMapping("/{idInvestimento}")
    @ResponseStatus(HttpStatus.OK)
    public Investimento consultarInvestimento(@PathVariable Integer idInvestimento) {
        return investimentoService.consultarInvestimento(idInvestimento);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Investimento criarInvestimento(@RequestBody Investimento investimento) {
        return investimentoService.criarInvestimento(investimento);
    }

    @PutMapping("/{idInvestimento}")
    @ResponseStatus(HttpStatus.OK)
    public Investimento atualizarInvestimento(@PathVariable Integer idInvestimento, @RequestBody Investimento investimento) {
        investimento.setIdInvestimento(idInvestimento);
        return investimentoService.atualizarInvestimento(investimento);
    }

    @DeleteMapping("/{idInvestimento}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarInvestimento(@PathVariable Integer idInvestimento) {
        investimentoService.deletarInvestimento(idInvestimento);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Investimento> listarInvestimentos() {
        return investimentoService.listarInvestimentos();
    }
}