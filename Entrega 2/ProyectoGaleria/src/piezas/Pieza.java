package piezas;

import java.util.*;
import modelo.*;
import usuarios.*;


abstract public class Pieza {
	
	private String titulo;
	private int año;
	private String lugar;
	private ArrayList<String> autores;
	private boolean exhibida;
	private int valor;
	private Usuario propietarioOriginal;
	private Usuario propietarioActual;
	public String EXHIBA = "1";
	public String VENTA = "2";
	public String SUBASTA = "3";
	private String exhibaVendaoSubasta;
	

public Pieza(String titulo, int año, int valor, String lugar, ArrayList<String> autores, boolean exhibida, Usuario propietarioActual, Usuario propietarioOriginal,  String exhibaVendaoSubasta) {
	this.titulo = titulo;
	this.año = año;
	this.lugar = lugar;
	this.valor = valor;
	this.autores = autores;
	this.propietarioActual = propietarioActual;
	this.propietarioOriginal = propietarioOriginal;
	this.exhibaVendaoSubasta = exhibaVendaoSubasta;
}


	public String getTitulo() {
	return titulo;
	}


	public void setTitulo(String titulo) {
	this.titulo = titulo;
	}

	public int getValor() {
		return this.valor;
	}
	
public int getAño() {
	return año;
}


public void setAño(int año) {
	this.año = año;
}


public String getLugar() {
	return lugar;
}


public void setLugar(String lugar) {
	this.lugar = lugar;
}


public ArrayList<String> getAutores() {
	return autores;
}


public void setAutores(ArrayList<String> autores) {
	this.autores = autores;
}


public boolean isExhibida() {
	return exhibida;
}


public void setExhibida(boolean exhibida) {
	this.exhibida = exhibida;
}


public Usuario getPropietarioActual() {
	return propietarioActual;
}


public void setPropietarioActual(Usuario propietario) {
	this.propietarioActual = propietario;
}

public Usuario getPropietarioOriginal() {
	return propietarioOriginal;
}


public String getExhibaVendaoSubasta() {
	return exhibaVendaoSubasta;
}


public void setExhibaVendaoSubasta(String exhibaVendaoSubasta) {
	this.exhibaVendaoSubasta = exhibaVendaoSubasta;
}

}