package circuitry.api;

import circuitry.elements.Calculatable;

/**
 *
 */
public class Circuit {
    private final Calculatable calculatable;
    
    public void hello() {
        System.out.println("Hello world");
    }
    
    public Circuit(Calculatable calculatable) {
        this.calculatable = calculatable;
    }
    
    public boolean calculate() {
        return this.calculatable.calculate();
    }
}
