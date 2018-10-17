package inicio.modelos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pagamento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Double valorPago;
	
	private Double valorTotal;

	
	
	
	public Pagamento() {
		super();

	}
	
	
	
	
	public Pagamento(Integer id, Double valorPago, Double valorTotal) {
		super();
		this.id = id;
		this.valorPago = valorPago;
		this.valorTotal = valorTotal;
	}




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public Double getValorPago() {
		return valorPago;
	}




	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}




	public Double getValorTotal() {
		return valorTotal;
	}




	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
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
		Pagamento other = (Pagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}