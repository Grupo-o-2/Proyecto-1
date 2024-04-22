package persistencia;

import piezas.*; 
import usuarios.*;
import modelo.*;
import fabrica.*;
import exceptions.*;
import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

import org.json.JSONArray;
import org.json.JSONObject;
public class PersistenciaUsuarios {

	public void salvarUsuariosCreados (String archivo, ArrayList<Usuario> compradores, HashMap<Pieza, String> identificadorPieza) throws IOException
	{
		JSONObject jobject = new JSONObject( );
		salvarUsuarios(compradores, jobject, identificadorPieza);
		File carpeta = new File("C:\\Users\\naran\\Desktop\\workspace_eclipse\\Proyecto-1\\Entrega 2\\ProyectoGaleria\\Persistencia\\Usuarios");
		File nArchivo = new File(carpeta, archivo);
		PrintWriter pw = new PrintWriter( new FileWriter(nArchivo) );
		jobject.write( pw, 2, 0 );
		pw.close( );
	}


	public void salvarUsuarios(ArrayList<Usuario> usuarios, JSONObject jobject, HashMap<Pieza, String> identificadorPieza) 
	{
		JSONArray jUsuarios = new JSONArray( );
		for (Usuario usuario: usuarios) {

			if ("Comprador".equals(usuario.getTipo()))
			{
				salvarComprador((Comprador) usuario, jUsuarios, identificadorPieza );
			}
			else if ("Administrador".equals(usuario.getTipo()) || "Cajero".equals(usuario.getTipo()) || "Operador".equals(usuario.getTipo()))
			{
				salvarAdministradorOperadorCajero(usuario, jUsuarios);
			}
			else if ("Empleado".equals(usuario.getTipo()))
			{
				salvarEmpleado((Empleado) usuario, jUsuarios);
			}
		}
		jobject.put("Usuarios", jUsuarios);
	}

	public void salvarComprador(Comprador comprador, JSONArray jCompradores, HashMap<Pieza, String> identificadorPieza)
	{
		JSONObject jComprador = new JSONObject( );
		jComprador.put( "Login", comprador.getLogin() );
		jComprador.put( "Password", comprador.getPassword() );
		jComprador.put( "Nombre", comprador.getNombre( ) );
		jComprador.put( "Dinero", comprador.getDinero( ) );
		jComprador.put( "Telefono", comprador.getTelefono() );
		jComprador.put( "Valor Maximo Compras", comprador.getValorMaximoCompras( ) );
		String piezasActuales = "";
		if (! comprador.getPiezasActuales().isEmpty())
		{
			for (Pieza pieza: comprador.getPiezasActuales())
			{
				piezasActuales = piezasActuales + "," + identificadorPieza.get(pieza);
				comprador.getHistorialPiezas().remove(pieza);
			}
			jComprador.put( "Piezas Actuales", piezasActuales );
		}
		else
		{
			jComprador.put( "Piezas Actuales", "Vacío");
		}
		String historialPiezas = "";
		if (! comprador.getHistorialPiezas().isEmpty())
		{
			for (Pieza pieza: comprador.getHistorialPiezas())
			{
				historialPiezas = historialPiezas + "," + identificadorPieza.get(pieza);
			}
			jComprador.put( "Historial Piezas", historialPiezas);
		}
		else
		{
			jComprador.put( "Historial Piezas", "Vacío");
		}
		jComprador.put( "Tipo", comprador.getTipo( ) );

		jCompradores.put( jComprador );
	}
	
	public void salvarAdministradorOperadorCajero(Usuario usuario, JSONArray jCompradores)
	{
		JSONObject jComprador = new JSONObject( );
		jComprador.put( "Login", usuario.getLogin() );
		jComprador.put( "Password", usuario.getPassword() );
		jComprador.put( "Nombre", usuario.getNombre( ) );
		jComprador.put( "Telefono", usuario.getTelefono() );
		jComprador.put( "Tipo", usuario.getTipo( ) );

		jCompradores.put( jComprador );
	}
	
	public void salvarEmpleado(Empleado empleado, JSONArray jCompradores)
	{
		JSONObject jComprador = new JSONObject( );
		jComprador.put( "Login", empleado.getLogin() );
		jComprador.put( "Password", empleado.getPassword() );
		jComprador.put( "Nombre", empleado.getNombre( ) );
		jComprador.put( "Telefono", empleado.getTelefono() );
		jComprador.put( "Tipo", empleado.getTipo( ) );

		jCompradores.put( jComprador );
	}

