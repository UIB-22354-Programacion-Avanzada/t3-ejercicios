package es.uib.prgava.tema3.ejercicios;

import java.util.Map;

/** Ejercicio 3.2.3. Un recuento de votos que admite votar desde muchos hilos a la vez. */
public final class Votacion {

    // TODO 3.2.3: los votos de cada opcion, quien ha votado ya y el total. Ningun synchronized.

    /** Suma un voto a {@code opcion}. */
    public void votar(String opcion) {
        // TODO 3.2.3
        throw new UnsupportedOperationException("TODO 3.2.3: Votacion.votar");
    }

    /**
     * Suma un voto a {@code opcion} si {@code votante} no ha votado todavía, y devuelve si lo ha
     * sumado. Un votante solo vota una vez, aunque lo intente desde varios hilos a la vez.
     */
    public boolean votarUnaVez(String votante, String opcion) {
        // TODO 3.2.3
        throw new UnsupportedOperationException("TODO 3.2.3: Votacion.votarUnaVez");
    }

    /** Los votos de {@code opcion}, o 0 si no tiene ninguno. */
    public long votos(String opcion) {
        // TODO 3.2.3
        throw new UnsupportedOperationException("TODO 3.2.3: Votacion.votos");
    }

    /** Los votos emitidos, de todas las opciones. */
    public long total() {
        // TODO 3.2.3
        throw new UnsupportedOperationException("TODO 3.2.3: Votacion.total");
    }

    /** Una copia de los resultados en este momento, que no cambia aunque se siga votando. */
    public Map<String, Long> resultados() {
        // TODO 3.2.3
        throw new UnsupportedOperationException("TODO 3.2.3: Votacion.resultados");
    }
}
