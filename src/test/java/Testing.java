import circuitry.elements.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 *
 */
public class Testing {
    private ElementFactory factory = new ElementFactory(API.VERSION);

    @Test
    public void testCreation() {
        Circuit circuit = factory.createCircuit(factory.createInputBoolean(false));
        circuit.hello();
        System.out.println("Success!");
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

        System.out.println("Success!");
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

        System.out.println("Test OR success!");
    }


    @Test
    public void testNotGate() {
        final InputBoolean input1 = factory.createInputBoolean(true);
        Circuit circuit = factory.createCircuit(factory.createNotGateWithInput(input1));
        assertEquals(false, circuit.calculate());

        input1.set(false);
        assertEquals(true, circuit.calculate());
        System.out.println("Success!");
    }
    

    @Test
    public void test3() {
        final InputBoolean input1 = factory.createInputBoolean(true);
        final InputBoolean input2 = factory.createInputBoolean(false);
        final InputBoolean input3 = factory.createInputBoolean(false);
        Circuit circuit = factory.createCircuit(factory.createAndGateWithInputs(input1, factory.createOrGateWithInputs(input2, input3)));
        assertEquals(false, circuit.calculate());

        input3.set(true);
        assertEquals(true, circuit.calculate());
        System.out.println("Success!");
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
            System.out.println("Exception was thrown. This was the desired behaviour");
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
            System.out.println("Exception was thrown. This was the desired behaviour");
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
            Circuit circuit = factory.createCircuit(sig1);
            circuit.calculate();
            fail("Wrong user-input or circuit connections were handled INCORRECTLY");
        } catch (final Exception e) {
            System.out.println("Exception was thrown. This was the desired behaviour");
        }

        System.out.println("Exceptions handled correctly!");
    }


    public Testing() {
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
