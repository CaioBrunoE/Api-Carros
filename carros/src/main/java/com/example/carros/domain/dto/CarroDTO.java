package com.example.carros.domain.dto;

import com.example.carros.domain.Carro;

import lombok.*;
import org.modelmapper.ModelMapper;

@Data
public class CarroDTO {

    private Long id;

    private String nome;

    private String tipo;

   /* public CarroDTO(Carro carroOBJ){

        this.id=carroOBJ.getId();
        this.nome=carroOBJ.getNome();
        this.tipo=carroOBJ.getTipo();
    }*/

    public  static CarroDTO createDTO(Carro carro){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(carro,CarroDTO.class);

    }
}
