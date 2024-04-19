package usuarios;
import java.util.ArrayList;
import modelo.*;
import piezas.*;


public class Cajero extends Empleado {
	
	private String tipo = "Cajero";
	
	public Cajero(String login, String password, int telefono, String nombre) {
		super(login, password, telefono, nombre);
		// TODO Auto-generated constructor stub
	}

	public String getTipo() {
		
		return this.tipo;
	}
}
