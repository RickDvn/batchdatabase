package com.viewnext.batchdatabase.reader;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.database.JdbcCursorItemReader;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.viewnext.batchdatabase.batch.reader.TarifaReader;
import com.viewnext.batchdatabase.model.Tarifa;

class TarifaReaderTest {

	private TarifaReader reader = new TarifaReader();

	private MysqlDataSource dataSource;
	
	@Test
	void testReader() {
		Tarifa tarifa1 = new Tarifa(11111,"Básico",9.99F, 21);
		Tarifa tarifaTest;
		List<Tarifa> tarifasTest = new ArrayList<Tarifa>();
		JdbcCursorItemReader<Tarifa> readerTest;
		
		dataSource = new MysqlDataSource();
		dataSource.setUser("root");
		dataSource.setUrl("jdbc:mysql://localhost:3306/tarifasdb");
		
		readerTest = reader.read(dataSource);
		
		try {
			readerTest.open(new ExecutionContext());
			tarifaTest = readerTest.read();
			
			while (tarifaTest != null) {
				tarifasTest.add(tarifaTest);
				tarifaTest = readerTest.read();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Se ha lanzado una excepcion");
		}
		
		assertFalse(tarifasTest.isEmpty());
		assertEquals(tarifa1.getId(), tarifasTest.get(0).getId());
		assertEquals(tarifa1.getNombreTarifa(), tarifasTest.get(0).getNombreTarifa());
		assertEquals(tarifa1.getPrecio(), tarifasTest.get(0).getPrecio());
		assertEquals(tarifa1.getIva(), tarifasTest.get(0).getIva());
	}

}
