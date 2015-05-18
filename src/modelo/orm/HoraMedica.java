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
@Table(name="HoraMedica")
public class HoraMedica implements Serializable {
	public HoraMedica() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="MODELO_ORM_HORAMEDICA_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="MODELO_ORM_HORAMEDICA_ID_GENERATOR", strategy="increment")	
	private int id;
	
	@ManyToOne(targetEntity=modelo.orm.Medico.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="idMedico", referencedColumnName="id", unique=true, nullable=false) })	
	private modelo.orm.Medico medico;
	
	@ManyToOne(targetEntity=modelo.orm.Box.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="idBox", referencedColumnName="id", unique=true, nullable=false) })	
	private modelo.orm.Box box;
	
	@Column(name="esAPS", nullable=true, length=1)	
	private Integer esAPS;
	
        /**
         * Formato de fecha DD/MM/AAAA
         */
	@Column(name="fecha", nullable=true, length=10)	
	private String fecha;
        
        @Column(name="hora", nullable=true, length=5)	
	private String hora;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setEsAPS(int value) {
		setEsAPS(new Integer(value));
	}
	
	public void setEsAPS(Integer value) {
		this.esAPS = value;
	}
	
	public Integer getEsAPS() {
		return esAPS;
	}
	
	public void setFecha(String value) {
		this.fecha = value;
	}
	
	public String getFecha() {
		return fecha;
	}

        public String getHora() {
            return hora;
        }

        public void setHora(String hora) {
            this.hora = hora;
        }
	
	public void setMedico(modelo.orm.Medico value) {
		this.medico = value;
	}
	
	public modelo.orm.Medico getMedico() {
		return medico;
	}
	
	public void setBox(modelo.orm.Box value) {
		this.box = value;
	}
	
	public modelo.orm.Box getBox() {
		return box;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
