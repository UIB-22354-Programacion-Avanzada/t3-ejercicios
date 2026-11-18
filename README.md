# t3-ejercicios — Tema 3: Programación Concurrente

Esqueleto de los ejercicios del Tema 3 de *Programación Avanzada (22354)*, Grado en Ingeniería
Telemática, UIB-EPS. Los enunciados están en la
[página de ejercicios del tema](https://uib-22354-programacion-avanzada.github.io/website/es/ejercicios/tema3.html);
aquí tienes el código sobre el que trabajar.

Es un proyecto **Maven** para **Java 25** con pruebas en **JUnit 5**, preparado para **GitHub
Codespaces**. El esqueleto **compila desde el primer momento**, pero las pruebas fallan: tu trabajo
consiste en ponerlas en verde.

## Cómo empezar

Sea cual sea la vía, lo primero es lo mismo: pulsa **Use this template** → **Create a new
repository** y créalo en **tu cuenta personal**. A partir de ahí tienes dos caminos, y **los dos
valen igual**: es un proyecto Maven corriente.

**En el navegador, con Codespaces.** No hay nada que instalar. En tu copia, **Code** →
**Codespaces** → **Create codespace on main**. Se abre VS Code con el JDK 25 y Maven ya puestos. En
el terminal:

```bash
java -version    # debe empezar por: openjdk version "25
mvn test         # verás fallos: es lo esperado al empezar
```

> **Recuerda detener el Codespace** cuando termines (**Code → Codespaces → ⋯ → Stop codespace**):
> mientras está encendido consume tu cuota mensual gratuita.

**En tu ordenador, con IntelliJ IDEA o con VS Code.** Clona tu copia y abre el proyecto por su
`pom.xml`: en IntelliJ, **File → Open** y selecciona el `pom.xml` (elige *Open as Project*); en VS
Code, abre la carpeta y deja que la extensión de Java la importe. Necesitas un **JDK 25**; IntelliJ
puede descargarlo él mismo desde *File → Project Structure → SDK*. Maven viene incluido en
IntelliJ, así que no hace falta instalarlo aparte.

### La opción `--enable-preview`

El ejercicio 3.3.2 usa `StructuredTaskScope`, que en Java 25 es todavía una API **en vista previa**
(sección 3.3.4 del tema). El proyecto ya está configurado para ello: en el `pom.xml`, para el
compilador y para las pruebas, y en `.mvn/jvm.config`, para `mvn exec:java`. Si al ejecutar desde
el IDE ves un error que habla de *preview features*, comprueba que el nivel de lenguaje del
proyecto sea **25 (Preview)** en IntelliJ, o vuelve a importar el proyecto en VS Code.

## Un ejercicio, una clase de prueba

Cada ejercicio se comprueba con una clase de prueba, y solo con esa. Para trabajar en uno, abre su
clase de prueba y pulsa el botón de ejecutar que aparece junto al nombre de la clase: el ▶ en VS
Code, la flecha verde del margen izquierdo en IntelliJ. Se ejecutan solo sus pruebas, y al lado de
cada método aparece si pasó o falló.

| Ejercicio | Clases | Clase de prueba |
|---|---|---|
| 3.1.1 | `CreadorDeHilos` | `CreadorDeHilosTest` |
| 3.1.2 | `AforoSincronizado`, `SimulacionAforo` | `AforoSincronizadoTest` |
| 3.1.3 | `MesaOrdenada` | `MesaOrdenadaTest` |
| 3.2.1 | `PrimosEnParalelo` | `PrimosEnParaleloTest` |
| 3.2.2 | `EstacionMeteo` | `EstacionMeteoTest` |
| 3.2.3 | `Votacion` | `VotacionTest` |
| 3.2.4 | `Imprenta` | `ImprentaTest` |
| 3.2.5 | `CadenaDeMontaje` | `CadenaDeMontajeTest` |
| 3.3.1 | `Descargador` | `DescargadorTest` |
| 3.3.2 | `Replicas` | `ReplicasTest` |

**Al clonar, todas estas pruebas fallan. Es lo normal**: son la lista de tareas, no una avería. Van
pasando a verde según resuelves los ejercicios. Mientras un ejercicio está sin resolver, verás
además trazas de `UnsupportedOperationException` en hilos con nombres como `Thread-4`: son los
hilos que lanzan las pruebas, tropezando con tus `TODO`.

## Pruebas de programas concurrentes

Las pruebas de este tema no son como las de los anteriores, y conviene saberlo antes de empezar:

- **Una prueba en verde no demuestra que no haya una carrera.** Las pruebas repiten cada
  experimento varias veces con varios hilos, que es lo que hace aparecer una carrera casi siempre,
  pero «casi siempre» no es «siempre». Si una prueba falla una vez de cada diez, **hay un error**:
  no la vuelvas a ejecutar hasta que pase.
- **Algunas pruebas miden tiempos**, porque lo que comprueban es que algo ocurre a la vez. Los
  márgenes son amplios, pero en un ordenador muy cargado una de ellas podría fallar sin culpa
  tuya. Si pasa, cierra lo que sobre y repítela; si sigue fallando, el problema es tuyo.
- **Si una prueba se queda colgada**, lo más probable es un interbloqueo o un hilo esperando algo
  que no va a llegar. Las pruebas que pueden colgarse llevan un plazo de 10 s y fallan con un
  mensaje que lo dice.

## Cómo está organizado

```text
t3-ejercicios/
├── pom.xml                       ← proyecto Maven (Java 25, JUnit 5, --enable-preview)
├── .mvn/jvm.config               ← --enable-preview para exec:java
└── src/
    ├── main/java/es/uib/prgava/tema3/ejercicios/   ← tus clases y el código de partida
    └── test/java/es/uib/prgava/tema3/ejercicios/   ← las pruebas
```

Hay **11 clases** con ejercicios y **6** ya escritas. Una es `DemoCreadorDeHilos`, un programa
para ver funcionar el ejercicio 3.1.1 cuando lo hayas resuelto. Las otras cinco son el código de
partida de los ejercicios 3.1.2 y 3.1.3: `ControlDeAforo` y `Aforo`, `Mesa`, `MesaIngenua` y
`DemoCena`. **`Aforo` y `MesaIngenua` están mal a propósito**: la primera tiene una condición de
carrera y la segunda se puede quedar parada. No las corrijas; tu trabajo es escribir las versiones
buenas al lado.

## Cómo leer el esqueleto

Cada clase que tienes que escribir trae ya las **declaraciones** que necesita el ejercicio: las
firmas de sus métodos, la documentación y las cláusulas `implements` y `extends` correspondientes,
para que el proyecto compile y las pruebas se puedan ejecutar desde el primer momento. Lo que falta
son los **cuerpos**, marcados con `// TODO 3.X.k` y un `throw new
UnsupportedOperationException(...)`. **Borra ese `throw`** al implementar el método; mientras esté,
la prueba correspondiente falla con ese mensaje, que además te dice a qué ejercicio pertenece.

Algunos `TODO` no piden código sino **un comentario** o un pequeño `main` para ver algo con tus
propios ojos. No los saltes: son la parte del ejercicio que se evalúa leyendo, y el tipo de
pregunta que aparece en el Examen Parcial.

Los diez ejercicios son independientes y se pueden resolver en cualquier orden, aunque siguen el
del tema y conviene respetarlo.

## Órdenes útiles

```bash
mvn test                                   # todas las pruebas
mvn -Dtest=VotacionTest test               # solo una clase
mvn -q compile                             # solo compilar
mvn -q compile exec:java -Dexec.mainClass=es.uib.prgava.tema3.ejercicios.DemoCreadorDeHilos
mvn -q compile exec:java -Dexec.mainClass=es.uib.prgava.tema3.ejercicios.DemoCena
```

## Integridad académica

El uso de asistentes de IA en estos ejercicios se rige por las **condiciones de uso de la IA** de la
[guía docente](https://uib-22354-programacion-avanzada.github.io/website/es/informaciones/guia-docente.html).
En resumen: puedes pedir explicaciones y revisión, pero entregar código que no sabes explicar,
justificar ni modificar se considera uso indebido. Estos ejercicios son la base de los Talleres y
del Examen Parcial, donde no hay asistente que valga.

## Licencia

El material de partida se publica bajo licencia [MIT](LICENSE) — copyright © 2026 Alejandro Mesejo.
**Las soluciones que escribas son tuyas.** Los enunciados y el resto del material docente están en
el [sitio web de la asignatura](https://uib-22354-programacion-avanzada.github.io/website/), bajo
licencia [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en).
