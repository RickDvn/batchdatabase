package com.viewnext.batchdatabase.writer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.WritableResource;

import com.viewnext.batchdatabase.batch.writer.TarifaWriter;
import com.viewnext.batchdatabase.model.Tarifa;

class TarifaWriterTest {

	private TarifaWriter writer = new TarifaWriter();

	@Test
	void writerLocal() {
		List<Tarifa> items = new ArrayList<>();
		FlatFileItemWriter<Tarifa> writerTest = writer.writerLocal();
		String[] linesTest = null;
		String[] linesMock = new String[3];
		Tarifa test1 = new Tarifa(1, "Tarifa1", 1.99f, 7);
		Tarifa test2 = new Tarifa(2, "Tarifa2", 2.99f, 4);
		Tarifa test3 = new Tarifa(3, "Tarifa3", 3.99f, 21);

		items.add(test1);
		items.add(test2);
		items.add(test3);

		linesMock[0] = test1.getId() + "," + test1.getNombreTarifa() + "," + test1.getPrecio() + "," + test1.getIva();
		linesMock[1] = test2.getId() + "," + test2.getNombreTarifa() + "," + test2.getPrecio() + "," + test2.getIva();
		linesMock[2] = test3.getId() + "," + test3.getNombreTarifa() + "," + test3.getPrecio() + "," + test3.getIva();

		writerTest.setResource(new PathResource("src/test/java/data/local/testTarifas.csv"));
		try {
			linesTest = writerTest.doWrite(new Chunk<Tarifa>(items)).replace("\r", "").split("\n"); // Quito el caracter de tipado "\r" y separo por el otro "\n"
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception catched");
		}

		assertNotNull(writerTest);
		assertNotNull(linesTest);
		assertEquals(linesMock[0], linesTest[0]);
		assertEquals(linesMock[1], linesTest[1]);
		assertEquals(linesMock[2], linesTest[2]);
	}

}
