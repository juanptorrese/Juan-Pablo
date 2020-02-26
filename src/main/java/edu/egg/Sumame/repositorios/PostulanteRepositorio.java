package edu.egg.Sumame.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.egg.Sumame.entidades.Postulante;

@Repository
public interface PostulanteRepositorio extends JpaRepository<Postulante, String> {

	@Query("SELECT c FROM Postulante c WHERE c.id = :id")
	public Postulante buscarPorId(@Param("id")String id);
}
