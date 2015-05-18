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

public class PersonaDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public PersonaDetachedCriteria() {
		super(modelo.orm.Persona.class, modelo.orm.PersonaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		apellido = new StringExpression("apellido", this.getDetachedCriteria());
		rut = new StringExpression("rut", this.getDetachedCriteria());
		edad = new IntegerExpression("edad", this.getDetachedCriteria());
		direccion = new StringExpression("direccion", this.getDetachedCriteria());
		ciudad = new StringExpression("ciudad", this.getDetachedCriteria());
		comuna = new StringExpression("comuna", this.getDetachedCriteria());
		login = new StringExpression("login", this.getDetachedCriteria());
		pass = new StringExpression("pass", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		status = new IntegerExpression("status", this.getDetachedCriteria());
		fecha_nacimiento = new StringExpression("fecha_nacimiento", this.getDetachedCriteria());
	}
	
	public PersonaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, modelo.orm.PersonaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		apellido = new StringExpression("apellido", this.getDetachedCriteria());
		rut = new StringExpression("rut", this.getDetachedCriteria());
		edad = new IntegerExpression("edad", this.getDetachedCriteria());
		direccion = new StringExpression("direccion", this.getDetachedCriteria());
		ciudad = new StringExpression("ciudad", this.getDetachedCriteria());
		comuna = new StringExpression("comuna", this.getDetachedCriteria());
		login = new StringExpression("login", this.getDetachedCriteria());
		pass = new StringExpression("pass", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		status = new IntegerExpression("status", this.getDetachedCriteria());
		fecha_nacimiento = new StringExpression("fecha_nacimiento", this.getDetachedCriteria());
	}
	
	public Persona uniquePersona(PersistentSession session) {
		return (Persona) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Persona[] listPersona(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Persona[]) list.toArray(new Persona[list.size()]);
	}
}

