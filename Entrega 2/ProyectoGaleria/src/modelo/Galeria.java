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
	
	public boolean verificarUsuario(Usuario usuarioAVerificar) throws UsuarioInexistenteException {
		
		if ((this.usuarios.contains(usuarioAVerificar)) == false ) {
			
			throw new UsuarioInexistenteException(usuarioAVerificar.getNombre());
		}
		else {
			return true;
		}
		
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

	public Usuario getAdministrador() {
		Usuario administrador = null;
		for ( Usuario usuario : this.usuarios) {
			if (usuario.getTipo() == "Administrador") {
				administrador = usuario;}
		}
		return administrador;
	}
	
	
	public Usuario getUnCajero() {
		
		Usuario cajero = null;
		for ( Usuario usuario : this.usuarios) {
			if (usuario.getTipo() == "Cajero") {
				cajero = usuario;}
		}
		return cajero;
	}
	
	public Usuario getUnOperador() {
		
		Usuario operador = null;
		for ( Usuario usuario : this.usuarios) {
			if (usuario.getTipo() == "Operador") {
				operador = usuario;}
		}
		return operador;
	}
	
	
	public void realizarConsignacion(Usuario propietario, Pieza piezaAConsignar, String fechaLimite, Galeria galeria, String exhibaVendaoSubasta) throws PropietarioErroneoException {
		
		((Administrador )this.getAdministrador()).registrarPiezaPorConsignacion(propietario, piezaAConsignar, fechaLimite, this, exhibaVendaoSubasta);
		
	}
	
	public void crearSubasta(ArrayList<Usuario> participantes, Usuario operador, HashMap<Pieza,HashMap<Usuario, 
		Integer>> registroSubasta, HashMap<Pieza, ArrayList<Integer>> piezasSubastadas) throws UsuarioInexistenteException {
		
		if (  ((Administrador )this.getAdministrador()).verificarUsuariosSubasta(participantes, this) == true  ) {
			
			Subasta nuevaSubasta = new Subasta(participantes, operador, registroSubasta, piezasSubastadas);
			this.subastas.add(nuevaSubasta);
			
		}
	}
	
	public void finalizarSubasta(Subasta subasta)  {
		
		subasta.finalizarSubasta(this);
	}
	
}
	
	


