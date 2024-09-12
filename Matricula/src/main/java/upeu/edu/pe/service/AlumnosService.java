package upeu.edu.pe.service;

import java.util.List;
import java.util.Optional;

import upeu.edu.pe.entity.Alumnos;



public interface AlumnosService {
	Alumnos create(Alumnos a);
	Alumnos update(Alumnos a);
	void delete(Long id);
	Optional<Alumnos> read(Long id);
	List<Alumnos> readAll();
}
