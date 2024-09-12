package upeu.edu.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upeu.edu.pe.entity.Grados;

@Repository
public interface GradosRepository  extends JpaRepository<Grados, Long>{

}