	public void cargarUsuarios(JSONArray jUsuarios, Galeria galeria, HashMap<String, Comprador> loginCompradores,
			HashMap<Comprador , String> historialCompradores) throws LoginException
	{
		Fabrica fabrica = galeria.getFabrica(); 
		int numeroCompradores = jUsuarios.length();
		for (int i = 0 ; i < numeroCompradores ; i++)
		{
			JSONObject usuario = jUsuarios.getJSONObject( i );
			String tipo = usuario.getString("Tipo");
				if ("Comprador".equals(tipo))
				{
					cargarComprador(usuario, galeria, loginCompradores, 
							historialCompradores, fabrica);
				}
				else if ("Empleado".equals(tipo))
				{
					cargarAdministrador(usuario, galeria, fabrica);
				}
				else if ("Administrador".equals(tipo))
				{
					cargarCajero(usuario, galeria, fabrica);						
				}
				else if ("Cajero".equals(tipo))
				{
					cargarOperador(usuario, galeria, fabrica);
				}
				else if ("Operador".equals(tipo))
				{
					cargarEmpleado(usuario, galeria, fabrica);
				}
		}

	}
	
	public void cargarComprador(JSONObject jComprador, Galeria galeria, HashMap<String, Comprador> loginCompradores,
			HashMap<Comprador , String> historialCompradores, Fabrica fabrica) throws LoginException
	{
			String nLogin = jComprador.getString("Login");
			String nPassword = jComprador.getString("Password");
			String nNombre = jComprador.getString("Nombre");
			int nDinero = jComprador.getInt("Dinero");
			int nValorMaximoCompras = jComprador.getInt("Valor Maximo Compras");
			int nTelefono = jComprador.getInt("Telefono");
			ArrayList<Pieza> nHistorialPiezas = new ArrayList<Pieza>();
			ArrayList<Pieza> nPiezasActuales = new ArrayList<Pieza>();
			Comprador nComprador = fabrica.crearComprador(nLogin, nPassword, nNombre, nValorMaximoCompras, nHistorialPiezas, nPiezasActuales, nDinero, nTelefono, galeria);
			loginCompradores.put(nLogin, nComprador);
			String nHistorialPiezasString = jComprador.getString("Historial Piezas");
			if (! nHistorialPiezasString.equals("Vacío"))
			{
				historialCompradores.put(nComprador,nHistorialPiezasString );
			}
		}
	
	public void cargarAdministrador(JSONObject jAdministrador, Galeria galeria,
			Fabrica fabrica) throws LoginException
	{
			String nLogin = jAdministrador.getString("Login");
			if (galeria.getUsuarios().contains(nLogin))
			{
				throw new LoginException(nLogin);
			}
			String nPassword = jAdministrador.getString("Password");
			String nNombre = jAdministrador.getString("Nombre");
			int nTelefono = jAdministrador.getInt("Telefono");
			Administrador nAdministrador = fabrica.crearAdministrador(nLogin, nPassword,nTelefono, nNombre, galeria);
		}
	
	public void cargarCajero(JSONObject jCajero, Galeria galeria,
			Fabrica fabrica) throws LoginException
	{
		String nLogin = jCajero.getString("Login");
		String nPassword = jCajero.getString("Password");
		String nNombre = jCajero.getString("Nombre");
		int nTelefono = jCajero.getInt("Telefono");
		Cajero nCajero = fabrica.crearCajero(nLogin, nPassword,nTelefono, nNombre, galeria);
		}
	
	public void cargarOperador(JSONObject jOperador, Galeria galeria,
			Fabrica fabrica) throws LoginException
	{
			String nLogin = jOperador.getString("Login");
			String nPassword = jOperador.getString("Password");
			String nNombre = jOperador.getString("Nombre");
			int nTelefono = jOperador.getInt("Telefono");
			Operador nOperador = fabrica.crearOperador(nLogin, nPassword, nTelefono, nNombre, galeria);
		}

	public void cargarEmpleado(JSONObject jEmpleado, Galeria galeria,
			Fabrica fabrica) throws LoginException
	{
			String nLogin = jEmpleado.getString("Login");
			String nPassword = jEmpleado.getString("Password");
			String nNombre = jEmpleado.getString("Nombre");
			int nTelefono = jEmpleado.getInt("Telefono");
			Empleado nEmpleado = fabrica.crearEmpleado(nLogin, nPassword, nTelefono, nNombre, galeria);
		}	
}
