package edu.egg.Sumame.entidades;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import edu.egg.Sumame.enumeraciones.Sexo;



@Entity
public class Postulante extends Usuario {
	
	private String apellido;
	private Date fechaNacimiento;
	
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@OneToMany
	private List<Discapacidad> discapacidad;

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public List<Discapacidad> getDiscapacidad() {
		return discapacidad;
	}

	public void setDiscapacidad(List<Discapacidad> discapacidad) {
		this.discapacidad = discapacidad;
	}


	
	 
	
	

}
