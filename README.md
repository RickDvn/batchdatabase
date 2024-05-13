# Batchdatabase
Este batch lee los datos de una base de datos y los escribe en un fichero CSV, para ello utiliza Spring Boot y Spring Batch.
En el fichero escribe con un FlatFileItemWriter

Este proyecto se estructura de la siguiente forma:

reader- El paquete donde se encuentra el TerminalReader, que se encarga de manejar los distintos readers

processor- Paquete que contiene el TarifaProcessor, que se encarga de los distintos processors y TarifaItemProcessor, un processor simple que devuelve el objeto sin modificar

writer- El paquete donde está El TerminalWriter, que se encarga de manejar los distintos writers y TarifaHeaderWriter que escribe la cabecera

listener- Que contiene el JobCompletionNotificationListener el cual hace un log cada vez que un Job termina

config- En donde está el BatchConfig, la calse de configuración de los Jobs del batch
