package com.tinnova.ex05controleDeVeiculos.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tinnova.ex05controleDeVeiculos.domain.Veiculo;
import com.tinnova.ex05controleDeVeiculos.exception.ObjectNotFoundException;
import com.tinnova.ex05controleDeVeiculos.service.VeiculoService;

@RestController
@RequestMapping("/veiculos")
public class VeiculoResource {

	@Autowired
	private VeiculoService repository;

	@PostMapping
	public ResponseEntity<Veiculo> criarVeiculo(@RequestBody Veiculo veiculo) {
		Veiculo obj = repository.criarVeiculo(veiculo);
		return ResponseEntity.status(HttpStatus.CREATED).body(obj);

	}

	@GetMapping
	public ResponseEntity<List<Veiculo>> listarVeiculo() {
		List<Veiculo> obj = repository.listarVeiculo();
		return ResponseEntity.ok().body(obj);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Veiculo> listarPorId(@PathVariable Long id) throws ObjectNotFoundException {
		Veiculo obj = repository.listarPorId(id);
		return ResponseEntity.ok().body(obj);

	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarPorId(@PathVariable Long id) throws ObjectNotFoundException {
		repository.deletarPorId(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Veiculo> atualizarDados(@PathVariable Long id, @RequestBody Veiculo veiculo)
			throws ObjectNotFoundException {
		Veiculo obj = repository.atualizarDados(id, veiculo);
		return ResponseEntity.ok().body(obj);

	}

}
