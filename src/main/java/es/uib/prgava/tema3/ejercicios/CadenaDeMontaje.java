package es.uib.prgava.tema3.ejercicios;

import java.util.List;
import java.util.function.UnaryOperator;

/** Ejercicio 3.2.5. Una cadena de montaje: cada etapa es un hilo, y entre dos etapas hay una cola. */
public final class CadenaDeMontaje {

    private CadenaDeMontaje() { }

    /**
     * Pasa cada pieza por todas las etapas, en orden, con un hilo por etapa y colas de
     * {@code capacidad} piezas entre ellas. Devuelve las piezas terminadas, en el orden de entrada.
     *
     * @throws IllegalArgumentException si {@code capacidad} es menor que 1
     */
    public static List<String> procesar(List<String> piezas, List<UnaryOperator<String>> etapas,
            int capacidad) throws InterruptedException {
        // TODO 3.2.5
        throw new UnsupportedOperationException("TODO 3.2.5: CadenaDeMontaje.procesar");
    }
}
