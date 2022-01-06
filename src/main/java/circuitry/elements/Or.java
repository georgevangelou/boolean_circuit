package circuitry.elements;

/**
 *
 */
public class Or extends Calculatable{
    private final Calculatable a;
    private final Calculatable b;
    
    protected Or(final Calculatable a, final Calculatable b) {
        this.a = a;
        this.b = b;
    }

    protected boolean calculateInner() {
        return a.calculate() || b.calculate();
    }
}
