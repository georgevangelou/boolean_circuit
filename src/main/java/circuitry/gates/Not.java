package circuitry.gates;

/**
 *
 */
public class Not extends Calculatable {
    private final Calculatable a;
    
    public Not(final Calculatable a) {
        this.a = a;
    }
            
            
    public boolean calculate() {
        return !a.calculate();
    }
}
