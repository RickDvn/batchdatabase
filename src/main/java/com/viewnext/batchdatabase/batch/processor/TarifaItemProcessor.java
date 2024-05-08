package com.viewnext.batchdatabase.batch.processor;

import org.springframework.batch.item.ItemProcessor;

import com.viewnext.batchdatabase.model.TarifaPL;

public class TarifaItemProcessor implements ItemProcessor<TarifaPL, TarifaPL>{

	@Override
	public TarifaPL process(TarifaPL item) throws Exception {
		return item;
	}

}
