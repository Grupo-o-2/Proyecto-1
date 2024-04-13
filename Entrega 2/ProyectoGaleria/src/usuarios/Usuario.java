package usuarios;
import java.util.ArrayList;
import piezas.*;

public abstract class Usuario {
	private String login;
	private String password;
	private int dinero;
	private int telefono;
	private String nombre;
	private int valorMaximoCompras;
	private ArrayList<Pieza> historialPiezas;
	private ArrayList<Pieza> piezasActuales;
	

	
public Usuario(String login, String password, int dinero, int telefono, String nombre, int valorMaximoCompras, ArrayList<Pieza> historialPiezas, ArrayList<Pieza> piezasActuales ) {	
	this.login = login;
	this.password = password;
	this.dinero = dinero;
	this.telefono = telefono;
	this.nombre = nombre;
	this.valorMaximoCompras = valorMaximoCompras;
	this.historialPiezas = historialPiezas;
	this.piezasActuales = piezasActuales;

}
}
