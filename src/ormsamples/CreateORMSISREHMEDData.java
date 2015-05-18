/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateORMSISREHMEDData {
	public void createTestData() throws PersistentException {
		// Insert sample data
		PersistentSession session = modelo.orm.ORMSISREHMEDPersistentManager.instance().getSession();
		PersistentTransaction transaction = session.beginTransaction();
		try {
			session.doWork(new org.hibernate.jdbc.Work() {
				public void execute(java.sql.Connection conn) throws java.sql.SQLException {
					java.sql.Statement statement = conn.createStatement();
					statement.close();
				}
			});
			transaction.commit();
		}
		catch (Exception e) {
			try {
				transaction.rollback();
			}
			catch (PersistentException e1) {
				e.printStackTrace();
			}
			e.printStackTrace();
		}
		
		PersistentTransaction t = modelo.orm.ORMSISREHMEDPersistentManager.instance().getSession().beginTransaction();
		try {
			modelo.orm.Paciente lmodeloormPaciente = modelo.orm.PacienteDAO.createPaciente();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : persona
			modelo.orm.PacienteDAO.save(lmodeloormPaciente);
			modelo.orm.Persona lmodeloormPersona = modelo.orm.PersonaDAO.createPersona();
			// Initialize the properties of the persistent object here
			modelo.orm.PersonaDAO.save(lmodeloormPersona);
			modelo.orm.Medico lmodeloormMedico = modelo.orm.MedicoDAO.createMedico();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : especialidad, persona
			modelo.orm.MedicoDAO.save(lmodeloormMedico);
			modelo.orm.Especialidad lmodeloormEspecialidad = modelo.orm.EspecialidadDAO.createEspecialidad();
			// Initialize the properties of the persistent object here
			modelo.orm.EspecialidadDAO.save(lmodeloormEspecialidad);
			modelo.orm.HoraMedica lmodeloormHoraMedica = modelo.orm.HoraMedicaDAO.createHoraMedica();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : box, medico
			modelo.orm.HoraMedicaDAO.save(lmodeloormHoraMedica);
			modelo.orm.Box lmodeloormBox = modelo.orm.BoxDAO.createBox();
			// Initialize the properties of the persistent object here
			modelo.orm.BoxDAO.save(lmodeloormBox);
			modelo.orm.Director lmodeloormDirector = modelo.orm.DirectorDAO.createDirector();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : persona
			modelo.orm.DirectorDAO.save(lmodeloormDirector);
			modelo.orm.Reserva lmodeloormReserva = modelo.orm.ReservaDAO.createReserva();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : personaQueRegistra, horaMedica, paciente
			modelo.orm.ReservaDAO.save(lmodeloormReserva);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateORMSISREHMEDData createORMSISREHMEDData = new CreateORMSISREHMEDData();
			try {
				createORMSISREHMEDData.createTestData();
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
