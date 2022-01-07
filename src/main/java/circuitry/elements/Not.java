package circuitry.elements;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Created on: 2022-01-06
 */
class Not<T> extends Calculatable<T> {
    private final Calculatable<T> a;
    private final Class<T> classOfInputs;


    protected Not(final Calculatable<T> a, final Class<T> classOfInputs) {
        Preconditions.checkNotNull(a, "Gate input should not be null");
        Preconditions.checkNotNull(classOfInputs, "Gate input should not be null");

        this.a = a;
        this.classOfInputs = classOfInputs;
    }


    @Override
    protected Pair<Boolean, T> calculateInner() {
        if (this.classOfInputs == Double.class) {
            double ad = (Double) a.calculate().getRight();
            Double value = (1 - ad);
            return Pair.of(false, (T) value);
        } else if (this.classOfInputs == Boolean.class) {
            Boolean value = !((Boolean) ((Boolean) a.calculate().getRight()));
            return Pair.of(true, (T) value);
        } else {
            throw new RuntimeException();
        }
    }
}
