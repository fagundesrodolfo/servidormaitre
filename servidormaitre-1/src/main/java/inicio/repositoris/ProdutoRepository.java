package inicio.repositoris;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import inicio.modelos.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>  {
//responsavel por fazer a conexão com o banco de dados
	
	
}
