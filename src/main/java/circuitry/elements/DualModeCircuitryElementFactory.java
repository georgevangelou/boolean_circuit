package circuitry.elements;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.tuple.Pair;

import java.util.InputMismatchException;

/**
 * Created on: 2022-01-07
 */
public class DualModeCircuitryElementFactory extends API {
    public DualModeCircuitryElementFactory(int version) {
        init(version);
    }


    @Override
    protected void init(int version) throws IllegalStateException {
        if (version != API.VERSION)
            throw new IllegalStateException("API version error!");
    }


    public final DualModeCircuit createCircuit(final Calculatable<?> a) {
        Preconditions.checkNotNull(a, "Circuit input should not be null");

        return new DualModeCircuit((Calculatable<?>) a);
    }


    public final InputPair<?> createInputPair(final boolean valueIsBoolean, final Object value) {
        if (((value.getClass() == Double.class) && !valueIsBoolean) || ((value.getClass() == Boolean.class) && valueIsBoolean)) {
            return new InputPair<>(Pair.of(valueIsBoolean, value));
        }
        throw new InputMismatchException("Wrong input pair");
    }


    public final Calculatable<?> createAndGateWithInputs(final Calculatable<?> a, final Calculatable<?> b) {
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

    public final Calculatable<?> createOrGateWithInputs(final Calculatable<?> a, final Calculatable<?> b) {
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


    public final Calculatable<?> createNotGateWithInputs(final Calculatable<?> a) {
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
