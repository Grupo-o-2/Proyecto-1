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

public class PersistenciaPiezas {

	public PersistenciaPiezas() {

	}

	public void salvarPiezasCreadas (String archivo, ArrayList<Pieza> piezas) throws IOException
	{
		JSONObject jobject = new JSONObject( );
		HashMap<Pieza, String> identificadorPieza = new HashMap<Pieza,String>();
		salvarPiezas(piezas, jobject, identificadorPieza);
		File carpeta = new File("C:\\Users\\naran\\Desktop\\workspace_eclipse\\Proyecto-1\\Entrega 2\\ProyectoGaleria\\Persistencia\\Piezas");
		File nArchivo = new File(carpeta, archivo);
		PrintWriter pw = new PrintWriter( new FileWriter(nArchivo) );
		jobject.write( pw, 2, 0 );
		pw.close( );
	}


	public void salvarPiezas(ArrayList<Pieza> piezas, JSONObject jobject, HashMap<Pieza, String> identificadorPieza ) 
	{
		if (piezas.size()!=0)
		{
			int identificador = 0;
			JSONArray jPiezas = new JSONArray( );
			for (Pieza pieza: piezas) {
				String sIdentificador = String.valueOf(identificador);

				if ("Video".equals(pieza.getTipo()))
				{
					salvarVideos((Video) pieza, jPiezas, sIdentificador, identificadorPieza );
				}
				else if ("Pintura".equals(pieza.getTipo()))
				{
					salvarPinturas((Pintura) pieza, jPiezas, sIdentificador, identificadorPieza);
				}
				else if ("Fotografia".equals(pieza.getTipo()))
				{
					salvarFotografias((Fotografia) pieza, jPiezas, sIdentificador, identificadorPieza);
				}
				else if ("Impresion".equals(pieza.getTipo()))
				{
					salvarImpresiones((Impresion) pieza, jPiezas, sIdentificador, identificadorPieza);
				}
				else if ("Escultura".equals(pieza.getTipo()))
				{
					salvarEsculturas((Escultura) pieza, jPiezas, sIdentificador, identificadorPieza);
				}
				identificador++;
			}
			jobject.put("Piezas", jPiezas);
		}
		else 
		{
			jobject.put("Piezas", "Vacío");
		}
	}

	public void salvarVideos (Video video, JSONArray jVideos, String sIdentificador,  HashMap<Pieza, String> identificadorPieza)
	{
		JSONObject jVideo = new JSONObject( );
		jVideo.put( "Identificador", sIdentificador );
		jVideo.put( "Titulo", video.getTitulo( ) );
		jVideo.put( "Año", video.getAño( ) );
		jVideo.put( "Lugar", video.getLugar( ) );
		jVideo.put( "Autores", video.getAutores( ) );
		jVideo.put( "Exhibida", video.getExhibida() );
		jVideo.put( "Valor", video.getValor( ) );
		jVideo.put( "Proprietario", video.getPropietario( ).getLogin() );
		jVideo.put( "Exhiba venda o subasta", video.getExhibaVendaoSubasta() );
		jVideo.put( "Tipo", video.getTipo( ) );
		jVideo.put( "Alto", video.getAlto( ) );
		jVideo.put( "Ancho", video.getAncho( ) );
		jVideo.put( "Duracion", video.getDuracion( ) );
		jVideo.put( "Formato", video.getFormato( ) );
		jVideo.put( "Consignacion", video.isConsignacion( ) );
		identificadorPieza.put(video, sIdentificador);

		jVideos.put( jVideo );
	}

	public void salvarPinturas (Pintura pintura, JSONArray jPinturas, String sIdentificador, HashMap<Pieza, String> identificadorPieza)
	{
		JSONObject jPintura = new JSONObject( );
		jPintura.put( "Identificador", sIdentificador );
		jPintura.put( "Titulo", pintura.getTitulo( ) );
		jPintura.put( "Año", pintura.getAño( ) );
		jPintura.put( "Lugar", pintura.getLugar( ) );
		jPintura.put( "Autores", pintura.getAutores( ) );
		jPintura.put( "Exhibida", pintura.getExhibida() );
		jPintura.put( "Valor", pintura.getValor( ) );
		jPintura.put( "Proprietario", pintura.getPropietario( ).getLogin() );
		jPintura.put( "Exhiba venda o subasta", pintura.getExhibaVendaoSubasta() );
		jPintura.put( "Tipo", pintura.getTipo( ) );
		jPintura.put( "Alto", pintura.getAlto( ) );
		jPintura.put( "Ancho", pintura.getAncho( ) );
		jPintura.put( "Consignacion", pintura.isConsignacion( ) );
		identificadorPieza.put(pintura, sIdentificador);

		jPinturas.put( jPintura );
	}

