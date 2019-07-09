package entitites;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import enuns.TipoMovimentacao;

public class Movimentacao implements Comparable<Movimentacao>{
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
	
	private Integer id;
	private String descricao;
	private Date data;
	private TipoMovimentacao tipoMovimentacao;
	private Double valor;
	
	private Categoria categoria;
	private Usuario usuario;
	
	public Movimentacao(Usuario usuario, String descricao, Date data, TipoMovimentacao tipoMovimentacao, Double valor, Categoria categoria) {
		id = new Random().nextInt();
		this.descricao = descricao;
		this.data = data;
		this.tipoMovimentacao = tipoMovimentacao;
		this.valor = valor;
		this.usuario = usuario;
		this.categoria = categoria;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}
	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Usuario getUsuario() { 
		return usuario;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Categoria getCategoria() { 
		return categoria;
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
		Movimentacao other = (Movimentacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int compareTo(Movimentacao movimentacao) {
		return -data.compareTo(movimentacao.getData());
	} 
	
	@Override
	public String toString() {
		return tipoMovimentacao + " - " + sdf.format(data) 
			+ "\n" + String.format("%.2f", valor) 
			+ "\n" + categoria.getNome() 
			+ "\n" + "Descrição: " + descricao + "\n";
	}
}
