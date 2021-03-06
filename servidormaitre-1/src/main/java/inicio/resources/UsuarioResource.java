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

import inicio.modelos.Usuario;
import inicio.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;

	// get todos os usuarios
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> getUsuarios() {
		List<Usuario> lista = service.findAll();
		return ResponseEntity.ok(lista);

	}

	// get usuarios por id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Usuario>> find(@PathVariable Integer id) {
		Optional<Usuario> obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	// salva um novo usuario
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody Usuario obj) {
		obj = service.insere(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	// atualiza usuarios com base no id
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Usuario obj, @PathVariable Integer id) {
		try {
			obj = service.atualiza(obj);
		} catch (Exception e) {
			obj = null;
		}

		return ResponseEntity.noContent().build();
	}
	

	// get usuarios por id
	@RequestMapping(value = "/{login}/{senha}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> verificaUsuario(@PathVariable String login, @PathVariable String senha) {
		System.out.println("---------------------------");
		System.out.println("Valores recebidos: " + login + " e " + senha);
		Usuario obj = service.getPorEmail(login, senha);
		return ResponseEntity.ok().body(obj);
	}

}
