package services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import entitites.Categoria;
import entitites.Movimentacao;
import entitites.Usuario;
import enuns.TipoMovimentacao;

public class CaixaService {
	MovimentacaoService ms = new MovimentacaoService();
	
	private Double sumarizar(Set<Movimentacao> movimetacoes) {
		Double saldo = 0.0;
		for (Movimentacao movimentacao : movimetacoes) {
			saldo = movimentacao.getValor();
		}
		return saldo;
	}
	
	//Retorna o saldo total
	public Double getSaldo(Usuario usuario) {
		Double totalEntradas = sumarizar(ms.buscarMovimentacoesPorTipo(usuario, TipoMovimentacao.ENTRADA));
		Double totalSaidas = sumarizar(ms.buscarMovimentacoesPorTipo(usuario, TipoMovimentacao.SAIDA));
		return totalEntradas - totalSaidas;
	}
	
	
	public Double getValorTotalSaidasPorMes(Usuario usuario, Date data) throws Exception {
		return sumarizar(ms.buscarMovimentacoesPorTipoNumMes(usuario, TipoMovimentacao.SAIDA, data));
	}
	
	public Double getValorTotalEntradasPorMes(Usuario usuario, Date data) throws Exception {
		return sumarizar(ms.buscarMovimentacoesPorTipoNumMes(usuario, TipoMovimentacao.ENTRADA, data));
	}
	
	public Map<Categoria, Double> getTotaMovimentacoesPorCategoriaNumMes(Usuario usuario, Date data) throws Exception{
		Set<Movimentacao> movimentacoes = new TreeSet<Movimentacao>(ms.buscarPorMesAno(usuario, data));		
		Map<Categoria, Double> saldoPorCategorias = new HashMap<Categoria, Double>();
		
		for (Movimentacao movimentacao : movimentacoes) {
			saldoPorCategorias.
		}
		
		return null;
		
	}
}
