package consolas;

import fabrica.Fabrica;
import modelo.*;

public class ConsolaComprador extends Consola{
	
	public ConsolaComprador()
	{
		
	}
	
	public void mostrarMenu(){
		System.out.println("------------------------------------------------------------------------------------------\n");
		System.out.println("Opciones disponibles:\n\n");
		System.out.println("0: Salir de la aplicación.\n");
		System.out.println("1: Hacer una consignación.\n");
		System.out.println("2: Comprar una pieza.\n");
		System.out.println("3: Realizar una oferta en una subasta.\n");
	}
	
}

