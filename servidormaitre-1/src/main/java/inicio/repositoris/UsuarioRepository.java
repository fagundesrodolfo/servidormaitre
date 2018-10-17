package inicio.repositoris;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import inicio.modelos.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>  {

	Usuario findByEmailAndSenha(String email, String senha);
//responsavel por fazer a conexão com o banco de dados
	
	
}
