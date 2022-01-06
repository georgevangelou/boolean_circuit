package circuitry.gates;

/**
 *
 */
public class Or extends Gate{
    @Override
    protected boolean calculate(final boolean a, final boolean b) {
        return a || b;
    }
}
