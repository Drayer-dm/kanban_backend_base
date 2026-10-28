package cl.ipss.kanban.exception;

import java.time.LocalDateTime;
import java.util.List;

// Formato unico de error que recibe Angular
public record ApiError(LocalDateTime fecha, int status, String error, String mensaje, List<String> detalles) {

	public static ApiError de(int status, String error, String mensaje, List<String> detalles) {
		return new ApiError(LocalDateTime.now(), status, error, mensaje, detalles);
	}
}
