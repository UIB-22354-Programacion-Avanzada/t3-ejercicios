package es.uib.prgava.tema3.ejercicios;

import java.util.List;
import java.util.Map;

/** Ejercicio 3.2.4. Varias oficinas mandan documentos a una cola, y varias impresoras los imprimen. */
public final class Imprenta {

    private Imprenta() { }

    /** Imprimir un documento cuesta 10 ms. Ya está escrito: cada impresora lo llama por documento. */
    static void imprimirUno(String documento) throws InterruptedException {
        Thread.sleep(10);
    }

    /**
     * Una oficina por cada lista de {@code oficinas} y {@code impresoras} impresoras, comunicadas
     * por una cola de {@code capacidad} documentos. Vuelve cuando se ha impreso todo, con lo que ha
     * impreso cada impresora, por su nombre: {@code "impresora-1"}, {@code "impresora-2"}…
     *
     * @throws IllegalArgumentException si {@code impresoras} o {@code capacidad} son menores que 1
     */
    public static Map<String, List<String>> imprimir(List<List<String>> oficinas, int impresoras,
            int capacidad) throws InterruptedException {
        // TODO 3.2.4
        throw new UnsupportedOperationException("TODO 3.2.4: Imprenta.imprimir");
    }
}
