package circuitry.gates;

/**
 *
 */
public class And extends Gate {
    protected boolean calculate(final boolean a, final boolean b) {
        return a && b;
    }
}
