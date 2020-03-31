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
import com.vhsadev.springpodcasts.models.dto.categoria.CategoriaCadastroDTO;
import com.vhsadev.springpodcasts.models.dto.categoria.CategoriaEdicaoDTO;
import com.vhsadev.springpodcasts.services.interfaces.ICategoriaService;

@RestController
@RequestMapping("/categorias")

public class CategoriaController {

	@Autowired
	ICategoriaService categoriaService;

	@GetMapping("{id}")
	public ResponseEntity<ResponseDTO<?>> buscar(@PathVariable("id") Integer id) {
		try {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDTO<List<Categoria>>("Categoria encontrada", categoriaService.buscar(id)));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseDTO<List<Categoria>>(e.getMessage(), null));
		}
	}

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
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO<Categoria>(
					"Categoria cadastrada com sucesso!", categoriaService.cadastrar(categoria)));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ResponseDTO<List<Categoria>>(e.getMessage(), null));
		}
	}

	@PutMapping
	public ResponseEntity<?> editar(@RequestBody CategoriaEdicaoDTO categoria) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(categoriaService.editar(categoria));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@DeleteMapping
	public ResponseEntity<?> excluir(Integer id) {
		try {
			categoriaService.excluir(id);
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDTO<String>("Categoria excluída com sucesso.", null));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
					.body(new ResponseDTO<List<String>>(e.getMessage(), null));
		}
	}
}
