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

public class PersonaCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression nombre;
	public final StringExpression apellido;
	public final StringExpression rut;
	public final IntegerExpression edad;
	public final StringExpression direccion;
	public final StringExpression ciudad;
	public final StringExpression comuna;
	public final StringExpression login;
	public final StringExpression pass;
	public final StringExpression email;
	public final IntegerExpression status;
	public final StringExpression fecha_nacimiento;
	
	public PersonaCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		nombre = new StringExpression("nombre", this);
		apellido = new StringExpression("apellido", this);
		rut = new StringExpression("rut", this);
		edad = new IntegerExpression("edad", this);
		direccion = new StringExpression("direccion", this);
		ciudad = new StringExpression("ciudad", this);
		comuna = new StringExpression("comuna", this);
		login = new StringExpression("login", this);
		pass = new StringExpression("pass", this);
		email = new StringExpression("email", this);
		status = new IntegerExpression("status", this);
		fecha_nacimiento = new StringExpression("fecha_nacimiento", this);
	}
	
	public PersonaCriteria(PersistentSession session) {
		this(session.createCriteria(Persona.class));
	}
	
	public PersonaCriteria() throws PersistentException {
		this(modelo.orm.ORMSISREHMEDPersistentManager.instance().getSession());
	}
	
	public Persona uniquePersona() {
		return (Persona) super.uniqueResult();
	}
	
	public Persona[] listPersona() {
		java.util.List list = super.list();
		return (Persona[]) list.toArray(new Persona[list.size()]);
	}
}

