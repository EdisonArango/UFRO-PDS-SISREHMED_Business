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
public class MedicoProcessor {
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
	
	private int especialidad_especialidadid;
	
	public void setEspecialidad_especialidadid(int value) {
		this.especialidad_especialidadid = value;
	}
	
	public int getEspecialidad_especialidadid() {
		return especialidad_especialidadid;
	}
	
	public String process() {
		String result = "Unexcepted result";
		if (action.equals("search")) {
			try {
				modelo.orm.Medico _medico = modelo.orm.MedicoDAO.loadMedicoByORMID(getId());
				if (_medico!= null) {
					copyFromBean(_medico);
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
				modelo.orm.Medico _medico = modelo.orm.MedicoDAO.createMedico();
				copyToBean(_medico);
				if (modelo.orm.MedicoDAO.save(_medico)) {
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
				modelo.orm.Medico _medico= modelo.orm.MedicoDAO.loadMedicoByORMID(getId());
				if (_medico != null) {
					copyToBean(_medico);
					if (modelo.orm.MedicoDAO.save(_medico)) {
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
				modelo.orm.Medico _medico = modelo.orm.MedicoDAO.loadMedicoByORMID(getId());
				if (_medico != null && modelo.orm.MedicoDAO.delete(_medico)) {
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
	
	private void copyFromBean(modelo.orm.Medico _medico) {
		setId(_medico.getORMID());
		
		{
			modelo.orm.Persona _persona = _medico.getPersona();
			if (_persona != null) {
				setPersona_personaid(_persona.getORMID());
			}
		}
		
		
		{
			modelo.orm.Especialidad _especialidad = _medico.getEspecialidad();
			if (_especialidad != null) {
				setEspecialidad_especialidadid(_especialidad.getORMID());
			}
		}
		
	}
	
	private void copyToBean(modelo.orm.Medico _medico) {
		try  {
			modelo.orm.Persona _persona = modelo.orm.PersonaDAO.loadPersonaByORMID(getPersona_personaid());
			_medico.setPersona(_persona);
		}
		catch (PersistentException e) {
		}
		
		try  {
			modelo.orm.Especialidad _especialidad = modelo.orm.EspecialidadDAO.loadEspecialidadByORMID(getEspecialidad_especialidadid());
			_medico.setEspecialidad(_especialidad);
		}
		catch (PersistentException e) {
		}
		
	}
	
}

