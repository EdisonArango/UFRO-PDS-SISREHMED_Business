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

public class HoraMedicaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final IntegerExpression medicoId;
	public final AssociationExpression medico;
	public final IntegerExpression boxId;
	public final AssociationExpression box;
	public final IntegerExpression esAPS;
	public final StringExpression fecha;
        public final StringExpression hora;
	
	public HoraMedicaDetachedCriteria() {
		super(modelo.orm.HoraMedica.class, modelo.orm.HoraMedicaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		medicoId = new IntegerExpression("medico.id", this.getDetachedCriteria());
		medico = new AssociationExpression("medico", this.getDetachedCriteria());
		boxId = new IntegerExpression("box.id", this.getDetachedCriteria());
		box = new AssociationExpression("box", this.getDetachedCriteria());
		esAPS = new IntegerExpression("esAPS", this.getDetachedCriteria());
		fecha = new StringExpression("fecha", this.getDetachedCriteria());
                hora = new StringExpression("hora", this.getDetachedCriteria());
	}
	
	public HoraMedicaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, modelo.orm.HoraMedicaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		medicoId = new IntegerExpression("medico.id", this.getDetachedCriteria());
		medico = new AssociationExpression("medico", this.getDetachedCriteria());
		boxId = new IntegerExpression("box.id", this.getDetachedCriteria());
		box = new AssociationExpression("box", this.getDetachedCriteria());
		esAPS = new IntegerExpression("esAPS", this.getDetachedCriteria());
		fecha = new StringExpression("fecha", this.getDetachedCriteria());
                hora = new StringExpression("hora", this.getDetachedCriteria());
	}
	
	public MedicoDetachedCriteria createMedicoCriteria() {
		return new MedicoDetachedCriteria(createCriteria("medico"));
	}
	
	public BoxDetachedCriteria createBoxCriteria() {
		return new BoxDetachedCriteria(createCriteria("box"));
	}
	
	public HoraMedica uniqueHoraMedica(PersistentSession session) {
		return (HoraMedica) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public HoraMedica[] listHoraMedica(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (HoraMedica[]) list.toArray(new HoraMedica[list.size()]);
	}
}

