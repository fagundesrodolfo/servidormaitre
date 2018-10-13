package inicio.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import inicio.modelos.Produto;
import inicio.services.ProdutoService;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public  ResponseEntity<List<Produto>> getPedidos(){
		
		List<Produto> lista = service.findAll();
		return ResponseEntity.ok(lista); 
		
	}
	

}
