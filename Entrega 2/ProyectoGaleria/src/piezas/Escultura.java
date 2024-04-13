package piezas;
import java.util.ArrayList;
import modelo.*;
import usuarios.*;

public class Escultura extends Pieza {
	private int alto;
	private int ancho;
	private int profundidad;
	private ArrayList<String> materiales;
	private int peso;
	private boolean electricidad;
	private boolean otroDetalle;
	
	
	public Escultura(String titulo, int año, int valor, String lugar, ArrayList<String> autores, boolean exhibida,
			Usuario propietarioActual, Usuario propietarioOriginal, String exhibaVendaoSubasta) {
		super(titulo, año, valor, lugar, autores, exhibida, propietarioActual, propietarioOriginal, exhibaVendaoSubasta);
		// TODO Auto-generated constructor stub
	}
	

}
