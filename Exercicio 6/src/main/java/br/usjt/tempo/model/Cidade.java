package br.usjt.tempo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@NamedQuery (name = "Cidade.buscarPelaLatitudeEPelaLongitude",
query = "SELECT a FROM Cidade a WHERE latitude = :123 AND longitude = :312")

@NamedQuery (name = "Cidade.buscarPeloNome",
query = "SELECT a FROM Cidade a WHERE a.nome = :São Paulo")

@NamedQuery (name = "Cidade.buscarPeloNomeIgnorecase",
query = "SELECT a FROM Cidade a WHERE upper a.nome = :São Paulo")


@Entity
public class Cidade {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private Double latitude;
	private Double longitude;
	
	@ManyToOne
	private List<Previsao> previsoes;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public List<Previsao> getPrevisoes() {
		return previsoes;
	}
	public void setPrevisoes(List<Previsao> previsoes) {
		this.previsoes = previsoes;
	}	
}
