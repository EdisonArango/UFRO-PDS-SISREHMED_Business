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
public class PersonaProcessor {
	private int id;
	
	private String nombre;
	
	private String apellido;
	
	private String rut;
	
	private Integer edad;
	
	private String direccion;
	
	private String ciudad;
	
	private String comuna;
	
	private String login;
	
	private String pass;
	
	private String email;
	
	private Integer status;
	
	private String fecha_nacimiento;
	
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
	
	public void setApellido(String value) {
		this.apellido = value;
	}
	
	public String getApellido() {
		return apellido == null ? "" : apellido;
	}
	
	public void setRut(String value) {
		this.rut = value;
	}
	
	public String getRut() {
		return rut == null ? "" : rut;
	}
	
	public void setEdad(int value) {
		setEdad(new Integer(value));
	}
	
	public void setEdad(Integer value) {
		this.edad = value;
	}
	
	public Integer getEdad() {
		return edad;
	}
	
	public void setDireccion(String value) {
		this.direccion = value;
	}
	
	public String getDireccion() {
		return direccion == null ? "" : direccion;
	}
	
	public void setCiudad(String value) {
		this.ciudad = value;
	}
	
	public String getCiudad() {
		return ciudad == null ? "" : ciudad;
	}
	
	public void setComuna(String value) {
		this.comuna = value;
	}
	
	public String getComuna() {
		return comuna == null ? "" : comuna;
	}
	
	public void setLogin(String value) {
		this.login = value;
	}
	
	public String getLogin() {
		return login == null ? "" : login;
	}
	
	public void setPass(String value) {
		this.pass = value;
	}
	
	public String getPass() {
		return pass == null ? "" : pass;
	}
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return email == null ? "" : email;
	}
	
	public void setStatus(int value) {
		setStatus(new Integer(value));
	}
	
	public void setStatus(Integer value) {
		this.status = value;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setFecha_nacimiento(String value) {
		this.fecha_nacimiento = value;
	}
	
	public String getFecha_nacimiento() {
		return fecha_nacimiento == null ? "" : fecha_nacimiento;
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
				modelo.orm.Persona _persona = modelo.orm.PersonaDAO.loadPersonaByORMID(getId());
				if (_persona!= null) {
					copyFromBean(_persona);
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
				modelo.orm.Persona _persona = modelo.orm.PersonaDAO.createPersona();
				copyToBean(_persona);
				if (modelo.orm.PersonaDAO.save(_persona)) {
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
				modelo.orm.Persona _persona= modelo.orm.PersonaDAO.loadPersonaByORMID(getId());
				if (_persona != null) {
					copyToBean(_persona);
					if (modelo.orm.PersonaDAO.save(_persona)) {
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
				modelo.orm.Persona _persona = modelo.orm.PersonaDAO.loadPersonaByORMID(getId());
				if (_persona != null && modelo.orm.PersonaDAO.delete(_persona)) {
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
	
	private void copyFromBean(modelo.orm.Persona _persona) {
		setNombre(_persona.getNombre());
		setApellido(_persona.getApellido());
		setRut(_persona.getRut());
		setEdad(_persona.getEdad());
		setDireccion(_persona.getDireccion());
		setCiudad(_persona.getCiudad());
		setComuna(_persona.getComuna());
		setLogin(_persona.getLogin());
		setPass(_persona.getPass());
		setEmail(_persona.getEmail());
		setStatus(_persona.getStatus());
		setFecha_nacimiento(_persona.getFecha_nacimiento());
		setId(_persona.getORMID());
	}
	
	private void copyToBean(modelo.orm.Persona _persona) {
		_persona.setNombre(getNombre());
		_persona.setApellido(getApellido());
		_persona.setRut(getRut());
		_persona.setEdad(getEdad());
		_persona.setDireccion(getDireccion());
		_persona.setCiudad(getCiudad());
		_persona.setComuna(getComuna());
		_persona.setLogin(getLogin());
		_persona.setPass(getPass());
		_persona.setEmail(getEmail());
		_persona.setStatus(getStatus());
		_persona.setFecha_nacimiento(getFecha_nacimiento());
	}
	
}

