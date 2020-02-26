package edu.egg.Sumame.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class GradoDiscapacidad {
	
@Id
@GeneratedValue(generator = "uuid")
@GenericGenerator(name = "uuid", strategy = "uuid2")
private String id;

private float procentaje;

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public float getProcentaje() {
	return procentaje;
}

public void setProcentaje(float procentaje) {
	this.procentaje = procentaje;
}



}
