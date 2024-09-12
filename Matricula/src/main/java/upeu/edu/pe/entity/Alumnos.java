package upeu.edu.pe.entity;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="alumno")
public class Alumnos {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="codigo", length = 10)
	private String codigo; 
	@Column(name="nombres", length = 50)
	private String nombres;
	@Column(name="apellidos", length = 50)
	private String apellidos;
	@Column(name="fecha_nac")
	@Temporal (TemporalType.TIMESTAMP)
	private Date fecha_nac;
	@Column(name="correo", length = 50)
	private String correo;
	
	@OneToMany(cascade=CascadeType.ALL, fetch =FetchType.LAZY,mappedBy = "alumnos")
	@JsonIgnore
	private Set<Matricula> matriculas;
}










