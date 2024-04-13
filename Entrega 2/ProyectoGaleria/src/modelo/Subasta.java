package modelo;
import java.util.ArrayList;
import java.util.HashMap;
import usuarios.*;
import piezas.*;

public class Subasta {
	private ArrayList<Usuario> participantes;
	private Usuario operador;
	private HashMap<Pieza,HashMap<Usuario, Integer>> registroSubasta;
	private ArrayList<Pieza> piezas;
}
