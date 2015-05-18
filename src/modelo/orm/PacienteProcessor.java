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
public class PacienteProcessor {
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
				modelo.orm.Paciente _paciente = modelo.orm.PacienteDAO.loadPacienteByORMID(getId());
				if (_paciente!= null) {
					copyFromBean(_paciente);
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
				modelo.orm.Paciente _paciente = modelo.orm.PacienteDAO.createPaciente();
				copyToBean(_paciente);
				if (modelo.orm.PacienteDAO.save(_paciente)) {
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
				modelo.orm.Paciente _paciente= modelo.orm.PacienteDAO.loadPacienteByORMID(getId());
				if (_paciente != null) {
					copyToBean(_paciente);
					if (modelo.orm.PacienteDAO.save(_paciente)) {
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
				modelo.orm.Paciente _paciente = modelo.orm.PacienteDAO.loadPacienteByORMID(getId());
				if (_paciente != null && modelo.orm.PacienteDAO.delete(_paciente)) {
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
	
	private void copyFromBean(modelo.orm.Paciente _paciente) {
		setId(_paciente.getORMID());
		
		{
			modelo.orm.Persona _persona = _paciente.getPersona();
			if (_persona != null) {
				setPersona_personaid(_persona.getORMID());
			}
		}
		
	}
	
	private void copyToBean(modelo.orm.Paciente _paciente) {
		try  {
			modelo.orm.Persona _persona = modelo.orm.PersonaDAO.loadPersonaByORMID(getPersona_personaid());
			_paciente.setPersona(_persona);
		}
		catch (PersistentException e) {
		}
		
	}
	
}

