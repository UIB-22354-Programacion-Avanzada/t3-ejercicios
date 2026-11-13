package es.uib.prgava.tema3.ejercicios;

/** Ejercicio 3.1.2. El control de aforo de {@link Aforo}, sin la condición de carrera. */
public final class AforoSincronizado implements ControlDeAforo {

    // TODO 3.1.2: los mismos atributos que Aforo.

    /**
     * @throws IllegalArgumentException si la capacidad es negativa
     */
    public AforoSincronizado(int capacidad) {
        // TODO 3.1.2
        throw new UnsupportedOperationException("TODO 3.1.2: AforoSincronizado(int)");
    }

    @Override
    public boolean entrar() {
        // TODO 3.1.2: el mismo cuerpo que en Aforo, Thread.yield() incluido, pero en exclusion mutua.
        throw new UnsupportedOperationException("TODO 3.1.2: AforoSincronizado.entrar");
    }

    @Override
    public int dentro() {
        // TODO 3.1.2
        throw new UnsupportedOperationException("TODO 3.1.2: AforoSincronizado.dentro");
    }

    @Override
    public int capacidad() {
        // TODO 3.1.2
        throw new UnsupportedOperationException("TODO 3.1.2: AforoSincronizado.capacidad");
    }
}
