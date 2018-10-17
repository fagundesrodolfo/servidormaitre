package inicio.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inicio.modelos.Usuario;
import inicio.repositoris.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public List<Usuario> findAll() {
		return repository.findAll();
	}
	
	public Optional<Usuario> find(Integer id) {

			return repository.findById(id);

	}

	public Usuario insere(Usuario obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Usuario atualiza(Usuario obj) {
		return repository.save(obj);
	}
	
	public Usuario getPorEmail(String email, String senha) {
		Usuario user = null;
		System.out.println("Valores recebidos: " + email + " e " + senha);
		try {
		System.out.println("---------------------------");
		 user = repository.findByEmailAndSenha(email, senha);
		if(user!=null) {
			System.out.println("Usuario encontrado, comparando");
			System.out.println(user.toString());
			return user;
		}
		}catch(Exception e) {
			System.out.println("Erro " + e.getMessage());
		}
		System.out.println("Retornando Nulo");
		return user;
		
		
		

}
	
}
