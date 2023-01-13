package com.rafaeldvl.taverncoffee.Services;

import com.rafaeldvl.taverncoffee.Domain.DTOS.ClienteDTO;
import com.rafaeldvl.taverncoffee.Domain.Models.Cliente;
import com.rafaeldvl.taverncoffee.Domain.Models.Pessoa;
import com.rafaeldvl.taverncoffee.Repository.ClienteRepository;
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
public class ClienteService {

    @Autowired
    ClienteRepository repository;

    @Autowired
    PessoaRepository pessoaRepository;

    public List<Cliente> findAll(){
        return  repository.findAll();
    }

    public Cliente findById(Integer id) {
        Optional<Cliente> response = repository.findById(id);
        return response.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!" + id));
    }

    public Cliente create(ClienteDTO objDTO) {
        objDTO.setId(null);
        validCpfEmail(objDTO);
        Cliente newObj = new Cliente(objDTO);
        return repository.save(newObj);
    }

    private void validCpfEmail(ClienteDTO objDTO) {
        Optional<Pessoa> oldObjCpf = pessoaRepository.findByCpf(objDTO.getCpf());
        if(oldObjCpf.isPresent() && !Objects.equals(oldObjCpf.get().getId(), objDTO.getId())){
            throw new DataIntegrityViolationException("Cpf ja cadastrado no sistema!");
        }
        Optional<Pessoa> oldObjEmail = pessoaRepository.findByEmail(objDTO.getEmail());
        if(oldObjEmail.isPresent() && !Objects.equals(oldObjEmail.get().getId(), objDTO.getId())){
            throw new DataIntegrityViolationException("Email ja cadastrado no sistema!");
        }
    }

    public Cliente update(@Valid ClienteDTO objDTO, Integer id) {
        objDTO.setId(id);
        Cliente oldObj = findById(id);
        validCpfEmail(objDTO);
        Cliente newObj = new Cliente(objDTO);
        newObj.setDatacriacao(oldObj.getDatacriacao());
        return repository.save(newObj);
    }

    public void delele(Integer id) {
        Cliente obj = findById(id);
        if(obj.getListaOrdem().size() <= 0){
            repository.deleteById(id);
        } else {
            throw new DataIntegrityViolationException("Esse Cliente não pode ser apagado porque contem PEDIDOS em aberto!");
        }

    }

}
