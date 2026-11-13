package es.uib.prgava.tema3.ejercicios;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Supplier;

/** Ejercicio 3.2.2. Un informe que combina dos consultas asíncronas, con plazo y sin dejarse tumbar. */
public final class EstacionMeteo {

    private EstacionMeteo() { }

    /**
     * El futuro de un informe como {@code "temperatura 21.5, humedad 60"}. Las dos consultas se
     * lanzan a la vez en {@code ejecutor}; la que falle o no conteste dentro de {@code plazo}
     * aparece como {@code ?}. El método vuelve al instante, sin esperar a ninguna.
     */
    public static CompletableFuture<String> informe(Supplier<Double> temperatura,
            Supplier<Integer> humedad, Duration plazo, Executor ejecutor) {
        // TODO 3.2.2: un futuro por consulta, ya convertido en texto, con su plazo y su valor de
        // repuesto; y un tercero que combine los dos. Ningun join aqui dentro.
        throw new UnsupportedOperationException("TODO 3.2.2: EstacionMeteo.informe");
    }
}
