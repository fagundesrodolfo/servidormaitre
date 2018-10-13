package inicio.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import inicio.modelos.Pedido;
import inicio.services.PedidoService;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {
	//recebe requisições rest
	
	
	@Autowired
	private PedidoService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public  ResponseEntity<List<Pedido>> getPedidos(){
		
		List<Pedido> lista = service.findAll();
		return ResponseEntity.ok(lista); 
		
	}
	
}
