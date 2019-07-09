package DomainException;

public class UsuarioException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public UsuarioException(String mensage) {
		super(mensage);
	}
}
