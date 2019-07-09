package test;

import entitites.Categoria;
import entitites.Usuario;
import enuns.TipoMovimentacao;
import services.CategoriaService;

public class CategoriaTeste {

	public static void main(String[] args) {
		try {
			Usuario usuario = new Usuario("Macelo", "123");
			
			CategoriaService cs = new CategoriaService();
			
			cs.criarCategoria(usuario, "Conta de água", TipoMovimentacao.SAIDA);
			cs.criarCategoria(usuario, "Conta de luz", TipoMovimentacao.SAIDA);
			cs.criarCategoria(usuario, "Salário", TipoMovimentacao.ENTRADA);
			cs.criarCategoria(usuario, "Conta de débito do cartão", TipoMovimentacao.SAIDA);	
			
			for (Categoria c : cs.listarCategoriaPorUsuario(usuario)) {
				System.out.println(c.getNome());
			}
			
			cs.excluirCategoria(usuario, "conta de água");
			for (Categoria c : cs.listarCategoriaPorUsuario(usuario)) {
				System.out.println(c.getNome());
			}
			System.out.println(cs.buscarCategoriaPorNome(usuario, "salário").getNome());
	
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
