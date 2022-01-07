package circuitry.elements;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.tuple.Pair;

/**
 *
 */
public class And<T> extends Calculatable<T> {
    private final Calculatable<T> a;
    private final Calculatable<T> b;
    private final Class<T> classOfInputs;


    protected And(final Calculatable<T> a, final Calculatable<T> b, final Class<T> classOfInputs) {
        Preconditions.checkNotNull(a, "Gate input should not be null");
        Preconditions.checkNotNull(b, "Gate input should not be null");
        Preconditions.checkNotNull(classOfInputs, "Gate input should not be null");

        this.a = a;
        this.b = b;
        this.classOfInputs = classOfInputs;
    }


    @Override
    protected Pair<Boolean, T> calculateInner() {
        if (this.classOfInputs == Double.class) {
            Double value =  (Double) ((Double) a.calculate().getRight() * ((Double) b.calculate().getRight()));
            return Pair.of(false, (T) value);
        } else if (this.classOfInputs == Boolean.class) {
            Boolean value =  (Boolean) ((Boolean) a.calculate().getRight() && ((Boolean) b.calculate().getRight()));
            return Pair.of(true, (T) value);
        } else {
            throw new RuntimeException();
        }
    }
}
