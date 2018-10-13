package inicio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inicio.modelos.Produto;
import inicio.repositoris.ProdutoRepository;


@Service
public class ProdutoService {
//intercepta a requisição e processa e faz conexaõ entre rest e banco de dados
	
	@Autowired
	private ProdutoRepository repository;

	public List<Produto> findAll() {
		return repository.findAll();
	}
	
}
