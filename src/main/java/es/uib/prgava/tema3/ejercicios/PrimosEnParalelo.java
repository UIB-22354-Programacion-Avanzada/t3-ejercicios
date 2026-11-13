package es.uib.prgava.tema3.ejercicios;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

/** Ejercicio 3.2.1. Contar primos repartiendo el intervalo entre las tareas de un ejecutor. */
public final class PrimosEnParalelo {

    private PrimosEnParalelo() { }

    /** Si {@code n} es primo. Ya está escrito: no hace falta tocarlo. */
    public static boolean esPrimo(int n) {
        if (n < 2) {
            return false;
        }
        for (int d = 2; (long) d * d <= n; d++) {
            if (n % d == 0) {
                return false;
            }
        }
        return true;
    }

    /** Cuántos primos hay en {@code [desde, hasta)}, contados secuencialmente. Ya está escrito. */
    public static long contarSecuencial(int desde, int hasta) {
        long cuenta = 0;
        for (int n = desde; n < hasta; n++) {
            if (esPrimo(n)) {
                cuenta++;
            }
        }
        return cuenta;
    }

    /**
     * Cuántos primos hay en {@code [desde, hasta)}, repartiendo el intervalo en {@code partes}
     * tareas que se entregan a {@code ejecutor}. No cierra el ejecutor: no es suyo.
     *
     * @throws IllegalArgumentException si {@code desde > hasta} o {@code partes < 1}
     */
    public static long contar(int desde, int hasta, int partes, ExecutorService ejecutor)
            throws InterruptedException, ExecutionException {
        // TODO 3.2.1: valida; prepara una lista de Callable<Long>, una por parte, cada una con su
        // trozo [inicio, fin); entregalas con invokeAll y suma los resultados de los futuros.
        throw new UnsupportedOperationException("TODO 3.2.1: PrimosEnParalelo.contar");
    }
}
