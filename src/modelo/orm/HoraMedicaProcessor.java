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
public class HoraMedicaProcessor {
	private int id;
	
	private Integer esAPS;
	
	private String fecha;
	
	private String action="";
	
	public void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public void setEsAPS(int value) {
		setEsAPS(new Integer(value));
	}
	
	public void setEsAPS(Integer value) {
		this.esAPS = value;
	}
	
	public Integer getEsAPS() {
		return esAPS;
	}
	
	public void setFecha(String value) {
		this.fecha = value;
	}
	
	public String getFecha() {
		return fecha == null ? "" : fecha;
	}
	
	public String getAction() {
		return action;
	}
	
	public void setAction(String action) {
		this.action = action;
	}
	
	private int medico_medicoid;
	
	public void setMedico_medicoid(int value) {
		this.medico_medicoid = value;
	}
	
	public int getMedico_medicoid() {
		return medico_medicoid;
	}
	
	private int box_boxid;
	
	public void setBox_boxid(int value) {
		this.box_boxid = value;
	}
	
	public int getBox_boxid() {
		return box_boxid;
	}
	
	public String process() {
		String result = "Unexcepted result";
		if (action.equals("search")) {
			try {
				modelo.orm.HoraMedica _horaMedica = modelo.orm.HoraMedicaDAO.loadHoraMedicaByORMID(getId());
				if (_horaMedica!= null) {
					copyFromBean(_horaMedica);
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
				modelo.orm.HoraMedica _horaMedica = modelo.orm.HoraMedicaDAO.createHoraMedica();
				copyToBean(_horaMedica);
				if (modelo.orm.HoraMedicaDAO.save(_horaMedica)) {
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
				modelo.orm.HoraMedica _horaMedica= modelo.orm.HoraMedicaDAO.loadHoraMedicaByORMID(getId());
				if (_horaMedica != null) {
					copyToBean(_horaMedica);
					if (modelo.orm.HoraMedicaDAO.save(_horaMedica)) {
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
				modelo.orm.HoraMedica _horaMedica = modelo.orm.HoraMedicaDAO.loadHoraMedicaByORMID(getId());
				if (_horaMedica != null && modelo.orm.HoraMedicaDAO.delete(_horaMedica)) {
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
	
	private void copyFromBean(modelo.orm.HoraMedica _horaMedica) {
		setEsAPS(_horaMedica.getEsAPS());
		setFecha(_horaMedica.getFecha());
		setId(_horaMedica.getORMID());
		
		{
			modelo.orm.Medico _medico = _horaMedica.getMedico();
			if (_medico != null) {
				setMedico_medicoid(_medico.getORMID());
			}
		}
		
		
		{
			modelo.orm.Box _box = _horaMedica.getBox();
			if (_box != null) {
				setBox_boxid(_box.getORMID());
			}
		}
		
	}
	
	private void copyToBean(modelo.orm.HoraMedica _horaMedica) {
		_horaMedica.setEsAPS(getEsAPS());
		_horaMedica.setFecha(getFecha());
		try  {
			modelo.orm.Medico _medico = modelo.orm.MedicoDAO.loadMedicoByORMID(getMedico_medicoid());
			_horaMedica.setMedico(_medico);
		}
		catch (PersistentException e) {
		}
		
		try  {
			modelo.orm.Box _box = modelo.orm.BoxDAO.loadBoxByORMID(getBox_boxid());
			_horaMedica.setBox(_box);
		}
		catch (PersistentException e) {
		}
		
	}
	
}

