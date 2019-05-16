package br.com.edward.restfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.edward.restfull.domain.Ingresso;

@Repository
public interface IngressoRepository extends JpaRepository<Ingresso, Long>{

}
