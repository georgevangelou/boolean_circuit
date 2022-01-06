package circuitry.gates;

/**
 *
 */
public class Not extends Gate {
    private final Calculatable a;
    
    public Not(final Calculatable a) {
        this.a = a;
    }
            
            
    public boolean calculate() {
        return a.calculate();
    }
}