	public void salvarImpresiones (Impresion impresion, JSONArray jImpresiones, String sIdentificador, HashMap<Pieza, String> identificadorPieza)
	{
		JSONObject jImpresion = new JSONObject( );
		jImpresion.put( "Identificador", sIdentificador );
		jImpresion.put( "Titulo", impresion.getTitulo( ) );
		jImpresion.put( "Año", impresion.getAño( ) );
		jImpresion.put( "Lugar", impresion.getLugar( ) );
		jImpresion.put( "Autores", impresion.getAutores( ) );
		jImpresion.put( "Exhibida", impresion.getExhibida() );
		jImpresion.put( "Valor", impresion.getValor( ) );
		jImpresion.put( "Proprietario", impresion.getPropietario( ).getLogin() );
		jImpresion.put( "Exhiba venda o subasta", impresion.getExhibaVendaoSubasta() );
		jImpresion.put( "Tipo", impresion.getTipo( ) );
		jImpresion.put( "Alto", impresion.getAlto( ) );
		jImpresion.put( "Ancho", impresion.getAncho( ) );
		jImpresion.put( "Consignacion", impresion.isConsignacion( ) );
		identificadorPieza.put(impresion, sIdentificador);

		jImpresiones.put( jImpresion );
	}

	public void salvarFotografias (Fotografia fotografia, JSONArray jFotografias, String sIdentificador, HashMap<Pieza, String> identificadorPieza)
	{
		JSONObject jFotografia = new JSONObject( );
		jFotografia.put( "Identificador", sIdentificador );
		jFotografia.put( "Titulo", fotografia.getTitulo( ) );
		jFotografia.put( "Año", fotografia.getAño( ) );
		jFotografia.put( "Lugar", fotografia.getLugar( ) );
		jFotografia.put( "Autores", fotografia.getAutores( ) );
		jFotografia.put( "Exhibida", fotografia.getExhibida() );
		jFotografia.put( "Valor", fotografia.getValor( ) );
		jFotografia.put( "Proprietario", fotografia.getPropietario( ).getLogin() );
		jFotografia.put( "Exhiba venda o subasta", fotografia.getExhibaVendaoSubasta() );
		jFotografia.put( "Tipo", fotografia.getTipo( ) );
		jFotografia.put( "Alto", fotografia.getAlto( ) );
		jFotografia.put( "Ancho", fotografia.getAncho( ) );
		jFotografia.put( "Formato", fotografia.getFormato( ) );
		jFotografia.put( "Enmarcado", fotografia.isEnmarcado( ) );
		jFotografia.put( "Consignacion", fotografia.isConsignacion( ) );
		identificadorPieza.put(fotografia, sIdentificador);

		jFotografias.put( jFotografia );
	}

	public void salvarEsculturas (Escultura escultura, JSONArray jEsculturas, String sIdentificador, HashMap<Pieza, String> identificadorPieza)
	{
		JSONObject jEscultura = new JSONObject( );
		jEscultura.put( "Identificador", sIdentificador );
		jEscultura.put( "Titulo", escultura.getTitulo( ) );
		jEscultura.put( "Año", escultura.getAño( ) );
		jEscultura.put( "Lugar", escultura.getLugar( ) );
		jEscultura.put( "Autores", escultura.getAutores( ) );
		jEscultura.put( "Exhibida", escultura.getExhibida() );
		jEscultura.put( "Valor", escultura.getValor( ) );
		jEscultura.put( "Proprietario", escultura.getPropietario( ).getLogin() );
		jEscultura.put( "Exhiba venda o subasta", escultura.getExhibaVendaoSubasta() );
		jEscultura.put( "Tipo", escultura.getTipo( ) );
		jEscultura.put( "Alto", escultura.getAlto( ) );
		jEscultura.put( "Ancho", escultura.getAncho( ) );
		jEscultura.put( "Profundidad", escultura.getProfundidad( ) );
		jEscultura.put( "Materiales", escultura.getMateriales( ) );
		jEscultura.put( "Peso", escultura.getPeso( ) );
		jEscultura.put( "Electricidad", escultura.isElectricidad( ) );
		jEscultura.put( "Otro detalle", escultura.isOtroDetalle( ) );
		jEscultura.put( "Consignacion", escultura.isConsignacion( ) );
		identificadorPieza.put(escultura, sIdentificador);

		jEsculturas.put( jEscultura );
	}

