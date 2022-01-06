import circuitry.api.Circuit;
import circuitry.gates.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
public class Testing {
    private Factory factory = new Factory();
    
     @Test
     public void test1() {
         Circuit circuit = new Circuit(factory.createAndGateWithInputs(factory.createInputBoolean(false), factory.createInputBoolean(true)));
         assertEquals(false, circuit.calculate());
     }
     
     @Test
     public void test2() {
         final InputBoolean input1 = factory.createInputBoolean(false);
         final InputBoolean input2 = factory.createInputBoolean(true);
         Circuit circuit = new Circuit(factory.createAndGateWithInputs(input1, input2));
         assertEquals(false, circuit.calculate());
         
         input1.set(true);
         assertEquals(true, circuit.calculate());
     }
     
     @Test
     public void test3() {
         final InputBoolean input1 = factory.createInputBoolean(true);
         final InputBoolean input2 = factory.createInputBoolean(false);
         final InputBoolean input3 = factory.createInputBoolean(false);
         Circuit circuit = new Circuit(factory.createAndGateWithInputs(input1, factory.createOrGateWithInputs(input2, input3)));
         assertEquals(false, circuit.calculate());
         
         input3.set(true);
         assertEquals(true, circuit.calculate());
     }
     
     
     @Test
     public void hello() {
         Circuit circuit = new Circuit(new InputBoolean(false));
         circuit.hello();
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
//    
//    @BeforeAll
//    public static void setUpClass() {
//    }
//    
//    @AfterAll
//    public static void tearDownClass() {
//    }
//    
//    @BeforeEach
//    public void setUp() {
//    }
//    
//    @AfterEach
//    public void tearDown() {
//    }


}
