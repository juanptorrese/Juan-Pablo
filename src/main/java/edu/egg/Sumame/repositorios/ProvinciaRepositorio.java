package edu.egg.Sumame.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.egg.Sumame.entidades.Provincia;

@Repository
public interface ProvinciaRepositorio extends JpaRepository<Provincia, String> {
	
	@Query("SELECT c FROM Provincia c WHERE c.id = :id")
	public Provincia buscarPorId(@Param("id")String id);

}
