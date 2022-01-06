package circuitry.gates;

import circuitry.gates.And;
import circuitry.gates.Calculatable;
import circuitry.gates.Not;
import circuitry.gates.Or;

/**
 *
 */
public class Factory {
    public final InputBoolean createInputBoolean(final boolean value) {
        return new InputBoolean(value);
    }
    
    public final Calculatable createAndGateWithInputs(final Calculatable a, final Calculatable b) {
        return new And(a, b);
    }
    
    public final Calculatable createOrGateWithInputs(final Calculatable a, final Calculatable b) {
        return new Or(a, b);
    }
    
    public final Calculatable createNotGateWithInput(final Calculatable a) {
        return new Not(a);
    }
}
