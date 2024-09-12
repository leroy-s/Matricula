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
import upeu.edu.pe.entity.Grados;
import upeu.edu.pe.service.GradosService;

@RestController
@RequestMapping("/api/grados")
public class GradosController {

    @Autowired
    private GradosService gradosService;

    @GetMapping
    public ResponseEntity<List<Grados>> readAll() {
        try {
            List<Grados> grados = gradosService.readAll();
            if (grados.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(grados, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Grados> crear(@Valid @RequestBody Grados grado) {
        try {
            Grados g = gradosService.create(grado);
            return new ResponseEntity<>(g, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grados> getGrados(@PathVariable Long id) {
        try {
            Grados g = gradosService.read(id).get();
            return new ResponseEntity<>(g, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Grados> delGrados(@PathVariable Long id) {
        try {
            gradosService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateGrados(@PathVariable Long id, @Valid @RequestBody Grados grado) {
        Optional<Grados> g = gradosService.read(id);
        if (g.isEmpty()) {
            return new ResponseEntity<>(gradosService.update(grado), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
