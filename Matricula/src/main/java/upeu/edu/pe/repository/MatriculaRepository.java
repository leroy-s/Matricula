package upeu.edu.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upeu.edu.pe.entity.Matricula;

@Repository
public interface MatriculaRepository  extends JpaRepository<Matricula, Long>{

}
