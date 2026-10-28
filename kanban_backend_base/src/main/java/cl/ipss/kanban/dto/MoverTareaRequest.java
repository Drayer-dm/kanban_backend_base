package cl.ipss.kanban.dto;

import cl.ipss.kanban.enums.EstadoTarea;
import jakarta.validation.constraints.NotNull;

public record MoverTareaRequest(
		
		@NotNull(message = "El estado no puede estar vacio")
		EstadoTarea estado
		) {

}
