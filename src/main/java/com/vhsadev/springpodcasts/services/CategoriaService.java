package com.vhsadev.springpodcasts.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vhsadev.springpodcasts.libs.validations.ValidacaoDeEntidade;
import com.vhsadev.springpodcasts.models.Categoria;
import com.vhsadev.springpodcasts.models.dto.categoria.CategoriaCadastroDTO;
import com.vhsadev.springpodcasts.models.dto.categoria.CategoriaEdicaoDTO;
import com.vhsadev.springpodcasts.repositories.CategoriaRepository;

import javassist.NotFoundException;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ValidacaoDeEntidade<Categoria> validacaoDeEntidade;

	public Categoria cadastrar(CategoriaCadastroDTO categoriaTemp) throws Exception {
		
		
		Categoria categoria = new Categoria();
		categoria.setNome(categoriaTemp.getNome());
		
		
		List<String> erros = validacaoDeEntidade.validarEntidade(categoria);
		if (!erros.isEmpty()) {
			throw new Exception(erros.toString());
		}
		return categoriaRepository.save(categoria);
	}

	public Categoria editar(CategoriaEdicaoDTO categoriaTemp) throws Exception {

		if (!categoriaRepository.existsById(categoriaTemp.getGuidCategoria())) {
			throw new NotFoundException("Categoria não encontrada!");
		}

		Categoria categoria = new Categoria();
		categoria.setGuidCategoria(categoriaTemp.getGuidCategoria());
		categoria.setNome(categoriaTemp.getNome());
		return categoriaRepository.save(categoria);
	}

	public void excluir(Integer id) {
		Categoria categoria = buscarPorId(id);
		categoriaRepository.delete(categoria);
	}

	public List<Categoria> listar() throws Exception {
		List<Categoria> categorias = categoriaRepository.findAll();

		if (categorias.isEmpty()) {
			throw new NotFoundException("Nenhuma categoria encontrada");
		}

		return categorias;
	}

	public Categoria buscarPorId(Integer id) {
		return categoriaRepository.findById(id).get();
	}
}
