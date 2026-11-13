package es.uib.prgava.tema3.ejercicios;

/** Ejercicio 3.1.3. La mesa sin interbloqueo: los tenedores se toman en un orden global. */
public final class MesaOrdenada implements Mesa {

    // TODO 3.1.3: los tenedores, como en MesaIngenua.

    /**
     * @throws IllegalArgumentException si no hay al menos un comensal
     */
    public MesaOrdenada(int comensales) {
        // TODO 3.1.3
        throw new UnsupportedOperationException("TODO 3.1.3: MesaOrdenada(int)");
    }

    @Override
    public int comensales() {
        // TODO 3.1.3
        throw new UnsupportedOperationException("TODO 3.1.3: MesaOrdenada.comensales");
    }

    /**
     * @throws IllegalArgumentException si {@code filosofo} no es un comensal de la mesa
     */
    @Override
    public void comer(int filosofo, Runnable bocado) {
        // TODO 3.1.3: toma primero el tenedor de numero menor, sea el de la izquierda o el de la
        // derecha, y despues el de numero mayor.
        throw new UnsupportedOperationException("TODO 3.1.3: MesaOrdenada.comer");
    }

    // TODO 3.1.3: escribe aqui, en un comentario de pocas lineas, cual de las cuatro condiciones
    // de Coffman rompe esta mesa, y por que el ciclo de la mesa ingenua ya no puede cerrarse.
}
