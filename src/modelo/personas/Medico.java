package modelo.personas;

import java.util.ArrayList;

import modelo.hospital.Especialidad;
import modelo.hospital.HoraMedica;

import org.orm.PersistentException;

public class Medico extends Persona {
	private int id;
	public Especialidad especialidad;
	public HoraMedica horaMedica;

       
    public Medico(int id, String id_facebook, String nombre, String apellido,
			String rut, String direccion, String ciudad, String comuna,
			String usuario, String email, String pass, String telefono,
			String fecha_nacimiento, int status, int id2,
			Especialidad especialidad) {
    	
		super(id, id_facebook, nombre, apellido, rut, direccion, ciudad,
				comuna, usuario, email, pass, telefono, fecha_nacimiento,
				status);
		id = id2;
		this.especialidad = especialidad;
	}

		public boolean medicoLibreEnHora(String fecha,String hora) throws PersistentException {
        	modelo.orm.Reserva[] reservas = modelo.orm.ReservaDAO.listReservaByQuery("horaMedica.medico.id="+id, null);
    		for (int i = 0; i < reservas.length; i++) {
    			if (reservas[i].getHoraMedica().getFecha().equals(fecha)&&reservas[i].getHoraMedica().getHora().equals(hora)) {
    				return false;
    			}
    		}
    		return true;
    	}
        
		public boolean medicoActivo(int idMedico) {
			throw new UnsupportedOperationException();
		}

		public ArrayList<HoraMedica> obtenerHorasLibres(String fechaIn,String fechaFin) throws PersistentException {
			return HoraMedica.obtenerHorasLibresMedico(this, fechaIn, fechaFin);
		}
		
		public ArrayList<HoraMedica> obtenerHorasMedicas(String fechaIn,String fechaFin) throws PersistentException{
	    	return HoraMedica.obtenerHorasMedicasDeMedico(this, fechaIn, fechaFin);
	    }
        
		public int numeroDeReservas (String fechaIn, String fechaFin) throws PersistentException{
			ArrayList<HoraMedica> horasMedicas = obtenerHorasMedicas(fechaIn, fechaFin);
			int totalHorasReservadas = 0;
			for (int i = 0; i < horasMedicas.size(); i++) {
				if (horasMedicas.get(i).horaReservada()) {
					totalHorasReservadas++;
				}
			}
			return totalHorasReservadas;
		}
		
		public int numeroDeReservas (ArrayList<HoraMedica> horasMedicas ,String fechaIn, String fechaFin){
			int totalHorasReservadas = 0;
			for (int i = 0; i < horasMedicas.size(); i++) {
				if (horasMedicas.get(i).horaReservada()) {
					totalHorasReservadas++;
				}
			}
			return totalHorasReservadas;
		}
		
        public static Medico cargarMedicoPorId(int id) throws PersistentException{
            modelo.orm.Medico medicoORM = modelo.orm.MedicoDAO.loadMedicoByQuery("id="+id, null);
            return medicoORMAMedico(medicoORM);
        }
        
        public static Medico[] obtenerTodosLosMedicos() throws PersistentException{
            modelo.orm.Medico[] medicosORM = modelo.orm.MedicoDAO.listMedicoByQuery(null, null);
            Medico[] medicos = new Medico[medicosORM.length];
            for (int i = 0; i < medicosORM.length; i++) {
                medicos[i] = Medico.medicoORMAMedico(medicosORM[i]);
            }
            return medicos;
        }
        
        /**
         * Error, validar que atributos pueden ser nulos
         * @param medicoORM
         * @return 
         */
        public static Medico medicoORMAMedico(modelo.orm.Medico medicoORM){
        	Especialidad specialidad = Especialidad.especialidadORMAEspecialidad(medicoORM.getEspecialidad());
        	modelo.orm.Persona persona = medicoORM.getPersona();
        	int status = -1;
        	if (medicoORM.getPersona().getStatus()!=null){
        		status = medicoORM.getPersona().getStatus();
        	}
        	return new Medico(persona.getId(), persona.getId_facebook(), persona.getNombre(),
        			persona.getApellido(), persona.getRut(), persona.getDireccion(), 
        			persona.getCiudad(), persona.getComuna(), persona.getUsuario(),
        			 persona.getEmail(), persona.getPass(), persona.getTelefono(), 
        			persona.getFecha_nacimiento(), status,
        			medicoORM.getId(),specialidad);
        }

        @Override
        public int getId() {
            return id;
        }
        
}