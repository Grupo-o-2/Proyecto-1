package piezas;

import java.util.ArrayList;
import modelo.*;
import usuarios.*;

public class Video extends Pieza {
	private int alto;
	private int ancho;
	private int duracion;
	private String formato;
	
	public Video(String titulo, int año, int valor, String lugar, ArrayList<String> autores, boolean exhibida,
			Usuario propietarioActual, Usuario propietarioOriginal, String exhibaVendaoSubasta) {
		super(titulo, año, valor, lugar, autores, exhibida, propietarioActual, propietarioOriginal, exhibaVendaoSubasta);
		// TODO Auto-generated constructor stub
	}
		
	
}