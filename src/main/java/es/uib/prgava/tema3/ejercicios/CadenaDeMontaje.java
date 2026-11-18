package es.uib.prgava.tema3.ejercicios;

import java.util.List;

/**
 * Ejercicio 3.2.5. Una cadena de montaje de tres puestos —ensamblar, pintar y empaquetar—
 * comunicados por colas. Los tres pasos los hace la clase {@link Taller}, que ya está escrita.
 */
public final class CadenaDeMontaje {

    private CadenaDeMontaje() { }

    /**
     * Fabrica las piezas con un hilo por puesto, {@code "ensamblador"}, {@code "pintor"} y
     * {@code "empaquetador"}, y colas de {@code capacidad} piezas entre ellos. Devuelve las piezas
     * terminadas en el orden en que entraron.
     *
     * @throws IllegalArgumentException si {@code capacidad} es menor que 1
     */
    public static List<String> fabricar(List<String> piezas, int capacidad) throws InterruptedException {
        // TODO 3.2.5
        throw new UnsupportedOperationException("TODO 3.2.5: CadenaDeMontaje.fabricar");
    }

    /**
     * Ampliación. Fabrica las piezas con varios hilos en cada puesto, llamados
     * {@code "ensamblador-1"}, {@code "pintor-1"}, {@code "empaquetador-1"}… Las piezas terminadas
     * salen en cualquier orden.
     *
     * @throws IllegalArgumentException si {@code capacidad} o alguno de los tres números de
     *         trabajadores es menor que 1
     */
    public static List<String> fabricar(List<String> piezas, int capacidad,
            int ensambladores, int pintores, int empaquetadores) throws InterruptedException {
        // TODO 3.2.5 (ampliacion): sus pruebas estan en CadenaDeMontajeEquiposTest, con @Disabled.
        throw new UnsupportedOperationException("TODO 3.2.5 (ampliacion): CadenaDeMontaje.fabricar con equipos");
    }
}
