package com.vhsadev.springpodcasts.models.dto.podcast;

public class PodcastListagemDTO {
	
	

	public PodcastListagemDTO() {
	}

	public PodcastListagemDTO(Integer guidPodcast, String nome, String autor, String descricao, String link,
			String imagem, String nomeCategoria, Integer guidCategoria) {
		this.guidPodcast = guidPodcast;
		this.nome = nome;
		this.autor = autor;
		this.descricao = descricao;
		this.link = link;
		this.imagem = imagem;
		this.nomeCategoria = nomeCategoria;
		this.guidCategoria = guidCategoria;
	}

	private Integer guidPodcast;

	private String nome;

	private String autor;

	private String descricao;

	private String link;

	private String imagem;

	private String nomeCategoria;

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

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public Integer getGuidCategoria() {
		return guidCategoria;
	}

	public void setGuidCategoria(Integer guidCategoria) {
		this.guidCategoria = guidCategoria;
	}

}
