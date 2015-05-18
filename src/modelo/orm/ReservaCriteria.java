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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ReservaCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression pacienteId;
	public final AssociationExpression paciente;
	public final IntegerExpression horaMedicaId;
	public final AssociationExpression horaMedica;
	public final IntegerExpression personaQueRegistraId;
	public final AssociationExpression personaQueRegistra;
	
	public ReservaCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		pacienteId = new IntegerExpression("paciente.id", this);
		paciente = new AssociationExpression("paciente", this);
		horaMedicaId = new IntegerExpression("horaMedica.id", this);
		horaMedica = new AssociationExpression("horaMedica", this);
		personaQueRegistraId = new IntegerExpression("personaQueRegistra.id", this);
		personaQueRegistra = new AssociationExpression("personaQueRegistra", this);
	}
	
	public ReservaCriteria(PersistentSession session) {
		this(session.createCriteria(Reserva.class));
	}
	
	public ReservaCriteria() throws PersistentException {
		this(modelo.orm.ORMSISREHMEDPersistentManager.instance().getSession());
	}
	
	public PacienteCriteria createPacienteCriteria() {
		return new PacienteCriteria(createCriteria("paciente"));
	}
	
	public HoraMedicaCriteria createHoraMedicaCriteria() {
		return new HoraMedicaCriteria(createCriteria("horaMedica"));
	}
	
	public PersonaCriteria createPersonaQueRegistraCriteria() {
		return new PersonaCriteria(createCriteria("personaQueRegistra"));
	}
	
	public Reserva uniqueReserva() {
		return (Reserva) super.uniqueResult();
	}
	
	public Reserva[] listReserva() {
		java.util.List list = super.list();
		return (Reserva[]) list.toArray(new Reserva[list.size()]);
	}
}

