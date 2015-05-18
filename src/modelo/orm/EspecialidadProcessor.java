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
public class EspecialidadProcessor {
	private int id;
	
	private String nombre;
	
	private String action="";
	
	public void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public void setNombre(String value) {
		this.nombre = value;
	}
	
	public String getNombre() {
		return nombre == null ? "" : nombre;
	}
	
	public String getAction() {
		return action;
	}
	
	public void setAction(String action) {
		this.action = action;
	}
	
	public String process() {
		String result = "Unexcepted result";
		if (action.equals("search")) {
			try {
				modelo.orm.Especialidad _especialidad = modelo.orm.EspecialidadDAO.loadEspecialidadByORMID(getId());
				if (_especialidad!= null) {
					copyFromBean(_especialidad);
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
				modelo.orm.Especialidad _especialidad = modelo.orm.EspecialidadDAO.createEspecialidad();
				copyToBean(_especialidad);
				if (modelo.orm.EspecialidadDAO.save(_especialidad)) {
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
				modelo.orm.Especialidad _especialidad= modelo.orm.EspecialidadDAO.loadEspecialidadByORMID(getId());
				if (_especialidad != null) {
					copyToBean(_especialidad);
					if (modelo.orm.EspecialidadDAO.save(_especialidad)) {
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
				modelo.orm.Especialidad _especialidad = modelo.orm.EspecialidadDAO.loadEspecialidadByORMID(getId());
				if (_especialidad != null && modelo.orm.EspecialidadDAO.delete(_especialidad)) {
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
	
	private void copyFromBean(modelo.orm.Especialidad _especialidad) {
		setNombre(_especialidad.getNombre());
		setId(_especialidad.getORMID());
	}
	
	private void copyToBean(modelo.orm.Especialidad _especialidad) {
		_especialidad.setNombre(getNombre());
	}
	
}

