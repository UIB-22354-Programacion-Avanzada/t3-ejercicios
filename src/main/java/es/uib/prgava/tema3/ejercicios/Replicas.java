package es.uib.prgava.tema3.ejercicios;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Ejercicio 3.3.2. Preguntar a varias réplicas a la vez y quedarse con la primera que conteste bien.
 *
 * <p>Usa {@code StructuredTaskScope}, una API en vista previa en Java 25: el proyecto ya está
 * configurado con {@code --enable-preview}.
 */
public final class Replicas {

    private Replicas() { }

    /**
     * La primera respuesta correcta de las réplicas, consultadas a la vez en un ámbito
     * estructurado con plazo. Cuando vuelve, ninguna consulta sigue en marcha.
     *
     * @throws IllegalArgumentException si la lista está vacía
     * @throws java.util.concurrent.StructuredTaskScope.FailedException si fallan todas
     * @throws java.util.concurrent.StructuredTaskScope.TimeoutException si ninguna contesta bien
     *         dentro del plazo
     */
    public static <T> T primeraRespuesta(List<Callable<T>> replicas, Duration plazo)
            throws InterruptedException {
        // TODO 3.3.2
        throw new UnsupportedOperationException("TODO 3.3.2: Replicas.primeraRespuesta");
    }
}
