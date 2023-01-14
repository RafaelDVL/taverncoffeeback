package com.rafaeldvl.taverncoffee.Services;

import com.rafaeldvl.taverncoffee.Domain.DTOS.ProdutoDTO;
import com.rafaeldvl.taverncoffee.Domain.Models.Produto;
import com.rafaeldvl.taverncoffee.Repository.ProdutoRepository;
import com.rafaeldvl.taverncoffee.Services.Exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository repository;

    public List<Produto> findAll() {
        return repository.findAll();
    }

    public Produto findById(Integer id) {
        Optional<Produto> obj =  repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!" + id));
    }
    public Produto create(ProdutoDTO objDTO) {
        objDTO.setId(null);
        Produto obj = new Produto(objDTO);
        return repository.save(obj);
    }
    public void delete(Integer id) {
        Produto obj = findById(id);
        repository.deleteById(id);
    }

    public Produto update(ProdutoDTO objDTO, Integer id) {
        objDTO.setId(id);
        Produto oldobj = findById(id);
        oldobj.setEstoque(objDTO.getEstoque());
        oldobj.setNome(objDTO.getNome());
        oldobj.setPreco(objDTO.getPreco());
        oldobj.setUrlImage(objDTO.getUrlImage());
        oldobj.setObservacoes(objDTO.getObservacoes());
        return repository.save(oldobj);
    }
}
