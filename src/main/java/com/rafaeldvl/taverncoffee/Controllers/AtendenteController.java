package com.rafaeldvl.taverncoffee.Controllers;

import com.rafaeldvl.taverncoffee.Domain.DTOS.AtendenteDTO;
import com.rafaeldvl.taverncoffee.Domain.Models.Atendente;
import com.rafaeldvl.taverncoffee.Services.AtendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/atendentes")
public class AtendenteController {

    @Autowired
    AtendenteService service;

    @GetMapping("/all")
    public ResponseEntity<List<AtendenteDTO>> findAll(){
        List<Atendente> obj = service.findAll();
        List<AtendenteDTO> objDTO = obj.stream().map(AtendenteDTO::new).toList();
        return ResponseEntity.ok().body(objDTO);
    }
    @GetMapping("/findid/{id}")
    public ResponseEntity<AtendenteDTO> findById(@PathVariable Integer id){
        Atendente obj = service.findById(id);
        AtendenteDTO objDto = new AtendenteDTO(obj);
        return ResponseEntity.ok().body(objDto);
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<AtendenteDTO> create(@RequestBody @Valid AtendenteDTO objDTO){
        Atendente newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<AtendenteDTO> update(@RequestBody @Valid AtendenteDTO objDTO,@PathVariable Integer id){
        Atendente obj = service.update(objDTO,id);
        return ResponseEntity.ok().body(new AtendenteDTO(obj));
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delele(id);
        return ResponseEntity.noContent().build();
    }
}
