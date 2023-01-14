package com.rafaeldvl.taverncoffee.Services;

import com.rafaeldvl.taverncoffee.Domain.DTOS.OrdemPedidoDTO;
import com.rafaeldvl.taverncoffee.Domain.Enums.Prioridade;
import com.rafaeldvl.taverncoffee.Domain.Enums.Status;
import com.rafaeldvl.taverncoffee.Domain.Models.Atendente;
import com.rafaeldvl.taverncoffee.Domain.Models.Cliente;
import com.rafaeldvl.taverncoffee.Domain.Models.OrdemPedido;
import com.rafaeldvl.taverncoffee.Repository.OrdemPedidoRepository;
import com.rafaeldvl.taverncoffee.Services.Exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrdemPedidoService {

    @Autowired
    OrdemPedidoRepository repository;

    @Autowired
    AtendenteService atendenteService;

    @Autowired
    ClienteService clienteService;


    public List<OrdemPedido> findAll(){
        return repository.findAll();
    }

    public OrdemPedido findById(Integer id) {
        Optional<OrdemPedido> response = repository.findById(id);
        return response.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!" + id));
    }

    public OrdemPedido create(OrdemPedidoDTO ordemPedidoDTO){
        ordemPedidoDTO.setId(null);
        return repository.save(novoChamado(ordemPedidoDTO)); //Inverção de controle DTO/CHAMADO
    }

    private OrdemPedido novoChamado(OrdemPedidoDTO opDTO) {
        Atendente atendente = atendenteService.findById(opDTO.getAtendente());
        Cliente cliente = clienteService.findById(opDTO.getCliente());
        OrdemPedido op = new OrdemPedido();

        if(opDTO.getId() != null){
            op.setId(opDTO.getId());
        }
        if(opDTO.getStatus().equals(2)){
            op.setDataFechamento(LocalDateTime.now());
        }

        op.setAtendente(atendente);
        op.setCliente(cliente);
        op.setPrioridade(Prioridade.toEnum(opDTO.getPrioridade()));
        op.setStatus(Status.toEnum(opDTO.getStatus()));
        op.setDataAbertura(opDTO.getDataAbertura());
        op.setEntrega(opDTO.getEntrega());

        return op;
    }
}
