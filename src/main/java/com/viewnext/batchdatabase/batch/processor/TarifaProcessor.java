package com.viewnext.batchdatabase.batch.processor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Clase que se encarga de los distintos processor del batch
 */
@Configuration
@Component
public class TarifaProcessor {

	/**
	 * El processor sin ningun tipo do Skip Policy ni modificacion
	 * 
	 * @return TarifaItemProcessor
	 */
	@Bean(value = "processorNoSP")
	TarifaItemProcessor itemProcessor() {
		return new TarifaItemProcessor();
	}
	
}
