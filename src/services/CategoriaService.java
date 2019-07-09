package services;

import java.util.Set;

import entitites.Categoria;
import entitites.Usuario;
import enuns.TipoMovimentacao;

public class CategoriaService {
	
	//Criar categoria
	public void criarCategoria(Usuario usuario, String nome, TipoMovimentacao  tipo) throws Exception {
			if (buscarCategoriaPorNome(usuario, nome) != null)
				throw new Exception("Já existe categoria com o nome: " + nome);

		usuario.getCategorias().add(new Categoria(nome, tipo, usuario));
		System.out.println("Categoria criada");
	}
	
	//listar categorias por usuário
	public Set<Categoria> listarCategoriaPorUsuario(Usuario usuario) throws Exception{
		if (usuario.getCategorias().isEmpty())
			throw new Exception("O usuário não possui categorias");
		return usuario.getCategorias();
	}
	
	//Buscar categoria por nome
	public Categoria buscarCategoriaPorNome(Usuario usuario, String nome) throws Exception {
		if (usuario.getCategorias().isEmpty()) {
			throw new Exception("O usuário não possui categorias");
		}
		for (Categoria categoria : usuario.getCategorias()) {
			if (categoria.getNome().toUpperCase().hashCode() == nome.toUpperCase().hashCode())
				return categoria;
		}
		return null;
	}
	
	//Excluir categoria
	public void excluirCategoria(Usuario usuario, String nome) throws Exception {
		if (buscarCategoriaPorNome(usuario, nome) == null)
			throw new Exception("Essa categoria não existe");
		
		usuario.getCategorias().remove(buscarCategoriaPorNome(usuario, nome));
		System.out.println("Categoria removida com sucesso");
	}
}
