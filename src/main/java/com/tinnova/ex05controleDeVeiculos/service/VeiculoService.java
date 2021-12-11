package com.tinnova.ex05controleDeVeiculos.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.tinnova.ex05controleDeVeiculos.Dto.VeiculosNaoVendidosDto;
import com.tinnova.ex05controleDeVeiculos.domain.Veiculo;
import com.tinnova.ex05controleDeVeiculos.repository.VeiculoRepository;


@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository repository;

	public Veiculo criarVeiculo(Veiculo veiculo) {
		Veiculo obj = repository.save(veiculo);
		return obj;
	}

	public List<Veiculo> listarVeiculo() {
		List<Veiculo> obj = repository.findAll();
		return obj;
	}

	public Veiculo listarPorId(Long id) {
		Optional<Veiculo> obj = repository.findById(id);
		obj.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id " + id + " não encontrado!"));
		return obj.get();
	}

	public void deletarPorId(Long id){
		repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id " + id + " não encontrado!"));
		repository.deleteById(id);
	}
	
	public Veiculo atualizarDados( Long id,  Veiculo veiculo){
		return repository.findById(id)
			.map(record -> {
			record.setVeiculo(veiculo.getVeiculo());
			record.setMarca(veiculo.getMarca());
			record.setAno(veiculo.getAno());
			record.setDescricao(veiculo.getDescricao());
			record.setVendido(veiculo.isVendido());
			record.setUpdated(veiculo.getUpdated());
			Veiculo obj = repository.save(record);
			return obj;
			
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id " + id + " não encontrado!"));

}


	public VeiculosNaoVendidosDto buscarQuantNaoVendida() {

		Integer quant = repository.quantidadeVeiculosNaoVendidos();
		VeiculosNaoVendidosDto obj = new VeiculosNaoVendidosDto("NÃO_VENDIDO", quant);
		return obj;
	}

	public Veiculo buscarDadosParcial(Long id, Veiculo veiculo) {
		return repository.findById(id).map(record -> {
			record.setVendido(veiculo.isVendido());
			Veiculo obj = repository.save(record);
			return obj;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id " + id + " não encontrado!"));
	}

	}
