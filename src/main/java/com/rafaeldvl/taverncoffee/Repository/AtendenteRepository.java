package com.rafaeldvl.taverncoffee.Repository;

import com.rafaeldvl.taverncoffee.Domain.Models.Atendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendenteRepository extends JpaRepository<Atendente,Integer> {
}
