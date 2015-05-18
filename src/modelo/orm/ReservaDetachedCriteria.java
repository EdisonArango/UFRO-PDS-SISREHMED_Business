/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package modelo.orm;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ReservaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final IntegerExpression pacienteId;
	public final AssociationExpression paciente;
	public final IntegerExpression horaMedicaId;
	public final AssociationExpression horaMedica;
	public final IntegerExpression personaQueRegistraId;
	public final AssociationExpression personaQueRegistra;
	
	public ReservaDetachedCriteria() {
		super(modelo.orm.Reserva.class, modelo.orm.ReservaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		pacienteId = new IntegerExpression("paciente.id", this.getDetachedCriteria());
		paciente = new AssociationExpression("paciente", this.getDetachedCriteria());
		horaMedicaId = new IntegerExpression("horaMedica.id", this.getDetachedCriteria());
		horaMedica = new AssociationExpression("horaMedica", this.getDetachedCriteria());
		personaQueRegistraId = new IntegerExpression("personaQueRegistra.id", this.getDetachedCriteria());
		personaQueRegistra = new AssociationExpression("personaQueRegistra", this.getDetachedCriteria());
	}
	
	public ReservaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, modelo.orm.ReservaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		pacienteId = new IntegerExpression("paciente.id", this.getDetachedCriteria());
		paciente = new AssociationExpression("paciente", this.getDetachedCriteria());
		horaMedicaId = new IntegerExpression("horaMedica.id", this.getDetachedCriteria());
		horaMedica = new AssociationExpression("horaMedica", this.getDetachedCriteria());
		personaQueRegistraId = new IntegerExpression("personaQueRegistra.id", this.getDetachedCriteria());
		personaQueRegistra = new AssociationExpression("personaQueRegistra", this.getDetachedCriteria());
	}
	
	public PacienteDetachedCriteria createPacienteCriteria() {
		return new PacienteDetachedCriteria(createCriteria("paciente"));
	}
	
	public HoraMedicaDetachedCriteria createHoraMedicaCriteria() {
		return new HoraMedicaDetachedCriteria(createCriteria("horaMedica"));
	}
	
	public PersonaDetachedCriteria createPersonaQueRegistraCriteria() {
		return new PersonaDetachedCriteria(createCriteria("personaQueRegistra"));
	}
	
	public Reserva uniqueReserva(PersistentSession session) {
		return (Reserva) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Reserva[] listReserva(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Reserva[]) list.toArray(new Reserva[list.size()]);
	}
}

