package com.tinnova.ex05controleDeVeiculos.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tinnova.ex05controleDeVeiculos.Dto.VeiculosNaoVendidosDto;
import com.tinnova.ex05controleDeVeiculos.domain.Veiculo;
import com.tinnova.ex05controleDeVeiculos.service.VeiculoService;

@RestController
@RequestMapping("/veiculos")
public class VeiculoResource {

	@Autowired
	private VeiculoService repository;

	@PostMapping
	public ResponseEntity<Veiculo> criarVeiculo(@RequestBody @Valid Veiculo veiculo) {
		Veiculo obj = repository.criarVeiculo(veiculo);
		return ResponseEntity.status(HttpStatus.CREATED).body(obj);

	}

	@GetMapping
	public ResponseEntity<List<Veiculo>> listarVeiculo() {
		List<Veiculo> obj = repository.listarVeiculo();
		return ResponseEntity.ok().body(obj);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Veiculo> listarPorId(@PathVariable Long id)  {
		Veiculo obj = repository.listarPorId(id);
		return ResponseEntity.ok().body(obj);

	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarPorId(@PathVariable Long id) {
		repository.deletarPorId(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Veiculo> atualizarDados(@PathVariable Long id, @RequestBody @Valid Veiculo veiculo){
			 
		Veiculo obj = repository.atualizarDados(id, veiculo);
		return ResponseEntity.ok().body(obj);

	}

	@GetMapping("/VeiculosNaoVendidos")
	public ResponseEntity<VeiculosNaoVendidosDto> buscarQuantNaoVendida() {
		VeiculosNaoVendidosDto obj = repository.buscarQuantNaoVendida();
		return ResponseEntity.ok().body(obj);

	}

	@PatchMapping("/{id}")
	public ResponseEntity<Veiculo> buscarDadosParcial(@PathVariable Long id, @RequestBody Veiculo veiculo)
			 {
		Veiculo obj = repository.buscarDadosParcial(id, veiculo);
		return ResponseEntity.ok().body(obj);

	}

}
