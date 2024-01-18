package com.example.carros.domain.dto;

import com.example.carros.domain.Carro;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CarroDTO {

    private Long id;

    private String nome;

    private String tipo;

    public CarroDTO(Carro carroOBJ){

        this.id=carroOBJ.getId();
        this.nome=carroOBJ.getNome();
        this.tipo=carroOBJ.getTipo();
    }
}
