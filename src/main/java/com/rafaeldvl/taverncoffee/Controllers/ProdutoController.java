package com.rafaeldvl.taverncoffee.Controllers;

import com.rafaeldvl.taverncoffee.Domain.DTOS.ProdutoDTO;
import com.rafaeldvl.taverncoffee.Domain.Models.Produto;
import com.rafaeldvl.taverncoffee.Services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService service;

    @GetMapping("/all")
    public ResponseEntity<List<ProdutoDTO>> findAll(){
        List<Produto> obj = service.findAll();
        List<ProdutoDTO> objDTO = obj.stream().map(ProdutoDTO::new).toList();
        return ResponseEntity.ok().body(objDTO);
    }

    @GetMapping("/findid/{id}")
    public ResponseEntity<ProdutoDTO> findid(@PathVariable Integer id){
        Produto obj = service.findById(id);
        return ResponseEntity.ok().body(new ProdutoDTO(obj));
    }

    @PostMapping("/create")
    public ResponseEntity<ProdutoDTO> create(@RequestBody ProdutoDTO objDTO){
        Produto newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProdutoDTO> update(@Valid @RequestBody ProdutoDTO objDTO, @PathVariable Integer id){
        Produto obj =  service.update(objDTO,id);
        return ResponseEntity.ok().body(new ProdutoDTO(obj));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
