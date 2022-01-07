package circuitry.elements;

import com.google.common.base.Preconditions;

/**
 *
 */
public class Not extends Calculatable {
    private final Calculatable a;


    protected Not(final Calculatable a) {
        Preconditions.checkNotNull(a, "Gate input should not be null");

        this.a = a;
    }


    @Override
    protected boolean calculateInner() {
        return !a.calculate();
    }
}
