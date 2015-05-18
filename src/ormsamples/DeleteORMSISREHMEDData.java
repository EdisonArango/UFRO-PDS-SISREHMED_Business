/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeleteORMSISREHMEDData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = modelo.orm.ORMSISREHMEDPersistentManager.instance().getSession().beginTransaction();
		try {
			modelo.orm.Paciente lmodeloormPaciente = modelo.orm.PacienteDAO.loadPacienteByQuery(null, null);
			// Delete the persistent object
			modelo.orm.PacienteDAO.delete(lmodeloormPaciente);
			modelo.orm.Persona lmodeloormPersona = modelo.orm.PersonaDAO.loadPersonaByQuery(null, null);
			// Delete the persistent object
			modelo.orm.PersonaDAO.delete(lmodeloormPersona);
			modelo.orm.Medico lmodeloormMedico = modelo.orm.MedicoDAO.loadMedicoByQuery(null, null);
			// Delete the persistent object
			modelo.orm.MedicoDAO.delete(lmodeloormMedico);
			modelo.orm.Especialidad lmodeloormEspecialidad = modelo.orm.EspecialidadDAO.loadEspecialidadByQuery(null, null);
			// Delete the persistent object
			modelo.orm.EspecialidadDAO.delete(lmodeloormEspecialidad);
			modelo.orm.HoraMedica lmodeloormHoraMedica = modelo.orm.HoraMedicaDAO.loadHoraMedicaByQuery(null, null);
			// Delete the persistent object
			modelo.orm.HoraMedicaDAO.delete(lmodeloormHoraMedica);
			modelo.orm.Box lmodeloormBox = modelo.orm.BoxDAO.loadBoxByQuery(null, null);
			// Delete the persistent object
			modelo.orm.BoxDAO.delete(lmodeloormBox);
			modelo.orm.Director lmodeloormDirector = modelo.orm.DirectorDAO.loadDirectorByQuery(null, null);
			// Delete the persistent object
			modelo.orm.DirectorDAO.delete(lmodeloormDirector);
			modelo.orm.Reserva lmodeloormReserva = modelo.orm.ReservaDAO.loadReservaByQuery(null, null);
			// Delete the persistent object
			modelo.orm.ReservaDAO.delete(lmodeloormReserva);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteORMSISREHMEDData deleteORMSISREHMEDData = new DeleteORMSISREHMEDData();
			try {
				deleteORMSISREHMEDData.deleteTestData();
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
