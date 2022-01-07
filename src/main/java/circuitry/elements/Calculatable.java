package circuitry.elements;

/**
 *
 */
public abstract class Calculatable {

    public final boolean calculate() {
        try {
            return calculateInner();
        } catch (final NullPointerException npe) {
            System.out.println("Null object found.");
            return false;
        }
    }


    protected abstract boolean calculateInner();
}
