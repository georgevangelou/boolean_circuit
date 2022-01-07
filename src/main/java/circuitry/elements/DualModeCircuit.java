package circuitry.elements;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Created on: 2022-01-07
 */
public class DualModeCircuit {
   private final Calculatable<?> calculatable;


    protected DualModeCircuit(final Calculatable<?> calculatable) {
        Preconditions.checkNotNull(calculatable, "Circuit input should not be null");

        this.calculatable = calculatable;
    }


    public void hello() {
        System.out.println("Hello world");
    }


    public Pair<Boolean, ?> calculate() {
        return this.calculatable.calculate();
    }
}

