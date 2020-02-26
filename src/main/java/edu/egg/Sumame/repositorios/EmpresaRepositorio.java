package edu.egg.Sumame.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.egg.Sumame.entidades.Empresa;

@Repository
public interface EmpresaRepositorio extends JpaRepository<Empresa, String> {
	
	@Query("SELECT c FROM Empresa c WHERE c.id = :id")
	public Empresa buscarPorId(@Param("id")String id);

}
