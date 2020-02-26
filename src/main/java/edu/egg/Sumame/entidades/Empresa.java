package edu.egg.Sumame.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Empresa extends Usuario {
	
	private String sectorEmpresarial;
	
	private String valoracion;
	
	@ManyToOne
	private Categoria categoria;
	
	@OneToMany
	private List<OfertaLaboral> ofertaLaboral;
	
	public String getSectorEmpresarial() {
		return sectorEmpresarial;
	}
	public void setSectorEmpresarial(String sectorEmpresarial) {
		this.sectorEmpresarial = sectorEmpresarial;
	}
	public String getValoracion() {
		return valoracion;
	}
	public void setValoracion(String valoracion) {
		this.valoracion = valoracion;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public List<OfertaLaboral> getOfertaLaboral() {
		return ofertaLaboral;
	}
	public void setOfertaLaboral(List<OfertaLaboral> ofertaLaboral) {
		this.ofertaLaboral = ofertaLaboral;
	}
	
	
	
	
	
	
	
}
