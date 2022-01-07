import circuitry.elements.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 *
 */
public class TestingBooleanCircuit {
    private final ElementFactory factory = new ElementFactory(API.VERSION);


    @Test
    public void testCircuitCreation() {
        Circuit circuit = factory.createCircuit(factory.createInputBoolean(false));
        circuit.hello();
        System.out.println("Success (testCreation)!");
    }


    @Test
    public void testAndGate() {
        final InputBoolean input1 = factory.createInputBoolean(false);
        final InputBoolean input2 = factory.createInputBoolean(true);
        Circuit circuit = factory.createCircuit(factory.createAndGateWithInputs(input1, input2));
        assertEquals(false, circuit.calculate());

        input1.set(true);
        input2.set(true);
        assertEquals(true, circuit.calculate());

        input1.set(false);
        input2.set(false);
        assertEquals(false, circuit.calculate());

        input1.set(true);
        input2.set(false);
        assertEquals(false, circuit.calculate());

        System.out.println("Success (testAndGate)!");
    }


    @Test
    public void testOrGate() {
        final InputBoolean input1 = factory.createInputBoolean(false);
        final InputBoolean input2 = factory.createInputBoolean(true);
        Circuit circuit = factory.createCircuit(factory.createOrGateWithInputs(input1, input2));
        assertEquals(true, circuit.calculate());

        input1.set(true);
        input2.set(true);
        assertEquals(true, circuit.calculate());

        input1.set(false);
        input2.set(false);
        assertEquals(false, circuit.calculate());

        input1.set(true);
        input2.set(false);
        assertEquals(true, circuit.calculate());

        System.out.println("Success (testOrGate)!");
    }


    @Test
    public void testNotGate() {
        final InputBoolean input1 = factory.createInputBoolean(true);
        Circuit circuit = factory.createCircuit(factory.createNotGateWithInput(input1));
        assertEquals(false, circuit.calculate());

        input1.set(false);
        assertEquals(true, circuit.calculate());
        System.out.println("Success (testNotGate)!");
    }


    @Test
    public void testComplexCircuit() {
        final InputBoolean a = factory.createInputBoolean(true);
        final InputBoolean b = factory.createInputBoolean(false);
        final InputBoolean c = factory.createInputBoolean(false);

        final Calculatable sig1 = factory.createOrGateWithInputs(a, b);
        final Calculatable sig2 = factory.createNotGateWithInput(c);
        final Calculatable sig3 = factory.createAndGateWithInputs(sig1, sig2);

        // circuit = (a or b) and (!c)
        Circuit circuit = factory.createCircuit(sig3);

        assertEquals(true, circuit.calculate());

        c.set(true);
        assertEquals(false, circuit.calculate());
        System.out.println("Success (testComplexCircuit)!");
    }


    @Test
    public void testIfCircuitIsFailSafe1() {
        try {
            final InputBoolean input1 = null;
            final InputBoolean input2 = factory.createInputBoolean(true);

            Circuit circuit = factory.createCircuit(factory.createAndGateWithInputs(input1, input2));
            circuit.calculate();
            fail("Wrong user-input or circuit connections were handled INCORRECTLY");
        } catch (final Exception e) {
//            System.out.println("Exception was thrown. This was the desired behaviour");
            System.out.println("Success (testIfCircuitIsFailSafe1)!");
        }
    }


    @Test
    public void testIfCircuitIsFailSafe2() {
        try {
            final InputBoolean input1 = factory.createInputBoolean(false);
            final InputBoolean input2 = null;

            Circuit circuit = factory.createCircuit(factory.createAndGateWithInputs(input1, input2));
            circuit.calculate();
            fail("Wrong user-input or circuit connections were handled INCORRECTLY");
        } catch (final Exception e) {
//            System.out.println("Exception was thrown. This was the desired behaviour");
            System.out.println("Success (testIfCircuitIsFailSafe2)!");
        }
    }


    @Test
    public void testIfCircuitIsFailSafe3() {
        try {
            final InputBoolean input1 = factory.createInputBoolean(false);
            final InputBoolean input2 = factory.createInputBoolean(true);
            final Calculatable sig1 = factory.createAndGateWithInputs(input1, input2);
            final Calculatable sig2 = factory.createNotGateWithInput(null);
            final Calculatable sig3 = factory.createOrGateWithInputs(sig1, sig2);
            Circuit circuit = factory.createCircuit(sig3);
            circuit.calculate();
            fail("Wrong user-input or circuit connections were handled INCORRECTLY");
        } catch (final Exception e) {
//            System.out.println("Exception was thrown. This was the desired behaviour");
            System.out.println("Success (testIfCircuitIsFailSafe3)!");
        }
    }


    public TestingBooleanCircuit() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
}
