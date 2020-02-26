package edu.egg.Sumame.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.egg.Sumame.entidades.Domicilio;

@Repository
public interface DomicilioRepositorio extends JpaRepository<Domicilio, String>{
	
	@Query("SELECT c FROM Domicilio c WHERE c.id = :id")
	public Domicilio buscarPorId(@Param("id")String id);

}
