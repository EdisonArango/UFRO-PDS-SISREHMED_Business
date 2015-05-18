/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class ListORMSISREHMEDData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Paciente...");
		modelo.orm.Paciente[] modeloormPacientes = modelo.orm.PacienteDAO.listPacienteByQuery(null, null);
		int length = Math.min(modeloormPacientes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(modeloormPacientes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Persona...");
		modelo.orm.Persona[] modeloormPersonas = modelo.orm.PersonaDAO.listPersonaByQuery(null, null);
		length = Math.min(modeloormPersonas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(modeloormPersonas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Medico...");
		modelo.orm.Medico[] modeloormMedicos = modelo.orm.MedicoDAO.listMedicoByQuery(null, null);
		length = Math.min(modeloormMedicos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(modeloormMedicos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Especialidad...");
		modelo.orm.Especialidad[] modeloormEspecialidads = modelo.orm.EspecialidadDAO.listEspecialidadByQuery(null, null);
		length = Math.min(modeloormEspecialidads.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(modeloormEspecialidads[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing HoraMedica...");
		modelo.orm.HoraMedica[] modeloormHoraMedicas = modelo.orm.HoraMedicaDAO.listHoraMedicaByQuery(null, null);
		length = Math.min(modeloormHoraMedicas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(modeloormHoraMedicas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Box...");
		modelo.orm.Box[] modeloormBoxs = modelo.orm.BoxDAO.listBoxByQuery(null, null);
		length = Math.min(modeloormBoxs.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(modeloormBoxs[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Director...");
		modelo.orm.Director[] modeloormDirectors = modelo.orm.DirectorDAO.listDirectorByQuery(null, null);
		length = Math.min(modeloormDirectors.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(modeloormDirectors[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Reserva...");
		modelo.orm.Reserva[] modeloormReservas = modelo.orm.ReservaDAO.listReservaByQuery(null, null);
		length = Math.min(modeloormReservas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(modeloormReservas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Paciente by Criteria...");
		modelo.orm.PacienteCriteria lmodeloormPacienteCriteria = new modelo.orm.PacienteCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lmodeloormPacienteCriteria.id.eq();
		lmodeloormPacienteCriteria.setMaxResults(ROW_COUNT);
		modelo.orm.Paciente[] modeloormPacientes = lmodeloormPacienteCriteria.listPaciente();
		int length =modeloormPacientes== null ? 0 : Math.min(modeloormPacientes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(modeloormPacientes[i]);
		}
		System.out.println(length + " Paciente record(s) retrieved."); 
		
		System.out.println("Listing Persona by Criteria...");
		modelo.orm.PersonaCriteria lmodeloormPersonaCriteria = new modelo.orm.PersonaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lmodeloormPersonaCriteria.id.eq();
		lmodeloormPersonaCriteria.setMaxResults(ROW_COUNT);
		modelo.orm.Persona[] modeloormPersonas = lmodeloormPersonaCriteria.listPersona();
		length =modeloormPersonas== null ? 0 : Math.min(modeloormPersonas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(modeloormPersonas[i]);
		}
		System.out.println(length + " Persona record(s) retrieved."); 
		
		System.out.println("Listing Medico by Criteria...");
		modelo.orm.MedicoCriteria lmodeloormMedicoCriteria = new modelo.orm.MedicoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lmodeloormMedicoCriteria.id.eq();
		lmodeloormMedicoCriteria.setMaxResults(ROW_COUNT);
		modelo.orm.Medico[] modeloormMedicos = lmodeloormMedicoCriteria.listMedico();
		length =modeloormMedicos== null ? 0 : Math.min(modeloormMedicos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(modeloormMedicos[i]);
		}
		System.out.println(length + " Medico record(s) retrieved."); 
		
		System.out.println("Listing Especialidad by Criteria...");
		modelo.orm.EspecialidadCriteria lmodeloormEspecialidadCriteria = new modelo.orm.EspecialidadCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lmodeloormEspecialidadCriteria.id.eq();
		lmodeloormEspecialidadCriteria.setMaxResults(ROW_COUNT);
		modelo.orm.Especialidad[] modeloormEspecialidads = lmodeloormEspecialidadCriteria.listEspecialidad();
		length =modeloormEspecialidads== null ? 0 : Math.min(modeloormEspecialidads.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(modeloormEspecialidads[i]);
		}
		System.out.println(length + " Especialidad record(s) retrieved."); 
		
		System.out.println("Listing HoraMedica by Criteria...");
		modelo.orm.HoraMedicaCriteria lmodeloormHoraMedicaCriteria = new modelo.orm.HoraMedicaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lmodeloormHoraMedicaCriteria.id.eq();
		lmodeloormHoraMedicaCriteria.setMaxResults(ROW_COUNT);
		modelo.orm.HoraMedica[] modeloormHoraMedicas = lmodeloormHoraMedicaCriteria.listHoraMedica();
		length =modeloormHoraMedicas== null ? 0 : Math.min(modeloormHoraMedicas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(modeloormHoraMedicas[i]);
		}
		System.out.println(length + " HoraMedica record(s) retrieved."); 
		
		System.out.println("Listing Box by Criteria...");
		modelo.orm.BoxCriteria lmodeloormBoxCriteria = new modelo.orm.BoxCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lmodeloormBoxCriteria.id.eq();
		lmodeloormBoxCriteria.setMaxResults(ROW_COUNT);
		modelo.orm.Box[] modeloormBoxs = lmodeloormBoxCriteria.listBox();
		length =modeloormBoxs== null ? 0 : Math.min(modeloormBoxs.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(modeloormBoxs[i]);
		}
		System.out.println(length + " Box record(s) retrieved."); 
		
		System.out.println("Listing Director by Criteria...");
		modelo.orm.DirectorCriteria lmodeloormDirectorCriteria = new modelo.orm.DirectorCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lmodeloormDirectorCriteria.id.eq();
		lmodeloormDirectorCriteria.setMaxResults(ROW_COUNT);
		modelo.orm.Director[] modeloormDirectors = lmodeloormDirectorCriteria.listDirector();
		length =modeloormDirectors== null ? 0 : Math.min(modeloormDirectors.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(modeloormDirectors[i]);
		}
		System.out.println(length + " Director record(s) retrieved."); 
		
		System.out.println("Listing Reserva by Criteria...");
		modelo.orm.ReservaCriteria lmodeloormReservaCriteria = new modelo.orm.ReservaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lmodeloormReservaCriteria.id.eq();
		lmodeloormReservaCriteria.setMaxResults(ROW_COUNT);
		modelo.orm.Reserva[] modeloormReservas = lmodeloormReservaCriteria.listReserva();
		length =modeloormReservas== null ? 0 : Math.min(modeloormReservas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(modeloormReservas[i]);
		}
		System.out.println(length + " Reserva record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListORMSISREHMEDData listORMSISREHMEDData = new ListORMSISREHMEDData();
			try {
				listORMSISREHMEDData.listTestData();
				//listORMSISREHMEDData.listByCriteria();
			}
			finally {
				modelo.orm.ORMSISREHMEDPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
