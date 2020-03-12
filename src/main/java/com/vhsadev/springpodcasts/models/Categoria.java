package com.vhsadev.springpodcasts.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity(name = "Categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "GUID_CATEGORIA")
	private Integer guidCategoria;
	
	@Column(name = "NOME", nullable = false)
	@NotBlank(message = "O campo NOME é requerido.")
	private String nome;

	public Integer getGuidCategoria() {
		return guidCategoria;
	}

	public void setGuidCategoria(Integer guidCategoria) {
		this.guidCategoria = guidCategoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((guidCategoria == null) ? 0 : guidCategoria.hashCode());
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
		Categoria other = (Categoria) obj;
		if (guidCategoria == null) {
			if (other.guidCategoria != null)
				return false;
		} else if (!guidCategoria.equals(other.guidCategoria))
			return false;
		return true;
	}

	
}
