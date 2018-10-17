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

import inicio.modelos.Pagamento;
import inicio.modelos.Pagamento;
import inicio.services.PagamentoService;
import inicio.services.PagamentoService;

@RestController
@RequestMapping(value="/pagamentos")
public class PagamentoResource {
	

	@Autowired
	private PagamentoService service;

	// get todos os Pagamentos
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Pagamento>> getPagamentos() {
		List<Pagamento> lista = service.findAll();
		return ResponseEntity.ok(lista);

	}

	// get Pagamentos por id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Pagamento>> find(@PathVariable Integer id) {
		Optional<Pagamento> obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	// salva um novo Pagamento
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody Pagamento obj) {
		obj = service.insere(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	// atualiza Pagamentos com base no id
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Pagamento obj, @PathVariable Integer id) {
		try {
			obj = service.atualiza(obj);
		} catch (Exception e) {
			obj = null;
		}

		return ResponseEntity.noContent().build();
	}
	

}
