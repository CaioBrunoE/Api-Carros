package com.example.carros.api;

import com.example.carros.domain.Carro;
import com.example.carros.domain.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/carros")
public class CarrosController {

    @Autowired
    private CarroService service;

    @GetMapping
    public Iterable<Carro> get(){
        return service.getCarros();
    }
    @GetMapping("/{id}")
    public Optional<Carro> getID(@PathVariable("id") Long id){
      return service.getCarroById(id);
    }

    @GetMapping("/tipo/{tipo}")
    public Iterable<Carro> getTipo(@PathVariable("tipo") String tipo){
        return  service.getByTipo(tipo);
    }
    @PostMapping
    public String  postCarro(@RequestBody Carro carro){

     Carro c =  service.save(carro);

      return "Carro salvo comsucesso " + c.getId();
    }

    @PutMapping("/{id}")
    public  String putCarro(@PathVariable("id") Long id , @RequestBody Carro carro){
        Carro c = service.update(id, carro);

        return "Carro atualizado com sucesso " + c.getNome();
    }

    @DeleteMapping("/{id}")
    public String deleteCarro(@PathVariable("id") Long id){
        service.delete(id);

        return "Carro deletado com sucesso" ;
    }

}
