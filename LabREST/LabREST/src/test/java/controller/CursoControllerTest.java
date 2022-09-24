package controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import model.Curso;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CursoControllerTest {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void listCursos() {
		webTestClient.get().uri("/curso").exchange().expectHeader().contentType(MediaType.APPLICATION_JSON)
				.expectStatus().isOk().expectBody().returnResult();

	}

	@Test
	void dadoCursoIdValido_quandoGetCursoPeloId_entaoRespondeComCursoValido() {
		Long cursoIdValido = 1L;

		Curso resultCurso = webTestClient.get().uri("/curso/" + cursoIdValido).exchange().expectBody(Curso.class)
				.returnResult().getResponseBody();

		assertNotNull(resultCurso);
		assertEquals(resultCurso.getId(), cursoIdValido);
	}

	@Test
	void dadoCursoIdInvalido_quandoGetCursoPeloId_entaoRespondeComNotFound() {
		Long cursoIdInvalido = 16L;

		webTestClient.get().uri("/curso/" + cursoIdInvalido).exchange().expectStatus().isNotFound();

	}

	@Test
	void dadoNovoCurso_quandoPostCurso_entaoRespondeComStatusCreatedECursoValido() {
		Curso newCurso = new Curso();
		newCurso.setDescription("Node.Js");
		newCurso.setnumHoraria(400);

		Curso result = webTestClient.post().uri("/curso").bodyValue(newCurso).exchange().expectStatus().isCreated()
				.expectBody(Curso.class).returnResult().getResponseBody();

		assertThat(result).isNotNull();
		assertThat(result.getId()).isNotNull();
		
	}
	
	@Test
    void dadoCursoValido_quandoPutCurso_entaoRespondeComStatusAccepted() {
        Curso cursoEdit= new Curso(1L, "Curso VUE.JS", 120);

         webTestClient
                .put()
                .uri("/curso")
                .bodyValue(cursoEdit)
                .exchange()
                .expectStatus().isAccepted();
    }

    @Test
	void dadoCursoValido_quandoDeleteCurso_entaoRespondeComStatusAccept() {
		Long cursoIdValido = 2L;
	
		webTestClient.delete()
			.uri("/curso/" + cursoIdValido)
			.exchange()
			.expectStatus()
				.isAccepted()
			.expectBody(Curso.class);
	}

    @Test
    void dadoCursoInvalido_quandoDeleteCurso_entaoRespondeComStatusNotFound(){
        Long cursoIdInvalido= 16L;

        webTestClient
                .delete()
                .uri("/curso/" + cursoIdInvalido)
                .exchange()
                .expectStatus().isNotFound();
    }

}