package circuitry.elements;

import com.google.common.base.Preconditions;

/**
 *
 */
public final class ElementFactory extends API {
    public ElementFactory(int version) {
        init(version);
    }


    @Override
    protected void init(int version) throws IllegalStateException {
        if (version != API.VERSION)
            throw new IllegalStateException("API version error!");
    }


    public final Circuit createCircuit(final Calculatable a) {
        Preconditions.checkNotNull(a, "Circuit input should not be null");

        return new Circuit(a);
    }


    public final InputBoolean createInputBoolean(final boolean value) {
        return new InputBoolean(value);
    }


    public final Calculatable createAndGateWithInputs(final Calculatable a, final Calculatable b) {
        Preconditions.checkNotNull(a, "Gate input should not be null");
        Preconditions.checkNotNull(b, "Gate input should not be null");

        return new And(a, b);
    }


    public final Calculatable createOrGateWithInputs(final Calculatable a, final Calculatable b) {
        Preconditions.checkNotNull(a, "Gate input should not be null");
        Preconditions.checkNotNull(b, "Gate input should not be null");

        return new Or(a, b);
    }


    public final Calculatable createNotGateWithInput(final Calculatable a) {
        Preconditions.checkNotNull(a, "Gate input should not be null");

        return new Not(a);
    }
}
