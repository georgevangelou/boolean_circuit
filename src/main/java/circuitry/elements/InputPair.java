package circuitry.elements;

import org.apache.commons.lang3.tuple.Pair;

import java.util.InputMismatchException;

/**
 * Created on: 2022-01-07
 */
public final class InputPair<T> extends Calculatable<T> {
    private Pair<Boolean, ?> pair;

    protected InputPair(Pair<Boolean, T> pair) {
        this.pair = pair;
    }


    @Override
    protected Pair<Boolean, T> calculateInner() {
        try {
            return (Pair<Boolean, T>) this.pair;
        } catch (ClassCastException classCastException) {
            System.err.println("Class cast exception");
            throw classCastException;
        }
    }

    public void setValue(final boolean isBoolean, final T value) {
        if ((this.pair.getLeft() == isBoolean)
                && ((this.pair.getLeft() && value instanceof Boolean)
                || (!this.pair.getLeft() && value instanceof Double))) {
            this.pair = Pair.of(this.pair.getLeft(), value);
        }
        throw new InputMismatchException("Input signal should not change type (boolean/double)");
    }

    public void set(final InputPair<?> updatedInput) {
        if (this.pair.getLeft()!=updatedInput.pair.getLeft()) {
            throw new InputMismatchException("Input signal should not change type (boolean/double)");
        }
        this.pair = updatedInput.pair;
    }
}
