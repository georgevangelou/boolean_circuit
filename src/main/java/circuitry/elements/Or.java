package circuitry.elements;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.tuple.Pair;

/**
 *
 */
public class Or<T> extends Calculatable<T> {
    private final Calculatable<T> a;
    private final Calculatable<T> b;
    private final Class<T> classOfInputs;


    protected Or(final Calculatable<T> a, final Calculatable<T> b, final Class<T> classOfInputs) {
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
            double ad = (Double) a.calculate().getRight();
            double bd = (Double) b.calculate().getRight();
            Double value = 1 - (1 - ad) * (1 - bd);
            return Pair.of(false, (T) value);
        } else if (this.classOfInputs == Boolean.class) {
            Boolean value = (Boolean) ((Boolean) a.calculate().getRight() || ((Boolean) b.calculate().getRight()));
            return Pair.of(true, (T) value);
        } else {
            throw new RuntimeException();
        }
    }
}
