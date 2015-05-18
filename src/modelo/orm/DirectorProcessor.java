/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package modelo.orm;

import org.orm.PersistentException;
public class DirectorProcessor {
	private int id;
	
	private String action="";
	
	public void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public String getAction() {
		return action;
	}
	
	public void setAction(String action) {
		this.action = action;
	}
	
	private int persona_personaid;
	
	public void setPersona_personaid(int value) {
		this.persona_personaid = value;
	}
	
	public int getPersona_personaid() {
		return persona_personaid;
	}
	
	public String process() {
		String result = "Unexcepted result";
		if (action.equals("search")) {
			try {
				modelo.orm.Director _director = modelo.orm.DirectorDAO.loadDirectorByORMID(getId());
				if (_director!= null) {
					copyFromBean(_director);
					result = "Search success";
				}
				else {
					result = "Search failed";
				}
			}
			catch (PersistentException e) {
				result = "Search error: " + e.toString();
			}
		}
		else if(action.equals("insert"))  {
			try {
				modelo.orm.Director _director = modelo.orm.DirectorDAO.createDirector();
				copyToBean(_director);
				if (modelo.orm.DirectorDAO.save(_director)) {
					result = "Insert success";
				}
				else {
					result = "Insert failed";
				}
			}
			catch (Exception e) {
				result = "Insert error: " + e.toString();
			}
		}
		else if (action.equals("update")) {
			try {
				modelo.orm.Director _director= modelo.orm.DirectorDAO.loadDirectorByORMID(getId());
				if (_director != null) {
					copyToBean(_director);
					if (modelo.orm.DirectorDAO.save(_director)) {
						result = "Update success";
					}
					 else {
						result = "Update failed";
					}
				}
				 else  {
					result = "Update failed";
				}
				
			}
			catch (PersistentException e) {
				result = "Update error: " + e.toString();
			}
		}
		else if (action.equals("delete")) {
			try {
				modelo.orm.Director _director = modelo.orm.DirectorDAO.loadDirectorByORMID(getId());
				if (_director != null && modelo.orm.DirectorDAO.delete(_director)) {
					result = "Delete success";
				}
				else {
					result = "Delete failed";
				}
			}
			catch (PersistentException e)  {
				result = "Delete error: " + e.toString();
			}
		}
		else if (action.equals("")) {
			result = "";
		}
		action = "";
		return result;
	}
	
	private void copyFromBean(modelo.orm.Director _director) {
		setId(_director.getORMID());
		
		{
			modelo.orm.Persona _persona = _director.getPersona();
			if (_persona != null) {
				setPersona_personaid(_persona.getORMID());
			}
		}
		
	}
	
	private void copyToBean(modelo.orm.Director _director) {
		try  {
			modelo.orm.Persona _persona = modelo.orm.PersonaDAO.loadPersonaByORMID(getPersona_personaid());
			_director.setPersona(_persona);
		}
		catch (PersistentException e) {
		}
		
	}
	
}

