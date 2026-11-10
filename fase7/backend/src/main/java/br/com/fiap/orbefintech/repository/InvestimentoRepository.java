package br.com.fiap.orbefintech.repository;

import br.com.fiap.orbefintech.model.Investimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface InvestimentoRepository extends JpaRepository<Investimento, Integer> {

}

