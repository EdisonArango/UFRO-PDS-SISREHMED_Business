package control.servicios;

import java.util.ArrayList;

import modelo.hospital.Especialidad;
import modelo.hospital.HoraMedica;
import modelo.personas.Medico;
import modelo.personas.Paciente;

import org.orm.PersistentException;

public class Reserva {

	public static String reservarHoraAPS(int idHoraMedica, int idPaciente) throws PersistentException {
		Paciente paciente = Paciente.cargarPacientePorId(idPaciente);
		HoraMedica horaMedica = HoraMedica.cargarHoraMedicaPorId(idHoraMedica);
		if (!horaMedica.horaEsAPS()){
			return "Hora no es APS";
		}
		if (horaMedica.horaReservada()){
			if (horaMedica.paciente.getId()==idPaciente){
				return "Paciente ya ha reservado la hora";
			}
			else{
				return "La hora ya esta reservada";
			}
		}
		if (!paciente.libreEnHora(horaMedica.getFecha(), horaMedica.getHora())){
			return "Paciente no esta libre en hora a reservar";
		}
		if (!horaMedica.medico.medicoLibreEnHora(horaMedica.getFecha(), horaMedica.getHora())) {
			return "Médico no esta libre en hora a reservar";
		}
		return horaMedica.guardarReserva(paciente,true)+"";
		
	}

	public static String reservarHoraControl(int[] idHoras, int idPaciente) throws PersistentException {
		Paciente paciente = Paciente.cargarPacientePorId(idPaciente);
		HoraMedica[] horasMedicas = new HoraMedica[idHoras.length];
		for (int i = 0; i < idHoras.length; i++) {
			horasMedicas[i] = HoraMedica.cargarHoraMedicaPorId(idHoras[i]);
			if (horasMedicas[i].horaEsAPS()){
				return "La hora médica con fecha "+horasMedicas[i].getFecha()+" y hora "+horasMedicas[i].getHora()+" no es hora de control";
			}
			if (horasMedicas[i].horaReservada()){
				return "La hora médica con fecha "+horasMedicas[i].getFecha()+" y hora "+horasMedicas[i].getHora()+" esta reservada";
			}
			if (!paciente.libreEnHora(horasMedicas[i].getFecha(), horasMedicas[i].getHora())){
				return "Paciente no esta libre en la hora médica con fecha "+horasMedicas[i].getFecha()+" y hora "+horasMedicas[i].getHora();
			}
			if (!horasMedicas[i].medico.medicoLibreEnHora(horasMedicas[i].getFecha(), horasMedicas[i].getHora())) {
				return "Médico no esta libre en la hora médica con fecha "+horasMedicas[i].getFecha()+" y hora "+horasMedicas[i].getHora();
			}
		}
		
		String reservas="";
		for (int i = 0; i < horasMedicas.length; i++) {
			reservas+= horasMedicas[i].guardarReserva(paciente,false) + ",";
		}
		return reservas;
	}

	public static ArrayList<HoraMedica> buscarHorasAPSPorMedico(int idMedico, String fechaIn, String fechaFin) throws PersistentException {
		Medico medico = Medico.cargarMedicoPorId(idMedico);
		return medico.obtenerHorasLibres(fechaIn, fechaFin);
	}
        

	public static ArrayList<HoraMedica> buscarHorasAPSPorEspecialidad(int idEspecialidad, String fechaIn, String fechaFin) throws PersistentException {
		Especialidad especialidad = Especialidad.cargarEspecialidadPorId(idEspecialidad);
		Medico[] medicosEspecialidad = especialidad.obtenerMedicosEspecialidad();
		ArrayList<HoraMedica> horasLibresEspecialidad = new ArrayList<>();
		for (int i = 0; i < medicosEspecialidad.length; i++) {
			horasLibresEspecialidad.addAll(medicosEspecialidad[i].obtenerHorasLibres(fechaIn, fechaFin));
		}
		return horasLibresEspecialidad;
	}
	
	public static ArrayList<HoraMedica> buscarSusHorasMedicas (int idMedico,String fechaIn,String fechaFin) throws PersistentException{
		Medico medico = Medico.cargarMedicoPorId(idMedico);
		return medico.obtenerHorasMedicas(fechaIn, fechaFin);
	}
        
}