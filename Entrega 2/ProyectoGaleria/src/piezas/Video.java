package piezas;
import java.util.ArrayList;
import usuarios.*;

public class Video extends Pieza {
	private int alto;
	private int ancho;
	private int duracion;
	private String formato;
		
	public Video(String titulo, int año, String lugar, ArrayList<String> autores, Usuario propietario,
			String exhibaVendaoSubasta) {
		super(titulo, año, lugar, autores, propietario, exhibaVendaoSubasta);
		// TODO Auto-generated constructor stub
	}

}
