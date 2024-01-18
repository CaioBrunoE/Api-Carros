package com.example.carros.domain;


import com.example.carros.domain.dto.CarroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarroService {

    @Autowired
   private CarroRepository repository;

    public List<CarroDTO> getCarros(){

        List<Carro> carros = repository.findAll();

   List<CarroDTO> list = carros.stream().map(c-> CarroDTO.createDTO(c)).collect(Collectors.toList());

        return list ;
    }

    public Optional<CarroDTO> getCarroById(Long id) {

        return repository.findById(id).map(CarroDTO::createDTO);

      /*  Optional<Carro> carro = repository.findById(id);

        if (carro.isPresent()){
            return Optional.of(new CarroDTO(carro.get()));
        }else {
            return null;
        }*/


    }

    public List<CarroDTO> getByTipo(String tipo) {

        List<Carro> carros =  repository.getByTipo(tipo);
        List<CarroDTO> list = carros.stream().map(CarroDTO::createDTO).collect(Collectors.toList());

        return list;
    }

    public CarroDTO insert(Carro carro){
        Assert.isNull(carro.getId(),"Não foi possivel inserir o registro");

        return CarroDTO.createDTO(repository.save(carro));
    }

    public CarroDTO update(Long id, Carro carro) {
        Optional<Carro> optional = repository.findById(id);

         if (optional.isPresent()){
             Carro newCarro = optional.get();
             newCarro.setNome(carro.getNome());
             newCarro.setTipo(carro.getTipo());
             System.out.println("Carro id :" + newCarro.getId());

             repository.save(newCarro);

             return  CarroDTO.createDTO(newCarro);

    }else {
             return null ;
            // throw  new RuntimeException("Não foi possivel atualizar o rsgistro");
         }

    }

    public boolean delete(Long id) {
        if (getCarroById(id).isPresent()){
            repository.deleteById(id);
            return true;
        }
        return false;

    }
}
