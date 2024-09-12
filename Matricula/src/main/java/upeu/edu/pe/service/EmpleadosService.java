package upeu.edu.pe.service;

import java.util.List;
import java.util.Optional;

import upeu.edu.pe.entity.Empleados;

public interface EmpleadosService {
	Empleados create(Empleados a);
	Empleados update(Empleados a);
	void delete(Long id);
	Optional<Empleados> read(Long id);
	List<Empleados> readAll();
}
