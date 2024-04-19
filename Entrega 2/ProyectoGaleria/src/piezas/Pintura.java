package piezas;
import java.util.ArrayList;
import modelo.*;
import usuarios.*;

public class Pintura extends Pieza{
	private int alto;
	private int ancho;
	private String tipo = "Pintura";
	
	public Pintura(String titulo, int año, int valor, String lugar, String autores, boolean exhibida,
			Usuario propietario, String exhibaVendaoSubasta, int alto, int ancho, boolean consignacion) {
		super(titulo, año, valor, lugar, autores, exhibida, propietario, exhibaVendaoSubasta, consignacion);
		this.alto = alto;
		this.ancho = ancho;
	}
	
	public int getAlto() {
		return alto;
	}

	public int getAncho() {
		return ancho;
	}

	public String getTipo() {
		
		return this.tipo;
	}
	
	
}