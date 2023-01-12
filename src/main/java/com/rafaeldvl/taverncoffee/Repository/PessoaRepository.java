package com.rafaeldvl.taverncoffee.Repository;

import com.rafaeldvl.taverncoffee.Domain.Models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    @Override
    Optional<Pessoa> findById(Integer integer);

    Optional<Pessoa> findByCpf(String cpf);
    Optional<Pessoa> findByEmail(String email);
}
