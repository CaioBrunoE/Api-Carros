package com.example.carros.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nome")
    private String nome;
    @Column(name = "tipo")
    private String tipo;


}
