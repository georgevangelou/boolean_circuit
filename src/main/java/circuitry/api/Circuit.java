package circuitry.api;

import circuitry.elements.Calculatable;
import com.google.common.base.Preconditions;

/**
 *
 */
public class Circuit {
    private final Calculatable calculatable;
    
    public void hello() {
        System.out.println("Hello world");
    }
    
    public Circuit(final Calculatable calculatable) {
        Preconditions.checkNotNull(calculatable, "Circuit input should not be null");
        
        this.calculatable = calculatable;
    }
    
    public boolean calculate() {
        return this.calculatable.calculate();
    }
}
