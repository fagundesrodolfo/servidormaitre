package inicio.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import inicio.modelos.Categoria;
import inicio.modelos.Pedido;
import inicio.services.CategoriaService;


@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
//recebe as requisições rest
	
	@Autowired
	private CategoriaService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public  ResponseEntity<List<Categoria>> getPedidos(){
		
		List<Categoria> lista = service.findAll();
		return ResponseEntity.ok(lista); 
		
	}
	

	
}
