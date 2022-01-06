package circuitry.gates;

/**
 *
 */
public class InputBoolean extends Calculatable{
    private boolean value;
    
    public InputBoolean(final boolean value) {
        this.value = value;
    }
    
    public boolean calculate() {
        return this.value;
    }
    
    public void set(final boolean value) {
        this.value = value;
    }
}