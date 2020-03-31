package com.vhsadev.springpodcasts.models.dto.episodio;

import java.time.LocalDateTime;

public class EpisodioEdicaoDTO {

	public Integer guidEpisodio;
	private String titulo;
	private String descricao;
	private LocalDateTime lancamento;
	private int duracao;
	private String linkAudio;
	public Integer guidPodcast;

	public EpisodioEdicaoDTO() {
	}

	public EpisodioEdicaoDTO(Integer guidEpisodio, String titulo, String descricao, LocalDateTime lancamento,
			int duracao, String linkAudio, Integer guidPodcast) {
		this.guidEpisodio = guidEpisodio;
		this.titulo = titulo;
		this.descricao = descricao;
		this.lancamento = lancamento;
		this.duracao = duracao;
		this.linkAudio = linkAudio;
		this.guidPodcast = guidPodcast;
	}

	public Integer getGuidEpisodio() {
		return guidEpisodio;
	}

	public void setGuidEpisodio(Integer guidEpisodio) {
		this.guidEpisodio = guidEpisodio;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getLancamento() {
		return lancamento;
	}

	public void setLancamento(LocalDateTime lancamento) {
		this.lancamento = lancamento;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public String getLinkAudio() {
		return linkAudio;
	}

	public void setLinkAudio(String linkAudio) {
		this.linkAudio = linkAudio;
	}

	public Integer getGuidPodcast() {
		return guidPodcast;
	}

	public void setGuidPodcast(Integer guidPodcast) {
		this.guidPodcast = guidPodcast;
	}

}
