package circuitry.api;

import circuitry.gates.Calculatable;

/**
 *
 */
public class Circuit {
    Calculatable calculatable;
    
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
