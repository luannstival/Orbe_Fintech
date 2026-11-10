package br.com.fiap.orbefintech.controller;

import br.com.fiap.orbefintech.model.InstituicaoBancaria;
import br.com.fiap.orbefintech.service.InstituicaoBancariaService;
import br.com.fiap.orbefintech.repository.InstituicaoBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instituicoes")
@CrossOrigin(origins = "http://localhost:5173")
public class InstituicaoBancariaController {

    @Autowired
    private InstituicaoBancariaService instituicaoBancariaService;

    @GetMapping("/{idInstituicao}")
    @ResponseStatus(HttpStatus.OK)
    public InstituicaoBancaria consultarInstituicaoBancaria(@PathVariable Integer idInstituicao) {
        return instituicaoBancariaService.consultarInstituicaoBancaria(idInstituicao);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InstituicaoBancaria criarInstituicaoBancaria(@RequestBody InstituicaoBancaria instituicaoBancaria) {
        return instituicaoBancariaService.criarInstituicaoBancaria(instituicaoBancaria);
    }

    @PutMapping("/{idInstituicao}")
    @ResponseStatus(HttpStatus.OK)
    public InstituicaoBancaria atualizarInstituicaoBancaria(@PathVariable Integer idInstituicao, @RequestBody InstituicaoBancaria instituicaoBancaria) {
        instituicaoBancaria.setIdInstituicao(idInstituicao);
        return instituicaoBancariaService.atualizarInstituicaoBancaria(instituicaoBancaria);
    }

    @DeleteMapping("/{idInstituicao}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarInstituicaoBancaria(@PathVariable Integer idInstituicao) {
        instituicaoBancariaService.deletarInstituicaoBancaria(idInstituicao);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InstituicaoBancaria> listarInstituicoesBancarias() {
        return instituicaoBancariaService.listarInstituicoesBancarias();
    }
}
