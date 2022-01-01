package mx.edu.uacm.progweb.evaluacionanonima.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.edu.uacm.progweb.evaluacionanonima.dominio.Curso;
import mx.edu.uacm.progweb.evaluacionanonima.error.AplicacionExcepcion;
import mx.edu.uacm.progweb.evaluacionanonima.repository.CursoRepository;
import mx.edu.uacm.progweb.evaluacionanonima.service.CursoService;

@Service
@Slf4j
public class CursoServiceImpl implements CursoService {
	
	
	@Autowired
	private CursoRepository cursoRepository;

	@Override
	public List<Curso> obtenerCursos() {
		
		return (List<Curso>) cursoRepository.findAll();
	}

	
	public Curso guardarCurso(Curso curso) throws AplicacionExcepcion {
		
		if(log.isDebugEnabled())
			log.debug("> Entrando a agregarActividad");
		
		Curso CursoGuardado = null;
		
		try {
			
			CursoGuardado = cursoRepository.save(curso);
		
		} catch (DataAccessException e) {
			log.error(e.getMessage());
			
			throw new AplicacionExcepcion("Hubo un error al guardar el registro");
		}
		
		return CursoGuardado;
	}

	@Override
	public void eliminarCurso(Curso curso) throws AplicacionExcepcion {
		if (log.isDebugEnabled())
			log.debug("> entrando a eliminarCurso ");
		
		try { 
			cursoRepository.delete(curso);
			
		}catch (DataAccessException e) {
			log.error(e.getMessage());
			throw new AplicacionExcepcion("Error al eliminar el registro");
		}
		
	}

}
