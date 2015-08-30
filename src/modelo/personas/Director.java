package modelo.personas;

import org.json.simple.JSONObject;
import org.orm.PersistentException;

public class Director {
	
	public static boolean existe (String usuario, String pass) throws PersistentException{
		modelo.orm.Director director = modelo.orm.DirectorDAO.loadDirectorByQuery("(persona.usuario = '"+usuario+"' or persona.email = '"+usuario+"') and persona.pass = '"+pass+"'", null);
		return director != null;
	}
    
    public static JSONObject login (String usuario, String pass) throws PersistentException{
		modelo.orm.Director director = modelo.orm.DirectorDAO.loadDirectorByQuery("(persona.usuario = '"+usuario+"' or persona.email = '"+usuario+"') and persona.pass = '"+pass+"'", null);
		JSONObject respuesta = new JSONObject();
		respuesta.put("id", director.getId());
		respuesta.put("nombre", director.getPersona().getNombre()+" "+director.getPersona().getApellido());
		return respuesta;
	}
    
}
