package upeu.edu.pe.service;

import java.util.List;
import java.util.Optional;

import upeu.edu.pe.entity.Cursos;


public interface CursosService {
	Cursos create(Cursos a);
	Cursos update(Cursos a);
	void delete(Long id);
	Optional<Cursos> read(Long id);
	List<Cursos> readAll();
}
