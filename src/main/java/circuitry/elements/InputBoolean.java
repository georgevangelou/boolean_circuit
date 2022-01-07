package circuitry.elements;

import org.apache.commons.lang3.tuple.Pair;

/**
 *
 */
public class InputBoolean extends Calculatable<Boolean> {
    private boolean value;

    protected InputBoolean(final boolean value) {
        this.value = value;
    }

    @Override
    protected Pair<Boolean, Boolean> calculateInner() {
        return Pair.of(true, this.value);
    }

    public void set(final boolean value) {
        this.value = value;
    }
}
