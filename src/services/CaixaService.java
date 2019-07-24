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
			saldo += movimentacao.getValor();
		}
		return saldo;
	}
	
	//Retorna o saldo total
	public Double getSaldo(Usuario usuario) {
		Double totalEntradas = sumarizar(ms.buscarMovimentacoesPorTipo(usuario, TipoMovimentacao.ENTRADA));
		Double totalSaidas = sumarizar(ms.buscarMovimentacoesPorTipo(usuario, TipoMovimentacao.SAIDA));
		return totalEntradas - totalSaidas;
	}
	
	//Retorna o saldo total num mẽs
	public Double getSaldoNumMes(Usuario usuario, Date data) throws Exception {
		Double totalEntradas = sumarizar(ms.buscarMovimentacoesPorTipoNumMes(usuario, TipoMovimentacao.ENTRADA, data));
		Double totalSaidas = sumarizar(ms.buscarMovimentacoesPorTipoNumMes(usuario, TipoMovimentacao.SAIDA, data));
		return totalEntradas - totalSaidas;
	}
	
	//total de saidas num mês
	public Double getValorTotalSaidasPorMes(Usuario usuario, Date data) throws Exception {
		return sumarizar(ms.buscarMovimentacoesPorTipoNumMes(usuario, TipoMovimentacao.SAIDA, data));
	}
	
	//total de entradas num mês
	public Double getValorTotalEntradasPorMes(Usuario usuario, Date data) throws Exception {
		return sumarizar(ms.buscarMovimentacoesPorTipoNumMes(usuario, TipoMovimentacao.ENTRADA, data));
	}
	
	//total de movimentações por categoria
	public Map<Categoria, Double> getTotalMovimentacoesPorCategoriaNumMes(Usuario usuario, Date data, TipoMovimentacao tipoMovimentacao) throws Exception{
		Set<Movimentacao> movimentacoes = new TreeSet<Movimentacao>(ms.buscarMovimentacoesPorTipoNumMes(usuario, tipoMovimentacao, data));		
		Map<Categoria, Double> saldoPorCategorias = new HashMap<Categoria, Double>();
		
		for (Movimentacao movimentacao : movimentacoes) {
			if (saldoPorCategorias.containsKey(movimentacao.getCategoria())) {
				double valorAtual = saldoPorCategorias.get(movimentacao.getCategoria());
				saldoPorCategorias.put(movimentacao.getCategoria(), valorAtual + movimentacao.getValor());
			} else {
				saldoPorCategorias.put(movimentacao.getCategoria(),movimentacao.getValor());
			}	
		}
		
		return saldoPorCategorias;	
	}
	
}
