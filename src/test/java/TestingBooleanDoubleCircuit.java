import circuitry.elements.*;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
public class TestingBooleanDoubleCircuit {
    private final ExtendedCircuitryElementFactory factory = new ExtendedCircuitryElementFactory(API.VERSION);


    @Test
    public void testCircuitCreation() {
        AdvancedCircuit circuit = factory.createCircuit(factory.createInputPair(true, true));
        circuit.hello();
        System.out.println("Success (testCreation)!");
    }


    @Test
    public void testAndGateBoolean() {
        final InputPair<?>  input1 = factory.createInputPair(true, false);
        final InputPair<?>  input2 = factory.createInputPair(true, true);
        AdvancedCircuit circuit = factory.createCircuit(factory.createAndGateWithInputs(input1, input2));
        assertEquals(Pair.of(true, false), circuit.calculate());

        input1.set(factory.createInputPair(true, true));
        input2.set(factory.createInputPair(true, true));
        assertEquals(Pair.of(true, true), circuit.calculate());

        try {
            input1.set(factory.createInputPair(false, 0.2));
            input2.set(factory.createInputPair(false, 0.5));
            fail("Exception should have been thrown");
        } catch (Exception e) {
        }
        System.out.println("Success (testAndGateBoolean)!");
    }


    @Test
    public void testAndGateDouble() {
        Pair<Boolean, ?> result;

        final InputPair<?>  input1 = factory.createInputPair(false, 0.6);
        final InputPair<?>  input2 = factory.createInputPair(false, 0.5);
        AdvancedCircuit circuit = factory.createCircuit(factory.createAndGateWithInputs(input1, input2));
         result = circuit.calculate();
        assertEquals(false, result.getLeft());
        assertEquals(0.3, (double) result.getRight(), 0.001);

        input1.set(factory.createInputPair(false, 0.1));
        input2.set(factory.createInputPair(false, 0.1));
         result = circuit.calculate();
        assertEquals(false, result.getLeft());
        assertEquals(0.01, (double) result.getRight(), 0.001);

        try {
            input1.set(factory.createInputPair(true, true));
            input2.set(factory.createInputPair(true, false));
            fail("Exception should have been thrown");
        } catch (Exception e) {
        }
        System.out.println("Success (testAndGateDouble)!");
    }

//
//    @Test
//    public void testOrGate() {
//        final InputPair input1 = factory.createInputPair(false, 0);
//        final InputPair input2 = factory.createInputPair(true, true);
//        BooleanDoubleCircuit circuit = factory.createCircuit(factory.createOrGateWithInputs(input1, input2));
//        assertEquals(true, circuit.calculate());
//
//        input1.set(true);
//        input2.set(true);
//        assertEquals(true, circuit.calculate());
//
//        input1.set(false);
//        input2.set(false);
//        assertEquals(false, circuit.calculate());
//
//        input1.set(true);
//        input2.set(false);
//        assertEquals(true, circuit.calculate());
//
//        System.out.println("Success (testOrGate)!");
//    }
//
//
//    @Test
//    public void testNotGate() {
//        final InputPair input1 = factory.createInputPair(true, true);
//        BooleanDoubleCircuit circuit = factory.createCircuit(factory.createNotGateWithInput(input1));
//        assertEquals(false, circuit.calculate());
//
//        input1.set(false);
//        assertEquals(true, circuit.calculate());
//        System.out.println("Success (testNotGate)!");
//    }
//
//
//    @Test
//    public void testComplexCircuit() {
//        final InputPair a = factory.createInputPair(true, true);
//        final InputPair b = factory.createInputPair(false, 0);
//        final InputPair c = factory.createInputPair(false, 0);
//
//        final Calculatable sig1 = factory.createOrGateWithInputs(a, b);
//        final Calculatable sig2 = factory.createNotGateWithInput(c);
//        final Calculatable sig3 = factory.createAndGateWithInputs(sig1, sig2);
//
//        // circuit = (a or b) and (!c)
//        BooleanDoubleCircuit circuit = factory.createCircuit(sig3);
//
//        assertEquals(true, circuit.calculate());
//
//        c.set(true);
//        assertEquals(false, circuit.calculate());
//        System.out.println("Success (testComplexCircuit)!");
//    }
//
//
//    @Test
//    public void testIfCircuitIsFailSafe1() {
//        try {
//            final InputPair input1 = null;
//            final InputPair input2 = factory.createInputPair(true, true);
//
//            BooleanDoubleCircuit circuit = factory.createCircuit(factory.createAndGateWithInputs(input1, input2));
//            circuit.calculate();
//            fail("Wrong user-input or circuit connections were handled INCORRECTLY");
//        } catch (final Exception e) {
////            System.out.println("Exception was thrown. This was the desired behaviour");
//            System.out.println("Success (testIfCircuitIsFailSafe1)!");
//        }
//    }
//
//
//    @Test
//    public void testIfCircuitIsFailSafe2() {
//        try {
//            final InputPair input1 = factory.createInputPair(false, 0);
//            final InputPair input2 = null;
//
//            BooleanDoubleCircuit circuit = factory.createCircuit(factory.createAndGateWithInputs(input1, input2));
//            circuit.calculate();
//            fail("Wrong user-input or circuit connections were handled INCORRECTLY");
//        } catch (final Exception e) {
////            System.out.println("Exception was thrown. This was the desired behaviour");
//            System.out.println("Success (testIfCircuitIsFailSafe2)!");
//        }
//    }
//
//
//    @Test
//    public void testIfCircuitIsFailSafe3() {
//        try {
//            final InputPair input1 = factory.createInputPair(false, 0);
//            final InputPair input2 = factory.createInputPair(true, true);
//            final Calculatable sig1 = factory.createAndGateWithInputs(input1, input2);
//            final Calculatable sig2 = factory.createNotGateWithInput(null);
//            final Calculatable sig3 = factory.createOrGateWithInputs(sig1, sig2);
//            BooleanDoubleCircuit circuit = factory.createCircuit(sig3);
//            circuit.calculate();
//            fail("Wrong user-input or circuit connections were handled INCORRECTLY");
//        } catch (final Exception e) {
////            System.out.println("Exception was thrown. This was the desired behaviour");
//            System.out.println("Success (testIfCircuitIsFailSafe3)!");
//        }
//    }


    public TestingBooleanDoubleCircuit() {
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
