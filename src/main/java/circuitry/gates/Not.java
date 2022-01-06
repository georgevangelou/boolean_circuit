package circuitry.gates;

/**
 *
 */
public class Not extends Gate {
    protected boolean calculate(final boolean a, final boolean b) {
        return !a;
    }
}
