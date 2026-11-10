package br.com.fiap.orbefintech.service;

import br.com.fiap.orbefintech.model.Investimento;
import br.com.fiap.orbefintech.repository.InvestimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service //avisa ao Spring: “esta classe faz parte do sistema, cuide dela”
public class InvestimentoService {

    @Autowired //“preciso de um InvestimentoRepository, entregue um pronto”
    private InvestimentoRepository investimentoRepository;

    public Investimento consultarInvestimento(Integer idInvestimento) {
        Optional<Investimento> investimentoOptional = investimentoRepository.findById(idInvestimento);
        if (investimentoOptional.isPresent()) {
            return investimentoOptional.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Investimento não encontrado!");
        }
    }

    public Investimento criarInvestimento(Investimento investimento) {
        if (investimento.getDtInvestimento() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data do investimento é obrigatória.");
        }
        return investimentoRepository.save(investimento);
    }

    public Investimento atualizarInvestimento(Investimento investimento) {
        Optional<Investimento> investimentoExistente = investimentoRepository.findById(investimento.getIdInvestimento());
        if (investimentoExistente.isPresent()) {
            return investimentoRepository.save(investimento);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Investimento não encontrado!");
        }
    }

    public void deletarInvestimento(Integer idInvestimento) {
        Optional<Investimento> investimentoOptional = investimentoRepository.findById(idInvestimento);
        if (investimentoOptional.isPresent()) {
            investimentoRepository.deleteById(idInvestimento);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Investimento não encontrado!");
        }
    }

    public List<Investimento> listarInvestimentos() {
        return investimentoRepository.findAll();
    }
}