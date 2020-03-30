package com.vhsadev.springpodcasts.services.interfaces;

import java.util.List;

import com.vhsadev.springpodcasts.models.Podcast;
import com.vhsadev.springpodcasts.models.dto.podcast.PodcastCadastroDTO;
import com.vhsadev.springpodcasts.models.dto.podcast.PodcastEdicaoDTO;
import com.vhsadev.springpodcasts.models.dto.podcast.PodcastListagemDTO;

public interface IPodcastService {

	Podcast cadastrar(PodcastCadastroDTO podcastTemp) throws Exception;

	Podcast editar(PodcastEdicaoDTO podcastTemp) throws Exception;

	void excluir(Integer id) throws Exception;

	List<PodcastListagemDTO> listar() throws Exception;

}