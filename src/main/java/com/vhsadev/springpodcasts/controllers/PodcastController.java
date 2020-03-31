package com.vhsadev.springpodcasts.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vhsadev.springpodcasts.models.Categoria;
import com.vhsadev.springpodcasts.models.dto.ResponseDTO;
import com.vhsadev.springpodcasts.models.dto.podcast.PodcastCadastroDTO;
import com.vhsadev.springpodcasts.models.dto.podcast.PodcastEdicaoDTO;
import com.vhsadev.springpodcasts.models.dto.podcast.PodcastListagemDTO;
import com.vhsadev.springpodcasts.services.interfaces.IPodcastService;

@RestController
@RequestMapping("/podcasts")
public class PodcastController {

	@Autowired
	IPodcastService podcastService;

	@GetMapping("{id}")
	public ResponseEntity<ResponseDTO<?>> buscar(@PathVariable("id") Integer id) {
		try {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDTO<List<Categoria>>("Podcast encontrado", podcastService.buscar(id)));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseDTO<List<Categoria>>(e.getMessage(), null));
		}
	}
	
	@GetMapping
	public ResponseEntity<ResponseDTO<?>> listar() {
		try {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDTO<List<PodcastListagemDTO>>("Podcasts encontrados", podcastService.listar()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseDTO<List<Categoria>>(e.getMessage(), null));
		}
	}

	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody PodcastCadastroDTO podcast) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseDTO<Categoria>("Podcast cadastrado com sucesso!", podcastService.cadastrar(podcast)));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ResponseDTO<List<String>>("Não foi possível cadastrar o podcast!", e.getMessage()));
		}
	}

	@PutMapping
	public ResponseEntity<?> editar(@RequestBody PodcastEdicaoDTO podcast) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(podcastService.editar(podcast));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ResponseDTO<List<String>>("Não foi possível editar o podcast!", e.getMessage()));
		}
	}

	@DeleteMapping
	public ResponseEntity<?> excluir(Integer id) {
		try {
			podcastService.excluir(id);
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDTO<String>("Podcast excluído com sucesso.", null));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
					.body(new ResponseDTO<List<String>>(e.getMessage(), null));
		}
	}
}
