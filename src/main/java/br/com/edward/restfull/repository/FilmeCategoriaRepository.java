package br.com.edward.restfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.edward.restfull.domain.FilmeCategoria;

@Repository
public interface FilmeCategoriaRepository extends JpaRepository<FilmeCategoria, Long> {

}
