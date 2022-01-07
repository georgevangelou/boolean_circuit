package circuitry.elements;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.tuple.Pair;

/**
 *
 */
class Gte<T> extends Calculatable<T> {
    private final Calculatable<Double> a;
    private final Calculatable<Double> b;
    private final Class<Double> classOfInputs = Double.class;


    protected Gte(final Calculatable<Double> a, final Calculatable<Double> b) {
        Preconditions.checkNotNull(a, "Gate input should not be null");
        Preconditions.checkNotNull(b, "Gate input should not be null");
        Preconditions.checkNotNull(classOfInputs, "Gate input should not be null");

        this.a = a;
        this.b = b;
    }


    @Override
    protected Pair<Boolean, T> calculateInner() {
        if (this.classOfInputs == Double.class) {
            Boolean value =  ((Double) a.calculate().getRight() >= ((Double) b.calculate().getRight()));
            return Pair.of(true, (T) value);
        } else {
            throw new RuntimeException();
        }
    }
}
