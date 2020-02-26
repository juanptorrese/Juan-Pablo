package edu.egg.Sumame.entidades;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import edu.egg.Sumame.enumeraciones.TipoDiscapacidad;

@Entity
public class Discapacidad {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	
	private String nombreDIscapacidad;
	
	@Enumerated(EnumType.STRING)
	private TipoDiscapacidad tipoDiscapacidad;
	
	@ManyToOne
	private GradoDiscapacidad gradoDiscapacidad;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombreDIscapacidad() {
		return nombreDIscapacidad;
	}

	public void setNombreDIscapacidad(String nombreDIscapacidad) {
		this.nombreDIscapacidad = nombreDIscapacidad;
	}

	public TipoDiscapacidad getTipoDiscapacidad() {
		return tipoDiscapacidad;
	}

	public void setTipoDiscapacidad(TipoDiscapacidad tipoDiscapacidad) {
		this.tipoDiscapacidad = tipoDiscapacidad;
	}

	public GradoDiscapacidad getGradoDiscapacidad() {
		return gradoDiscapacidad;
	}

	public void setGradoDiscapacidad(GradoDiscapacidad gradoDiscapacidad) {
		this.gradoDiscapacidad = gradoDiscapacidad;
	}
	
	
	
	
	
	

}
