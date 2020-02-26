package edu.egg.Sumame.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.egg.Sumame.entidades.OfertaLaboral;

@Repository
public interface OfertaLaboralRepositorio extends JpaRepository<OfertaLaboral, String>{
	
	@Query("SELECT c FROM OfertaLaboral c WHERE c.id = :id")
	public OfertaLaboral buscarPorId(@Param("id")String id);

}
