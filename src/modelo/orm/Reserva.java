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
@Table(name="Reserva")
public class Reserva implements Serializable {
	public Reserva() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="MODELO_ORM_RESERVA_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="MODELO_ORM_RESERVA_ID_GENERATOR", strategy="increment")	
	private int id;
	
	@ManyToOne(targetEntity=modelo.orm.Paciente.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="idPaciente", referencedColumnName="id", unique=true, nullable=false) })	
	private modelo.orm.Paciente paciente;
	
	@ManyToOne(targetEntity=modelo.orm.HoraMedica.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="idHoraMedica", referencedColumnName="id", unique=true, nullable=false) })	
	private modelo.orm.HoraMedica horaMedica;
	
	@ManyToOne(targetEntity=modelo.orm.Persona.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="idPersonaQueRegistra", referencedColumnName="id", unique=true, nullable=false) })	
	private modelo.orm.Persona personaQueRegistra;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setPaciente(modelo.orm.Paciente value) {
		this.paciente = value;
	}
	
	public modelo.orm.Paciente getPaciente() {
		return paciente;
	}
	
	public void setHoraMedica(modelo.orm.HoraMedica value) {
		this.horaMedica = value;
	}
	
	public modelo.orm.HoraMedica getHoraMedica() {
		return horaMedica;
	}
	
	public void setPersonaQueRegistra(modelo.orm.Persona value) {
		this.personaQueRegistra = value;
	}
	
	public modelo.orm.Persona getPersonaQueRegistra() {
		return personaQueRegistra;
	}
	
        @Override
	public String toString() {
		return String.valueOf(getId());
	}
	
}
