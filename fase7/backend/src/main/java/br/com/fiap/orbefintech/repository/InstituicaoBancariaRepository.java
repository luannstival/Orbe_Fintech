package br.com.fiap.orbefintech.repository;

import br.com.fiap.orbefintech.model.InstituicaoBancaria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstituicaoBancariaRepository extends JpaRepository<InstituicaoBancaria, Integer> {
    boolean existsByCdCompe(String cdCompe);
}
