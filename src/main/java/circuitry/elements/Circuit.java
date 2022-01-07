package circuitry.elements;

import com.google.common.base.Preconditions;

/**
 *
 */
public final class Circuit {
    private final Calculatable calculatable;


    protected Circuit(final Calculatable calculatable) {
        Preconditions.checkNotNull(calculatable, "Circuit input should not be null");

        this.calculatable = calculatable;
    }


    public void hello() {
        System.out.println("Hello world");
    }


    public boolean calculate() {
        return this.calculatable.calculate();
    }
}
