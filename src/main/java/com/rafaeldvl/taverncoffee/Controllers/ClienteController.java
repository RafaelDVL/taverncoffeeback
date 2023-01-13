package com.rafaeldvl.taverncoffee.Controllers;

import com.rafaeldvl.taverncoffee.Domain.DTOS.ClienteDTO;
import com.rafaeldvl.taverncoffee.Domain.Models.Cliente;
import com.rafaeldvl.taverncoffee.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService service;

    @GetMapping("/all")
    public ResponseEntity<List<ClienteDTO>> findAll(){
        List<Cliente> obj = service.findAll();
        List<ClienteDTO> objDTO = obj.stream().map(ClienteDTO::new).toList();
        return ResponseEntity.ok().body(objDTO);
    }
    @GetMapping("/findid/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Integer id){
        Cliente obj = service.findById(id);
        ClienteDTO objDto = new ClienteDTO(obj);
        return ResponseEntity.ok().body(objDto);
    }

    @PostMapping("/create")
    public ResponseEntity<ClienteDTO> create(@RequestBody @Valid ClienteDTO objDTO){
        Cliente newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ClienteDTO> update(@RequestBody @Valid ClienteDTO objDTO,@PathVariable Integer id){
        Cliente obj = service.update(objDTO,id);
        return ResponseEntity.ok().body(new ClienteDTO(obj));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delele(id);
        return ResponseEntity.noContent().build();
    }
}
