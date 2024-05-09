package com.viewnext.batchdatabase.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Modelo de las tarifas en persistencia
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TARIFAS")
public class TarifaPL {
	
	@Id
	private Integer id;
	
	private String nombreTarifa;
	
	private float precio;
	
}
