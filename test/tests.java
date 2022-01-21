import org.junit.Test;
import static org.junit.Assert.*;



public class tests {


    @Test
    public void getNrDoorsTest(){
        Volvo240 car = new Volvo240();
        assertTrue(car.getNrDoors() == 4);
    }






}
