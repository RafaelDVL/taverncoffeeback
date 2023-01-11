package com.rafaeldvl.taverncoffee.Services;

import com.rafaeldvl.taverncoffee.Domain.Models.Atendente;
import com.rafaeldvl.taverncoffee.Repository.AtendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtendenteService {

    @Autowired
    AtendenteRepository repository;

    public List<Atendente> findAll(){
        return  repository.findAll();
    }

    public Atendente findById(Integer id) {
        Optional<Atendente> response = repository.findById(id);
        return response.orElse(null);
    }
}
