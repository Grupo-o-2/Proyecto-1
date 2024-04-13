package usuarios;
import java.util.ArrayList;
import modelo.*;
import piezas.*;


public class Usuario {
	private String login;
	private String password;
	private String nombre;

	

	
public Usuario(String login, String password, String nombre) {
	this.password = password;
	this.nombre = nombre;

}



 public String getLogin() {
	return login;
}



public String getPassword() {
	return password;
}


public String getNombre() {
	return nombre;
}

}