	public void cargarPiezas(JSONArray jPiezas, Galeria galeria, HashMap<String, Comprador> loginCompradores, HashMap<String, Pieza> identificacionPieza) throws LoginInexistenteException
	{ 
		int numeroPiezas = jPiezas.length();
		for (int i = 0 ; i < numeroPiezas ; i++)
		{
			JSONObject pieza = jPiezas.getJSONObject( i );
			String tipo = pieza.getString("Tipo");
			if ("Video".equals(tipo))
			{
				cargarVideo(pieza, galeria, loginCompradores, identificacionPieza );
			}
			else if ("Pintura".equals(tipo))
			{
				cargarPintura(pieza, galeria, loginCompradores, identificacionPieza);
			}
			else if ("Fotografia".equals(tipo))
			{
				cargarFotografia(pieza, galeria, loginCompradores, identificacionPieza);
			}
			else if ("Impresion".equals(tipo))
			{
				cargarImpresion(pieza, galeria, loginCompradores, identificacionPieza);
			}
			else if ("Escultura".equals(tipo))
			{
				cargarEscultura(pieza, galeria, loginCompradores, identificacionPieza);
			}
		}
	}

	public void cargarEscultura(JSONObject jEscultura, Galeria galeria, HashMap<String, Comprador> loginCompradores, HashMap<String, Pieza> identificacionPieza) throws LoginInexistenteException
	{
		String nAutores = jEscultura.getString("Autores");
		String nLugar = jEscultura.getString("Lugar");
		String nTitulo = jEscultura.getString("Titulo");
		int nValor = jEscultura.getInt("Valor");
		String nExhibaVendaoSubaste = jEscultura.getString("Exhiba venda o subasta");
		int nAño = jEscultura.getInt("Año");
		String loginComprador = jEscultura.getString("Proprietario");
		if (! loginCompradores.containsKey(loginComprador))
		{
			throw new LoginInexistenteException(loginComprador);
		}
		Comprador nPropietario = loginCompradores.get(loginComprador);
		boolean nExhibida = jEscultura.getBoolean("Exhibida");
		int nAlto = jEscultura.getInt("Alto");
		int nAancho = jEscultura.getInt("Ancho");
		int nProfundidad = jEscultura.getInt("Profunidad");
		String nMateriales = jEscultura.getString("Materiales");
		int nPeso = jEscultura.getInt("Peso");
		boolean nElectricidad = jEscultura.getBoolean("Electricidad");
		boolean nOtroDetalle = jEscultura.getBoolean("Otro detalle");
		boolean nConsignacion = jEscultura.getBoolean("Consignacion");
		Escultura escultura = galeria.getFabrica().crearEscultura(nTitulo, nAño, nValor, nLugar, nAutores, nExhibida, nPropietario, nExhibaVendaoSubaste, nAlto, nAancho, nProfundidad, nMateriales, nPeso, nElectricidad, nOtroDetalle, nConsignacion, true, false, "20/09/2024");
		identificacionPieza.put(jEscultura.getString("Identificador"), escultura);
	}

	public void cargarFotografia(JSONObject jFotografia, Galeria galeria, HashMap<String, Comprador> loginCompradores, HashMap<String, Pieza> identificacionPieza) throws LoginInexistenteException
	{
		String nAutores = jFotografia.getString("Autores");
		String nLugar = jFotografia.getString("Lugar");
		String nTitulo = jFotografia.getString("Titulo");
		int nValor = jFotografia.getInt("Valor");
		String nExhibaVendaoSubaste = jFotografia.getString("Exhiba venda o subasta");
		int nAño = jFotografia.getInt("Año");
		String loginComprador = jFotografia.getString("Proprietario");
		if (! loginCompradores.containsKey(loginComprador))
		{
			throw new LoginInexistenteException(loginComprador);
		}
		Comprador nPropietario = loginCompradores.get(loginComprador);
		boolean nExhibida = jFotografia.getBoolean("Exhibida");
		int nAlto = jFotografia.getInt("Alto");
		int nAancho = jFotografia.getInt("Ancho");
		String nFormato = jFotografia.getString("Formato");
		boolean nEnmarcado = jFotografia.getBoolean("Enmarcado");
		boolean nConsignacion = jFotografia.getBoolean("Consignacion");
		Fotografia fotografia = galeria.getFabrica().crearFotografia(nTitulo, nAño, nValor, nLugar, nAutores, nExhibida, nPropietario, nExhibaVendaoSubaste, nAlto, nAancho, nFormato, nEnmarcado, nConsignacion, true, false, "20/09/2024");
		identificacionPieza.put(jFotografia.getString("Identificador"), fotografia);

	}

