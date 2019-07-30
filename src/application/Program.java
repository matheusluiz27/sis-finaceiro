package application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entitites.Categoria;
import entitites.Usuario;
import enuns.TipoMovimentacao;
import services.CaixaService;
import services.CategoriaService;
import services.MovimentacaoService;
import services.UsuarioService;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
			
			char op = sc.nextLine().charAt(0);
			CaixaService cs = new CaixaService();
			CategoriaService cateService = new CategoriaService();
			MovimentacaoService ms = new MovimentacaoService();
			UsuarioService us = new UsuarioService();

			System.out.println();
			System.out.println("=====================SISTEMA FINANCEIRO====================");
			System.out.println();
			System.out.println("Você deseja:");
			System.out.println("Criar uma nova conta - 1");
			System.out.println("Fazer login - 2");
			System.out.println();

			if (op == '1') {

				System.out.print("Digite um nome de usuário: ");
				String nomeUsuario = sc.nextLine();
				System.out.print("Digite uma senha: ");
				String senha = sc.nextLine();
				us.cadastrarUsuario(nomeUsuario, senha);

			} else if (op == '2') {

				System.out.print("Digite o nome de usuário: ");
				String nomeUsuario = sc.nextLine();
				System.out.print("Digite a senha: ");
				String senha = sc.nextLine();
				Usuario usuarioLogado = us.buscarPorNomeSenha(nomeUsuario, senha);

				if (usuarioLogado != null) {
					System.out.println();
					System.out.println("Escolha uma operação:");
					System.out.println("1 - Ver saldo");
					System.out.println("2 - Registrar movimentação");
					System.out.println("4 - Ver movimentações");
					System.out.println("5 - Registrar categorias");
					System.out.println();

					op = sc.next().charAt(0);

					if (op == '1') {
						System.out.println("Saldo: " + cs.getSaldo(usuarioLogado));
						
					} else if (op == '2') {
						System.out.println();
						System.out.println("Qual o tipo da movimentação ?");
						System.out.println("1 - Entrada");
						System.out.println("2 - Saída");
						
						op = sc.nextLine().charAt(0);
						TipoMovimentacao tipoMovimentacao = null;
						
						if (op == '1') {
							tipoMovimentacao = TipoMovimentacao.ENTRADA;
						} else if (op == '2') {
							tipoMovimentacao = TipoMovimentacao.SAIDA;
						}
						
						System.out.println();
						System.out.println("Digite uma categoria: ");
						for (Categoria c : cateService.listarCategoriaPorUsuarioTipo(usuarioLogado, tipoMovimentacao)) {
							System.out.println(c.getNome());
						}
						String nomeCate = sc.nextLine();
						Categoria categoria = cateService.buscarCategoriaPorNome(usuarioLogado, nomeCate);
						
						System.out.println();
						System.out.println("Digite o valor da movimentação: ");
						Double valor = sc.nextDouble();
						
						System.out.println();
						System.out.println("Digite uma descrição da movimentação: ");
						String descricao = sc.nextLine();
						
						System.out.println();
						System.out.println("Digite a data da movimentação: ");
						String strData = sc.nextLine();
						Date data = sdf.parse(strData);
						
						ms.cadastrarMovimentacoes(usuarioLogado, descricao, data, tipoMovimentacao, valor, categoria);
					}

				}
			}

		} catch (Exception e) {

		}

		sc.close();
	}

}