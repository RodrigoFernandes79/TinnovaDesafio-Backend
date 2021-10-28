package com.tinnova.ex05controleDeVeiculos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tinnova.ex05controleDeVeiculos.domain.Veiculo;
import com.tinnova.ex05controleDeVeiculos.exception.ObjectNotFoundException;
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

	public Veiculo listarPorId(Long id) throws ObjectNotFoundException {
	Optional<Veiculo> obj = repository.findById(id);
		obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
		return obj.get();
	}

	public void deletarPorId(Long id) throws ObjectNotFoundException {
		repository.findById(id).orElseThrow(() ->new ObjectNotFoundException("Id "+id+" não encontrado!"));
		repository.deleteById(id);
	}

	public Veiculo atualizarDados(Long id, Veiculo veiculo) throws ObjectNotFoundException  {
		return repository.findById(id)
				.map(record ->{
				record.setVeiculo(veiculo.getVeiculo());
				record.setMarca(veiculo.getMarca());
				record.setAno(veiculo.getAno());
				record.setDescricao(veiculo.getDescricao());
				record.setVendido(veiculo.isVendido());
				record.setUpdated(veiculo.getUpdated());
				Veiculo obj = repository.save(record);
				return obj;
				}).orElseThrow(() -> new ObjectNotFoundException("Id "+id+" não encontrado!"));
		
	

	}



}
