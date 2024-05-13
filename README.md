# Batchdatabase
Este batch lee los datos de una base de datos y los escribe en un fichero CSV, para ello utiliza Spring Boot y Spring Batch.
En el fichero escribe con un FlatFileItemWriter. Los modelos han sido realizados con Lombok

Este proyecto se estructura de la siguiente forma:

## model: Paquete donde se encuantran los modelos

### Tarifa: El modelo de Tarifa

![image](https://github.com/RickDvn/batchdatabase/assets/168721035/3f0bd0f5-d08a-4c3f-b53b-5d580956418d)


## reader: El paquete donde se encuentran los distintos readers del batch

### TarifaReader: Clase que maneja los readers de Terminales

![image](https://github.com/RickDvn/batchdatabase/assets/168721035/467a8887-e45c-4b38-84c8-f4defc57ecef)


## processor: Paquete que contiene los processors del batch

### TarifaProcessor: Clase que maneja los processors del batch

![image](https://github.com/RickDvn/batchdatabase/assets/168721035/b204cbb9-24d2-407e-960d-430590d738e8)

### TarifaItemProcessor: Procesador de Terminales que devuelve el objeto sin modificar

![image](https://github.com/RickDvn/batchdatabase/assets/168721035/470aa649-26b6-4fa1-9437-00484cd61303)


## writer: El paquete donde están los writers de este batch

### TarifaWriter: Clase que maneja los writers del batch

![image](https://github.com/RickDvn/batchdatabase/assets/168721035/323476cc-bdc6-455e-847b-9bb2c9834d00)


### TarifaHeaderWriter: Clase personalizada de FlatFileHeaderCallback para escribir una cabecera personalizada en los CSV

![image](https://github.com/RickDvn/batchdatabase/assets/168721035/59268bd5-81d8-4268-a1c1-6320a1625614)


## listener: Que contiene los listeners que escuchan los Jobs del batch

### JobCompletionNotificationListener: Listener que realiza un log cada vez que un Job a terminado e informa del resultado

![image](https://github.com/RickDvn/batchdatabase/assets/168721035/8e6479b2-a63c-4ac0-a04e-0f9335e6b841)


## config: En donde está la configuración del batch

### BatchConfig: Clase de configuración del batch

![image](https://github.com/RickDvn/batchdatabase/assets/168721035/6361930b-a110-497e-9128-b267b87b4340)

## Tests

### TarifaWriterTest: Tests de TarifaWriter

![image](https://github.com/RickDvn/batchdatabase/assets/168721035/907131a6-27cd-4b7e-b626-7bc15b848d2c)

### TarifaReaderTest: Tests de TarifaReader

![image](https://github.com/RickDvn/batchdatabase/assets/168721035/10821f03-8562-43d7-8e16-89c78a132101)


### TarifaItemProcessorTest: Tests de TarifaItemProcessor

![image](https://github.com/RickDvn/batchdatabase/assets/168721035/9100d4ea-44bf-47f9-bf42-8c6fe3e772e7)
