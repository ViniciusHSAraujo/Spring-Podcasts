package com.vhsadev.springpodcasts.services.interfaces;

import java.util.List;

import com.vhsadev.springpodcasts.models.Categoria;
import com.vhsadev.springpodcasts.models.dto.categoria.CategoriaCadastroDTO;
import com.vhsadev.springpodcasts.models.dto.categoria.CategoriaEdicaoDTO;

public interface ICategoriaService {

	Categoria cadastrar(CategoriaCadastroDTO categoriaTemp) throws Exception;

	Categoria editar(CategoriaEdicaoDTO categoriaTemp) throws Exception;

	void excluir(Integer id) throws Exception;

	List<Categoria> listar() throws Exception;

	Categoria buscar(Integer id) throws Exception;

}