package upeu.edu.pe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import jakarta.validation.Valid;
import upeu.edu.pe.entity.Alumnos;
import upeu.edu.pe.service.AlumnosService;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnosController {
	
	@Autowired
	private AlumnosService alumnosservice;
	
	@GetMapping
	public ResponseEntity<List<Alumnos>> readAll() {
		try {
			List<Alumnos> Alumno = alumnosservice.readAll();
			if (Alumno.isEmpty()) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(Alumno, HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<Alumnos> crear(@Valid @RequestBody Alumnos cat){
		try {
			Alumnos a = alumnosservice.create(cat);
			return new ResponseEntity<>(a, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Alumnos> getAlumnos(@PathVariable Long id){
		try {
			Alumnos a = alumnosservice.read(id).get();
			return new ResponseEntity<>(a, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Alumnos> delAlumnos(@PathVariable Long id){
		try {
			alumnosservice.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateAlumnos(@PathVariable Long id, @Valid @RequestBody Alumnos cat){

			Optional<Alumnos> a = alumnosservice.read(id);
			if(a.isEmpty()) {
				return new ResponseEntity<>(alumnosservice.update(cat), HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}		
		
	}
}
