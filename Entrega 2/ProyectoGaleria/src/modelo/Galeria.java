package modelo;

import java.util.*; 
import fabrica.*;
import piezas.*;
import usuarios.*;
import exceptions.*;

public class Galeria {

	private String nombre;
	private ArrayList<Subasta> subastas;
	private ArrayList<Pieza> historialPiezas = new ArrayList<Pieza>();
	private ArrayList<Pieza> piezasActuales = new ArrayList<Pieza>();
	private ArrayList<Pieza> piezasAntiguas = new ArrayList<Pieza>();
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private Fabrica fabrica = new Fabrica();

	public Galeria(String nombre, ArrayList<Subasta> subastas, ArrayList<Pieza> historialPiezas,
			ArrayList<Pieza> piezasActuales, ArrayList<Pieza> piezasAntiguas, ArrayList<Usuario> usuarios )
	{
		this.nombre = nombre;
		this.subastas = subastas;
		this.historialPiezas = historialPiezas;
		this.piezasActuales = piezasActuales;
		this.piezasAntiguas = piezasAntiguas;
	}
	
	
	public ArrayList<Pieza> obtenerPiezasEnBodega (){
		
		ArrayList<Pieza> piezasBodega = new ArrayList<Pieza>();
		for (Pieza pieza: this.piezasActuales) {
			
			if ( pieza.isExhibida() == false) {
				piezasBodega.add(pieza); }
			
			}
		return piezasBodega;
	}
	
	public ArrayList<Pieza> obtenerPiezasEnExhibicion (){
		
		ArrayList<Pieza> piezasExhibidas = new ArrayList<Pieza>();
		for (Pieza pieza: this.piezasActuales) {
			
			if ( pieza.isExhibida()) {
				piezasExhibidas.add(pieza); }
			
			}
		return piezasExhibidas;
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Subasta> getSubastas() {
		return subastas;
	}

	public ArrayList<Pieza> getHistorialPiezas() {
		return historialPiezas;
	}

	public ArrayList<Pieza> getPiezasActuales() {
		return piezasActuales;
	}

	public ArrayList<Pieza> getPiezasAntiguas() {
		return piezasAntiguas;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public Fabrica getFabrica() {
		return this.fabrica;
	}
	
	public boolean verificarUsuario(Usuario usuarioAVerificar) {
		
		boolean verificado = false;
		
		for (Usuario usuario: this.usuarios )
		{
			if ( usuarioAVerificar.getLogin() == usuario.getLogin() ){
				verificado = true;}
		}
		
		return verificado;
	}
	
	public void agregarUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	
	public void crearComprador(String login, String password,  String nombre, int valorMaximoCompras,
			ArrayList<Pieza> historialPiezas, ArrayList<Pieza> piezasActuales, int dinero, int telefono, Galeria galeria ) throws LoginException
	{
		getFabrica().crearComprador(login, password, nombre, valorMaximoCompras, historialPiezas, piezasActuales, dinero, telefono, galeria);
	}
	public void cargarGaleria(String archivo)
	{
		try
		{
			getFabrica().cargarGaleria(archivo, this);
		}
		catch (Exception e)
		{
			
		}
	}
	
// ¡Crear usuario! y pieza. 




}
	
	


