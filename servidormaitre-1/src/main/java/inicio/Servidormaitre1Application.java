package inicio;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import inicio.modelos.Categoria;
import inicio.modelos.Pagamento;
import inicio.modelos.Pedido;
import inicio.modelos.Produto;
import inicio.modelos.Usuario;
import inicio.repositoris.CategoriaRepository;
import inicio.repositoris.PagamentoRepository;
import inicio.repositoris.PedidoRepository;
import inicio.repositoris.ProdutoRepository;
import inicio.repositoris.UsuarioRepository;

@SpringBootApplication
public class Servidormaitre1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Servidormaitre1Application.class, args);
	}

	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Usuario user = new Usuario(null,"Rodolfo","123","rodolfo3841",1,true);
		Usuario user2 = new Usuario(null,"Rodolfo dos santos","123","rodolfo3841@gmail",1,true);
		
		Categoria cat1 = new Categoria(null,"Bebidas","Bebidas normais");
		Categoria cat2 = new Categoria(null,"Pizzas","Pizzas Salgadas");
		
		Produto p1 = new Produto(null,"Agua","agua normal",cat1,10.0);
		Produto p2 = new Produto(null,"Coca Cola","cola cola 2 litros",cat1,20.0);
		
		Produto p3 = new Produto(null,"Portuguesa","pizza portuguesa",cat2,10.0);
		Produto p4 = new Produto(null,"Mussarela","Pizza com queijp",cat2,20.0);
		
		Pedido pedido1 = new Pedido(null,p1,1,user,1);
		
		Pedido pedido2 = new Pedido(null,p3,0,user,2);
		
		Pedido pedido3 = new Pedido(null,p4,0,user2,2);
		
		Pedido pedido4 = new Pedido(null,p2,0,user2,3);
		
		Pagamento pagamento = new Pagamento(null, 10.0,100.0);
		
		pedido3.setPagamento(pagamento);
		
				
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		
		usuarioRepository.saveAll(Arrays.asList(user,user2));
		
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4));
		
		pagamentoRepository.saveAll(Arrays.asList(pagamento));
		
		pedidoRepository.saveAll(Arrays.asList(pedido1,pedido2,pedido3,pedido4));
		
	}
}
