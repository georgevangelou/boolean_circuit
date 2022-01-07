package circuitry.elements;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.tuple.Pair;

/**
 *
 */
public final class Circuit {
    private final Calculatable<?> calculatable;


    protected Circuit(final Calculatable<?> calculatable) {
        Preconditions.checkNotNull(calculatable, "Circuit input should not be null");

        this.calculatable = calculatable;
    }


    public void hello() {
        System.out.println("Hello world");
    }


    public boolean calculate() {
        Object output = this.calculatable.calculate().getRight();

        if (output instanceof Double) {
            return ((Double) output) >= 0.5;
        } else if (output instanceof Boolean) {
            return (Boolean) output;
        } else {
            throw new RuntimeException("Unexpected type of output");
        }
    }


    public Pair<Boolean, ?> calculatePairOutput() {
        return this.calculatable.calculate();
    }
}
