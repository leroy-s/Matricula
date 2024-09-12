package upeu.edu.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upeu.edu.pe.entity.Cursos;

@Repository
public interface CursosRepository extends JpaRepository<Cursos, Long>{

}
