import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;



public class tests {





    @Test
    public void checkColorOfCars(){
        Volvo240 volvo240 = new Volvo240();
        Saab95 saab95 = new Saab95();
        assertTrue(saab95.getColor() == Color.red && volvo240.getColor() == Color.black);



    }


    @Test
    public void checkEnginePower(){
        Volvo240 volvo240 = new Volvo240();
        Saab95 saab95 = new Saab95();
        assertTrue(saab95.getEnginePower() == 125 && volvo240.getEnginePower() == 100);
    }


    @Test
    public void testEnginePower(){
        Saab95 saab95 = new Saab95();
        Volvo240 volvo240 = new Volvo240();
        assertTrue(volvo240.enginePower < saab95.enginePower);
    }


    @Test
    public void speedAtStart(){
        Volvo240 volvo240 = new Volvo240();
        Saab95 saab95 = new Saab95();
        volvo240.startEngine();
        saab95.startEngine();
        assertTrue(volvo240.currentSpeed == 0.1 && saab95.currentSpeed == 0.1);
    }

    @Test
    public void speedAfterGasing(){
        Volvo240 volvo240 = new Volvo240();
        Saab95 saab95 = new Saab95();
        volvo240.startEngine();
        saab95.startEngine();
        saab95.gas(1);
        volvo240.gas(1);
        assertTrue(volvo240.currentSpeed == 1.35 && saab95.currentSpeed == 1.35);
    }








    @Test
    public void getNrDoorsTest(){
        Volvo240 car = new Volvo240();
        assertTrue(car.getNrDoors() == 4);
    }






}
