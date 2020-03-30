package com.vhsadev.springpodcasts.models.dto.podcast;

public class PodcastEdicaoDTO {

	private Integer guidPodcast;

	private String nome;

	private String autor;

	private String descricao;

	private String link;

	private String imagem;

	private Integer guidCategoria;

	public Integer getGuidPodcast() {
		return guidPodcast;
	}

	public void setGuidPodcast(Integer guidPodcast) {
		this.guidPodcast = guidPodcast;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Integer getGuidCategoria() {
		return guidCategoria;
	}

	public void setGuidCategoria(Integer guidCategoria) {
		this.guidCategoria = guidCategoria;
	}
}
