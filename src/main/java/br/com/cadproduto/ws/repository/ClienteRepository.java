package br.com.cadproduto.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cadproduto.ws.model.Produto;
@Repository
@Transactional
public interface ClienteRepository extends JpaRepository<Produto, Integer>{
	
}

