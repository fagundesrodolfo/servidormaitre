package inicio.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inicio.modelos.Categoria;
import inicio.modelos.Pedido;
import inicio.modelos.Produto;
import inicio.modelos.Usuario;
import inicio.modelosDTO.CategoriaDTO;
import inicio.modelosDTO.PedidoDTO;
import inicio.modelosDTO.ProdutoDTO;
import inicio.repositoris.CategoriaRepository;
import inicio.repositoris.PedidoRepository;
import inicio.repositoris.ProdutoRepository;
import inicio.repositoris.UsuarioRepository;

@Service
public class ItensServices {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private PedidoRepository pedidosRepository;
	
	@Autowired
	private UsuarioRepository usuariosRepository;

	private List<Categoria> categorias = new ArrayList();
	private List<Produto> produtos = new ArrayList();
	private List<Pedido> pedidos = new ArrayList();
	private List<Usuario> usuarios = new ArrayList();

	private List<CategoriaDTO> categoriasDTO = new ArrayList();
	private List<ProdutoDTO> produtosDTO = new ArrayList();
	private List<PedidoDTO> pedidosDTO = new ArrayList();

	private void atualizaListasBase() {

		categorias = new ArrayList();
		produtos = new ArrayList();

		produtos = produtoRepository.findAll();
		categorias = categoriaRepository.findAll();

	}

	private void atualizaPedidos() {

		pedidos.clear();
		pedidos = pedidosRepository.findAll();
		pedidosDTO = new ArrayList();
		
		System.out.println(pedidos);

		for (Pedido p : pedidos) {

			PedidoDTO pDTO = new PedidoDTO();

			pDTO.setId(p.getId());
			pDTO.setMesa(p.getMesa());
			pDTO.setProdutoId(p.getUsuarioAbriu().getId());
			pDTO.setProdutoNome(p.getProduto().getNome());
			pDTO.setHoraAbertura(p.getHoraAbertura());
			pDTO.setNomeUsuarioAbriu(p.getUsuarioAbriu().getNome());
			pDTO.setHoraFechamento(p.getHoraFechamento());
			pDTO.setQuantidade(p.getQuantidade());
			pDTO.setNomeUsuarioAbriu(p.getUsuarioAbriu().getNome());
			pDTO.setValorTotal(p.getProduto().getValor() * p.getQuantidade());

			pedidosDTO.add(pDTO);

		}

	}

	private List<PedidoDTO> filtraPedidosPorMesa(Integer mesa) {

		List<PedidoDTO> aux = new ArrayList();

		for (PedidoDTO p : pedidosDTO) {
			if (p.getMesa() == mesa) {
				aux.add(p);
			}
		}
		return aux;

	}

	private void iniciaListas() {

		if (categoriasDTO.isEmpty() || produtosDTO.isEmpty()) {

			atualizaListasBase();

			categoriasDTO = new ArrayList();

			produtosDTO = new ArrayList();

			for (Produto p : produtos) {

				ProdutoDTO pDTO = new ProdutoDTO();
				pDTO.setId(p.getId());
				pDTO.setNome(p.getNome());
				pDTO.setDescricao(p.getDescricao());
				pDTO.setValor(p.getValor());
				pDTO.setCategoriaId(p.getCategoria().getId());
				produtosDTO.add(pDTO);
			}

			for (Categoria c : categorias) {

				CategoriaDTO cDTO = new CategoriaDTO();
				cDTO.setId(c.getId());
				cDTO.setNome(c.getNome());
				cDTO.setDescricao(c.getDescricao());
				categoriasDTO.add(cDTO);

				for (ProdutoDTO p : produtosDTO) {

					if (p.getCategoriaId() == cDTO.getId()) {
						p.setCategoriaNome(cDTO.getNome());
					}

				}

			}
		}

	}

	private Produto getProdutosPorId(Integer id) {
		if(produtos.isEmpty()) {
			produtos = produtoRepository.findAll();
		}
		Produto aux = null;
		for (Produto p : produtos) {
			if (p.getId() == id) {
				aux = p;
				break;
			}
		}

		return aux;
	}

	private Usuario getUsuarioPorId(Integer id) {
		
		if(usuarios.isEmpty()) {
			usuarios = usuariosRepository.findAll();
		}
		System.out.println("Em get Usuario: " + id);
		Usuario user = null;
		for (Usuario u : usuarios) {
			if (u.getId() == id) {
				user = u;
				break;
			}
		}

		return user;
	}

	public List<CategoriaDTO> getCategorias() {
		iniciaListas();
		return categoriasDTO;
	}

	public List<ProdutoDTO> getProdutos() {
		iniciaListas();
		return produtosDTO;
	}

	public List<PedidoDTO> getPedidos() {
		atualizaPedidos();
		return pedidosDTO;
	}

	public List<PedidoDTO> getPedidosPorMesa(Integer mesa) {
		atualizaPedidos();
		return filtraPedidosPorMesa(mesa);
	}

	public PedidoDTO salvaPedido(PedidoDTO p) {

		Pedido pAux = new Pedido(
				null,
				getProdutosPorId(p.getProdutoId()),
				p.getQuantidade(),
				getUsuarioPorId(p.getUsuarioAbriu()),
				p.getMesa());
		pAux.setHoraAbertura(p.getHoraAbertura());		
		System.out.println(pAux.toString());
		
		try {
			System.out.println("Salvando ////////////////");
			pAux =  pedidosRepository.save(pAux);
		}catch(Exception e) {
			System.out.println("Erro = " + e);
		pAux = null;
		}
		return p;
	}
}
