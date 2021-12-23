package mx.edu.uacm.progweb.evaluacionanonima.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mx.edu.uacm.progweb.evaluacionanonima.dominio.Curso;
import mx.edu.uacm.progweb.evaluacionanonima.error.AplicacionExcepcion;

public interface CursoService {
	
	/**
	 * 
	 * @return
	 */
	List<Curso> obtenerCursos();
	
	/**
	 * 
	 * @param actividad
	 * @return
	 * @throws AplicacionExcepcion
	 */
	Curso agregarCurso(Curso curso) throws AplicacionExcepcion;
	/**
	 * Metodo para obtener actividades de manera paginada
	 * @param pageable
	 * @return
	 */
	Page<Curso> obtenerCursosPaginados(Pageable pageable);

}
