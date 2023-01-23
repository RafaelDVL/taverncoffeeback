package com.rafaeldvl.taverncoffee.Services;

import com.rafaeldvl.taverncoffee.Domain.Enums.Perfil;
import com.rafaeldvl.taverncoffee.Domain.Enums.Prioridade;
import com.rafaeldvl.taverncoffee.Domain.Enums.Status;
import com.rafaeldvl.taverncoffee.Domain.Models.*;
import com.rafaeldvl.taverncoffee.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private AtendenteRepository atendenteRepository;
    @Autowired
    private OrdemPedidoRepository ordemPedidoRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ItemBillRepository itemBillRepository;

    public void instanciaDB(){
        Atendente at1 = new Atendente(null, "Rafael Dias Rodrigues",
                "407.328.348-05",
                "rafaelrodrigues@gmail.com",
                encoder.encode("senha123"), "1590908765",
                "Avenida Champs, 610");
        at1.addPerfil(Perfil.ADMIN);
        Atendente at2 = new Atendente(null, "Marcelo Dias Rodrigues",
                "904.952.710-80",
                "marcelorodrigues@gmail.com",
                encoder.encode("minhasenha"), "1590908666",
                "Avenida Champs, 260");
        Atendente tec2 = new Atendente(null,"Richard Stallman", "903.347.070-56", "stallman@mail.com", encoder.encode("123"),"159999978978","Avenida Champs, 260");
        Atendente tec3 = new Atendente(null, "Claude Elwood Shannon", "271.068.470-54", "shannon@mail.com", encoder.encode("123"),"159999978978","Avenida Champs, 260");
        Atendente tec4 = new Atendente(null, "Tim Berners-Lee", "162.720.120-39", "lee@mail.com", encoder.encode("123"),"159999978978","Avenida Champs, 260");
        Atendente tec5 = new Atendente(null, "Linus Torvalds", "778.556.170-27", "linus@mail.com", encoder.encode("123"),"159999978978","Avenida Champs, 260");

        Cliente c1 = new Cliente(null,"Maria Aparecida",
                "830.910.910-58",
                "calebgeraldodasilva@sinelcom.com.br",
                encoder.encode("gordinho123"), "(41) 98139-9833",
                "Rua João Borsato");
        Cliente cli1 = new Cliente(null, "Albert Einstein", "111.661.890-74", "einstein@mail.com", encoder.encode("123"),"159999978978","Avenida Champs, 260");
        Cliente cli2 = new Cliente(null, "Marie Curie", "322.429.140-06", "curie@mail.com", encoder.encode("123"),"159999978978","Avenida Champs, 260");
        Cliente cli3 = new Cliente(null, "Charles Darwin", "792.043.830-62", "darwin@mail.com", encoder.encode("123"),"159999978978","Avenida Champs, 260");
        Cliente cli4 = new Cliente(null, "Stephen Hawking", "177.409.680-30", "hawking@mail.com", encoder.encode("123"),"159999978978","Avenida Champs, 260");
        Cliente cli5 = new Cliente(null, "Max Planck", "081.399.300-83", "planck@mail.com", encoder.encode("123"),"159999978978","Avenida Champs, 260");

        Produto p1 = new Produto(null,10,20.00,"Pizza","http://conteudo.imguol.com.br/c/entretenimento/54/2021/05/07/pizza-de-batata---instachef-1620392226580_v2_1598x1920.jpg","Sem tomate");
        Produto p2 = new Produto(null,5,10.00,"Pão de Queijo","https://www.donaformosa.com.br/wp-content/uploads/2022/05/pao_de_queijo.jpeg","Com requeijão");
        OrdemPedido o1 = new OrdemPedido(null,"Retirar", Status.ABERTO, c1, at2, Prioridade.MEDIA);
        OrdemPedido o2 = new OrdemPedido(null,"Entrega", Status.ANDAMENTO, cli3, tec4, Prioridade.MEDIA);
        ItemBill it1 = new ItemBill(null,o1,p1,4);
        ItemBill it2 = new ItemBill(null,o1,p2,7);
        ItemBill it3 = new ItemBill(null,o2,p2,12);


        pessoaRepository.saveAll(Arrays.asList(tec2,tec3,tec4,tec5,cli1,cli2,cli3,cli4,cli5));
        produtoRepository.save(p1);
        produtoRepository.save(p2);
        clienteRepository.save(c1);
        atendenteRepository.save(at1);
        atendenteRepository.save(at2);
        ordemPedidoRepository.save(o1);
        ordemPedidoRepository.save(o2);
        itemBillRepository.save(it1);
        itemBillRepository.save(it2);
        itemBillRepository.save(it3);



    }
}
