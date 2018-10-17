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

import inicio.modelos.Produto;
import inicio.modelos.Produto;
import inicio.services.ProdutoService;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;
	

	// get todos os usuarios
		@RequestMapping(method = RequestMethod.GET)
		public ResponseEntity<List<Produto>> getProdutos() {
			List<Produto> lista = service.findAll();
			return ResponseEntity.ok(lista);

		}

		// get usuarios por id
		@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		public ResponseEntity<Optional<Produto>> find(@PathVariable Integer id) {
			Optional<Produto> obj = service.find(id);
			return ResponseEntity.ok().body(obj);
		}

		// salva um novo Produto
		@RequestMapping(method = RequestMethod.POST)
		public ResponseEntity<Void> inserir(@RequestBody Produto obj) {
			obj = service.insere(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).build();
		}

		// atualiza produtos com base no id
		@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Void> atualizar(@RequestBody Produto obj, @PathVariable Integer id) {
			try {
				obj = service.atualiza(obj);
			} catch (Exception e) {
				obj = null;
			}

			return ResponseEntity.noContent().build();
		}

	

}
