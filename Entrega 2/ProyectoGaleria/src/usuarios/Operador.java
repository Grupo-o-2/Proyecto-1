package usuarios;

public class Operador extends Empleado{
	
	private String tipo="Operador";
	
	public Operador(String login, String password, int telefono, String nombre) {
		
		super(login, password, telefono, nombre);
		// TODO Auto-generated constructor stub
	}
	
	public String getTipo() {
		
		return this.tipo;
	}
}
