package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import model.Curso;
import service.CursoService;

@RestController
@RequestMapping("curso")
public class CursoController {

	@Autowired
	private CursoService service;

	@GetMapping
	public List<Curso> listarCursos() {
		return service.searchCurso();
	}

	@GetMapping("/{id}")
	public Curso buscar(@PathVariable("id") Long cursoId) {
		Optional<Curso> opCurso = service.searchCursoId(cursoId);
		if (opCurso.isPresent()) {
			return opCurso.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso Não encontrado");
		}

	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Curso createCurso(@RequestBody Curso curso) {
		Curso newCurso = service.createCurso(curso);
		return newCurso;
	}

	@PutMapping
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void editCurso(@RequestBody Curso curso) {
		service.editCurso(curso);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void removeCurso(@PathVariable("id") Long cursoId) {
		Optional<Curso> opCurso = service.searchCursoId(cursoId);
		if (opCurso.isPresent()) {
			service.removeCurso(opCurso.get());
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso Não encontrado");
		}
	}

}
