package cl.ipss.kanban.entity;


import java.time.LocalDate;
import java.time.LocalDateTime;

import cl.ipss.kanban.enums.EstadoTarea;
import cl.ipss.kanban.enums.PrioridadTarea;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table (name = "Tarea")
public class Tarea {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "titulo", nullable = false , length = 100)
	private String titulo;
	
	@Column(length = 500)
	private String descripcion;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 10)
	private EstadoTarea estado;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 10)
	private PrioridadTarea prioridad;
	
	@Column(name = "fecha_limite")
	private LocalDate fechaLimite;

	@Column(name = "creada_en", nullable = false, updatable = false)
	private LocalDateTime creadaEn;

	public PrioridadTarea getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(PrioridadTarea prioridad) {
		this.prioridad = prioridad;
	}


	@Column(name = "actualizada_en", nullable = false) //ola
	private LocalDateTime actualizadaEn;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public EstadoTarea getEstado() {
		return estado;
	}

	public void setEstado(EstadoTarea estado) {
		this.estado = estado;
	}

	public LocalDate getFechaLimite() {
		return fechaLimite;
	}

	public void setFechaLimite(LocalDate fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	public LocalDateTime getCreadaEn() {
		return creadaEn;
	}

	public void setCreadaEn(LocalDateTime creadaEn) {
		this.creadaEn = creadaEn;
	}

	public LocalDateTime getActualizadaEn() {
		return actualizadaEn;
	}

	public void setActualizadaEn(LocalDateTime actualizadaEn) {
		this.actualizadaEn = actualizadaEn;
	}

public Tarea () {
	
}
//Para guardar la fecha y actualizacion, conjunto a validacion back en caso de que el campo este vacio

@PrePersist
void antesDeGuardar() {
	LocalDateTime ahora = LocalDateTime.now();
	this.creadaEn = ahora;
	this.actualizadaEn = ahora;
	if(this.estado == null) {
		this.estado = EstadoTarea.POR_HACER;
	}
}


@PreUpdate
void antesDeAcualizar() {
	this.actualizadaEn = LocalDateTime.now();
}

}