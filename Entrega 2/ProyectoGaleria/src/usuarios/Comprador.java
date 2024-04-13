package usuarios;

import java.util.ArrayList;
import piezas.Pieza;

public class Comprador extends Usuario{
	
	private int dinero;
	private int telefono;
	private int valorMaximoCompras;
	private ArrayList<Pieza> historialPiezas;
	private ArrayList<Pieza> piezasActuales;
	
	public Comprador(String login, String password,  String nombre, int valorMaximoCompras,
			ArrayList<Pieza> historialPiezas, ArrayList<Pieza> piezasActuales, int dinero, int telefono) {
		super(login, password, nombre);
	}

	public int getValorMaximoCompras() {
		return valorMaximoCompras;
	}

	public void setValorMaximoCompras(int valorMaximoCompras) {
		this.valorMaximoCompras = valorMaximoCompras;
	}

	public ArrayList<Pieza> getHistorialPiezas() {
		return historialPiezas;
	}

	public void setHistorialPiezas(ArrayList<Pieza> historialPiezas) {
		this.historialPiezas = historialPiezas;
	}

	public ArrayList<Pieza> getPiezasActuales() {
		return piezasActuales;
	}

	public void setPiezasActuales(ArrayList<Pieza> piezasActuales) {
		this.piezasActuales = piezasActuales;
	}

	public int getDinero() {
		return dinero;
	}

	public int getTelefono() {
		return telefono;
	}
	
	
}