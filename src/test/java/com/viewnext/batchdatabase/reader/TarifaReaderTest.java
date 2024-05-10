package com.viewnext.batchdatabase.reader;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.test.ExecutionContextTestUtils;

import com.viewnext.batchdatabase.batch.reader.TarifaReader;
import com.viewnext.batchdatabase.model.TarifaPL;

class TarifaReaderTest {

	private TarifaReader reader = new TarifaReader();
	
	@Test
	void testReader() {
		TarifaPL tarifa1 = new TarifaPL(11111,"Básico",9.99F);
		TarifaPL tarifaTest;
		List<TarifaPL> tarifasTest = new ArrayList<TarifaPL>();
		
		
	}

}
