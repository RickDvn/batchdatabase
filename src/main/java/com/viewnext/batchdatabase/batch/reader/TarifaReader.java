package com.viewnext.batchdatabase.batch.reader;

import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.viewnext.batchdatabase.batch.repository.TarifaRepository;
import com.viewnext.batchdatabase.model.TarifaPL;

@Configuration
@Component
public class TarifaReader {
	
	@Autowired
	private TarifaRepository tarifaRepository;
	
	@Bean(value = "readerDB")
	public RepositoryItemReader<TarifaPL> reader() {
	    RepositoryItemReader<TarifaPL> reader = new RepositoryItemReader<>();
	    reader.setRepository(tarifaRepository);
	    reader.setMethodName("findAll");
	    
	    return reader;
	  }
	
}
