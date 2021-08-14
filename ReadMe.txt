Es necesario tener instalado Java

Para incializar el programa dirigirse al directorio dist en el se encuentra el archivo mayoristaRevision.jar

Los diagramas uml se encuentran en el directorio UML
Parte H

Responder las siguientes preguntas: Por favor, especifica tu nombre completo: Elian Federico Remaggi

¿C# permite herencia múltiple? C# no permite herencias múltiples.

¿Cuándo utilizaría una Clase Abstracta en lugar de una Interfaz? Ejemplifique. Una Clase Abstracta se utilizara cuando se esté modelando una jerarquía de clases, definiendo tanto metodos como atributos que seran heredados por clases hijas ,mientras que se utilizara una interface cuando lo que se pretende es homogeneizar nombres entre objetos no emparentados, se definiran metodos pero no como se comportaran estos. Ejemplo Clase abstracta: Persona; Clase empleados y clientes como subclases.

¿Qué implica una relación de Generalización entre dos clases? La generalización (o especialización, esto depende del punto de vista) es una relación entre dos clases de modo que la subclase se considera como una forma especializada de la superclase. La superclase se considera como generalización de la subclase y la subclase se considera una especialización de la superclase.

¿Qué implica una relación de Implementación entre una clase y una interfaz? Cuando una clase hereda de otra clase (abstracta o no), estás definiendo qué es, pasar de una idea abstracta a una concreción. Además, estás definiendo una relación entre clases pero cuando implementas una interfaz, estás definiendo cómo se comporta, se definen los encabezados de los metodos pero no su contenido. Es algo como definir y cumplir un contrato

¿Qué diferencia hay entre la relación de Composición y la Agregación? La Agregación es un tipo de asociación que indica que una clase es parte de otra. La destrucción del compuesto no conlleva la destrucción de los componentes. La Composición es una forma fuerte de composición donde la vida de la clase contenida debe coincidir con la vida de la clase contenedor. La destrucción del compuesto conlleva la destrucción del componente.

Indique V o F según corresponda. Diferencia entre Asociación y Agregación:

a. Una diferencia es que la segunda indica la relación entre un “todo” y sus “partes”, mientras que en la primera los objetos están al mismo nivel contextual. V

b. Una diferencia es que la Agregación es de cardinalidad 1 a muchos mientras que la Asociación es de 1 a 1. F

c. Una diferencia es que, en la Agregación, la vida o existencia de los objetos relacionados está fuertemente ligada, es decir que si “muere” el objeto contenedor también morirán las “partes”, en cambio en la Asociación los objetos viven y existen independientemente de la relación. F