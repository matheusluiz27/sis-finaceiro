package services;

import java.util.Set;

import entitites.Movimentacao;
import entitites.Usuario;

public class CaixaService {
	MovimentacaoService ms = new MovimentacaoService();
	
	private Double sumarizar(Set<Movimentacao> movimetacoes) {
		Double saldo = 0.0;
		for (Movimentacao movimentacao : movimetacoes) {
			saldo = movimentacao.getValor();
		}
		return saldo;
	}
	
	public Double getSaldo(Usuario usuario) {
		return sumarizar(usuario.getMovimentacoes());
	}
	
	public Double getValorTotalSaidasMesAtual(Usuario usuario) throws Exception {
		return sumarizar(ms.buscarMovimentacoesPorMesAtual(usuario));
	}
	
}
