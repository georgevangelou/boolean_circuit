package circuitry.elements;

/**
 *
 */
public class InputBoolean extends Calculatable{
    private boolean value;
    
    protected InputBoolean(final boolean value) {
        this.value = value;
    }
    
    public boolean calculate() {
        return this.value;
    }
    
    public void set(final boolean value) {
        this.value = value;
    }
}
