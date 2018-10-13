package inicio.repositoris;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import inicio.modelos.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>  {
//responsavel por fazer a conexão com o banco de dados
	
	
}
