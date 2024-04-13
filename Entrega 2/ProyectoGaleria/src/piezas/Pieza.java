package piezas;

import java.util.*;


abstract public class Pieza {
	
	private String titulo;
	private int año;
	private String lugar;
	private ArrayList<String> autores;
	private Usuario propietario;
	public String EXHIBA = "1";
	public String VENTA = "2";
	public String SUBASTA = "3";
	private String exhibaVendaoSubasta;
	

public Pieza(String titulo, int año, String lugar, ArrayList<String> autores, Usuario propietario,  String exhibaVendaoSubasta) {
	this.titulo = titulo;
	this.año = año;
	this.lugar = lugar;
	this.autores = autores;
	this.propietario = propietario;
	this.exhibaVendaoSubasta = exhibaVendaoSubasta;
}

}