	public void cargarImpresion(JSONObject jImpresion, Galeria galeria, HashMap<String, Comprador> loginCompradores, HashMap<String, Pieza> identificacionPieza) throws LoginInexistenteException
	{
		String nAutores = jImpresion.getString("Autores");
		String nLugar = jImpresion.getString("Lugar");
		String nTitulo = jImpresion.getString("Titulo");
		int nValor = jImpresion.getInt("Valor");
		String nExhibaVendaoSubaste = jImpresion.getString("Exhiba venda o subasta");
		int nAño = jImpresion.getInt("Año");
		String loginComprador = jImpresion.getString("Proprietario");
		if (! loginCompradores.containsKey(loginComprador))
		{
			throw new LoginInexistenteException(loginComprador);
		}
		Comprador nPropietario = loginCompradores.get(loginComprador);
		boolean nExhibida = jImpresion.getBoolean("Exhibida");
		int nAlto = jImpresion.getInt("Alto");
		int nAncho = jImpresion.getInt("Ancho");
		boolean nConsignacion = jImpresion.getBoolean("Consignacion");
		Impresion impresion = galeria.getFabrica().crearImpresion(nTitulo, nAño, nValor, nLugar, nAutores, nExhibida, nPropietario, nExhibaVendaoSubaste, nAncho, nAlto, nConsignacion, true, false, "20/09/2024");
		identificacionPieza.put(jImpresion.getString("Identificador"), impresion);

	}

	public void cargarPintura(JSONObject jPintura, Galeria galeria, HashMap<String, Comprador> loginCompradores, HashMap<String, Pieza> identificacionPieza) throws LoginInexistenteException
	{
		String nAutores = jPintura.getString("Autores");
		String nLugar = jPintura.getString("Lugar");
		String nTitulo = jPintura.getString("Titulo");
		int nValor = jPintura.getInt("Valor");
		String nExhibaVendaoSubaste = jPintura.getString("Exhiba venda o subasta");
		int nAño = jPintura.getInt("Año");
		String loginComprador = jPintura.getString("Proprietario");
		if (! loginCompradores.containsKey(loginComprador))
		{
			throw new LoginInexistenteException(loginComprador);
		}
		Comprador nPropietario = loginCompradores.get(loginComprador);
		boolean nExhibida = jPintura.getBoolean("Exhibida");
		int nAlto = jPintura.getInt("Alto");
		int nAncho = jPintura.getInt("Ancho");
		boolean nConsignacion = jPintura.getBoolean("Consignacion");
		Pintura pintura = galeria.getFabrica().crearPintura(nTitulo, nAño, nValor, nLugar, nAutores, nExhibida, nPropietario, nExhibaVendaoSubaste, nAncho, nAlto, nConsignacion, true, false, "20/09/2024");
		identificacionPieza.put(jPintura.getString("Identificador"), pintura);

	}


	public void cargarVideo(JSONObject jVideo, Galeria galeria, HashMap<String, Comprador> loginCompradores, HashMap<String, Pieza> identificacionPieza) throws LoginInexistenteException
	{
		String nAutores = jVideo.getString("Autores");
		String nLugar = jVideo.getString("Lugar");
		String nTitulo = jVideo.getString("Titulo");
		int nValor = jVideo.getInt("Valor");
		String nExhibaVendaoSubaste = jVideo.getString("Exhiba venda o subasta");
		int nAño = jVideo.getInt("Año");
		String loginComprador = jVideo.getString("Proprietario");
		if (! loginCompradores.containsKey(loginComprador))
		{
			throw new LoginInexistenteException(loginComprador);
		}
		Comprador nPropietario = loginCompradores.get(loginComprador);
		boolean nExhibida = jVideo.getBoolean("Exhibida");
		int nAlto = jVideo.getInt("Alto");
		int nAncho = jVideo.getInt("Ancho");
		int nDuracion = jVideo.getInt("Duracion");
		String nFormato = jVideo.getString("Formato");
		boolean nConsignacion = jVideo.getBoolean("Consignacion");
		Video video = galeria.getFabrica().crearVideo(nTitulo, nAño, nValor, nLugar, nAutores, nExhibida, nPropietario, nExhibaVendaoSubaste, nAncho, nAlto, nDuracion, nFormato, nConsignacion, true, false, "20/09/2024");
		identificacionPieza.put(jVideo.getString("Identificador"), video);
	}

}



