package com.rafaeldvl.taverncoffee;

import com.rafaeldvl.taverncoffee.Domain.Enums.Perfil;
import com.rafaeldvl.taverncoffee.Domain.Enums.Prioridade;
import com.rafaeldvl.taverncoffee.Domain.Enums.Status;
import com.rafaeldvl.taverncoffee.Domain.Models.Atendente;
import com.rafaeldvl.taverncoffee.Domain.Models.Cliente;
import com.rafaeldvl.taverncoffee.Domain.Models.OrdemPedido;
import com.rafaeldvl.taverncoffee.Domain.Models.Produto;
import com.rafaeldvl.taverncoffee.Repository.AtendenteRepository;
import com.rafaeldvl.taverncoffee.Repository.ClienteRepository;
import com.rafaeldvl.taverncoffee.Repository.OrdemPedidoRepository;
import com.rafaeldvl.taverncoffee.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaverncoffeeApplication implements CommandLineRunner {


	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private AtendenteRepository atendenteRepository;

	@Autowired
	private OrdemPedidoRepository ordemPedidoRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(TaverncoffeeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Atendente at1 = new Atendente(null, "Rafael Dias Rodrigues",
				"407.328.348-05",
				"rafaelrodrigues@gmail.com",
				"minhasenha","1590908765",
				"Avenida Champs, 610");
		at1.addPerfil(Perfil.ADMIN);

		Cliente c1 = new Cliente(null,"Maria Aparecida",
				"830.910.910-58",
				"calebgeraldodasilva@sinelcom.com.br",
				"gordinho123","(41) 98139-9833",
				"Rua João Borsato");
		c1.addPerfil(Perfil.CLIENTE);

		Produto p1 = new Produto(null,10,"Pizza","http://conteudo.imguol.com.br/c/entretenimento/54/2021/05/07/pizza-de-batata---instachef-1620392226580_v2_1598x1920.jpg","Sem tomate");

		OrdemPedido o1 = new OrdemPedido(null,"Retirar", Status.ABERTO, c1, at1, Prioridade.MEDIA);


		clienteRepository.save(c1);
		atendenteRepository.save(at1);
		produtoRepository.save(p1);

		o1.addListaProduto(p1);
		ordemPedidoRepository.save(o1);

	}
}
