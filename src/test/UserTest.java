package test;

import DomainException.UsuarioException;
import entitites.Usuario;
import services.UsuarioService;

public class UserTest {

	public static void main(String[] args) {
		UsuarioService us = new UsuarioService();
		try {
			
			us.cadastrarUsuario("Feliciano", "123");
			us.cadastrarUsuario("Tiago", "123");
			us.cadastrarUsuario("Joao", "123");
			us.cadastrarUsuario("Maria", "123");
			us.cadastrarUsuario("Felicia", "123");
			us.cadastrarUsuario("Matheus", "123");
			
			for (Usuario u : us.listarUsuarios()) {
				System.out.println(u.getId() + " - " + u);
			}
			
			Usuario u = us.buscarPorNomeSenha("Feliciano", "123");
			
			System.out.println(us.buscarPorId(u.getId()));
			
			us.atualizarSenha(u.getId(), "444");
			
			System.out.println(us.buscarPorNomeSenha("Feliciano", "444"));
			
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
