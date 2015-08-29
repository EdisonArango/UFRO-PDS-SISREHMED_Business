package modelo.personas;

import org.orm.PersistentException;

public class Persona {
	private int id;
	private String id_facebook;
	private String nombre;
	private String apellido;
	private String rut;
	private String direccion;
	private String ciudad;
	private String comuna;
	private String usuario;
	private String email;
	private String pass;
	private String telefono;
	private String fecha_nacimiento;
	private int admin;
	
	public Persona(int id, String id_facebook, String nombre, String apellido,
				String rut, String direccion, String ciudad, String comuna,
				String usuario, String email, String pass, String telefono,
				String fecha_nacimiento, int admin) {
			this.id = id;
			this.id_facebook = id_facebook;
			this.nombre = nombre;
			this.apellido = apellido;
			this.rut = rut;
			this.direccion = direccion;
			this.ciudad = ciudad;
			this.comuna = comuna;
			this.usuario = usuario;
			this.email = email;
			this.pass = pass;
			this.telefono = telefono;
			this.fecha_nacimiento = fecha_nacimiento;
			this.admin = admin;
	}

        
    public static Persona personaORMAPersona(modelo.orm.Persona persona){
    	int admin = -1;
    	if (persona.getAdmin()!=null){
    		admin = persona.getAdmin();
    	}
    	return new Persona(persona.getId(), persona.getId_facebook(), persona.getNombre(),
    			persona.getApellido(), persona.getRut(), persona.getDireccion(), 
    			persona.getCiudad(), persona.getComuna(), persona.getUsuario(),
    			 persona.getEmail(), persona.getPass(), persona.getTelefono(), 
    			persona.getFecha_nacimiento(), admin);
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

    public int getAdmin() {
        return admin;
    }

    public void setStatus(int status) {
        this.admin = admin;
    }


	public String getId_facebook() {
		return id_facebook;
	}


	public void setId_facebook(String id_facebook) {
		this.id_facebook = id_facebook;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
    
    
}