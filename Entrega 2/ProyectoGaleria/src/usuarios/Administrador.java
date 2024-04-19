package usuarios;
import java.util.ArrayList;
import modelo.*;
import piezas.*;

public class Administrador extends Empleado{
	
	private String tipo = "Administrador";

	public Administrador(String login, String password, int telefono, String nombre) {
		super(login, password, telefono, nombre);
		// TODO Auto-generated constructor stub
	}

	
 public void registrarPiezas(Pieza nuevaPieza, Galeria galeria) {
	galeria.getPiezasActuales().add(nuevaPieza);
	galeria.getHistorialPiezas().add(nuevaPieza);
			
}

//usar persistencia para guardar cambios

 public void devoluciondePiezas(Pieza pieza, Galeria galeria, Usuario usuario ) {
	galeria.getPiezasActuales().remove(pieza);
	galeria.getPiezasAntiguas().add(pieza);
}
	
 public boolean verificacionDeCompra(Pieza pieza, Usuario comprador, Galeria galeria) {
	
	boolean verificado = false;
	
	if ( galeria.verificarUsuario(comprador) == true && ((Comprador)comprador).getDinero() >= pieza.getValor()) {
		verificado = true;
	}
	
	return verificado;
	
}
 
 public String getTipo() {
		
		return this.tipo;
	}

}