package br.com.zenganet.segurancaoauth2jwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zenganet.segurancaoauth2jwt.model.Apolice;

@Repository
public interface ApoliceRepository extends JpaRepository<Apolice, Long> {

	public List<Apolice> findByClienteId(long clienteId);
	
}
