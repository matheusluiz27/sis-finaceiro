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
	
	//Listar movimentacoes por mes e ano específicos
	public Set<Movimentacao> buscarPorMesAno(Usuario usuario, Date data) throws Exception {
		Set<Movimentacao> filterMovimrntacoes = new TreeSet<Movimentacao>();
		filterMovimrntacoes.addAll(usuario.getMovimentacoes());
		filterMovimrntacoes.removeIf(x -> x.getData().getMonth() != data.getMonth() && x.getData().getYear() != data.getYear());
		if (filterMovimrntacoes.isEmpty()) {
			throw new Exception("Não há movimentações cadastradas nesse mês");
		}
		return filterMovimrntacoes;
	}
	
	public Set<Movimentacao> buscarPorMesAno(Set<Movimentacao> movimentacoes, Date data) throws Exception {
		Set<Movimentacao> filterMovimrntacoes = new TreeSet<Movimentacao>();
		filterMovimrntacoes.addAll(movimentacoes);
		filterMovimrntacoes.removeIf(x -> x.getData().getMonth() != data.getMonth() || x.getData().getYear() != data.getYear());
		if (movimentacoes.isEmpty()) {
			throw new Exception("Não há movimentações cadastradas nesse mês");
		}
		return filterMovimrntacoes;
	}
	
	//Listar por tipo
	public Set<Movimentacao> buscarMovimentacoesPorTipo(Usuario usuario, TipoMovimentacao tipoMovimentacao) {
		Set<Movimentacao> filterMovimrntacoes = new TreeSet<Movimentacao>();
		filterMovimrntacoes.addAll(usuario.getMovimentacoes());
		filterMovimrntacoes.removeIf(x -> x.getTipoMovimentacao() != tipoMovimentacao);
		return filterMovimrntacoes;
	}
	
	public Set<Movimentacao> buscarMovimentacoesPorTipo(Set<Movimentacao> movimentacoes, TipoMovimentacao tipoMovimentacao) {
		Set<Movimentacao> filterMovimrntacoes = new TreeSet<Movimentacao>();
		filterMovimrntacoes.addAll(movimentacoes);
		filterMovimrntacoes.removeIf(x -> x.getTipoMovimentacao() != tipoMovimentacao);
		return filterMovimrntacoes;
	}
	
	//Listar por tipo em um mês
	public Set<Movimentacao> buscarMovimentacoesPorTipoNumMes(Usuario usuario, TipoMovimentacao tipoMovimentacao, Date data) throws Exception {
		Set<Movimentacao> movimentacoes = new TreeSet<Movimentacao>();
		movimentacoes.addAll(this.buscarMovimentacoesPorTipo(usuario.getMovimentacoes(), tipoMovimentacao));
		movimentacoes.retainAll(buscarPorMesAno(movimentacoes, data));
		return movimentacoes;
	}
}
