package usuarios;
import java.util.ArrayList;
import modelo.*;
import piezas.*;


public class Empleado extends Usuario{
	
	private int telefono;
	
	public Empleado(String login, String password, int telefono, String nombre) {
		super(login, password,  nombre);
		// TODO Auto-generated constructor stub
	}

}
