package cl.ipss.kanban.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import cl.ipss.kanban.enums.EstadoTarea;
import cl.ipss.kanban.enums.PrioridadTarea;

public record TareaResponse(
		
		Long id,
		String titulo,
		String descripcion,
		EstadoTarea estado,
		PrioridadTarea prioridad,
		LocalDate fechaLimite,
		LocalDateTime creadaEn,
		LocalDateTime actualizadaEn
		
		) {
}
