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
@Table(name="Persona")
public class Persona implements Serializable {
	public Persona() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="MODELO_ORM_PERSONA_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="MODELO_ORM_PERSONA_ID_GENERATOR", strategy="increment")	
	private int id;
	
	@Column(name="nombre", nullable=true, length=100)	
	private String nombre;
	
	@Column(name="apellido", nullable=true, length=100)	
	private String apellido;
	
	@Column(name="rut", nullable=true, unique=true, length=20)	
	private String rut;
	
	@Column(name="edad", nullable=true, length=3)	
	private Integer edad;
	
	@Column(name="direccion", nullable=true, length=200)	
	private String direccion;
	
	@Column(name="ciudad", nullable=true, length=50)	
	private String ciudad;
	
	@Column(name="comuna", nullable=true, length=50)	
	private String comuna;
	
	@Column(name="login", nullable=true, length=100)	
	private String login;
	
	@Column(name="pass", nullable=true, length=32)	
	private String pass;
	
	@Column(name="email", nullable=true, length=255)	
	private String email;
	
	@Column(name="status", nullable=true, length=1)	
	private Integer status;
	
	@Column(name="fecha_nacimiento", nullable=true, length=10)	
	private String fecha_nacimiento;
	
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
	
	public void setApellido(String value) {
		this.apellido = value;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setRut(String value) {
		this.rut = value;
	}
	
	public String getRut() {
		return rut;
	}
	
	public void setEdad(int value) {
		setEdad(new Integer(value));
	}
	
	public void setEdad(Integer value) {
		this.edad = value;
	}
	
	public Integer getEdad() {
		return edad;
	}
	
	public void setDireccion(String value) {
		this.direccion = value;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setCiudad(String value) {
		this.ciudad = value;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public void setComuna(String value) {
		this.comuna = value;
	}
	
	public String getComuna() {
		return comuna;
	}
	
	public void setLogin(String value) {
		this.login = value;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setPass(String value) {
		this.pass = value;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setStatus(int value) {
		setStatus(new Integer(value));
	}
	
	public void setStatus(Integer value) {
		this.status = value;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setFecha_nacimiento(String value) {
		this.fecha_nacimiento = value;
	}
	
	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
