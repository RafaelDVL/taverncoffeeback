package com.rafaeldvl.taverncoffee.Repository;

import com.rafaeldvl.taverncoffee.Domain.Models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {


}
