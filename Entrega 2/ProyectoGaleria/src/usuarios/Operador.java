package usuarios;
import java.util.ArrayList;
import piezas.*;

public class Operador extends Empleado{

	public Operador(String login, String password, int dinero, int telefono, String nombre, int valorMaximoCompras,
			ArrayList<Pieza> historialPiezas, ArrayList<Pieza> piezasActuales) {
		super(login, password, dinero, telefono, nombre, valorMaximoCompras, historialPiezas, piezasActuales);
		// TODO Auto-generated constructor stub
	}

}