package com.example.carros;

import com.example.carros.domain.Carro;
import com.example.carros.domain.CarroService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CarrosApplicationTests {
    @Autowired
	private CarroService service;
	@Test
	void teste1() {
		Carro carro = new Carro();
		carro.setNome("Ferrari");
		carro.setTipo("Esportivo");

		service.insert(carro);
	}

	@Test
	void contextLoads() {


	}

}
