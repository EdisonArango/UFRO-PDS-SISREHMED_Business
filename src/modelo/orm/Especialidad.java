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

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Especialidad")
public class Especialidad implements Serializable {
	public Especialidad() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="MODELO_ORM_ESPECIALIDAD_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="MODELO_ORM_ESPECIALIDAD_ID_GENERATOR", strategy="increment")	
	private int id;
	
	@Column(name="nombre", nullable=true, length=150)	
	private String nombre;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setNombre(String value) {
		this.nombre = value;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
