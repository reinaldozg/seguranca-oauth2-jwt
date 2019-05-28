package br.com.zenganet.segurancaoauth2jwt.resource;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.zenganet.segurancaoauth2jwt.model.Apolice;
import br.com.zenganet.segurancaoauth2jwt.repository.ApoliceRepository;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/apolices")
public class ApoliceRecurso {
	
	@Autowired
	private ApoliceRepository apoliceRepository;

	@ApiOperation(value = "Buscar lista de apolices (Autenticado)", response = Apolice.class, responseContainer = "List" )
	@GetMapping
	public ResponseEntity<List<Apolice>> pesquisar() {
		List<Apolice> apolices = apoliceRepository.findAll();
		return apolices.size() > 0 ? ResponseEntity.ok(apolices) : ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "Buscar lista de apolices por cliente (Autenticado)", response = Apolice.class, responseContainer = "List" )
	@GetMapping("/{cliente}")
	public ResponseEntity<List<Apolice>> pesquisar(@PathVariable("cliente") long cliente) {
		List<Apolice> apolices = apoliceRepository.findByClienteId(cliente);
		return apolices.size() > 0 ? ResponseEntity.ok(apolices) : ResponseEntity.notFound().build();
	}
	
}
