package circuitry.elements;

/**
 * Created on: 2022-01-06
 */
public abstract class API {
    public static final int VERSION = 1;


    protected API() {
//        System.err.println("Initializing version " + VERSION);
        init(API.VERSION);
//        System.err.println("Properly initialized: " + this);
    }


    protected abstract void init(int version) throws IllegalStateException;
}
