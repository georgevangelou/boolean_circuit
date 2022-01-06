package circuitry.gates;

/**
 *
 */
public class Not extends Calculatable {
    private final Calculatable a;
    
    protected Not(final Calculatable a) {
        this.a = a;
    }
            
            
    public boolean calculate() {
        return !a.calculate();
    }
}
