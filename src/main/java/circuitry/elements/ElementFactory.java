package circuitry.elements;

/**
 *
 */
public class ElementFactory {
    public final InputBoolean createInputBoolean(final boolean value) {
        return new InputBoolean(value);
    }

    public final Calculatable createAndGateWithInputs(final Calculatable a, final Calculatable b) {
        return new And(a, b);
    }

    public final Calculatable createOrGateWithInputs(final Calculatable a, final Calculatable b) {
        return new Or(a, b);
    }

    public final Calculatable createNotGateWithInput(final Calculatable a) {
        return new Not(a);
    }
}
