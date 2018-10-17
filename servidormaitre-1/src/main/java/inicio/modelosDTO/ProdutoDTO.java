package inicio.modelosDTO;

import java.io.Serializable;

public class ProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String descricao;
	private Double valor;
	private Integer mesa;
	private Integer categoriaId;
	private String categoriaNome;
	
	public ProdutoDTO(Integer id, String nome, String descricao, Double valor,Integer mesa, Integer categoriaId,
			String categoriaNome) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.mesa = mesa;
		this.categoriaId = categoriaId;
		this.categoriaNome = categoriaNome;
	}
	
	
	
	public Integer getMesa() {
		return mesa;
	}



	public void setMesa(Integer mesa) {
		this.mesa = mesa;
	}



	public ProdutoDTO() {
		
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}

	public String getCategoriaNome() {
		return categoriaNome;
	}

	public void setCategoriaNome(String categoriaNome) {
		this.categoriaNome = categoriaNome;
	}

	
	
	
	
}
