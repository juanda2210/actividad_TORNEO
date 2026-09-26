# 🏆 Sistema de Gestión de un Torneo Deportivo

## 👨‍💻 Integrante

- **Juan David Arias Patiño**

---

## 📖 Descripción del proyecto

Este proyecto corresponde al desarrollo de un **Sistema de Gestión de un Torneo Deportivo** realizado en Java mediante una aplicación de consola.

El sistema permite crear y administrar un torneo, registrar equipos y personas, programar partidos, registrar resultados, calcular la tabla de posiciones, buscar jugadores y generar un reporte final del torneo.

El proyecto fue desarrollado aplicando conceptos fundamentales de **Programación Orientada a Objetos**, estructuras de decisión y repetición, colecciones, enumeraciones, manejo de fechas, validaciones y relaciones entre clases.

---

## 🎯 Objetivo

Desarrollar una aplicación funcional por consola capaz de administrar las principales operaciones de un torneo deportivo:

- Crear un torneo.
- Registrar equipos.
- Registrar jugadores y entrenadores.
- Programar partidos.
- Registrar resultados.
- Calcular puntos y diferencia de goles.
- Generar una tabla de posiciones.
- Buscar jugadores por nombre.
- Generar un reporte final.

El sistema utiliza un menú interactivo que permanece activo hasta que el usuario selecciona la opción de salir.

---

## 🛠️ Tecnologías utilizadas

- **Java**
- **Maven**
- **IntelliJ IDEA**
- `Scanner` para entrada de datos por consola.
- `LocalDateTime` para el manejo de fechas.
- `ArrayList` / `List` para el almacenamiento de información.
- Programación Orientada a Objetos.

---

## 📁 Estructura del proyecto

El proyecto se encuentra organizado de la siguiente manera:

```text
actividad_TORNEO/
│
├── .idea/
├── .mvn/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.apex/
│   │   │       ├── models/
│   │   │       │   ├── Entrenador.java
│   │   │       │   ├── Equipo.java
│   │   │       │   ├── EstadoDePartido.java
│   │   │       │   ├── Jugador.java
│   │   │       │   ├── Partido.java
│   │   │       │   ├── Persona.java
│   │   │       │   ├── Posicion.java
│   │   │       │   └── Torneo.java
│   │   │       │
│   │   │       ├── util/
│   │   │       │   └── ScannerUtils.java
│   │   │       │
│   │   │       └── Main.java
│   │   │
│   │   └── resources/
│   │
│   └── test/
│
├── target/
├── .gitignore
└── pom.xml
```

---

# 🧩 Descripción de las clases

## `Main`

Es la clase principal del programa y contiene el método `main()`.

Desde esta clase se crea el torneo y se controla el menú principal mediante un ciclo `while` y una estructura `switch`.

Las opciones disponibles son:

1. Registrar un equipo.
2. Registrar un jugador o entrenador.
3. Programar un partido.
4. Registrar el resultado de un partido.
5. Mostrar la tabla de posiciones.
6. Buscar un jugador por nombre.
7. Generar el reporte final.
8. Salir.

---

## `Persona`

Es una clase abstracta que funciona como clase base para las personas relacionadas con el torneo.

Contiene los atributos:

- `nombre`
- `documento`
- `edad`

Las clases `Jugador` y `Entrenador` heredan de ella.

También define el método abstracto:

```java
public abstract void mostrarCarnet();
```

Esto permite aplicar **herencia y polimorfismo**.

---

## `Jugador`

Hereda de `Persona`.

Además de los atributos heredados, contiene:

- `Posicion posicion`
- `int dorsal`

Permite mostrar la información específica de un jugador mediante la sobrescritura de:

```java
@Override
public void mostrarCarnet();
```

---

## `Entrenador`

Hereda de `Persona`.

Contiene información adicional sobre los años de experiencia:

```java
private String aniosExp;
```

También sobrescribe el método `mostrarCarnet()` para mostrar información específica del entrenador.

---

## `Equipo`

Representa a los equipos participantes del torneo.

Contiene información relacionada con:

- Nombre.
- Puntos.
- Goles a favor.
- Goles en contra.
- Diferencia de goles.

También contiene métodos para:

- Registrar victorias.
- Registrar empates.
- Actualizar goles.
- Calcular diferencia de goles.
- Verificar si un nombre de equipo ya está registrado.

