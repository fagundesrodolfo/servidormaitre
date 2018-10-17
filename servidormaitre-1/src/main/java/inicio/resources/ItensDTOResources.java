package inicio.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import inicio.modelosDTO.CategoriaDTO;
import inicio.modelosDTO.PedidoDTO;
import inicio.modelosDTO.ProdutoDTO;
import inicio.services.ItensServices;

@RestController
@RequestMapping(value="/itens")
public class ItensDTOResources {
	
	@Autowired
	private ItensServices services;
	

	@RequestMapping(value="/produtos", method = RequestMethod.GET)
	public ResponseEntity<List<ProdutoDTO>> getProdutos() {
		return ResponseEntity.ok(services.getProdutos());

	}

	@RequestMapping(value="/categorias", method = RequestMethod.GET)
	public ResponseEntity<List<CategoriaDTO>> getCategorias() {
		return ResponseEntity.ok(services.getCategorias());

	}
	
	@RequestMapping(value="/pedidos", method = RequestMethod.GET)
	public ResponseEntity<List<PedidoDTO>> getPedidos() {
		return ResponseEntity.ok(services.getPedidos());
	}
	
	@RequestMapping(value="/pedidos/{mesa}", method = RequestMethod.GET)
	public ResponseEntity<List<PedidoDTO>> getPedidosPorMesa(@PathVariable Integer mesa) {
		return ResponseEntity.ok(services.getPedidosPorMesa(mesa));

	}
	
	@RequestMapping(value="/pedidos/salva", method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody PedidoDTO obj) {
		obj = services.salvaPedido(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
