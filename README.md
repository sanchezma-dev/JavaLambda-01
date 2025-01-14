
# Example lambda

Sencillo ejemplo de creación de una función lambda con java 17.

Necesario la implementación de la interfaz RequestHandler ya que es una interfaz proporcionada por el SDK de AWS para Lambda. Define un contrato que AWS Lambda puede utilizar para invocar tu función.
La interfaz especifica de la clase JavaLambda debe tener un método handleRequest, que toma dos parámetros: el evento de solicitud (RequestMessage) y el contexto (Context),
y devuelve una respuesta (ResponseMessage).


**Prerrequisitos :** 
- Alta en cuenta AWS service

- En el servicio lambda, crear nueva función. 
Seleccionar: 
- Lenguaje: Java 17
- Arquitectura: arm86

Desde la pestaña código, pulsar en carga desde y seleccionar el .jar que hemos generado en nuestra app (mvn clean package)

Probar con el json adecuado, para este ejemplo este
```
{
    "name": "John Doe",
    "dateTime": "2025-01-14T15:30:00",
    "feeling": "happy"
}
```

**Documentación requerida en :** ``https://docs.aws.amazon.com/lambda/latest/dg/java-package.html#java-package-prereqs``

**Maven:** Dependencia maven mínima
```
<dependency>
    <groupId>com.amazonaws</groupId>
    <artifactId>aws-lambda-java-core</artifactId>
    <version>1.2.2</version>
</dependency>
```

**Build:** Necesario para el package de la aplicación
```
<build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-shade-plugin</artifactId>
                <version>3.5.0</version>
                <configuration>
                    <createDependencyReducedPom>false</createDependencyReducedPom>
                </configuration>
                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>shade</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
```

