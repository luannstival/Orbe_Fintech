package br.com.fiap.orbefintech.service;

import br.com.fiap.orbefintech.model.InstituicaoBancaria;
import br.com.fiap.orbefintech.repository.InstituicaoBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service //avisa ao Spring: “esta classe faz parte do sistema, cuide dela”
public class InstituicaoBancariaService {

    @Autowired //“preciso de um InstituicaoBancariaRepository, entregue um pronto”
    private InstituicaoBancariaRepository instituicaoBancariaRepository;

    public InstituicaoBancaria consultarInstituicaoBancaria(Integer idInstituicaoBancaria) {
        Optional<InstituicaoBancaria> instituicaoBancariaOptional = instituicaoBancariaRepository.findById(idInstituicaoBancaria);
        if (instituicaoBancariaOptional.isPresent()) {
            return instituicaoBancariaOptional.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Instituição Bancária não encontrada!");
        }
    }

    public InstituicaoBancaria criarInstituicaoBancaria(InstituicaoBancaria instituicaoBancaria) {
        //regra do compe mantendo o if com existsByCdCompe
        if (instituicaoBancaria.getCdCompe() != null && instituicaoBancariaRepository.existsByCdCompe(instituicaoBancaria.getCdCompe())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Código Compe já cadastrado."); //cód 409 http
        }
        return instituicaoBancariaRepository.save(instituicaoBancaria);
    }

    public InstituicaoBancaria atualizarInstituicaoBancaria(InstituicaoBancaria instituicaoBancaria) {
        Optional<InstituicaoBancaria> instituicaoBancariaExistente = instituicaoBancariaRepository.findById(instituicaoBancaria.getIdInstituicao());
        if (instituicaoBancariaExistente.isPresent()) {
            return instituicaoBancariaRepository.save(instituicaoBancaria);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Instituição Bancária não encontrada!");
        }
    }

    public void deletarInstituicaoBancaria(Integer idInstituicaoBancaria) {
        Optional<InstituicaoBancaria> instituicaoBancariaOptional = instituicaoBancariaRepository.findById(idInstituicaoBancaria);
        if (instituicaoBancariaOptional.isPresent()) {
            instituicaoBancariaRepository.deleteById(idInstituicaoBancaria);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Instituição Bancária não encontrada!");
        }
    }

    public List<InstituicaoBancaria> listarInstituicoesBancarias() {
        return instituicaoBancariaRepository.findAll();
    }
}