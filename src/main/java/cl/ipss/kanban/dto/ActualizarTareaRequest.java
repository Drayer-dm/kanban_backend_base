package cl.ipss.kanban.dto;

import java.time.LocalDate;

import cl.ipss.kanban.enums.PrioridadTarea;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ActualizarTareaRequest(
		@NotBlank(message = "El titulo es obligatorio")
		@Size(max = 100, message = "El titulo no puede superar los 100 caracteres")
		@Size(min = 5, message = "El titulo no puede ser mas pequeño que 5 caracteres")
		String titulo,

		@Size(max = 500, message = "No `puede superar los 500 caracteres")
		String descripcion,


		@NotNull(message = "La prioridad es obligatioro")
		PrioridadTarea prioridad,


		LocalDate fechaLimite
		) {

}
