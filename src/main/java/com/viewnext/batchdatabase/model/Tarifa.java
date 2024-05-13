package com.viewnext.batchdatabase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Modelo de las tarifas en persistencia
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarifa {
	
	private Integer id;
	
	private String nombreTarifa;
	
	private float precio;
	
	private Integer iva;
	
}
