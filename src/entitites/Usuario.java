package entitites;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Usuario {
	
	private Integer id;
	private String nomeUsuario;
	private String senha;
	
	private Set<Categoria> categorias = new HashSet<Categoria>();
	private Set<Movimentacao> movimentacoes = new TreeSet<Movimentacao>();

	public Usuario(String nomeUsuario, String senha) {
		this.id = new Random().nextInt();
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
	}

	public Usuario(Integer id, String nomeUsuario, String senha) {
		this.id = id;
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Set<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}
	
	public void setMovimentacoes(Set<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}
	
	public Set<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(Set<Categoria> categorias) {
		this.categorias = categorias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomeUsuario == null) ? 0 : nomeUsuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomeUsuario == null) {
			if (other.nomeUsuario != null)
				return false;
		} else if (!nomeUsuario.equals(other.nomeUsuario))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return nomeUsuario;
	}
}
