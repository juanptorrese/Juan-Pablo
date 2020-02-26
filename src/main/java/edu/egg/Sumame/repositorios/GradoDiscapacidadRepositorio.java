package edu.egg.Sumame.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.egg.Sumame.entidades.GradoDiscapacidad;

@Repository
public interface GradoDiscapacidadRepositorio extends JpaRepository<GradoDiscapacidad, String>{
	
	@Query("SELECT c FROM GradoDiscapacidad c WHERE c.id = :id")
	public GradoDiscapacidad buscarPorId(@Param("id")String id);

}
