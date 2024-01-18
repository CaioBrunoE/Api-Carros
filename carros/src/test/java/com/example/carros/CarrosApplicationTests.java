package com.example.carros;

import com.example.carros.domain.Carro;
import com.example.carros.domain.CarroService;
import com.example.carros.domain.dto.CarroDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarrosApplicationTests {
    @Autowired
	private CarroService service;
	@Test
	void testSave() {
		Carro carro = new Carro();
		carro.setNome("Ferrari");
		carro.setTipo("esportivo");

		CarroDTO c = service.insert(carro);

		assertNotNull(c);

		Long id = c.getId();

		assertNotNull(id);

		//Buscar o objeto
		Optional<CarroDTO> op = service.getCarroById(id);
		assertTrue(op.isPresent());

		c = op.get();
		assertEquals("Ferrari", c.getNome());
		assertEquals("esportivo", c. getTipo());


       //Deletar objeto
		service.delete(id);

		//Verificar se foi deletado
		assertFalse(service.getCarroById(id).isPresent());

	}

	@Test
	void testLista() {
		List<CarroDTO> carros = service.getCarros();

		assertEquals(30, carros.size());

	}

	@Test
	void testGet() {
		Optional<CarroDTO> op = service.getCarroById(11L);

		assertTrue(op.isPresent());

		CarroDTO c = op.get();

		assertEquals("Ferrari FF", c.getNome());
	}

}
