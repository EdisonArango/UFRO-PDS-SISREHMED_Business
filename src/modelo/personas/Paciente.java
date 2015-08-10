package modelo.personas;

import java.util.ArrayList;

import modelo.hospital.HoraMedica;

import org.json.simple.JSONObject;
import org.orm.PersistentException;

import control.util.Utilidades;

public class Paciente extends Persona {
	private int id;

   

	public Paciente(int id, String id_facebook, String nombre, String apellido,
			String rut, String direccion, String ciudad, String comuna,
			String usuario, String email, String pass, String telefono,
			String fecha_nacimiento, int status, int idPaciente) {
		
		super(id, id_facebook, nombre, apellido, rut, direccion, ciudad,
				comuna, usuario, email, pass, telefono, fecha_nacimiento,
				status);
		this.id = idPaciente;
	}

//	public boolean pacienteActivo() {
//		return 
//	}
	
    @Override
    public int getId(){
    	return id;
    }
    
	public static Paciente cargarPacientePorId(int id) throws PersistentException{
        modelo.orm.Paciente pacienteORM = modelo.orm.PacienteDAO.loadPacienteByQuery("id="+id, null);
        return pacienteORMAPaciente(pacienteORM);
    }
	
	public static String crearPaciente (String id_facebook, String nombre, String apellido,
			String rut, String direccion, String ciudad, String comuna,
			String usuario, String email, String pass, String telefono,
			String fecha_nacimiento){
		try {
			
			modelo.orm.Paciente pacienteNuevo = modelo.orm.PacienteDAO.createPaciente();
			modelo.orm.Persona personaNueva = modelo.orm.PersonaDAO.createPersona();
			personaNueva.setId_facebook(id_facebook);
			personaNueva.setNombre(nombre);
			personaNueva.setApellido(apellido);
			personaNueva.setRut(rut);
			personaNueva.setDireccion(direccion);
			personaNueva.setCiudad(ciudad);
			personaNueva.setComuna(comuna);
			personaNueva.setUsuario(usuario);
			personaNueva.setEmail(email);
			personaNueva.setPass(pass);
			personaNueva.setTelefono(telefono);
			personaNueva.setFecha_nacimiento(fecha_nacimiento);
			personaNueva.setStatus(1);
			modelo.orm.PersonaDAO.save(personaNueva);
			
			pacienteNuevo.setPersona(personaNueva);
			modelo.orm.PacienteDAO.save(pacienteNuevo);
			return "success;Bien!;Paciente registrado con éxito";
		} catch (PersistentException e) {
			return "danger;Error!;No se ha podido registrar el paciente";
		}
		
	}
	
	public static String crearPacienteFacebook (String id_facebook, String nombre, String apellido,String email){
		JSONObject respuesta = new JSONObject();
		try {
			modelo.orm.Paciente pacienteNuevo = modelo.orm.PacienteDAO.createPaciente();
			modelo.orm.Persona personaNueva = modelo.orm.PersonaDAO.createPersona();
			personaNueva.setId_facebook(id_facebook);
			personaNueva.setNombre(nombre);
			personaNueva.setApellido(apellido);
			personaNueva.setEmail(email);
			personaNueva.setStatus(1);
			modelo.orm.PersonaDAO.save(personaNueva);
			
			pacienteNuevo.setPersona(personaNueva);
			modelo.orm.PacienteDAO.save(pacienteNuevo);
			respuesta.put("mensaje", "success;Bien!;Paciente registrado con éxito");
			respuesta.put("id", pacienteNuevo.getId());
			respuesta.put("id_facebook", id_facebook);
			respuesta.put("nombre", nombre+" "+apellido);
		} catch (PersistentException e) {
			respuesta.put("mensaje", "danger;Error!;No se ha podido registrar el paciente");
		}
		return respuesta.toJSONString();
		
	}
	
	public static String cargarPacienteFacebook (String id_facebook){
		JSONObject respuesta = new JSONObject();
		try {
			Paciente paciente = pacienteORMAPaciente (modelo.orm.PacienteDAO.loadPacienteByQuery("persona.id_facebook="+id_facebook,null));
			respuesta.put("mensaje", "success;Bien!;Sesión iniciada correctamente");
			respuesta.put("id", paciente.getId());
			respuesta.put("id_facebook", id_facebook);
			respuesta.put("nombre", paciente.getNombre()+" "+paciente.getApellido());
		} catch (PersistentException e) {
			respuesta.put("mensaje", "danger;Error!;No se ha podido iniciar sesión");
		}
		return respuesta.toJSONString();
	}
	
	public static boolean noRegistradoFacebook(String id_facebook) throws PersistentException{
		modelo.orm.Paciente paciente = modelo.orm.PacienteDAO.loadPacienteByQuery("persona.id_facebook="+id_facebook,null);
		return paciente==null;
	}
	
	public boolean libreEnHora (String fecha,String hora) throws PersistentException{
		modelo.orm.Reserva[] reservas = modelo.orm.ReservaDAO.listReservaByQuery("idPaciente="+id, null);
		for (int i = 0; i < reservas.length; i++) {
			if (reservas[i].getHoraMedica().getFecha().equals(fecha)&&reservas[i].getHoraMedica().getHora().equals(hora)) {
				return false;
			}
		}
		return true;
	}
	
	public int numeroDeReservas (String fechaIn,String fechaFin) throws PersistentException{
		modelo.orm.Reserva[] reservas = modelo.orm.ReservaDAO.listReservaByQuery("idPaciente="+id, null);
		HoraMedica[] horasDePaciente = new HoraMedica[reservas.length];
		for (int i = 0; i < horasDePaciente.length; i++) {
			horasDePaciente[i] = HoraMedica.horaMedicaORMAHoraMedica(reservas[i].getHoraMedica());
		}
		
		ArrayList<String> fechasRango = Utilidades.diasDeRango(fechaIn, fechaFin);
		int cantidadReservasEnRango = 0;
		for (String fechaActual : fechasRango) {
			for (HoraMedica horaMedica : horasDePaciente) {
				if (fechaActual.equals(horaMedica.getFecha())){
					cantidadReservasEnRango++;
				}
			}
		}
		return cantidadReservasEnRango;
	}
	
    public static Paciente[] obtenerTodosLosPacientes() throws PersistentException{
        modelo.orm.Paciente[] pacientesORM = modelo.orm.PacienteDAO.listPacienteByQuery(null, null);
        Paciente[] pacientes = new Paciente[pacientesORM.length];
        for (int i = 0; i < pacientesORM.length; i++) {
            pacientes[i] = Paciente.pacienteORMAPaciente(pacientesORM[i]);
        }
        return pacientes;
    }
	
	public modelo.orm.Paciente pacienteAORM() throws PersistentException{
		return modelo.orm.PacienteDAO.loadPacienteByQuery("id="+id,null);
	}
        
	public static Paciente pacienteORMAPaciente(modelo.orm.Paciente pacienteORM){
		modelo.orm.Persona persona = pacienteORM.getPersona();
		int status = -1;
		if (persona.getStatus()!=null){
			status = persona.getStatus();
		}
		return new Paciente(persona.getId(), persona.getId_facebook(), persona.getNombre(),
    			persona.getApellido(), persona.getRut(), persona.getDireccion(), 
    			persona.getCiudad(), persona.getComuna(), persona.getUsuario(),
    			 persona.getEmail(), persona.getPass(), persona.getTelefono(), 
    			persona.getFecha_nacimiento(), status, pacienteORM.getId());
	}
}