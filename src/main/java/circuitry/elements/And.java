package circuitry.elements;

/**
 *
 */
public class And extends Calculatable {
    private final Calculatable a;
    private final Calculatable b;
    
    
    protected And(final Calculatable a, final Calculatable b) {
        this.a = a;
        this.b = b;
    }
            
    public boolean calculate() {
        return a.calculate() && b.calculate();
    }
}
