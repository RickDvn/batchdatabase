package com.viewnext.batchdatabase.batch.writer;

import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.PathResource;
import org.springframework.stereotype.Component;

import com.viewnext.batchdatabase.model.TarifaPL;

/**
 * Clase que guarda los distintos writers para este batch
 */
@Configuration
@Component
public class TarifaWriter {
	
	/**
	 * El writer para escribir en el csv
	 * 
	 * @return El writer que escribirá en el csv
	 */
	@Bean(value = "writerLocal")
	public FlatFileItemWriter<TarifaPL> writerLocal() {
		return new FlatFileItemWriterBuilder<TarifaPL>().name("productoItemWriter")
				.resource(new PathResource("src/main/resources/data/local/stockTerminales.csv")).delimited().delimiter(",")
				.names("id", "nombreTarifa", "precio")
				.headerCallback(new TarifaHeaderWriter("id,nombreTarifa,precio"))
				.build();
	}
}
