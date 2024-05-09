package com.viewnext.batchdatabase.batch.writer;

import java.io.IOException;
import java.io.Writer;

import org.springframework.batch.item.file.FlatFileHeaderCallback;

/**
 * Clase que se encarga de escribir la cabecera de los CSV segun se especifique
 */
public class TarifaHeaderWriter implements FlatFileHeaderCallback {

	private final String header;

	TarifaHeaderWriter(String header) {
        this.header = header;
    }

	@Override
    public void writeHeader(Writer writer) throws IOException {
        writer.write(header);
    }
}