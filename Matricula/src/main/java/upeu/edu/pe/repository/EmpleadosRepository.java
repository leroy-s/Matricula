package upeu.edu.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upeu.edu.pe.entity.Empleados;

@Repository
public interface EmpleadosRepository  extends JpaRepository<Empleados, Long>{

}
