package es.uib.prgava.tema3.ejercicios;

/** Ejercicio 3.1.2. Una simulación que pone a prueba un control de aforo con varios hilos. */
public final class SimulacionAforo {

    private SimulacionAforo() { }

    /**
     * Lanza {@code hilos} hilos que intentan entrar {@code intentosPorHilo} veces cada uno, espera a
     * que terminen y devuelve cuántas entradas fueron aceptadas en total.
     *
     * @throws IllegalArgumentException si {@code hilos} es menor que 1 o {@code intentosPorHilo}
     *         es negativo
     */
    public static int entradasAceptadas(ControlDeAforo aforo, int hilos, int intentosPorHilo)
            throws InterruptedException {
        // TODO 3.1.2: cada hilo cuenta sus aceptadas en su propia casilla de un array, y se suman
        // despues de los join.
        throw new UnsupportedOperationException("TODO 3.1.2: SimulacionAforo.entradasAceptadas");
    }

    // TODO 3.1.2: escribe aqui un main que simule 8 hilos y 500 intentos sobre un Aforo de 1000
    // plazas, y despues sobre un AforoSincronizado, e imprima cuantas entradas acepto cada uno.
}
