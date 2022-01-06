package circuitry.elements;

import com.google.common.base.Preconditions;

/**
 *
 */
public class Or extends Calculatable{
    private final Calculatable a;
    private final Calculatable b;
    
    protected Or(final Calculatable a, final Calculatable b) {
        Preconditions.checkNotNull(a, "Gate input should not be null");
        Preconditions.checkNotNull(b, "Gate input should not be null");

        this.a = a;
        this.b = b;
    }

    protected boolean calculateInner() {
        return a.calculate() || b.calculate();
    }
}
