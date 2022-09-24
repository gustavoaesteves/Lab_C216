package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import model.Curso;

@Service
public class CursoService {

	private List<Curso> listCursos = new ArrayList<Curso>();

	@PostConstruct
	private void setup() {
		model.Curso curso1 = new Curso(1L, "Front", 200);
		model.Curso curso2 = new model.Curso(2L, "Desenvolvimento Angular", 300);
		model.Curso curso3 = new model.Curso(3L, "Back", 100);

		listCursos.add(curso1);
		listCursos.add(curso2);
		listCursos.add(curso3);

	}

	public List<Curso> searchCurso() {
		return listCursos;
	}

	public Optional<Curso> searchCursoId(Long cursoId) {
		return listCursos.stream().filter(e -> e.getId().equals(cursoId)).findFirst();

	}

	public Curso createCurso(Curso curso) {
		Long id = new Random().nextLong();
		curso.setId(id);
		listCursos.add(curso);
		return curso;
	}

	public void editCurso(Curso curso) {
		listCursos.remove(curso);
		listCursos.add(curso);
	}

	public void removeCurso(Curso curso) {
		listCursos.remove(curso);
	}

}
