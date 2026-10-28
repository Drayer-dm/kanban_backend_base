package cl.ipss.kanban.service;

import java.util.List;

import cl.ipss.kanban.dto.ActualizarTareaRequest;
import cl.ipss.kanban.dto.CrearTareaRequest;
import cl.ipss.kanban.dto.TareaResponse;
import cl.ipss.kanban.enums.EstadoTarea;

public interface TareaService {

	List<TareaResponse> listar();

	TareaResponse obtener(Long id);

	TareaResponse crear(CrearTareaRequest request);

	TareaResponse actualizar(Long id, ActualizarTareaRequest request);

	TareaResponse mover(Long id, EstadoTarea destino);

	void eliminar(Long id);

}