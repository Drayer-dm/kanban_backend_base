package cl.ipss.kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.ipss.kanban.entity.Tarea;
import cl.ipss.kanban.enums.EstadoTarea;

public interface TareaRepository extends JpaRepository<Tarea, Long>{

	Long countByEstado(EstadoTarea estado);
	
}
