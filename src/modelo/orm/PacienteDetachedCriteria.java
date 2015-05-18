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

public class PacienteDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final IntegerExpression personaId;
	public final AssociationExpression persona;
	
	public PacienteDetachedCriteria() {
		super(modelo.orm.Paciente.class, modelo.orm.PacienteCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		personaId = new IntegerExpression("persona.id", this.getDetachedCriteria());
		persona = new AssociationExpression("persona", this.getDetachedCriteria());
	}
	
	public PacienteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, modelo.orm.PacienteCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		personaId = new IntegerExpression("persona.id", this.getDetachedCriteria());
		persona = new AssociationExpression("persona", this.getDetachedCriteria());
	}
	
	public PersonaDetachedCriteria createPersonaCriteria() {
		return new PersonaDetachedCriteria(createCriteria("persona"));
	}
	
	public Paciente uniquePaciente(PersistentSession session) {
		return (Paciente) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Paciente[] listPaciente(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Paciente[]) list.toArray(new Paciente[list.size()]);
	}
}

