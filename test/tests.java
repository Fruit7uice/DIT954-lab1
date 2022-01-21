import org.junit.Test;
import static org.junit.Assert.*;



public class tests {


    @Test
    public void testEnginePower(){
        Saab95 saab95 = new Saab95();
        Volvo240 volvo240 = new Volvo240();
        assertTrue(volvo240.enginePower < saab95.enginePower);
    }


    













}
