package br.com.zenganet.segurancaoauth2jwt.resource;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.zenganet.segurancaoauth2jwt.model.Cliente;
import br.com.zenganet.segurancaoauth2jwt.repository.ClienteRepository;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/clientes")
public class ClienteRecurso {

	@Autowired
	private ClienteRepository clienteRepository;

	@ApiOperation(value = "Buscar lista de cliente (Autenticado)", response = Cliente.class, responseContainer = "List" )
	@GetMapping
	public ResponseEntity<List<Cliente>> pesquisar() {
		List<Cliente> clientes = clienteRepository.findAll();
		return clientes.size() > 0 ? ResponseEntity.ok(clientes) : ResponseEntity.notFound().build();
	}

}
