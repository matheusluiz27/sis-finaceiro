package test;

import java.text.SimpleDateFormat;

import entitites.Categoria;
import entitites.Movimentacao;
import entitites.Usuario;
import enuns.TipoMovimentacao;
import services.MovimentacaoService;

public class MovimentacaoTest {

	public static void main(String[] args) {
		MovimentacaoService ms = new MovimentacaoService();
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Usuario marcos = new Usuario("Maros", "123");
			Usuario maria = new Usuario("maria", "123");
			
			Categoria contaLuz = new Categoria("conta luz", TipoMovimentacao.SAIDA);
			Categoria contaAgua = new Categoria("conta agua", TipoMovimentacao.SAIDA);
			Categoria salario = new Categoria("salario", TipoMovimentacao.ENTRADA);
			Categoria vendas = new Categoria("vendas", TipoMovimentacao.ENTRADA);
			
			
			ms.cadastrarMovimentacoes(marcos, "qwe", sdf.parse("12/12/2018"), TipoMovimentacao.SAIDA, 200.00, contaLuz);
			ms.cadastrarMovimentacoes(marcos, "asdf", sdf.parse("14/12/2018"), TipoMovimentacao.SAIDA, 200.00, contaAgua);
			ms.cadastrarMovimentacoes(marcos, "asdf", sdf.parse("01/02/2019"), TipoMovimentacao.SAIDA, 200.00, contaLuz);
			ms.cadastrarMovimentacoes(marcos, "asdf", sdf.parse("12/02/2019"), TipoMovimentacao.SAIDA, 200.00, contaAgua);
			ms.cadastrarMovimentacoes(marcos, "wefd", sdf.parse("12/07/2019"), TipoMovimentacao.ENTRADA, 200.00, salario);
			ms.cadastrarMovimentacoes(marcos, "adf", sdf.parse("08/07/2019"), TipoMovimentacao.ENTRADA, 200.00, salario);
			ms.cadastrarMovimentacoes(marcos, "asdfge", sdf.parse("15/12/2018"), TipoMovimentacao.SAIDA, 200.00, contaLuz);
			ms.cadastrarMovimentacoes(marcos, "qrgq", sdf.parse("19/12/2018"), TipoMovimentacao.ENTRADA, 200.00, vendas);
			ms.cadastrarMovimentacoes(marcos, "gegqgy", sdf.parse("12/03/2019"), TipoMovimentacao.ENTRADA, 200.00, vendas);
			
			ms.cadastrarMovimentacoes(maria, "adf", sdf.parse("08/07/2019"), TipoMovimentacao.ENTRADA, 200.00, salario);
			ms.cadastrarMovimentacoes(maria, "asdfge", sdf.parse("15/12/2018"), TipoMovimentacao.SAIDA, 200.00, contaLuz);
			ms.cadastrarMovimentacoes(maria, "qrgq", sdf.parse("19/12/2018"), TipoMovimentacao.ENTRADA, 200.00, vendas);
			ms.cadastrarMovimentacoes(maria, "gegqgy", sdf.parse("12/03/2019"), TipoMovimentacao.ENTRADA, 200.00, vendas);
			
			System.out.println();
			
			for (Movimentacao m : ms.listarMovimentacaoPorUsuario(marcos)) {
				System.out.println(m);
			}
			
			System.out.println();
			System.out.println("Listando por mês atual");
			System.out.println();
			
			for (Movimentacao m : ms.buscarMovimentacoesPorMesAtual(marcos)) {
				System.out.println(m);
			}
			
			System.out.println();
			System.out.println("Listando por mês expecífico");
			System.out.println();
			
//			for (Movimentacao m : ms.buscarPorMesAno(marcos, 03, 2019)) {
//				System.out.println(m);
//			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
