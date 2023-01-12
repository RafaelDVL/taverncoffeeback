package com.rafaeldvl.taverncoffee.Services;

import com.rafaeldvl.taverncoffee.Domain.DTOS.AtendenteDTO;
import com.rafaeldvl.taverncoffee.Domain.Models.Atendente;
import com.rafaeldvl.taverncoffee.Repository.AtendenteRepository;
import com.rafaeldvl.taverncoffee.Repository.PessoaRepository;
import com.rafaeldvl.taverncoffee.Services.Exceptions.DataIntegrityViolationException;
import com.rafaeldvl.taverncoffee.Services.Exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtendenteService {

    @Autowired
    AtendenteRepository repository;

    @Autowired
    PessoaRepository pessoaRepository;

    public List<Atendente> findAll(){
        return  repository.findAll();
    }

    public Atendente findById(Integer id) {
        Optional<Atendente> response = repository.findById(id);
        return response.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!" + id));
    }

    public Atendente create(AtendenteDTO objDTO) {
        objDTO.setId(null);
        validCpfEmail(objDTO);
        Atendente newObj = new Atendente(objDTO);
        return repository.save(newObj);
    }

    private void validCpfEmail(AtendenteDTO objDTO) {
        if(pessoaRepository.findByCpf(objDTO.getCpf()).isPresent() || pessoaRepository.findByEmail(objDTO.getEmail()).isPresent()){
            throw new DataIntegrityViolationException("Cpf ou email ja cadastrado no sistema!");
        }
    }


}
