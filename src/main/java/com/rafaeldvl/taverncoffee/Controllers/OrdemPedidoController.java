package com.rafaeldvl.taverncoffee.Controllers;

import com.rafaeldvl.taverncoffee.Domain.DTOS.OrdemPedidoDTO;
import com.rafaeldvl.taverncoffee.Domain.Models.OrdemPedido;
import com.rafaeldvl.taverncoffee.Services.OrdemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/ordempedido")
public class OrdemPedidoController {
    @Autowired
    OrdemPedidoService service;

    @GetMapping("/all")
    public ResponseEntity<List<OrdemPedidoDTO>> findAll(){
        List<OrdemPedido> lista = service.findAll();
        List<OrdemPedidoDTO> listaDTO = lista.stream().map(OrdemPedidoDTO::new).toList();
        return ResponseEntity.ok().body(listaDTO);
    }

    @GetMapping("/findid/{id}")
    public ResponseEntity<OrdemPedidoDTO> findById(@PathVariable Integer id){
        OrdemPedido obj = service.findById(id);
        OrdemPedidoDTO objDTO = new OrdemPedidoDTO(obj);
        return ResponseEntity.ok().body(objDTO);
    }

    @PostMapping("/create")
    public ResponseEntity<OrdemPedidoDTO> create(@Valid @RequestBody OrdemPedidoDTO ordemPedidoDTO){
        OrdemPedido newObj = service.create(ordemPedidoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<OrdemPedidoDTO> update(@Valid @RequestBody OrdemPedidoDTO objDTO, @PathVariable Integer id){
        OrdemPedido obj = service.update(objDTO,id);
        return ResponseEntity.ok().body(new OrdemPedidoDTO(obj));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
