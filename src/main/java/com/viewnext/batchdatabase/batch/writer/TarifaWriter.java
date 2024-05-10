package com.viewnext.batchdatabase.batch.writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.PathResource;
import org.springframework.stereotype.Component;

import com.viewnext.batchdatabase.model.Tarifa;

/**
 * Clase que guarda los distintos writers para este batch
 */
@Configuration
@Component
public class TarifaWriter {
	
	private static final Logger log = LoggerFactory.getLogger(TarifaWriter.class);
	
	/**
	 * El writer para escribir en el csv
	 * 
	 * @return El writer que escribirá en el csv
	 */
	@Bean(value = "writerLocal")
	public FlatFileItemWriter<Tarifa> writerLocal() {
		log.info("Escribiendo items...");
		
		return new FlatFileItemWriterBuilder<Tarifa>().name("tarifaItemWriter")
				.resource(new PathResource("src/main/resources/data/local/tarifaTerminales.csv")).delimited().delimiter(",")
				.names("id", "nombreTarifa", "precio")
				.headerCallback(new TarifaHeaderWriter("id,nombreTarifa,precio"))
				.build();
	}
}
