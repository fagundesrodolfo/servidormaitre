package inicio.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import inicio.modelos.Pedido;
import inicio.services.PedidoService;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {
	//recebe requisições rest
	
	
	@Autowired
	private PedidoService service;
	

	// get todos os Pedidos
		@RequestMapping(method = RequestMethod.GET)
		public ResponseEntity<List<Pedido>> getPedidos() {
			List<Pedido> lista = service.findAll();
			return ResponseEntity.ok(lista);

		}

		// get Pedidos por id
		@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		public ResponseEntity<Optional<Pedido>> find(@PathVariable Integer id) {
			Optional<Pedido> obj = service.find(id);
			return ResponseEntity.ok().body(obj);
		}

		// salva um novo Pedido
		@RequestMapping(method = RequestMethod.POST)
		public ResponseEntity<Void> inserir(@RequestBody Pedido obj) {
			obj = service.insere(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).build();
		}

		// atualiza Pedidos com base no id
		@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Void> atualizar(@RequestBody Pedido obj, @PathVariable Integer id) {
			try {
				obj = service.atualiza(obj);
			} catch (Exception e) {
				obj = null;
			}

			return ResponseEntity.noContent().build();
		}
		
		// get Pedidos por mesa
	/*			@RequestMapping(value = "/mesas/{mesa}", method = RequestMethod.GET)
				public ResponseEntity<List<Pedido>> getPedidosPorMesa(@PathVariable Integer mesa) {
					List<Pedido> obj = service.buscaPorMesa(mesa);
					return ResponseEntity.ok().body(obj);
				}*/

	
}
