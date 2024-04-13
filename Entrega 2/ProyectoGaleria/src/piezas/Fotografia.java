package piezas;
import java.util.ArrayList;

public class Fotografia extends Pieza{
	private int ancho;
	private int alto;
	private String formato;
	private boolean enmarcado;
	
	public Fotografia(String titulo, int año, String lugar, ArrayList<String> autores, Usuario propietario,
			String exhibaVendaoSubasta) {
		super(titulo, año, lugar, autores, propietario, exhibaVendaoSubasta);
		// TODO Auto-generated constructor stub
	}

}
