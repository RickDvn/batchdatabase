package com.viewnext.batchdatabase.batch.reader;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.viewnext.batchdatabase.model.TarifaPL;

/**
 * Clase que se encarga los distintos reader del batch
 */
@Configuration
@Component
public class TarifaReader {
	
	/**
	 * Reader que lee de la base de datos
	 * 
	 * @return RepositoryItemReader<TarifaPL> con las tarifas de la base de datos
	 */
	@Bean(value = "readerDB")
	public JdbcCursorItemReader<TarifaPL> read(DataSource dataSource) {
		JdbcCursorItemReader<TarifaPL> itemReader = new JdbcCursorItemReader<>();
		itemReader.setDataSource(dataSource);
		itemReader.setSql("SELECT id, nombre_tarifa, precio from TARIFAS");
		itemReader.setRowMapper(createRowMapper());
		return itemReader;
	}
	
	private RowMapper<TarifaPL> createRowMapper(){
		return new RowMapper<TarifaPL>() {
			
			@Override
			public TarifaPL mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new TarifaPL(rs.getInt(1), rs.getString(2), rs.getFloat(3));
			}
		};
	}
	
}
