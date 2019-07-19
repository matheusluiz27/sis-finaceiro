package test;

import java.text.SimpleDateFormat;

import entitites.Categoria;
import entitites.Usuario;
import enuns.TipoMovimentacao;
import services.CaixaService;
import services.MovimentacaoService;

public class CaixaTeste {

	public static void main(String[] args) {
		CaixaService cs = new CaixaService();
		MovimentacaoService ms = new MovimentacaoService();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Usuario marcos = new Usuario("Marcos", "123");
		Usuario maria = new Usuario("Maria", "123");

		Categoria contaLuz = new Categoria("conta luz", TipoMovimentacao.SAIDA);
		Categoria contaAgua = new Categoria("conta agua", TipoMovimentacao.SAIDA);
		Categoria salario = new Categoria("salario", TipoMovimentacao.ENTRADA);
		Categoria vendas = new Categoria("vendas", TipoMovimentacao.ENTRADA);

		try {

			ms.cadastrarMovimentacoes(marcos, "qwe", sdf.parse("12/12/2018"), TipoMovimentacao.SAIDA, 203.00, contaLuz);
			ms.cadastrarMovimentacoes(marcos, "asdf", sdf.parse("14/12/2018"), TipoMovimentacao.SAIDA, 500.00,contaAgua);
			ms.cadastrarMovimentacoes(marcos, "asdf", sdf.parse("01/02/2019"), TipoMovimentacao.SAIDA, 250.00,contaLuz);
			ms.cadastrarMovimentacoes(marcos, "asdf", sdf.parse("12/02/2019"), TipoMovimentacao.SAIDA, 230.00,contaAgua);
			ms.cadastrarMovimentacoes(marcos, "wefd", sdf.parse("12/07/2019"), TipoMovimentacao.ENTRADA, 223.00,salario);
			ms.cadastrarMovimentacoes(marcos, "adf", sdf.parse("08/07/2019"), TipoMovimentacao.ENTRADA, 500.00,salario);
			ms.cadastrarMovimentacoes(marcos, "asdfge", sdf.parse("15/12/2018"), TipoMovimentacao.SAIDA, 203.00,contaLuz);
			ms.cadastrarMovimentacoes(marcos, "qrgq", sdf.parse("19/12/2018"), TipoMovimentacao.ENTRADA, 20023.00,vendas);
			ms.cadastrarMovimentacoes(marcos, "gegqgy", sdf.parse("12/03/2019"), TipoMovimentacao.ENTRADA, 3220.00,vendas);
			ms.cadastrarMovimentacoes(maria, "adf", sdf.parse("08/07/2019"), TipoMovimentacao.ENTRADA, 20230.0, salario);
			ms.cadastrarMovimentacoes(maria, "asdfge", sdf.parse("15/12/2018"), TipoMovimentacao.SAIDA, 2023.00, contaLuz);
			ms.cadastrarMovimentacoes(maria, "qrgq", sdf.parse("19/12/2018"), TipoMovimentacao.ENTRADA, 100.00, vendas);
			ms.cadastrarMovimentacoes(maria, "gegqgy", sdf.parse("12/03/2019"), TipoMovimentacao.ENTRADA, 2100.00,vendas);
			
			System.out.println("Total: marcos = " + cs.getSaldo(marcos) + " - Maria = " + cs.getSaldo(maria));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
