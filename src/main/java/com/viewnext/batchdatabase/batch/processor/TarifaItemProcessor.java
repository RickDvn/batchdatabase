package com.viewnext.batchdatabase.batch.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.viewnext.batchdatabase.model.Tarifa;

/**
 * Processor que devuelve el objeto TarifaPL sin ningun tipo de modificacion ni Skip Policy
 */
public class TarifaItemProcessor implements ItemProcessor<Tarifa, Tarifa>{

	private static final Logger log = LoggerFactory.getLogger(TarifaItemProcessor.class);
	
	@Override
	public Tarifa process(Tarifa item) throws Exception {
		log.info("Processing item...");
		
		return item;
	}

}
