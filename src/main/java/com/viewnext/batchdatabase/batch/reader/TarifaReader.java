package com.viewnext.batchdatabase.batch.reader;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.viewnext.batchdatabase.batch.repository.TarifaRepository;
import com.viewnext.batchdatabase.model.TarifaPL;

/**
 * Clase que se encarga los distintos reader del batch
 */
@Configuration
@Component
public class TarifaReader {
	
	@Autowired
	private TarifaRepository tarifaRepository;
	
	/**
	 * Reader que lee de la base de datos
	 * 
	 * @return RepositoryItemReader<TarifaPL> con las tarifas de la base de datos
	 */
	@Bean(value = "readerDB")
	public RepositoryItemReader<TarifaPL> reader() {
		Map<String, Direction> sortMap = new HashMap<>();
		sortMap.put("id", Direction.ASC);
		
	    RepositoryItemReader<TarifaPL> reader = new RepositoryItemReader<>();
	    reader.setRepository(tarifaRepository);
	    reader.setMethodName("findAll");
	    reader.setSort(sortMap);
	    
	    return reader;
	  }
	
}