La validación del nombre utiliza:

```java
equalsIgnoreCase();
```

para evitar registrar equipos con el mismo nombre ignorando diferencias entre mayúsculas y minúsculas.

---

## `Partido`

Representa un encuentro entre dos equipos.

Contiene:

- Equipo local.
- Equipo visitante.
- Marcador local.
- Marcador visitante.
- Fecha.
- Estado del partido.

El partido comienza con el estado:

```java
// EstadoDePartido.AGENDADO
```

y posteriormente puede pasar a:

```java
// EstadoDePartido.JUGADO
```

También se valida que un equipo no pueda enfrentarse contra sí mismo.

---

## `Torneo`

Es la clase encargada de administrar la información general del torneo.

Contiene diferentes colecciones:

```java
private List<Equipo> equipos;
private List<Partido> partidos;
private List<Persona> personas;
private List<Equipo> posiciones;
```

Estas listas permiten almacenar los equipos, partidos, personas y la tabla de posiciones.

Entre sus principales responsabilidades se encuentran:

- Registrar equipos.
- Buscar equipos.
- Registrar personas.
- Buscar personas.
- Registrar partidos.
- Buscar partidos.
- Obtener partidos jugados.
- Obtener partidos agendados.
- Generar la tabla de posiciones.
- Mostrar la tabla de posiciones.
- Obtener el equipo campeón.
- Generar el reporte final.

---

## `EstadoDePartido`

Es una enumeración que permite controlar el estado de cada partido.

```java
public enum EstadoDePartido {
    AGENDADO,
    JUGADO
}
```

---

## `Posicion`

Es una enumeración utilizada para representar la posición de un jugador.

Actualmente contiene:

```java
//DEFENSA,
//MEDIOCAMPISTA,
//DELANTERO
```

---

## `ScannerUtils`

Es una clase utilitaria encargada de centralizar la captura y validación de información ingresada por consola.

Entre sus métodos se encuentran:

- `capturarTexto()`
- `capturarNumero()`
- `capturarDecimal()`
- `capturarFecha()`
- `capturarEquipo()`
- `capturarPosicion()`
- `capturarGoles()`

Esto permite mantener la clase `Main` más organizada y separar la lógica de captura de datos.

---

# 🔄 Funcionamiento del sistema

## 1. Creación del torneo

Al iniciar el programa, se solicita al usuario el nombre del torneo.

```text
Nombre del torneo:
```

Después de ingresar el nombre, se crea una instancia de `Torneo`.

---

## 2. Registro de equipos

El usuario puede registrar equipos mediante la opción:

```text
1. Registrar un equipo
```

El sistema valida que el nombre no esté vacío y verifica que no exista otro equipo registrado con el mismo nombre.

---

## 3. Registro de jugadores y entrenadores

La opción:

```text
2. Registrar un jugador o entrenador
```

permite seleccionar entre:

```text
1. Jugador
2. Entrenador
```

Para los jugadores se solicita:

- Nombre.
- Documento.
- Edad.
- Posición.
- Número dorsal.

Para los entrenadores se solicita:

- Nombre.
- Documento.
- Edad.
- Años de experiencia.

---

## 4. Programación de partidos

La opción:

```text
3. Programar un partido
```

muestra los equipos registrados y permite seleccionar un equipo local y uno visitante.

El sistema evita que se programe un partido entre el mismo equipo.

Cada partido recibe automáticamente una fecha mediante:

```java
//LocalDateTime.now()
```

---

## 5. Registro de resultados

La opción:

```text
4. Registrar el resultado de un partido
```

permite seleccionar un partido previamente agendado y registrar los goles de ambos equipos.

Los goles son validados para evitar valores negativos.

Una vez registrado el resultado:

- El partido cambia a estado `JUGADO`.
- Se calculan los puntos.
- Se actualizan los goles a favor.
- Se actualizan los goles en contra.
- Se calcula la diferencia de goles.
- Se actualiza la tabla de posiciones.

---

# 📊 Sistema de puntuación

El sistema utiliza la siguiente lógica:

### Victoria

El equipo ganador recibe:

```text
3 puntos
```

### Empate

Cada equipo recibe:

```text
1 punto
```

### Derrota

El equipo perdedor recibe:

```text
0 puntos
```

La lógica se encuentra implementada en el método:

```java
definirPuntos();
```

