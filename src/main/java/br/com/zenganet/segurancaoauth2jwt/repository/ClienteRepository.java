package br.com.zenganet.segurancaoauth2jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zenganet.segurancaoauth2jwt.model.Cliente;

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Long>{

}
