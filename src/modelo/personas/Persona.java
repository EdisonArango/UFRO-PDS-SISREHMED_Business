package modelo.personas;

import org.orm.PersistentException;

public class Persona {
	private int id;
	private String nombre;
	private String apellido;
	private String ciudad;
	private String comuna;
	private String direccion;
	private int edad;
	private String email;
	private String fecha_nacimiento;
	private String login;
	private String pass;
	private String rut;
	private int status;

    public Persona(int id, String nombre, String apellido, String ciudad, String comuna, String direccion, int edad, String email, String fecha_nacimiento, String login, String pass, String rut, int status) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
        this.comuna = comuna;
        this.direccion = direccion;
        this.edad = edad;
        this.email = email;
        this.fecha_nacimiento = fecha_nacimiento;
        this.login = login;
        this.pass = pass;
        this.rut = rut;
        this.status = status;
    }
        
    public static Persona personaORMAPersona(modelo.orm.Persona persona){
    	int edad = -1,status = -1;
    	if (persona.getEdad()!=null){
    		edad = persona.getEdad();
    	}
    	if (persona.getStatus()!=null){
    		status = persona.getStatus();
    	}
    	return new Persona(persona.getId(), persona.getNombre(),
    			persona.getApellido(), persona.getCiudad(), persona.getComuna(),
    			persona.getDireccion(), edad, persona.getEmail(),
    			persona.getFecha_nacimiento(), persona.getLogin(), persona.getPass(),
    			persona.getRut(), status);
    }
    
    public modelo.orm.Persona personaAORM() throws PersistentException{
		return modelo.orm.PersonaDAO.loadPersonaByQuery("id="+id,null);
	}
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}