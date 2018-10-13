package inicio.modelos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pedido  implements Serializable{
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="produto_id")
	private Produto produto;
	
	private Integer quantidade;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="usuario_abriu_id")
	private Usuario usuarioAbriu;
	
	@JsonIgnore
	//@OneToOne
	@JoinColumn(name="usuario_fechou_id")
	private Usuario usuarioFechoi;
	
	
	
	private Integer mesa;
	
	
	private LocalDate horaAbertura; // 
	private LocalDate horaFechamento; // 
	
	public Pedido() {
	
	}
	

	
	public Pedido(Integer id, Produto produto, Integer quantidade, Usuario usuarioAbriu, Integer mesa) {
		super();
		this.id = id;
		this.produto = produto;
		this.quantidade = quantidade;
		this.usuarioAbriu = usuarioAbriu;
		this.mesa = mesa;
		horaAbertura = LocalDate.now();
	}



	public Integer getMesa() {
		return mesa;
	}



	public void setMesa(Integer mesa) {
		this.mesa = mesa;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Usuario getUsuarioAbriu() {
		return usuarioAbriu;
	}
	public Usuario getUsuarioFechoi() {
		return usuarioFechoi;
	}
	public void setUsuarioFechoi(Usuario usuarioFechoi) {
		this.usuarioFechoi = usuarioFechoi;
	}
	public LocalDate getHoraAbertura() {
		return horaAbertura;
	}
	public LocalDate getHoraFechamento() {
		return horaFechamento;
	}
	public void setHoraFechamento() {
		horaFechamento= LocalDate.now();
	}
	
	

}
