package inicio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inicio.modelos.Pagamento;
import inicio.repositoris.PagamentoRepository;


@Service
public class PagamentoService {
//intercepta a requisição e processa e faz conexaõ entre rest e banco de dados
	
	@Autowired
	private PagamentoRepository repository;
	
	public List<Pagamento> findAll() {
		return repository.findAll();
	}
	
	public Optional<Pagamento> find(Integer id) {

			return repository.findById(id);

	}

	public Pagamento insere(Pagamento obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Pagamento atualiza(Pagamento obj) {
		return repository.save(obj);
	}
	
}
