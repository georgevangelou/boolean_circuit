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
     @Test
     public void test1() {
         Circuit circuit = new Circuit(new And(new InputBoolean(false), new InputBoolean(true)));
         assertEquals(false, circuit.calculate());
     }
     
     @Test
     public void test2() {
         final InputBoolean input1 = new InputBoolean(false);
         final InputBoolean input2 = new InputBoolean(true);
         Circuit circuit = new Circuit(new And(input1, input2));
         assertEquals(false, circuit.calculate());
         
         input1.set(true);
         assertEquals(true, circuit.calculate());
     }
     
     @Test
     public void test3() {
         final InputBoolean input1 = new InputBoolean(true);
         final InputBoolean input2 = new InputBoolean(false);
         final InputBoolean input3 = new InputBoolean(false);
         Circuit circuit = new Circuit(new And(input1, new Or(input2, input3)));
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
