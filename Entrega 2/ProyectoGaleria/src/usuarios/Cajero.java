package usuarios;
import java.util.ArrayList;

public class Cajero extends Empleado {

	public Cajero(String login, String password, int dinero, int telefono, String nombre, int valorMaximoCompras,
			ArrayList<Pieza> historialPiezas, ArrayList<Pieza> piezasActuales) {
		super(login, password, dinero, telefono, nombre, valorMaximoCompras, historialPiezas, piezasActuales);
		// TODO Auto-generated constructor stub
	}

}
