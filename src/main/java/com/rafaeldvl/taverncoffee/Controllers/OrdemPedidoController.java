package com.rafaeldvl.taverncoffee.Controllers;

import com.rafaeldvl.taverncoffee.Domain.DTOS.OrdemPedidoDTO;
import com.rafaeldvl.taverncoffee.Domain.Models.OrdemPedido;
import com.rafaeldvl.taverncoffee.Services.OrdemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
