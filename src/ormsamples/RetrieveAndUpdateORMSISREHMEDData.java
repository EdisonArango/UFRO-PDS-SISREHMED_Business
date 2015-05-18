/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateORMSISREHMEDData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = modelo.orm.ORMSISREHMEDPersistentManager.instance().getSession().beginTransaction();
		try {
			modelo.orm.Paciente lmodeloormPaciente = modelo.orm.PacienteDAO.loadPacienteByQuery(null, null);
			// Update the properties of the persistent object
			modelo.orm.PacienteDAO.save(lmodeloormPaciente);
			modelo.orm.Persona lmodeloormPersona = modelo.orm.PersonaDAO.loadPersonaByQuery(null, null);
			// Update the properties of the persistent object
			modelo.orm.PersonaDAO.save(lmodeloormPersona);
			modelo.orm.Medico lmodeloormMedico = modelo.orm.MedicoDAO.loadMedicoByQuery(null, null);
			// Update the properties of the persistent object
			modelo.orm.MedicoDAO.save(lmodeloormMedico);
			modelo.orm.Especialidad lmodeloormEspecialidad = modelo.orm.EspecialidadDAO.loadEspecialidadByQuery(null, null);
			// Update the properties of the persistent object
			modelo.orm.EspecialidadDAO.save(lmodeloormEspecialidad);
			modelo.orm.HoraMedica lmodeloormHoraMedica = modelo.orm.HoraMedicaDAO.loadHoraMedicaByQuery(null, null);
			// Update the properties of the persistent object
			modelo.orm.HoraMedicaDAO.save(lmodeloormHoraMedica);
			modelo.orm.Box lmodeloormBox = modelo.orm.BoxDAO.loadBoxByQuery(null, null);
			// Update the properties of the persistent object
			modelo.orm.BoxDAO.save(lmodeloormBox);
			modelo.orm.Director lmodeloormDirector = modelo.orm.DirectorDAO.loadDirectorByQuery(null, null);
			// Update the properties of the persistent object
			modelo.orm.DirectorDAO.save(lmodeloormDirector);
			modelo.orm.Reserva lmodeloormReserva = modelo.orm.ReservaDAO.loadReservaByQuery(null, null);
			// Update the properties of the persistent object
			modelo.orm.ReservaDAO.save(lmodeloormReserva);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Paciente by PacienteCriteria");
		modelo.orm.PacienteCriteria lmodeloormPacienteCriteria = new modelo.orm.PacienteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lmodeloormPacienteCriteria.id.eq();
		System.out.println(lmodeloormPacienteCriteria.uniquePaciente());
		
		System.out.println("Retrieving Persona by PersonaCriteria");
		modelo.orm.PersonaCriteria lmodeloormPersonaCriteria = new modelo.orm.PersonaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lmodeloormPersonaCriteria.id.eq();
		System.out.println(lmodeloormPersonaCriteria.uniquePersona());
		
		System.out.println("Retrieving Medico by MedicoCriteria");
		modelo.orm.MedicoCriteria lmodeloormMedicoCriteria = new modelo.orm.MedicoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lmodeloormMedicoCriteria.id.eq();
		System.out.println(lmodeloormMedicoCriteria.uniqueMedico());
		
		System.out.println("Retrieving Especialidad by EspecialidadCriteria");
		modelo.orm.EspecialidadCriteria lmodeloormEspecialidadCriteria = new modelo.orm.EspecialidadCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lmodeloormEspecialidadCriteria.id.eq();
		System.out.println(lmodeloormEspecialidadCriteria.uniqueEspecialidad());
		
		System.out.println("Retrieving HoraMedica by HoraMedicaCriteria");
		modelo.orm.HoraMedicaCriteria lmodeloormHoraMedicaCriteria = new modelo.orm.HoraMedicaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lmodeloormHoraMedicaCriteria.id.eq();
		System.out.println(lmodeloormHoraMedicaCriteria.uniqueHoraMedica());
		
		System.out.println("Retrieving Box by BoxCriteria");
		modelo.orm.BoxCriteria lmodeloormBoxCriteria = new modelo.orm.BoxCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lmodeloormBoxCriteria.id.eq();
		System.out.println(lmodeloormBoxCriteria.uniqueBox());
		
		System.out.println("Retrieving Director by DirectorCriteria");
		modelo.orm.DirectorCriteria lmodeloormDirectorCriteria = new modelo.orm.DirectorCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lmodeloormDirectorCriteria.id.eq();
		System.out.println(lmodeloormDirectorCriteria.uniqueDirector());
		
		System.out.println("Retrieving Reserva by ReservaCriteria");
		modelo.orm.ReservaCriteria lmodeloormReservaCriteria = new modelo.orm.ReservaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lmodeloormReservaCriteria.id.eq();
		System.out.println(lmodeloormReservaCriteria.uniqueReserva());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateORMSISREHMEDData retrieveAndUpdateORMSISREHMEDData = new RetrieveAndUpdateORMSISREHMEDData();
			try {
				retrieveAndUpdateORMSISREHMEDData.retrieveAndUpdateTestData();
				//retrieveAndUpdateORMSISREHMEDData.retrieveByCriteria();
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
