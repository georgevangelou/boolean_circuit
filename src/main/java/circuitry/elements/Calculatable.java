package circuitry.elements;

import org.apache.commons.lang3.tuple.Pair;

/**
 *
 */
public abstract class Calculatable<T> {

    protected final Pair<Boolean, T> calculate() {
        try {
            return calculateInner();
        } catch (final NullPointerException npe) {
            System.err.println("Null object found.");
            throw new NullPointerException("Null object found.");
        }
    }


    protected abstract Pair<Boolean, T> calculateInner();
}
