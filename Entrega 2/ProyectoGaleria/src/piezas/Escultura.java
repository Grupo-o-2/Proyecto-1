package piezas;
import java.util.ArrayList;
import usuarios.*;

public class Escultura extends Pieza {
	private int alto;
	private int ancho;
	private int profundidad;
	private ArrayList<String> materiales;
	private int peso;
	private boolean electricidad;
	private boolean otroDetalle;
	
	
	
	public Escultura(String titulo, int año, String lugar, ArrayList<String> autores, Usuario propietario,
			String exhibaVendaoSubasta) {
		super(titulo, año, lugar, autores, propietario, exhibaVendaoSubasta);
		// TODO Auto-generated constructor stub
	}

}
