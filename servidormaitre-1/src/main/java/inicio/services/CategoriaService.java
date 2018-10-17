package inicio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inicio.modelos.Categoria;
import inicio.repositoris.CategoriaRepository;

@Service
public class CategoriaService {
//intercepta a requisição e processa e faz conexaõ entre rest e banco de dados
	
	@Autowired
	private CategoriaRepository repository;
	
	public List<Categoria> findAll() {
		return repository.findAll();
	}
	
	public Optional<Categoria> find(Integer id) {

			return repository.findById(id);

	}

	public Categoria insere(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Categoria atualiza(Categoria obj) {
		return repository.save(obj);
	}
	
	
}
