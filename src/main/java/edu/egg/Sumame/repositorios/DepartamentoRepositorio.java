package edu.egg.Sumame.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.egg.Sumame.entidades.Departamento;

@Repository
public interface DepartamentoRepositorio extends JpaRepository<Departamento, String>{
	
	@Query("SELECT c FROM Departamento c WHERE c.id = :id")
	public Departamento buscarPorId(@Param("id")String id);

}
