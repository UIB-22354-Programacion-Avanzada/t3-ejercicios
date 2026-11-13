package es.uib.prgava.tema3.ejercicios;

import java.util.List;

/**
 * Ejercicio 3.1.1. Las cuatro formas de crear un hilo, y cómo arrancar y esperar a varios.
 *
 * <p>Los cuatro métodos {@code con…} crean un hilo <strong>sin arrancarlo</strong>, con el nombre
 * que se les da, cuya tarea es anotar en el registro el nombre del hilo que la ejecuta. El modelo es
 * el ejemplo «Cuatro formas de crear un hilo» del tema.
 */
public final class CreadorDeHilos {

    private CreadorDeHilos() { }

    /** Forma 1: una subclase de {@code Thread} que redefine {@code run}. */
    static final class HiloAnotador extends Thread {

        // TODO 3.1.1: guarda aqui el registro.

        HiloAnotador(String nombre, List<String> registro) {
            super(nombre);
            // TODO 3.1.1
        }

        @Override
        public void run() {
            // TODO 3.1.1: anota en el registro el nombre de este hilo.
            throw new UnsupportedOperationException("TODO 3.1.1: HiloAnotador.run");
        }
    }

    /** Forma 2: una clase con nombre que implementa {@code Runnable}. */
    static final class TareaAnotar implements Runnable {

        // TODO 3.1.1: guarda aqui el registro.

        TareaAnotar(List<String> registro) {
            // TODO 3.1.1
        }

        @Override
        public void run() {
            // TODO 3.1.1: anota en el registro el nombre del hilo que ejecuta la tarea.
            throw new UnsupportedOperationException("TODO 3.1.1: TareaAnotar.run");
        }
    }

    /** Forma 1: con la subclase {@link HiloAnotador}. */
    public static Thread conSubclase(String nombre, List<String> registro) {
        // TODO 3.1.1
        throw new UnsupportedOperationException("TODO 3.1.1: CreadorDeHilos.conSubclase");
    }

    /** Forma 2: con un {@code Thread} que recibe un {@link TareaAnotar}. */
    public static Thread conClaseRunnable(String nombre, List<String> registro) {
        // TODO 3.1.1
        throw new UnsupportedOperationException("TODO 3.1.1: CreadorDeHilos.conClaseRunnable");
    }

    /** Forma 3: con un {@code Thread} que recibe una lambda. */
    public static Thread conLambda(String nombre, List<String> registro) {
        // TODO 3.1.1
        throw new UnsupportedOperationException("TODO 3.1.1: CreadorDeHilos.conLambda");
    }

    /** Forma 4: con el constructor de hilos, {@code Thread.ofPlatform()}. */
    public static Thread conConstructor(String nombre, List<String> registro) {
        // TODO 3.1.1
        throw new UnsupportedOperationException("TODO 3.1.1: CreadorDeHilos.conConstructor");
    }

    /** Arranca todos los hilos, de modo que se ejecuten a la vez, y vuelve cuando han terminado todos. */
    public static void ejecutarTodos(List<Thread> hilos) throws InterruptedException {
        // TODO 3.1.1: dos bucles; por que dos, lo explica el ejemplo de start y join del tema.
        throw new UnsupportedOperationException("TODO 3.1.1: CreadorDeHilos.ejecutarTodos");
    }
}
