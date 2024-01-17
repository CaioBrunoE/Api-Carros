package com.example.carros.api;

import com.example.carros.domain.Carro;
import com.example.carros.domain.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/carros")
public class CarrosController {

    @Autowired
    private CarroService service;

    @GetMapping
    public ResponseEntity<Iterable<Carro>> get(){
        return  ResponseEntity.ok(service.getCarros());
        //return new ResponseEntity<>(service.getCarros(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity getID(@PathVariable("id") Long id){

        Optional<Carro> carro = service.getCarroById(id);

        return  carro
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

      //  return carro.isPresent() ? ResponseEntity.ok(carro.get()): ResponseEntity.notFound().build();

     /*  if (carro.isPresent()){
            return ResponseEntity.ok(carro.get());
        }else {
            return ResponseEntity.notFound().build();
        }*/
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity getTipo(@PathVariable("tipo") String tipo){
       List<Carro> carList = service.getByTipo(tipo);

       return carList.isEmpty() ?
               ResponseEntity.noContent().build():
               ResponseEntity.ok(carList);

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
