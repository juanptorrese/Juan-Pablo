package edu.egg.Sumame.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.egg.Sumame.entidades.Discapacidad;

@Repository
public interface DiscapacidadRepositorio extends JpaRepository<Discapacidad, String> {
	
	@Query("SELECT c FROM Discapacidad c WHERE c.id = :id")
	public Discapacidad buscarPorId(@Param("id")String id);

}
