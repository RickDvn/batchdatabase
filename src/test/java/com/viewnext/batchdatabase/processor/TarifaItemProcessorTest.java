package com.viewnext.batchdatabase.processor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.viewnext.batchdatabase.batch.processor.TarifaItemProcessor;
import com.viewnext.batchdatabase.model.Tarifa;

class TarifaItemProcessorTest {

	private TarifaItemProcessor processor = new TarifaItemProcessor();
	
	@Test
	void process() {
		Tarifa tarifa = new Tarifa(123, "Tarifa1", 99.99F, 21);
		Tarifa tarifaTest;
		
		try {
			tarifaTest = processor.process(tarifa);
			
			assertNotNull(tarifaTest);
			assertEquals(tarifa.getId(), tarifaTest.getId());
			assertEquals(tarifa.getNombreTarifa(), tarifaTest.getNombreTarifa());
			assertEquals(tarifa.getPrecio(), tarifaTest.getPrecio());
			assertEquals(tarifa.getIva(), tarifaTest.getIva());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Exception catched");
		}
		
	}

}
