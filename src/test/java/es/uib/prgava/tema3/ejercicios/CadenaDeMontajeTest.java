package es.uib.prgava.tema3.ejercicios;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.UnaryOperator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Ejercicio 3.2.5. */
class CadenaDeMontajeTest {

    private static List<String> piezas(int n) {
        List<String> todas = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            todas.add("p" + i);
        }
        return todas;
    }

    private static UnaryOperator<String> etapa(String nombre, long milis) {
        return pieza -> {
            try {
                Thread.sleep(milis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return nombre + "(" + pieza + ")";
        };
    }

    private static List<String> procesar(List<String> piezas, List<UnaryOperator<String>> etapas, int capacidad) {
        return assertTimeoutPreemptively(Duration.ofSeconds(10), () -> CadenaDeMontaje.procesar(piezas, etapas, capacidad),
                "la cadena no ha terminado en 10 s: alguna etapa se ha quedado esperando");
    }

    @Test
    void cadaPiezaPasaPorTodasLasEtapasEnOrden() {
        List<String> hechas = procesar(piezas(3), List.of(etapa("cortar", 0), etapa("pintar", 0), etapa("empaquetar", 0)), 2);
        assertEquals(List.of("empaquetar(pintar(cortar(p1)))", "empaquetar(pintar(cortar(p2)))",
                "empaquetar(pintar(cortar(p3)))"), hechas);
    }

    @Test
    void conservaElOrdenDeEntrada() {
        List<String> hechas = procesar(piezas(500), List.of(String::toUpperCase, s -> s + "!"), 3);
        List<String> esperadas = piezas(500).stream().map(s -> s.toUpperCase() + "!").toList();
        assertEquals(esperadas, hechas);
    }

    @Test
    void casosLimite() {
        assertEquals(List.of(), procesar(List.of(), List.of(etapa("a", 0)), 1), "sin piezas");
        assertEquals(List.of("x", "y"), procesar(List.of("x", "y"), List.of(), 1), "sin etapas, las piezas salen como entran");
        assertThrows(IllegalArgumentException.class, () -> CadenaDeMontaje.procesar(List.of("x"), List.of(), 0));
    }

    @Test
    void cadaEtapaTieneSuPropioHilo() {
        List<Set<Thread>> hilos = new ArrayList<>();
        List<UnaryOperator<String>> etapas = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Set<Thread> suyos = ConcurrentHashMap.newKeySet();
            hilos.add(suyos);
            etapas.add(pieza -> {
                suyos.add(Thread.currentThread());
                return pieza;
            });
        }
        procesar(piezas(20), etapas, 2);
        Set<Thread> todos = ConcurrentHashMap.newKeySet();
        for (Set<Thread> suyos : hilos) {
            assertEquals(1, suyos.size(), "cada etapa debe ejecutarse siempre en el mismo hilo");
            todos.addAll(suyos);
        }
        assertEquals(3, todos.size(), "cada etapa debe tener un hilo distinto");
        assertFalse(todos.contains(Thread.currentThread()), "ninguna etapa se ejecuta en el hilo que llama");
    }

    /** Esta es la que falla si las etapas no trabajan a la vez. */
    @Test
    void lasEtapasTrabajanALaVez() {
        long inicio = System.nanoTime();
        procesar(piezas(10), List.of(etapa("a", 50), etapa("b", 50), etapa("c", 50)), 2);
        long milis = (System.nanoTime() - inicio) / 1_000_000;
        assertTrue(milis < 1000, "10 piezas por 3 etapas de 50 ms han tardado " + milis
                + " ms; una detras de otra serian 1500, en cadena unas 600");
    }
}
