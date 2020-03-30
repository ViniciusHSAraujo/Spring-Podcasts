package com.vhsadev.springpodcasts.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vhsadev.springpodcasts.libs.validations.ValidacaoDeEntidade;
import com.vhsadev.springpodcasts.models.Categoria;
import com.vhsadev.springpodcasts.models.Podcast;
import com.vhsadev.springpodcasts.models.dto.podcast.PodcastCadastroDTO;
import com.vhsadev.springpodcasts.models.dto.podcast.PodcastEdicaoDTO;
import com.vhsadev.springpodcasts.models.dto.podcast.PodcastListagemDTO;
import com.vhsadev.springpodcasts.repositories.CategoriaRepository;
import com.vhsadev.springpodcasts.repositories.PodcastRepository;
import com.vhsadev.springpodcasts.services.interfaces.IPodcastService;

import javassist.NotFoundException;

@Service
public class PodcastService implements IPodcastService {

	@Autowired
	PodcastRepository podcastRepository;

	@Autowired
	CategoriaRepository categoriaRepository;

	@Autowired
	ValidacaoDeEntidade<Podcast> validacaoDeEntidade;

	@Override
	public Podcast cadastrar(PodcastCadastroDTO podcastTemp) throws Exception {

		Optional<Categoria> categoria = categoriaRepository.findById(podcastTemp.getGuidCategoria());

		if (!categoria.isPresent()) {
			throw new NotFoundException("Categoria não encontrada!");
		}

		Podcast podcast = new Podcast();
		podcast.setNome(podcastTemp.getNome());
		podcast.setAutor(podcastTemp.getAutor());
		podcast.setDescricao(podcastTemp.getDescricao());
		podcast.setLink(podcastTemp.getLink());
		podcast.setImagem(podcastTemp.getImagem());
		podcast.setCategoria(categoria.get());

		List<String> erros = validacaoDeEntidade.validarEntidade(podcast);
		if (!erros.isEmpty()) {
			throw new Exception(erros.toString());
		}
		return podcastRepository.save(podcast);
	}

	@Override
	public Podcast editar(PodcastEdicaoDTO podcastTemp) throws Exception {

		if (!podcastRepository.existsById(podcastTemp.getGuidPodcast())) {
			throw new NotFoundException("Podcast não encontrado!");
		}

		Optional<Categoria> categoria = categoriaRepository.findById(podcastTemp.getGuidCategoria());

		if (!categoria.isPresent()) {
			throw new NotFoundException("Categoria não encontrada!");
		}

		Podcast podcast = new Podcast();
		podcast.setGuidPodcast(podcastTemp.getGuidPodcast());
		podcast.setNome(podcastTemp.getNome());
		podcast.setAutor(podcastTemp.getAutor());
		podcast.setDescricao(podcastTemp.getDescricao());
		podcast.setLink(podcastTemp.getLink());
		podcast.setImagem(podcastTemp.getImagem());
		podcast.setCategoria(categoria.get());

		List<String> erros = validacaoDeEntidade.validarEntidade(podcast);
		if (!erros.isEmpty()) {
			throw new Exception(erros.toString());
		}
		return podcastRepository.save(podcast);
	}

	@Override
	public void excluir(Integer id) throws Exception {
		try {
			categoriaRepository.deleteById(id);
		} catch (Exception e) {
			throw new Exception(
					"Não foi possível excluir esse Podcast. Verifique possíveis relacionamentos e tente novamente mais tarde.");
		}
	}

	@Override
	public List<PodcastListagemDTO> listar() throws Exception {
		List<Podcast> podcasts = podcastRepository.findAll();
		List<PodcastListagemDTO> podcastsDtos = new ArrayList<PodcastListagemDTO>();

		if (podcasts.isEmpty()) {
			throw new NotFoundException("Nenhum podcast encontrado.");
		}

		for (Podcast podcast : podcasts) {
			podcastsDtos.add(new PodcastListagemDTO(podcast.getGuidPodcast(), podcast.getNome(), podcast.getAutor(),
					podcast.getDescricao(), podcast.getLink(), podcast.getImagem(), podcast.getCategoria().getNome(),
					podcast.getCategoria().getGuidCategoria()));
		}

		return podcastsDtos;
	}
}
