package com.vhsadev.springpodcasts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vhsadev.springpodcasts.libs.validations.ValidacaoDeEntidade;
import com.vhsadev.springpodcasts.models.Categoria;
import com.vhsadev.springpodcasts.models.dto.categoria.CategoriaCadastroDTO;
import com.vhsadev.springpodcasts.models.dto.categoria.CategoriaEdicaoDTO;
import com.vhsadev.springpodcasts.repositories.CategoriaRepository;
import com.vhsadev.springpodcasts.services.interfaces.ICategoriaService;

import javassist.NotFoundException;

@Service
public class CategoriaService implements ICategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;

	@Autowired
	ValidacaoDeEntidade<Categoria> validacaoDeEntidade;

	@Override
	public Categoria cadastrar(CategoriaCadastroDTO categoriaTemp) throws Exception {

		Categoria categoria = new Categoria();
		categoria.setNome(categoriaTemp.getNome());

		List<String> erros = validacaoDeEntidade.validarEntidade(categoria);
		if (!erros.isEmpty()) {
			throw new Exception(String.join(" ", erros));
		}
		return categoriaRepository.save(categoria);
	}

	@Override
	public Categoria editar(CategoriaEdicaoDTO categoriaTemp) throws Exception {

		if (!categoriaRepository.existsById(categoriaTemp.getGuidCategoria())) {
			throw new NotFoundException("Categoria não encontrada!");
		}

		Categoria categoria = new Categoria();
		categoria.setGuidCategoria(categoriaTemp.getGuidCategoria());
		categoria.setNome(categoriaTemp.getNome());

		List<String> erros = validacaoDeEntidade.validarEntidade(categoria);

		if (!erros.isEmpty()) {
			throw new Exception(String.join(" ", erros));
		}

		return categoriaRepository.save(categoria);
	}

	@Override
	public void excluir(Integer id) throws Exception {
		try {
			categoriaRepository.deleteById(id);
		} catch (Exception e) {
			throw new Exception(
					"Não foi possível excluir essa categoria. Verifique possíveis relacionamentos e tente novamente mais tarde.");
		}

	}

	@Override
	public List<Categoria> listar() throws Exception {

		List<Categoria> categorias = categoriaRepository.findAll();

		if (categorias.isEmpty()) {
			throw new NotFoundException("Nenhuma categoria encontrada");
		}

		return categorias;
	}

	@Override
	public Categoria buscar(Integer id) throws Exception {
		Optional<Categoria> categoria = categoriaRepository.findById(id);

		if (!categoria.isPresent()) {
			throw new NotFoundException("Categoria não encontrada!");
		}

		return categoria.get();
	}

}
