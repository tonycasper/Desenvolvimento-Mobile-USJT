package br.usjt.tempo.repository;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Async;

import br.usjt.tempo.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

	
	@Query ("SELECT a FROM Cidade a WHERE latitude = :latitude AND longitude = :longitude")
	
	public Cidade findByLatitudeAndLongitude(String latitude, String longitude);
	
	@Query ("SELECT a FROM Cidade a WHERE a.nome = :São Paulo")
	public Cidade findByNome(String nome);

	@Query ("SELECT a FROM Cidade a WHERE upper a.nome = :São Paulo")
	public  List<Cidade> findByNomeIgnoreCase(String nome);
	
	
	@Async
	public Future <List <Cidade> > findByNome2 (String nome);
	
	
	@Async
	public Future <List <Cidade> > findByLatitudeAndlongitude2(String latitude, String longitude);
	
	@Async
	public Future <List<Cidade>> findByNome2IgnoreCase(String nome);
}
