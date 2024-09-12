package upeu.edu.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upeu.edu.pe.entity.Alumnos;

@Repository
public interface AlumnosRepository  extends JpaRepository<Alumnos, Long>{

}
