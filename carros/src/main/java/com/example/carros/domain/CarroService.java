package com.example.carros.domain;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
   private CarroRepository repository;

    public Iterable<Carro> getCarros(){
      return  repository.findAll();
    }

    public List<Carro> getCarroFake(){
        List<Carro> carros = new ArrayList<>();

        carros.add(new Carro(1L, "Fusca"));
        carros.add(new Carro(2L,"Chevette"));
        carros.add(new Carro(3L,"Brasilia"));

        return carros;
    }

    public Optional<Carro> getCarroById(Long id) {
        return repository.findById(id);

    }

    public Iterable<Carro> getByTipo(String tipo) {
        return repository.getByTipo(tipo);
    }

    public Carro save(Carro carro){
       return repository.save(carro);
    }

    public Carro update(Long id, Carro carro) {
        Optional<Carro> c = repository.findById(id);
         if (c.isPresent()){
             Carro newCarro = c.get();
             newCarro.setNome(carro.getNome());
             newCarro.setTipo(carro.getTipo());
             System.out.println("Carro id :" + newCarro.getId());

             repository.save(newCarro);

             return  newCarro;
    }else {
             throw  new RuntimeException("Não foi possivel atualizar o rsgistro");
         }

    }
}
