package com.viewnext.batchdatabase.reader;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.test.ExecutionContextTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.viewnext.batchdatabase.batch.reader.TarifaReader;
import com.viewnext.batchdatabase.model.TarifaPL;

class TarifaReaderTest {

	private TarifaReader reader = new TarifaReader();

	private MysqlDataSource dataSource;
	
	@Test
	void testReader() {
		TarifaPL tarifa1 = new TarifaPL(11111,"Básico",9.99F);
		TarifaPL tarifaTest;
		List<TarifaPL> tarifasTest = new ArrayList<TarifaPL>();
		JdbcCursorItemReader<TarifaPL> readerTest;
		
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
	}

}
