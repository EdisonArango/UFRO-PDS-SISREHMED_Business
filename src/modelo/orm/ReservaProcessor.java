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
public class ReservaProcessor {
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
	
	private int paciente_pacienteid;
	
	public void setPaciente_pacienteid(int value) {
		this.paciente_pacienteid = value;
	}
	
	public int getPaciente_pacienteid() {
		return paciente_pacienteid;
	}
	
	private int horaMedica_horaMedicaid;
	
	public void setHoraMedica_horaMedicaid(int value) {
		this.horaMedica_horaMedicaid = value;
	}
	
	public int getHoraMedica_horaMedicaid() {
		return horaMedica_horaMedicaid;
	}
	
	private int personaQueRegistra_personaid;
	
	public void setPersonaQueRegistra_personaid(int value) {
		this.personaQueRegistra_personaid = value;
	}
	
	public int getPersonaQueRegistra_personaid() {
		return personaQueRegistra_personaid;
	}
	
	public String process() {
		String result = "Unexcepted result";
		if (action.equals("search")) {
			try {
				modelo.orm.Reserva _reserva = modelo.orm.ReservaDAO.loadReservaByORMID(getId());
				if (_reserva!= null) {
					copyFromBean(_reserva);
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
				modelo.orm.Reserva _reserva = modelo.orm.ReservaDAO.createReserva();
				copyToBean(_reserva);
				if (modelo.orm.ReservaDAO.save(_reserva)) {
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
				modelo.orm.Reserva _reserva= modelo.orm.ReservaDAO.loadReservaByORMID(getId());
				if (_reserva != null) {
					copyToBean(_reserva);
					if (modelo.orm.ReservaDAO.save(_reserva)) {
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
				modelo.orm.Reserva _reserva = modelo.orm.ReservaDAO.loadReservaByORMID(getId());
				if (_reserva != null && modelo.orm.ReservaDAO.delete(_reserva)) {
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
	
	private void copyFromBean(modelo.orm.Reserva _reserva) {
		setId(_reserva.getORMID());
		
		{
			modelo.orm.Paciente _paciente = _reserva.getPaciente();
			if (_paciente != null) {
				setPaciente_pacienteid(_paciente.getORMID());
			}
		}
		
		
		{
			modelo.orm.HoraMedica _horaMedica = _reserva.getHoraMedica();
			if (_horaMedica != null) {
				setHoraMedica_horaMedicaid(_horaMedica.getORMID());
			}
		}
		
		
		{
			modelo.orm.Persona _persona = _reserva.getPersonaQueRegistra();
			if (_persona != null) {
				setPersonaQueRegistra_personaid(_persona.getORMID());
			}
		}
		
	}
	
	private void copyToBean(modelo.orm.Reserva _reserva) {
		try  {
			modelo.orm.Paciente _paciente = modelo.orm.PacienteDAO.loadPacienteByORMID(getPaciente_pacienteid());
			_reserva.setPaciente(_paciente);
		}
		catch (PersistentException e) {
		}
		
		try  {
			modelo.orm.HoraMedica _horaMedica = modelo.orm.HoraMedicaDAO.loadHoraMedicaByORMID(getHoraMedica_horaMedicaid());
			_reserva.setHoraMedica(_horaMedica);
		}
		catch (PersistentException e) {
		}
		
		try  {
			modelo.orm.Persona _personaQueRegistra = modelo.orm.PersonaDAO.loadPersonaByORMID(getPersonaQueRegistra_personaid());
			_reserva.setPersonaQueRegistra(_personaQueRegistra);
		}
		catch (PersistentException e) {
		}
		
	}
	
}

