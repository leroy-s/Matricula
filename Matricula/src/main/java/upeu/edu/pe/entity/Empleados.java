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
@Table(name="empleado")
public class Empleados {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="dni", length = 8)
	private String codigo; 
	@Column(name="nombres", length = 50)
	private String nombres;
	@Column(name="apellidos", length = 50)
	private String apellidos;
	@Column(name="fecha_ingreso")
	@Temporal (TemporalType.TIMESTAMP)
	private Date fecha_ingreso;
	@Column(name="cargo", length = 50)
	private String cargo;
	
	@OneToMany(cascade=CascadeType.ALL, fetch =FetchType.LAZY,mappedBy = "empleados")
	@JsonIgnore
	private Set<Matricula> matriculas;
}
