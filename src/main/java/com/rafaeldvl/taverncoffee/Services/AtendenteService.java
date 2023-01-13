package com.rafaeldvl.taverncoffee.Services;

import com.rafaeldvl.taverncoffee.Domain.DTOS.AtendenteDTO;
import com.rafaeldvl.taverncoffee.Domain.Models.Atendente;
import com.rafaeldvl.taverncoffee.Domain.Models.Pessoa;
import com.rafaeldvl.taverncoffee.Repository.AtendenteRepository;
import com.rafaeldvl.taverncoffee.Repository.PessoaRepository;
import com.rafaeldvl.taverncoffee.Services.Exceptions.DataIntegrityViolationException;
import com.rafaeldvl.taverncoffee.Services.Exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
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
        Optional<Pessoa> oldObjCpf = pessoaRepository.findByCpf(objDTO.getCpf());
        if(oldObjCpf.isPresent() && !Objects.equals(oldObjCpf.get().getId(), objDTO.getId())){
            throw new DataIntegrityViolationException("Cpf ja cadastrado no sistema!");
        }
        Optional<Pessoa> oldObjEmail = pessoaRepository.findByEmail(objDTO.getEmail());
        if(oldObjEmail.isPresent() && !Objects.equals(oldObjEmail.get().getId(), objDTO.getId())){
            throw new DataIntegrityViolationException("Email ja cadastrado no sistema!");
        }
    }

    public Atendente update(@Valid AtendenteDTO objDTO, Integer id) {
        objDTO.setId(id);
        Atendente oldObj = findById(id);
        validCpfEmail(objDTO);
        Atendente newObj = new Atendente(objDTO);
        newObj.setDatacriacao(oldObj.getDatacriacao());
        return repository.save(newObj);
    }
}
