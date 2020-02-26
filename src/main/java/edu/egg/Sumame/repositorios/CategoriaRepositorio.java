package edu.egg.Sumame.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.egg.Sumame.entidades.Categoria;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, String>{
	
	@Query("SELECT c FROM Categoria c WHERE c.id = :id")
	public Categoria buscarPorId(@Param("id")String id);

}
