# Batchdatabase
Este batch lee los datos de una base de datos y los escribe en un fichero CSV, para ello utiliza Spring Boot y Spring Batch.
En el fichero escribe con un FlatFileItemWriter. Los modelos han sido realizados con Lombok

Este proyecto se estructura de la siguiente forma:

## model: Paquete donde se encuantran los modelos

### Tarifa: El modelo de Tarifa

![image](https://github.com/RickDvn/batchdatabase/assets/168721035/6b8a2ffc-9188-47d8-8764-c3a33241ac74)

En este modelo se guardan todos los datos de las tarifas

## reader: El paquete donde se encuentran los distintos readers del batch

### TarifaReader: Clase que maneja los readers de Terminales

![image](https://github.com/RickDvn/batchdatabase/assets/168721035/0c7aa9e2-84a5-4a8d-b118-bbbb711c44bc)

Aquí es donde se encuantran todos los readers del modelo **Tarifa**:

##### read

Es el Bean que se encarga de leer de la base de datos, utiliza el Datasource por defecto con las propiedades definidas en el aplication.properties. 
Tiene una consulta puesta, la cual es traerse el id, nombre_tarifa, precio e iva de la tabla TARIFAS

##### createRowMapper

Es un método privado que crea el **RowMapper** pare el JdbcCursorItemReader, creando un objeto Tarifa con los datos del **ResultSet** y devolviendolo

## processor: Paquete que contiene los processors del batch

### TarifaProcessor: Clase que maneja los processors del batch

![image](https://github.com/RickDvn/batchdatabase/assets/168721035/b204cbb9-24d2-407e-960d-430590d738e8)

Clase que contiene los distintos processsors del modelo **Tarifa**

##### itemProcessor

Este Bean lo que hace es devolver un nuevo **TarifaItemProcessor**

### TarifaItemProcessor: Procesador de Terminales que devuelve el objeto sin modificar

![image](https://github.com/RickDvn/batchdatabase/assets/168721035/470aa649-26b6-4fa1-9437-00484cd61303)

Este es un precessor del modelo **Tarifa**

##### process

El método de procesado en este procesador solo devuelve el mismo objeto que le ha llegado, sin ningún tipo de modificación ni Skip Policy

## writer: El paquete donde están los writers de este batch

### TarifaWriter: Clase que maneja los writers del batch

![image](https://github.com/RickDvn/batchdatabase/assets/168721035/323476cc-bdc6-455e-847b-9bb2c9834d00)

Aquí están todos los writers del modelo **Tarifa**

##### writerLocal

Bean que crea y devuelve un nuevo **FlatFileItemWriter<Tarifa>**, se le ponen: el recurso node tiene que escribir, el delimitador, los nombres de las columnas 
y el header del CSV

### TarifaHeaderWriter: Clase personalizada de FlatFileHeaderCallback para escribir una cabecera personalizada en los CSV

![image](https://github.com/RickDvn/batchdatabase/assets/168721035/59268bd5-81d8-4268-a1c1-6320a1625614)

Clase que implementa el **FlatFileHeaderCallback** y sobreescribe el método writeHeader para escribir una cabecera propia

## listener: Que contiene los listeners que escuchan los Jobs del batch

### JobCompletionNotificationListener: Listener que realiza un log cada vez que un Job a terminado e informa del resultado

![image](https://github.com/RickDvn/batchdatabase/assets/168721035/8e6479b2-a63c-4ac0-a04e-0f9335e6b841)

Clase que se encarga de logear si el Job se ha completado o no exitosamente

## config: En donde está la configuración del batch

### BatchConfig: Clase de configuración del batch

![image](https://github.com/RickDvn/batchdatabase/assets/168721035/6361930b-a110-497e-9128-b267b87b4340)

Clase en la que se encuentra la configuración del Batch, definiendo el tanto el Job como sus Step

##### importUserJob

Este Bean define el comportamiento del Job y le asigna el listener y los steps

##### step1

Este Bean define el primer step, asignándole su chunk, reader, writer y procesor

## Tests

### TarifaWriterTest: Tests de TarifaWriter

![image](https://github.com/RickDvn/batchdatabase/assets/168721035/907131a6-27cd-4b7e-b626-7bc15b848d2c)

### TarifaReaderTest: Tests de TarifaReader

![image](https://github.com/RickDvn/batchdatabase/assets/168721035/10821f03-8562-43d7-8e16-89c78a132101)


### TarifaItemProcessorTest: Tests de TarifaItemProcessor

![image](https://github.com/RickDvn/batchdatabase/assets/168721035/9100d4ea-44bf-47f9-bf42-8c6fe3e772e7)
