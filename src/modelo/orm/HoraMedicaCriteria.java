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

public class HoraMedicaCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression medicoId;
	public final AssociationExpression medico;
	public final IntegerExpression boxId;
	public final AssociationExpression box;
	public final IntegerExpression esAPS;
	public final StringExpression fecha;
        public final StringExpression hora;
	
	public HoraMedicaCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		medicoId = new IntegerExpression("medico.id", this);
		medico = new AssociationExpression("medico", this);
		boxId = new IntegerExpression("box.id", this);
		box = new AssociationExpression("box", this);
		esAPS = new IntegerExpression("esAPS", this);
		fecha = new StringExpression("fecha", this);
                hora = new StringExpression("hora", this);
	}
	
	public HoraMedicaCriteria(PersistentSession session) {
		this(session.createCriteria(HoraMedica.class));
	}
	
	public HoraMedicaCriteria() throws PersistentException {
		this(modelo.orm.ORMSISREHMEDPersistentManager.instance().getSession());
	}
	
	public MedicoCriteria createMedicoCriteria() {
		return new MedicoCriteria(createCriteria("medico"));
	}
	
	public BoxCriteria createBoxCriteria() {
		return new BoxCriteria(createCriteria("box"));
	}
	
	public HoraMedica uniqueHoraMedica() {
		return (HoraMedica) super.uniqueResult();
	}
	
	public HoraMedica[] listHoraMedica() {
		java.util.List list = super.list();
		return (HoraMedica[]) list.toArray(new HoraMedica[list.size()]);
	}
}

