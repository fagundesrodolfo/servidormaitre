package inicio.repositoris;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import inicio.modelos.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>  {
//responsavel por fazer a conexão com o banco de dados
	
	
}
