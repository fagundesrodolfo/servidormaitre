package inicio.services;

import java.util.List;

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
	
	
}
