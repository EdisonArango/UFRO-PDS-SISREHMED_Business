package modelo.personas;

import org.orm.PersistentException;

public class Paciente extends Persona {
	private int id;

    public Paciente(int id,int idPersona, String nombre, String apellido, String ciudad, String comuna, String direccion, int edad, String email, String fecha_nacimiento, String login, String pass, String rut, int status) {
        super(idPersona, nombre, apellido, ciudad, comuna, direccion, edad, email, fecha_nacimiento, login, pass, rut, status);
        this.id = id;
    }

//	public boolean pacienteActivo() {
//		return 
//	}
	
	public static Paciente cargarPacientePorId(int id) throws PersistentException{
        modelo.orm.Paciente pacienteORM = modelo.orm.PacienteDAO.loadPacienteByQuery("id="+id, null);
        return pacienteORMAPaciente(pacienteORM);
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
	
	public modelo.orm.Paciente pacienteAORM() throws PersistentException{
		return modelo.orm.PacienteDAO.loadPacienteByQuery("id="+id,null);
	}
        
	public static Paciente pacienteORMAPaciente(modelo.orm.Paciente pacienteORM){
		modelo.orm.Persona persona = pacienteORM.getPersona();
		int edad = -1,status = -1;
		if (persona.getEdad()!=null){
			edad = persona.getEdad();
		}
		if (persona.getStatus()!=null){
			status = persona.getStatus();
		}
		return new Paciente(pacienteORM.getId(), persona.getId(), persona.getNombre(),
				persona.getApellido(), persona.getCiudad(), persona.getComuna(),
				persona.getDireccion(), edad, persona.getEmail(),
				persona.getFecha_nacimiento(), persona.getLogin(), persona.getPass(),
				persona.getRut(), status);
	}
}