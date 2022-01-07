package circuitry.elements;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.tuple.Pair;

import java.util.InputMismatchException;

/**
 *
 */
public final class ElementFactory extends API {
    public ElementFactory(int version) {
        init(version);
    }


    @Override
    protected void init(int version) throws IllegalStateException {
    }


    public final Circuit createCircuit(final Calculatable<Boolean> a) {
        Preconditions.checkNotNull(a, "Circuit input should not be null");

        return new Circuit(a);
    }


    public final InputBoolean createInputBoolean(final boolean value) {
        return new InputBoolean(value);
    }


    public final Calculatable<Boolean> createAndGateWithInputs(final Calculatable<Boolean> a, final Calculatable<Boolean> b) {
        Preconditions.checkNotNull(a, "Gate input should not be null");
        Preconditions.checkNotNull(b, "Gate input should not be null");

        return new And<Boolean>(a, b, Boolean.class);
    }


    public final Calculatable<Boolean> createOrGateWithInputs(final Calculatable<Boolean> a, final Calculatable<Boolean> b) {
        Preconditions.checkNotNull(a, "Gate input should not be null");
        Preconditions.checkNotNull(b, "Gate input should not be null");

        return new Or<Boolean>(a, b, Boolean.class);
    }


    public final Calculatable<Boolean> createNotGateWithInput(final Calculatable<Boolean> a) {
        Preconditions.checkNotNull(a, "Gate input should not be null");

        return new Not<Boolean>(a, Boolean.class);
    }


    public final Circuit createDualModeCircuit(final Calculatable<?> a) {
        Preconditions.checkNotNull(a, "Circuit input should not be null");

        return new Circuit((Calculatable<?>) a);
    }


    public final InputPair<?> createInputPair(final boolean valueIsBoolean, final Object value) {
        if (((value.getClass() == Double.class) && !valueIsBoolean && ((Double) value >= 0) && ((Double) value <= 1))
                || ((value.getClass() == Boolean.class) && valueIsBoolean)) {
            return new InputPair<>(Pair.of(valueIsBoolean, value));
        }
        throw new InputMismatchException("Wrong input pair");
    }


    public final Calculatable<?> createDualModeAndGateWithInputs(final Calculatable<?> a, final Calculatable<?> b) {
        Preconditions.checkNotNull(a, "Gate input should not be null");
        Preconditions.checkNotNull(b, "Gate input should not be null");

        if (a.calculate().getRight() instanceof Boolean) {
            return new And<Boolean>((Calculatable<Boolean>) a, (Calculatable<Boolean>) b, Boolean.class);
        } else if (a.calculate().getRight() instanceof Double) {
            return new And<Double>((Calculatable<Double>) a, (Calculatable<Double>) b, Double.class);
        } else {
            throw new InputMismatchException("Wrong matching");
        }
    }

    public final Calculatable<?> createDualModeOrGateWithInputs(final Calculatable<?> a, final Calculatable<?> b) {
        Preconditions.checkNotNull(a, "Gate input should not be null");
        Preconditions.checkNotNull(b, "Gate input should not be null");

        if (a.calculate().getRight() instanceof Boolean) {
            return new Or<Boolean>((Calculatable<Boolean>) a, (Calculatable<Boolean>) b, Boolean.class);
        } else if (a.calculate().getRight() instanceof Double) {
            return new Or<Double>((Calculatable<Double>) a, (Calculatable<Double>) b, Double.class);
        } else {
            throw new InputMismatchException("Wrong matching");
        }
    }


    public final Calculatable<?> createDualModeNotGateWithInputs(final Calculatable<?> a) {
        Preconditions.checkNotNull(a, "Gate input should not be null");

        if (a.calculate().getRight() instanceof Boolean) {
            return new Not<Boolean>((Calculatable<Boolean>) a, Boolean.class);
        } else if (a.calculate().getRight() instanceof Double) {
            return new Not<Double>((Calculatable<Double>) a, Double.class);
        } else {
            throw new InputMismatchException("Wrong matching");
        }
    }


    public final Calculatable<Boolean> createGteGateWithInputs(final Calculatable<?> a, final Calculatable<?> b) {
        Preconditions.checkNotNull(a, "Gate input should not be null");
        Preconditions.checkNotNull(b, "Gate input should not be null");

        if (a.calculate().getRight() instanceof Double && b.calculate().getRight() instanceof Double) {
            return new Gte<>((Calculatable<Double>) a, (Calculatable<Double>) b);
        } else {
            throw new InputMismatchException("Wrong matching");
        }
    }
}
