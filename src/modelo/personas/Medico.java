package modelo.personas;

import java.util.ArrayList;

import modelo.hospital.Especialidad;
import modelo.hospital.HoraMedica;

import org.orm.PersistentException;

public class Medico extends Persona {
	private final int id;
	public Especialidad especialidad;
	public HoraMedica horaMedica;

        public Medico(int id, Especialidad especialidad, int idPersona, String nombre, String apellido, String ciudad, String comuna, String direccion, int edad, String email, String fecha_nacimiento, String login, String pass, String rut, int status) {
            super(idPersona, nombre, apellido, ciudad, comuna, direccion, edad, email, fecha_nacimiento, login, pass, rut, status);
            this.id = id;
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
        	int edad = -1,status = -1;
        	if (medicoORM.getPersona().getEdad()!=null){
        		edad = medicoORM.getPersona().getEdad();
        	}
        	if (medicoORM.getPersona().getStatus()!=null){
        		status = medicoORM.getPersona().getStatus();
        	}
        	return new Medico(medicoORM.getId(),specialidad,medicoORM.getPersona().getId(),
        			medicoORM.getPersona().getNombre(),medicoORM.getPersona().getApellido(),
        			medicoORM.getPersona().getCiudad(),medicoORM.getPersona().getComuna(),
        			medicoORM.getPersona().getDireccion(),
        			edad,medicoORM.getPersona().getEmail(),
        			medicoORM.getPersona().getFecha_nacimiento(),medicoORM.getPersona().getLogin(),
        			medicoORM.getPersona().getPass(),medicoORM.getPersona().getRut(),
        			status);
        }

        @Override
        public int getId() {
            return id;
        }
        
}