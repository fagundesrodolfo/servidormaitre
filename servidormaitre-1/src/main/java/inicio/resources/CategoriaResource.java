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

import inicio.modelos.Categoria;
import inicio.services.CategoriaService;


@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
//recebe as requisições rest

	@Autowired
	private CategoriaService service;

	// get todos os Categorias
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Categoria>> getCategorias() {
		List<Categoria> lista = service.findAll();
		return ResponseEntity.ok(lista);

	}

	// get Categorias por id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Categoria>> find(@PathVariable Integer id) {
		Optional<Categoria> obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	// salva um novo Categoria
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody Categoria obj) {
		obj = service.insere(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	// atualiza Categorias com base no id
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Categoria obj, @PathVariable Integer id) {
			obj.setId(id);
			obj = service.atualiza(obj);
		return ResponseEntity.noContent().build();
	}
	

	
}
