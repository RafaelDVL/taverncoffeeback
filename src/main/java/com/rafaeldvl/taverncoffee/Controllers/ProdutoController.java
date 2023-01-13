package com.rafaeldvl.taverncoffee.Controllers;

import com.rafaeldvl.taverncoffee.Domain.DTOS.ProdutoDTO;
import com.rafaeldvl.taverncoffee.Domain.Models.Produto;
import com.rafaeldvl.taverncoffee.Services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
}
