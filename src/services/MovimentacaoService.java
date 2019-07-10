package services;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import entitites.Categoria;
import entitites.Movimentacao;
import entitites.Usuario;
import enuns.TipoMovimentacao;

public class MovimentacaoService {
	private Calendar c = Calendar.getInstance();
	
	//Cadastrar movimentação
	public void cadastrarMovimentacoes(Usuario usuario, String descricao, Date data, TipoMovimentacao tipoMovimentacao, Double valor, Categoria categoria) {
		Movimentacao movimentacao = new Movimentacao(usuario, descricao, data, tipoMovimentacao, valor, categoria);
		usuario.getMovimentacoes().add(movimentacao);
		System.out.println("Movimrntação cadastrada com sucesso");
	}
	
	//Listar movimentacoes
	public Set<Movimentacao> listarMovimentacaoPorUsuario(Usuario usuario) throws Exception {
		if (usuario.getMovimentacoes().isEmpty())
			throw new Exception("Não existe movimentações cadastradas");
		
		return usuario.getMovimentacoes();
	}
	
	//Listar movimentações por mês atual
	public Set<Movimentacao> buscarMovimentacoesPorMesAtual(Usuario usuario) throws Exception {
		Set<Movimentacao> movimentacoesMesAtual = new TreeSet<Movimentacao>(usuario.getMovimentacoes());
		movimentacoesMesAtual.removeIf(x -> x.getData().getMonth() != c.get(Calendar.MONTH) && x.getData().getYear() != c.get(Calendar.YEAR));
		if (movimentacoesMesAtual.isEmpty()) {
			throw new Exception("Não há movimentações cadastradas nesse mês");
		}
		return movimentacoesMesAtual;
	}
	
	//Listar movimentacoes por mes e ano específicos
	public Set<Movimentacao> buscarPorMesAno(Usuario usuario, int mes, int ano) throws Exception {
		Set<Movimentacao> movimentacoes = new TreeSet<Movimentacao>(usuario.getMovimentacoes());
		movimentacoes.removeIf(x -> x.getData().getMonth() != mes -1 && x.getData().getYear() != ano);
		if (movimentacoes.isEmpty()) {
			throw new Exception("Não há movimentações cadastradas nesse mês");
		}
		return movimentacoes;
	}
	
	//Listar por tipo
	public Set<Movimentacao> buscarPorTipoMovimentacao(Usuario usuario, TipoMovimentacao tipoMovimentacao) {
		Set<Movimentacao> movimentacoes = new TreeSet<Movimentacao>(usuario.getMovimentacoes());
		movimentacoes.removeIf(x -> x.getTipoMovimentacao() != tipoMovimentacao);
		return movimentacoes;
	}
}
