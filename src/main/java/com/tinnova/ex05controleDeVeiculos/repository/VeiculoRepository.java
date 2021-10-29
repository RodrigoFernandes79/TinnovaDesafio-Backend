package com.tinnova.ex05controleDeVeiculos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tinnova.ex05controleDeVeiculos.domain.Veiculo;
@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo,Long> {

	@Query(value = "SELECT COUNT(*) AS QUANTIDADE_NÃO_VENDIDA FROM veiculos.veiculo WHERE vendido=false", nativeQuery = true)
	public Integer quantidadeVeiculosNaoVendidos();

	
}
