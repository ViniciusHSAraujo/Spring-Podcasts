package com.vhsadev.springpodcasts.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseDTO<List<String>>(e.getMessage(), null));
		}
	}

	@PutMapping
	public ResponseEntity<?> editar(@RequestBody PodcastEdicaoDTO podcast) {
		try {
			return ResponseEntity.ok().body(podcastService.editar(podcast));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping
	public ResponseEntity<?> excluir(Integer id) {
		try {
			podcastService.excluir(id);
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDTO<String>("Podcast excluído com sucesso.", null));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseDTO<List<String>>(e.getMessage(), null));
		}
	}
}
