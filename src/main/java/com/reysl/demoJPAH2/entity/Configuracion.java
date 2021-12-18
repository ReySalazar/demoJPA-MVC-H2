package com.reysl.demoJPAH2.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Configuracion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String idioma;
	private String pais;
	private boolean activo;
	
	public Configuracion() {}

	public Configuracion(Long id, String idioma, String pais, boolean activo) {
		super();
		this.id = id;
		this.idioma = idioma;
		this.pais = pais;
		this.activo = activo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Configuracion other = (Configuracion) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Configuracion [id=" + id + ", idioma=" + idioma + ", pais=" + pais + ", activo=" + activo + "]";
	}
	
}
