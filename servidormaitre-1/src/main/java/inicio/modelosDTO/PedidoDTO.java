package inicio.modelosDTO;

import java.io.Serializable;
import java.time.LocalDate;

public class PedidoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Integer usuarioAbriu;
	
	private String nomeUsuarioAbriu;
	
	private Integer usuarioFechou;
	
	private String nomeUsuarioFechou;
	
	private Integer produtoId;
	
	private String produtoNome;
	
	private Integer quantidade;
	
	private Double valorTotal;
	
	private Integer mesa;
	
	private LocalDate horaAbertura; 
	
	private LocalDate horaFechamento;

	
	public PedidoDTO() {
		
	}

	public PedidoDTO(Integer id, Integer usuarioAbriu, String nomeUsuarioAbriu, Integer usuarioFechou,
			String nomeUsuarioFechou, Integer produtoId, String produtoNome, Integer quantidade, Double valorTotal,
			LocalDate horaAbertura, LocalDate horaFechamento, Integer mesa) {
		super();
		this.id = id;
		this.usuarioAbriu = usuarioAbriu;
		this.nomeUsuarioAbriu = nomeUsuarioAbriu;
		this.usuarioFechou = usuarioFechou;
		this.nomeUsuarioFechou = nomeUsuarioFechou;
		this.produtoId = produtoId;
		this.produtoNome = produtoNome;
		this.quantidade = quantidade;
		this.valorTotal = valorTotal;
		this.horaAbertura = horaAbertura;
		this.horaFechamento = horaFechamento;
		this.mesa = mesa;
	}

	
	
	public Integer getMesa() {
		return mesa;
	}

	public void setMesa(Integer mesa) {
		this.mesa = mesa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUsuarioAbriu() {
		return usuarioAbriu;
	}

	public void setUsuarioAbriu(Integer usuarioAbriu) {
		this.usuarioAbriu = usuarioAbriu;
	}

	public String getNomeUsuarioAbriu() {
		return nomeUsuarioAbriu;
	}

	public void setNomeUsuarioAbriu(String nomeUsuarioAbriu) {
		this.nomeUsuarioAbriu = nomeUsuarioAbriu;
	}

	public Integer getUsuarioFechou() {
		return usuarioFechou;
	}

	public void setUsuarioFechou(Integer usuarioFechou) {
		this.usuarioFechou = usuarioFechou;
	}

	public String getNomeUsuarioFechou() {
		return nomeUsuarioFechou;
	}

	public void setNomeUsuarioFechou(String nomeUsuarioFechou) {
		this.nomeUsuarioFechou = nomeUsuarioFechou;
	}

	public Integer getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Integer produtoId) {
		this.produtoId = produtoId;
	}

	public String getProdutoNome() {
		return produtoNome;
	}

	public void setProdutoNome(String produtoNome) {
		this.produtoNome = produtoNome;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public LocalDate getHoraAbertura() {
		return horaAbertura;
	}

	public void setHoraAbertura(LocalDate horaAbertura) {
		this.horaAbertura = horaAbertura;
	}

	public LocalDate getHoraFechamento() {
		return horaFechamento;
	}

	public void setHoraFechamento(LocalDate horaFechamento) {
		this.horaFechamento = horaFechamento;
	}

	@Override
	public String toString() {
		return "PedidoDTO [id=" + id + ", usuarioAbriu=" + usuarioAbriu + ", nomeUsuarioAbriu=" + nomeUsuarioAbriu
				+ ", usuarioFechou=" + usuarioFechou + ", nomeUsuarioFechou=" + nomeUsuarioFechou + ", produtoId="
				+ produtoId + ", produtoNome=" + produtoNome + ", quantidade=" + quantidade + ", valorTotal="
				+ valorTotal + ", mesa=" + mesa + ", horaAbertura=" + horaAbertura + ", horaFechamento="
				+ horaFechamento + "]";
	}
	
	
	
	
	
	
	

}
