package circuitry.elements;

/**
 *
 */
public class InputBoolean extends Calculatable {
    private boolean value;


    protected InputBoolean(final boolean value) {
        this.value = value;
    }


    @Override
    protected boolean calculateInner() {
        return this.value;
    }


    public void set(final boolean value) {
        this.value = value;
    }
}
