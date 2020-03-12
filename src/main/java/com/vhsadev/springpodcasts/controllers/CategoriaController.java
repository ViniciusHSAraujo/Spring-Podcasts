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
import com.vhsadev.springpodcasts.models.dto.categoria.CategoriaCadastroDTO;
import com.vhsadev.springpodcasts.models.dto.categoria.CategoriaEdicaoDTO;
import com.vhsadev.springpodcasts.services.CategoriaService;

@RestController
@RequestMapping("/categorias")

public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<ResponseDTO<?>> listar() {
		try {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDTO<List<Categoria>>("Categorias encontradas", categoriaService.listar()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseDTO<List<Categoria>>(e.getMessage(), null));
		}
	}

	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody CategoriaCadastroDTO categoria) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseDTO<Categoria>("Categoria cadastrada com sucesso!", categoriaService.cadastrar(categoria)));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseDTO<List<Categoria>>(e.getMessage(), null));
		}
	}

	@PutMapping
	public ResponseEntity<?> editar(@RequestBody CategoriaEdicaoDTO categoria) {
		try {
			return ResponseEntity.ok().body(categoriaService.editar(categoria));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping
	public void excluir(Integer id) {
		categoriaService.excluir(id);
	}

}
