package com.example.carros.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarroRepository extends CrudRepository<Carro, Long> {


    List<Carro> getByTipo(String tipo);
}



