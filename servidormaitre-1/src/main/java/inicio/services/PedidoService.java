package inicio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inicio.modelos.Pedido;
import inicio.repositoris.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;

	public List<Pedido> findAll() {
		return repository.findAll();
	}

	public Optional<Pedido> find(Integer id) {
		return repository.findById(id);
	}

	public Pedido insere(Pedido obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Pedido atualiza(Pedido obj) {
		return repository.save(obj);
	}
	
	//public List<Pedido> buscaPorMesa(Integer mesa) {
		//return repository.findDistinctByMesaContainingIn(mesa);

//}

	
}
