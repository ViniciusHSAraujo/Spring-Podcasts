package com.vhsadev.springpodcasts.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "Episodio")
public class Episodio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "GUID_EPISODIO")
	private Integer guidEpisodio;
	
	@Column(name = "TITULO", nullable = false)
	@NotBlank(message = "O campo TÍTULO é requerido.")
	private String titulo;
	
	@Column(name = "DESCRICAO", nullable = false)
	@NotBlank(message = "O campo DESCRICÃO é requerido.")
	private String descricao;
	
	@Column(name = "LANCAMENTO", nullable = false)
	@NotBlank(message = "O campo LANÇAMENTO é requerido.")
	private LocalDateTime lancamento;
	
	@Column(name = "DURACAO", nullable = false)
	@NotBlank(message = "O campo DURAÇÃO é requerido.")
	private int duracao;
	
	@Column(name = "LINKAUDIO", nullable = false)
	@NotBlank(message = "O campo LINK DO ÁUDIO é requerido.")
	private String linkAudio;
	
	@JoinColumn(name = "guidPodcast")
	@NotNull(message = "O campo PODCAST é requerido.")
	@ManyToOne
	private Podcast podcast;

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

	public Podcast getPodcast() {
		return podcast;
	}

	public void setPodcast(Podcast podcast) {
		this.podcast = podcast;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((guidEpisodio == null) ? 0 : guidEpisodio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Episodio other = (Episodio) obj;
		if (guidEpisodio == null) {
			if (other.guidEpisodio != null)
				return false;
		} else if (!guidEpisodio.equals(other.guidEpisodio))
			return false;
		return true;
	}

	
}
