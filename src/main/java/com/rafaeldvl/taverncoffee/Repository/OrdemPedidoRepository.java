package com.rafaeldvl.taverncoffee.Repository;

import com.rafaeldvl.taverncoffee.Domain.Models.OrdemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrdemPedidoRepository extends JpaRepository<OrdemPedido,Integer>{

    @Override
    Optional<OrdemPedido> findById(Integer integer);


}
