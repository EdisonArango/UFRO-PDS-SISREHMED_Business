package control.servicios;

import java.util.ArrayList;

import modelo.hospital.Box;
import modelo.hospital.HoraMedica;
import modelo.personas.Medico;

import org.orm.PersistentException;

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
		int totalHorasReservadas = 0;
		for (int i = 0; i < horasMedicasMedico.size(); i++) {
			if (horasMedicasMedico.get(i).horaReservada()) {
				totalHorasReservadas++;
			}
		}
		return totalHorasReservadas*100/totalHorasAsignadas;
	}
	
	
}