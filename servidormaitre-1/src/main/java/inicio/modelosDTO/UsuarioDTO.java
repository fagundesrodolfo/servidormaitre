package inicio.modelosDTO;

import java.io.Serializable;

public class UsuarioDTO  implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private Integer tipoUsuario;
	private Boolean ativo;
	private String email;
	
	
	
	public UsuarioDTO(Integer id, String nome, Integer tipoUsuario, Boolean ativo, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipoUsuario = tipoUsuario;
		this.ativo = ativo;
		this.email = email;
	}


	public UsuarioDTO() {
	
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Integer getTipoUsuario() {
		return tipoUsuario;
	}


	public void setTipoUsuario(Integer tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}


	public Boolean getAtivo() {
		return ativo;
	}


	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	

	
	
	
}
