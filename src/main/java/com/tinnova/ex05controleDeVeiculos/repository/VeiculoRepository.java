package com.tinnova.ex05controleDeVeiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tinnova.ex05controleDeVeiculos.domain.Veiculo;
@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo,Long> {

}
