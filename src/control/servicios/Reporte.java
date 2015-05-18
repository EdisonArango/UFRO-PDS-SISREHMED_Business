package control.servicios;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import modelo.hospital.Box;
import modelo.hospital.HoraMedica;
import modelo.personas.Medico;
import modelo.personas.Paciente;

import org.orm.PersistentException;

import control.util.Utilidades;

public class Reporte {
	
	public static int obtenerPorcentajeOcupacionDeBox (int idBox,String fechaIn,String fechaFin) throws PersistentException{
		Box box = Box.cargarBoxPorId(idBox);
		ArrayList<HoraMedica> horasMedicasBox = box.obtenerHorasMedicas(fechaIn, fechaFin);
		int totalHorasAsignadas = horasMedicasBox.size();
		int totalHorasReservadas = 0;
		for (int i = 0; i < horasMedicasBox.size(); i++) {
			if (horasMedicasBox.get(i).horaReservada()) {
				totalHorasReservadas++;
			}
		}
		return totalHorasReservadas*100/totalHorasAsignadas;
	}
	
	public static int obtenerPorcentajeOcupacionDeMedico (int idMedico,String fechaIn,String fechaFin) throws PersistentException{
		Medico medico = Medico.cargarMedicoPorId(idMedico);
		ArrayList<HoraMedica> horasMedicasMedico = medico.obtenerHorasMedicas(fechaIn, fechaFin);
		int totalHorasAsignadas = horasMedicasMedico.size();
		int totalHorasReservadas = medico.numeroDeReservas(horasMedicasMedico, fechaIn, fechaFin);
		return totalHorasReservadas*100/totalHorasAsignadas;
	}
	
	public static LinkedHashMap<Object,Integer> obtenerMedicosMasSolicitados(String fechaIn , String fechaFin) throws PersistentException{
		Medico[] medicos = Medico.obtenerTodosLosMedicos();
		int[] cantidadesReservas = new int[medicos.length];
		for (int i = 0; i < medicos.length; i++) {
			cantidadesReservas[i] = medicos[i].numeroDeReservas(fechaIn, fechaFin);
		}

		LinkedHashMap<Object,Integer> map = Utilidades.ordenarObjetosDeMayorAMenor(medicos, cantidadesReservas);
		return map;

	}
	
	public static LinkedHashMap<Object,Integer> obtenerPacientesQueMasReservan(String fechaIn , String fechaFin) throws PersistentException{
		Paciente[] pacientes = Paciente.obtenerTodosLosPacientes();
		int[] cantidadesReservas = new int[pacientes.length];
		for (int i = 0; i < pacientes.length; i++) {
			cantidadesReservas[i] = pacientes[i].numeroDeReservas(fechaIn, fechaFin);
		}

		LinkedHashMap<Object,Integer> map = Utilidades.ordenarObjetosDeMayorAMenor(pacientes, cantidadesReservas);
		return map;

	}

	
}