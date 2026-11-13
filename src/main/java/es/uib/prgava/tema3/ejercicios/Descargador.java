package es.uib.prgava.tema3.ejercicios;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

/** Ejercicio 3.3.1. Muchas descargas, cada una en su hilo virtual, con un límite de simultáneas. */
public final class Descargador {

    private Descargador() { }

    /**
     * Descarga todas las direcciones con {@code descargar}, cada una en su propio hilo virtual, y
     * nunca más de {@code simultaneas} a la vez. Devuelve el contenido de cada dirección; si una
     * descarga lanza una excepción, su contenido es {@code "error: "} seguido del mensaje.
     *
     * @throws IllegalArgumentException si {@code simultaneas} es menor que 1
     */
    public static Map<String, String> descargarTodas(List<String> direcciones, int simultaneas,
            Function<String, String> descargar) throws InterruptedException {
        // TODO 3.3.1
        throw new UnsupportedOperationException("TODO 3.3.1: Descargador.descargarTodas");
    }
}
