package com.vhsadev.springpodcasts.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "Podcast")
public class Podcast {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "GUID_PODCAST")
	private Integer guidPodcast;
	
	@Column(name = "NOME", nullable = false)
	@NotBlank(message = "O campo NOME é requerido.")
	private String nome;
	
	@Column(name = "AUTOR", nullable = false)
	@NotBlank(message = "O campo AUTOR é requerido.")
	private String autor;
	
	@Column(name = "DESCRICAO", nullable = false)
	@NotBlank(message = "O campo DESCRIÇÃO é requerido.")
	private String descricao;
	
	@Column(name = "LINK", nullable = false)
	@NotBlank(message = "O campo LINK é requerido.")
	private String link;
	
	@Column(name = "IMAGEM", nullable = false)
	@NotBlank(message = "O campo IMAGEM é requerido.")
	private String imagem;
	
	@JoinColumn(name="guidCategoria")
	@NotNull(message = "O campo CATEGORIA é requerido.")
	@ManyToOne
	private Categoria categoria;

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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((guidPodcast == null) ? 0 : guidPodcast.hashCode());
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
		Podcast other = (Podcast) obj;
		if (guidPodcast == null) {
			if (other.guidPodcast != null)
				return false;
		} else if (!guidPodcast.equals(other.guidPodcast))
			return false;
		return true;
	}
	
	
	
}