de la clase `Partido`.

---

# 🏆 Tabla de posiciones

La tabla de posiciones se genera utilizando los puntos obtenidos por cada equipo.

En caso de empate en puntos, el sistema utiliza como criterios adicionales:

1. Diferencia de goles.
2. Goles a favor.

El ordenamiento se realiza mediante `Comparator`.

La tabla muestra:

```text
# ---- EQUIPO ---- PUNTOS -- GF -- GC -- DG
```

Donde:

- **PUNTOS:** puntos obtenidos.
- **GF:** goles a favor.
- **GC:** goles en contra.
- **DG:** diferencia de goles.

---

# 🔎 Búsqueda de jugadores

La opción:

```text
6. Buscar un jugador por nombre
```

permite ingresar el nombre de una persona.

La búsqueda utiliza:

```java
equalsIgnoreCase();
```

por lo que no depende de que el usuario escriba el nombre utilizando exactamente las mismas mayúsculas o minúsculas.

Después de encontrar la persona, el sistema verifica que corresponda a un objeto `Jugador` mediante:

```java
//persona instanceof Jugador
```

y muestra su información.

---

# 📄 Reporte final

La opción:

```text
7. Generar reporte final del torneo
```

muestra:

- Nombre del torneo.
- Equipo campeón.
- Equipos participantes.
- Tabla de posiciones.
- Partidos jugados.
- Resultado de los partidos.

El campeón se obtiene tomando el primer equipo de la lista ordenada de posiciones.

---

# 🧠 Conceptos de programación aplicados

Durante el desarrollo se utilizaron diferentes conceptos vistos durante el curso.

## Estructuras de decisión

Se utiliza `switch` para controlar las diferentes opciones del menú:

```java
//switch (opcion) {
    // opciones del menú
//}
```

También se utilizan estructuras `if`, `else if` y `else` para diferentes validaciones y para determinar el resultado de los partidos.

---

## Estructuras repetitivas

El menú principal utiliza un ciclo:

```java
// while (true)
```

que mantiene el programa funcionando hasta que el usuario selecciona la opción de salir.

También se utilizan ciclos `while` para validar datos ingresados por el usuario y `for` / `forEach` para recorrer colecciones.

---

## `continue`

El programa utiliza `continue` para regresar al inicio del ciclo cuando se detecta que un equipo ya se encuentra registrado.

Ejemplo:

```java
/*
if (Equipo.verificarNombre(nombre, torneo) != null) {
    System.err.println("Ese equipo ya está registrado. Intenta con otro nombre.");
    continue;
}*/

```

---

## Conversión y validación de datos

`ScannerUtils` permite recibir datos numéricos utilizando `Scanner`.

Por ejemplo:

```java
/*
while (!SCANNER.hasNextInt()) {
    System.out.println("Dato no aceptado");
    SCANNER.next();
}*/

```

También se validan fechas mediante `LocalDateTime.parse()`.

---

## Colecciones

El proyecto utiliza `List` y `ArrayList` para administrar diferentes tipos de información:

```java
/*
List<Equipo>
List<Partido>
List<Persona>*/

```

Esto permite almacenar dinámicamente los elementos registrados durante la ejecución.

---

# 🧬 Herencia y polimorfismo

La clase:

```text
Persona
├── Jugador
└── Entrenador
```

es abstracta y funciona como clase padre de `Jugador` y `Entrenador`.

Tanto `Jugador` como `Entrenador` sobrescriben:

```java
mostrarCarnet();
```

Esto permite utilizar polimorfismo al trabajar con referencias de tipo `Persona`.

Por ejemplo:

```java
Persona persona = new Jugador();
```

o:

```java
Persona persona = new Entrenador();
```

---

# 🔗 Relaciones entre clases

## Torneo → Equipo

El `Torneo` mantiene una colección de equipos:

```java
private List<Equipo> equipos;
```

Los equipos son registrados mediante:

```java
nuevoEquipo(Equipo equipo);
```

La relación permite que un torneo administre múltiples equipos.

---

## Torneo → Partido

El torneo mantiene una colección de partidos:

```java
private List<Partido> partidos;
```

Los partidos se agregan mediante:

```java
nuevoPartido(Partido partido);
```

Esto permite que el torneo administre los encuentros programados.

---

## Partido → Equipo

Cada `Partido` contiene dos referencias a objetos `Equipo`:

