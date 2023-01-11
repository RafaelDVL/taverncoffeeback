package com.rafaeldvl.taverncoffee.Controllers;

import com.rafaeldvl.taverncoffee.Domain.Models.Atendente;
import com.rafaeldvl.taverncoffee.Services.AtendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/atendentes")
public class AtendenteController {

    @Autowired
    AtendenteService service;

    @GetMapping("/all")
    public ResponseEntity<List<Atendente>> findAll(){
        List<Atendente> obj = service.findAll();
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping("/findid/{id}")
    public ResponseEntity<Atendente> findById(@PathVariable Integer id){
        Atendente obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
