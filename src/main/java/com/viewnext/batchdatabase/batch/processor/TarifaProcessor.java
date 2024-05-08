package com.viewnext.batchdatabase.batch.processor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class TarifaProcessor {

	@Bean(value = "processorNoSP")
	TarifaItemProcessor itemProcessor() {
		return new TarifaItemProcessor();
	}
	
}
