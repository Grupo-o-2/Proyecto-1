package modelo;

import java.util.*;

import piezas.*;
import usuarios.*;

public class Galeria {

	private String nombre;
	private ArrayList<Subasta> subastas;
	private ArrayList<Pieza> historialPiezas;
	private ArrayList<Pieza> piezasActuales;
	private ArrayList<Pieza> piezasAntiguas;
	private ArrayList<Usuario> usuarios;

	
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
	
	public boolean verificarUsuario(Usuario usuarioAVerificar) {
		
		boolean verificado = false;
		
		for (Usuario usuario: this.usuarios )
		{
			if ( usuarioAVerificar.getLogin() == usuario.getLogin() ){
				verificado = true;}
		}
		
		return verificado;
	}
	
	




}
	
	


