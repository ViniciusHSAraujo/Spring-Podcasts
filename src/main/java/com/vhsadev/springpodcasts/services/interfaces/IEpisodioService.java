package com.vhsadev.springpodcasts.services.interfaces;

import java.util.List;

import com.vhsadev.springpodcasts.models.Episodio;
import com.vhsadev.springpodcasts.models.dto.episodio.EpisodioCadastroDTO;
import com.vhsadev.springpodcasts.models.dto.episodio.EpisodioEdicaoDTO;

public interface IEpisodioService {

	Episodio cadastrar(EpisodioCadastroDTO episodioTemp) throws Exception;

	Episodio editar(EpisodioEdicaoDTO episodioTemp) throws Exception;

	void excluir(Integer id) throws Exception;

	List<Episodio> listar() throws Exception;

	Episodio buscar(Integer id) throws Exception;

}