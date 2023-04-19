# Pasos a seguir en cuanto a issues y backlogs

¿Y qué es eso del backlog y los marcos de tiempo? Pues bien, el backlog, también
conocido como Product Backlog , es una lista priorizada con todos los requisitos del
proyecto. Estos requisitos se irán desarrollando en determinados momentos concretos
del proyecto (marcos de tiempo).

## Elementos del backlog

### Bug

Aqui se ponen los issues que tengan que ver con código que implementa otros issues pero que no funciona del todo bien.

### Feature

Representa una funcionalidad de la aplicación desde el punto de vista del
negocio. Por ejemplo, si estás trabajando en un proyecto de desarrollo de un blog,
una feature podría ser: “Los artículos deben poderse comentar”.

### User stories

Las User Stories representan una funcionalidad concreta de grano fino
derivada de una Feature, que debe ser desarrollada en el marco de un sprint.
Por ejemplo:

- “El usuario puede guardar un comentario”
- “El admin puede filtrar comentarios con palabrotas”
- “El usuario puede escribir hasta 400 caracteres por comentario”…

### Work item

Elemento de trabajo para representar cualquier otra situación que pueda ocurrir.
Por ejemplo:

- “Hacer la memoria de la práctica”
- “Preparar el entorno para la práctica de JMS”.

# Comandos para ejecutar/testear código 
## Sonar -> comprobar si pasa el quality gate
`mvn verify sonar:sonar -Dsonar.id=NMAT -Dsonar.login=YOUR TOKEN`
 
To check the results you can access to the SonarQube web interface and see whether the project
passes the quality gate. 
> Note that YOUR TOKEN is a token created in the SonarQube web interface (User
icon : My Account : Security : Generate Tokens) and NMAT corresponds to your n´umero de matr´ıcula.


## Java FX commands
`mvn clean javafx:run`