```java
private Equipo local;
private Equipo visitante;
```

Por lo tanto, cada partido relaciona directamente dos equipos participantes.

---

## Jugador → Posición

Cada jugador contiene una posición:

```java
private Posicion posicion;
```

La posición se representa mediante el enum `Posicion` con los valores:

```text
DEFENSA
MEDIOCAMPISTA
DELANTERO
```

---

## Torneo → Persona

El torneo administra las personas registradas mediante:

```java
private List<Persona> personas;
```

Esta colección permite almacenar tanto jugadores como entrenadores gracias a la herencia.

---

# 📐 Diagrama de clases

## Anexo del diagrama de clases

> **Insertar aquí la imagen del diagrama de clases.**

```text
[ANEXO: DIAGRAMA DE CLASES]
```

---

# 📸 Anexo de evidencia

A continuación se presentan los espacios destinados para agregar las capturas de pantalla correspondientes al funcionamiento del programa.

## 1. Menú principal

> **Anexo de evidencia: menú principal funcionando**

```text
[INSERTAR CAPTURA AQUÍ]
```

---

## 2. Registro exitoso

> **Anexo de evidencia: registro exitoso de un equipo, jugador o entrenador**

```text
[INSERTAR CAPTURA AQUÍ]
```

---

## 3. Programación de un partido

> **Anexo de evidencia: partido programado correctamente**

```text
[INSERTAR CAPTURA AQUÍ]
```

---

## 4. Registro de resultado

> **Anexo de evidencia: resultado de un partido registrado correctamente**

```text
[INSERTAR CAPTURA AQUÍ]
```

---

## 5. Tabla de posiciones

> **Anexo de evidencia: tabla de posiciones calculada**

```text
[INSERTAR CAPTURA AQUÍ]
```

---

## 6. Búsqueda de jugador

> **Anexo de evidencia: búsqueda de jugador por nombre**

```text
[INSERTAR CAPTURA AQUÍ]
```

---

## 7. Validación de datos inválidos

> **Anexo de evidencia: sistema rechazando un dato inválido**

Algunos ejemplos de validaciones que pueden evidenciarse:

- Nombre de equipo vacío.
- Equipo repetido.
- Goles negativos.
- Fecha con formato incorrecto.
- Tipo de dato numérico incorrecto.
- Partido entre el mismo equipo.

```text
[INSERTAR CAPTURA AQUÍ]
```

---

# ▶️ Instrucciones para ejecutar

## Requisitos

Para ejecutar el proyecto se requiere:

- Java JDK instalado.
- Maven.
- Un IDE compatible con proyectos Maven, como IntelliJ IDEA.

## Ejecución desde IntelliJ IDEA

1. Abrir el proyecto en IntelliJ IDEA.
2. Esperar a que Maven cargue las dependencias del proyecto.
3. Ubicar la clase:

```text
src/main/java/com/apex/Main.java
```

4. Ejecutar el método:

```java
public static void main(String[] args);
```

5. Seguir las instrucciones mostradas en la consola.

---

## Ejecución mediante Maven

Desde la carpeta raíz del proyecto se puede compilar utilizando:

```bash
mvn clean compile
```

Posteriormente, la clase principal puede ejecutarse desde el IDE o mediante la configuración de ejecución correspondiente al proyecto Maven.

---

# 📌 Flujo general de uso

Una ejecución típica del sistema puede seguir este flujo:

```text
Crear torneo
     ↓
Registrar equipos
     ↓
Registrar jugadores / entrenadores
     ↓
Programar partido
     ↓
Registrar resultado
     ↓
Actualizar puntos y goles
     ↓
Mostrar tabla de posiciones
     ↓
Buscar jugadores
     ↓
Generar reporte final
```

---

# 📝 Consideraciones del desarrollo

El proyecto fue desarrollado de manera individual por **Juan David Arias Patiño**.

La estructura del código se separó en diferentes clases y paquetes con el objetivo de mantener una organización clara entre:

- Modelos del dominio.
- Utilidades de entrada de datos.
- Clase principal de ejecución.

El manejo de la información se realiza principalmente en memoria mediante colecciones `ArrayList`, por lo que los datos registrados existen durante la ejecución del programa.

---

# 👨‍💻 Autor

**Juan David Arias Patiño**

Proyecto académico desarrollado en Java.

🏆⚽
