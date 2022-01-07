import circuitry.elements.API;
import circuitry.elements.DualModeCircuit;
import circuitry.elements.InputPair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 *
 */
public class TestingDualModeCircuit {
    private final DualModeCircuitryElementFactory factory = new DualModeCircuitryElementFactory(API.VERSION);


    @Test
    public void testCircuitCreation() {
        DualModeCircuit circuit = factory.createCircuit(factory.createInputPair(true, true));
        circuit.hello();
        System.out.println("Success (testCreation)!");
    }


    @Test
    public void testAndGateBoolean() {
        final InputPair<?> input1 = factory.createInputPair(true, false);
        final InputPair<?> input2 = factory.createInputPair(true, true);
        DualModeCircuit circuit = factory.createCircuit(factory.createAndGateWithInputs(input1, input2));
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

        final InputPair<?> input1 = factory.createInputPair(false, 0.6);
        final InputPair<?> input2 = factory.createInputPair(false, 0.5);
        DualModeCircuit circuit = factory.createCircuit(factory.createAndGateWithInputs(input1, input2));
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


    @Test
    public void testOrGateBoolean() {
        final InputPair<?> input1 = factory.createInputPair(true, false);
        final InputPair<?> input2 = factory.createInputPair(true, true);
        DualModeCircuit circuit = factory.createCircuit(factory.createOrGateWithInputs(input1, input2));
        assertEquals(Pair.of(true, true), circuit.calculate());

        input1.set(factory.createInputPair(true, false));
        input2.set(factory.createInputPair(true, false));
        assertEquals(Pair.of(true, false), circuit.calculate());

        try {
            input1.set(factory.createInputPair(false, 0.2));
            input2.set(factory.createInputPair(false, 0.5));
            fail("Exception should have been thrown");
        } catch (Exception e) {
        }
        System.out.println("Success (testAndGateBoolean)!");
    }


    @Test
    public void testOrGateDouble() {
        Pair<Boolean, ?> result;

        final InputPair<?> input1 = factory.createInputPair(false, 0.6);
        final InputPair<?> input2 = factory.createInputPair(false, 0.5);
        DualModeCircuit circuit = factory.createCircuit(factory.createOrGateWithInputs(input1, input2));
        result = circuit.calculate();
        assertEquals(false, result.getLeft());
        assertEquals(1 - (1 - 0.6) * (1 - 0.5), (double) result.getRight(), 0.001);

        input1.set(factory.createInputPair(false, 0.1));
        input2.set(factory.createInputPair(false, 0.1));
        result = circuit.calculate();
        assertEquals(false, result.getLeft());
        assertEquals(1 - (1 - 0.1) * (1 - 0.1), (double) result.getRight(), 0.001);

        try {
            input1.set(factory.createInputPair(true, true));
            input2.set(factory.createInputPair(true, false));
            fail("Exception should have been thrown");
        } catch (Exception e) {
        }
        System.out.println("Success (testAndGateDouble)!");
    }


    @Test
    public void testNotGateBoolean() {
        final InputPair<?> input1 = factory.createInputPair(true, false);
        DualModeCircuit circuit = factory.createCircuit(factory.createNotGateWithInputs(input1));
        assertEquals(Pair.of(true, true), circuit.calculate());

        input1.set(factory.createInputPair(true, true));
        assertEquals(Pair.of(true, false), circuit.calculate());

        try {
            input1.set(factory.createInputPair(false, 0.2));
            fail("Exception should have been thrown");
        } catch (Exception e) {
        }
        System.out.println("Success (testAndGateBoolean)!");
    }


    @Test
    public void testNotGateDouble() {
        Pair<Boolean, ?> result;

        final InputPair<?> input1 = factory.createInputPair(false, 0.6);
        DualModeCircuit circuit = factory.createCircuit(factory.createNotGateWithInputs(input1));
        result = circuit.calculate();
        assertEquals(false, result.getLeft());
        assertEquals(1 - 0.6, (double) result.getRight(), 0.001);

        input1.set(factory.createInputPair(false, 0.1));
        result = circuit.calculate();
        assertEquals(false, result.getLeft());
        assertEquals(1 - 0.1, (double) result.getRight(), 0.001);

        try {
            input1.set(factory.createInputPair(true, true));
            fail("Exception should have been thrown");
        } catch (Exception e) {
        }
        System.out.println("Success (testAndGateDouble)!");
    }

    @Test
    public void testGteGateBoolean() {
        final InputPair<?> input1 = factory.createInputPair(true, false);
        final InputPair<?> input2 = factory.createInputPair(true, true);

        try {
            DualModeCircuit circuit = factory.createCircuit(factory.createGteGateWithInputs(input1, input2));
            fail("Exception should have been thrown");
        } catch (Exception e) {
        }
        System.out.println("Success (testGteGateBoolean)!");
    }


    @Test
    public void testGteGateDouble() {
        Pair<Boolean, ?> result;

        final InputPair<?> input1 = factory.createInputPair(false, 0.6);
        final InputPair<?> input2 = factory.createInputPair(false, 0.5);
        DualModeCircuit circuit = factory.createCircuit(factory.createGteGateWithInputs(input1, input2));
        result = circuit.calculate();
        assertEquals(false, result.getLeft());
        assertEquals(true, result.getRight());

        input1.set(factory.createInputPair(false, 0.1));
        input2.set(factory.createInputPair(false, 0.1));
        result = circuit.calculate();
        assertEquals(false, result.getLeft());
        assertEquals(true, result.getRight());

        input1.set(factory.createInputPair(false, 0.1));
        input2.set(factory.createInputPair(false, 0.3));
        result = circuit.calculate();
        assertEquals(false, result.getLeft());
        assertEquals(false, result.getRight());

        try {
            input1.set(factory.createInputPair(true, true));
            input2.set(factory.createInputPair(true, false));
            fail("Exception should have been thrown");
        } catch (Exception e) {
        }
        System.out.println("Success (testGteGateDouble)!");
    }

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


    public TestingDualModeCircuit() {
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
