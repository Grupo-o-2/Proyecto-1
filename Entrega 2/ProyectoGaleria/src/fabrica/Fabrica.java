package fabrica;
import usuarios.*;
import piezas.*;
import modelo.*;
import java.util.*;
import java.io.File; 
import java.io.PrintWriter;
import java.nio.file.Files;

import org.json.JSONArray;
import org.json.JSONObject;

public class Fabrica {

	private int cantidadPiezasCreadas;
	private ArrayList<Pieza> piezasCreadas;
	private int cantidadUsariosCreados;
	private ArrayList<Usuario> usuariosCreados;
	private int cantidadCompradoresCreados;
	private ArrayList<Comprador> compradoresCreados;
	private int cantidadEmpleadosCreados;
	private ArrayList<Empleado> empleadosCreados;
	private int cantidadOperadoresCreados;
	private ArrayList<Operador> operadoresCreados;
	private int cantidadCajerosCreados;
	private ArrayList<Cajero> cajerosCreados;
	private int cantidadAdministradoresCreados;
	private ArrayList<Administrador> administradoresCreados;
	private int cantidadEsculturasCreados;
	private ArrayList<Escultura> esculturasCreados;
	private int cantidadFotografiasCreados;
	private ArrayList<Fotografia> fotografiasCreados;
	private int cantidadImpresionesCreados;
	private ArrayList<Impresion> impresionesCreados;
	private int cantidadPinturasCreadas;
	private ArrayList<Pintura> pinturasCreados;
	private int cantidadVideosCreadas;
	private ArrayList<Video> videosCreados;
	private int cantidadComprasCreadas;
	private ArrayList<Compra> comprasCreadas;
	
	public Comprador crearComprador(String login, String password, int dinero, int telefono, String nombre, int valorMaximoCompras, ArrayList<Pieza> historialPiezas, ArrayList<Pieza> piezasActuales ) {
		Comprador nComprador = new Comprador(login, password, dinero, telefono, nombre, valorMaximoCompras,  historialPiezas, piezasActuales ); 
		this.cantidadUsariosCreados++;
		this.usuariosCreados.add(nComprador);
		this.cantidadCompradoresCreados++;
		this.compradoresCreados.add(nComprador);
		return nComprador;
	}
	
	public Empleado crearEmpleado(String login, String password, int dinero, int telefono, String nombre, int valorMaximoCompras, ArrayList<Pieza> historialPiezas, ArrayList<Pieza> piezasActuales ) {
		Empleado nEmpleado = new Empleado(login, password, dinero, telefono, nombre, valorMaximoCompras,  historialPiezas, piezasActuales ); 
		this.cantidadUsariosCreados++;
		this.usuariosCreados.add(nEmpleado);
		this.cantidadEmpleadosCreados++;
		this.empleadosCreados.add(nEmpleado);
		return nEmpleado;
	}
	
	public Cajero crearCajero(String login, String password, int dinero, int telefono, String nombre, int valorMaximoCompras, ArrayList<Pieza> historialPiezas, ArrayList<Pieza> piezasActuales ) {
		Cajero nCajero = new Cajero(login, password, dinero, telefono, nombre, valorMaximoCompras,  historialPiezas, piezasActuales ); 
		this.cantidadUsariosCreados++;
		this.usuariosCreados.add(nCajero);
		this.cantidadCajerosCreados++;
		this.cajerosCreados.add(nCajero);
		return nCajero;
	}
	
	public Administrador crearAdministrador(String login, String password, int dinero, int telefono, String nombre, int valorMaximoCompras, ArrayList<Pieza> historialPiezas, ArrayList<Pieza> piezasActuales ) {
		Administrador nAdministrador = new Administrador(login, password, dinero, telefono, nombre, valorMaximoCompras,  historialPiezas, piezasActuales ); 
		this.cantidadUsariosCreados++;
		this.usuariosCreados.add(nAdministrador);
		this.cantidadAdministradoresCreados++;
		this.administradoresCreados.add(nAdministrador);
		return nAdministrador;
	}
	
	public void salvarPiezas (String Archivo) {
		
	
	}
	
}
