package services;

import java.util.HashSet;
import java.util.Set;

import DomainException.UsuarioException;
import entitites.Usuario;

public class UsuarioService {
	
	public Set<Usuario> usuarios = new HashSet<Usuario>();
	
	//Listar todos os usuários
	public Set<Usuario> listarUsuarios() throws UsuarioException {
		if (!usuarios.isEmpty())
			return usuarios;
		throw new UsuarioException("Nenhum usuário cadastrado");
	}
	
	//Buscar usuário por id
	public Usuario buscarPorId(Integer id) throws UsuarioException {
		for (Usuario usuario : usuarios) {
			if(usuario.getId().equals(id))
				return usuario;	
		}
		throw new UsuarioException("Usuário inexistente");
	}
	
	//Buscar por nome e senha
	public Usuario buscarPorNomeSenha(String nomeUsuario, String senha) throws UsuarioException {
		for (Usuario usuario : usuarios) {
			if (usuario.getNomeUsuario().hashCode() == nomeUsuario.hashCode())
				if (usuario.getNomeUsuario().equals(nomeUsuario) && usuario.getSenha().equals(senha))
					return usuario;
		}
		throw new UsuarioException("Usuário inexistente"); 
	}
	
	//Cadastrar usuários
	public void cadastrarUsuario(String nomeUsuario, String senha) throws UsuarioException {
		
		for (Usuario u : usuarios) {
			if (u.getNomeUsuario().equals(nomeUsuario))
				throw new UsuarioException("Nome de usuário já existe");
		}
		Usuario usuario = new Usuario(nomeUsuario, senha);
		usuarios.add(usuario);		
		System.out.println("Usuario cadastrado Com  sucesso!");
	}
	
	//Atualizar senha de um usuário
	public void atualizarSenha(Integer id, String novaSenha) throws UsuarioException {
		Usuario newUsuario = buscarPorId(id);
		newUsuario.setSenha(novaSenha);
		usuarios.removeIf(x -> x.getSenha().equals(novaSenha));
		usuarios.add(newUsuario);
	}
}
