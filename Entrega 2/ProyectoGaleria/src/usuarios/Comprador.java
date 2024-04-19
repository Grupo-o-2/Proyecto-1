package usuarios;

import java.util.ArrayList;
import piezas.Pieza;

public class Comprador extends Usuario{
	
	private int dinero;
	private int telefono;
	private int valorMaximoCompras;
	private ArrayList<Pieza> historialPiezas;
	private ArrayList<Pieza> piezasActuales;
	private String tipo="Comprador";
	
	public Comprador(String login, String password,  String nombre, int valorMaximoCompras,
			ArrayList<Pieza> historialPiezas, ArrayList<Pieza> piezasActuales, int dinero, int telefono) {
		super(login, password, nombre, telefono);
		this.dinero = dinero;
		this.telefono = telefono;
		this.valorMaximoCompras = valorMaximoCompras;
		this.historialPiezas = historialPiezas;
		this.piezasActuales = piezasActuales;	}

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
	
	public String getTipo() {
		
		return this.tipo;
	}
	
	public void añadirPieza(Pieza pieza)
	{
		this.historialPiezas.add(pieza);
		this.piezasActuales.add(pieza);
	}
	
	public void añadirPiezaHistorial(Pieza pieza)
	{
		this.historialPiezas.add(pieza);
	}
}