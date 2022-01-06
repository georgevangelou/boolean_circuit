package circuitry.gates;

/**
 *
 */
public class And extends Gate {
    private final Calculatable a;
    private final Calculatable b;
    
    
    public And(final Calculatable a, final Calculatable b) {
        this.a = a;
        this.b = b;
    }
            
    public boolean calculate() {
        return a.calculate() && b.calculate();
    }
}
