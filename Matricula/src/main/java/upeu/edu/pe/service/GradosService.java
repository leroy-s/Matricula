package upeu.edu.pe.service;

import java.util.List;
import java.util.Optional;

import upeu.edu.pe.entity.Grados;


public interface GradosService {
	Grados create(Grados a);
	Grados update(Grados a);
	void delete(Long id);
	Optional<Grados> read(Long id);
	List<Grados> readAll();
}
