package com.rafaeldvl.taverncoffee.Services;

import com.rafaeldvl.taverncoffee.Domain.DTOS.OrdemPedidoDTO;
import com.rafaeldvl.taverncoffee.Domain.Models.Atendente;
import com.rafaeldvl.taverncoffee.Domain.Models.OrdemPedido;
import com.rafaeldvl.taverncoffee.Repository.OrdemPedidoRepository;
import com.rafaeldvl.taverncoffee.Services.Exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdemPedidoService {

    @Autowired
    OrdemPedidoRepository repository;


    public List<OrdemPedido> findAll(){
        return repository.findAll();
    }

    public OrdemPedido findById(Integer id) {
        Optional<OrdemPedido> response = repository.findById(id);
        return response.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!" + id));
    }
}
