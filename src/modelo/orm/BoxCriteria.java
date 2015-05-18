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

public class BoxCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression nombre;
	
	public BoxCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		nombre = new StringExpression("nombre", this);
	}
	
	public BoxCriteria(PersistentSession session) {
		this(session.createCriteria(Box.class));
	}
	
	public BoxCriteria() throws PersistentException {
		this(modelo.orm.ORMSISREHMEDPersistentManager.instance().getSession());
	}
	
	public Box uniqueBox() {
		return (Box) super.uniqueResult();
	}
	
	public Box[] listBox() {
		java.util.List list = super.list();
		return (Box[]) list.toArray(new Box[list.size()]);
	}
}

