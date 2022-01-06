package circuitry.gates;

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
    
    public boolean calculate() {
        return a.calculate() || b.calculate();
    }
}
