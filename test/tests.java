import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;



public class tests {

    @Test
    public void paintjobColor(){
        Saab95 saab95 = new Saab95();
        assertSame(saab95.getColor(), Color.red);
        saab95.setColor(Color.blue);
        assertEquals(Color.blue, saab95.getColor());




    }
    @Test
    public void stopEngineSpeed(){
        Volvo240 volvo240 = new Volvo240();
        volvo240.startEngine();
        volvo240.stopEngine();
        assertEquals(0, volvo240.getCurrentSpeed(), 0.0);
    }

    @Test
    public void controlTurning(){
        Saab95 saab95 = new Saab95();
        saab95.startEngine();
        saab95.gas(1);
        saab95.setdY(0);
        saab95.setdX(1);
        saab95.turnLeft();
        assertTrue(saab95.getdY() == 1 && saab95.getdX() == 0);
        saab95.turnRight();
        assertTrue(saab95.getdY() == 0 && saab95.getdX() == 1);
        saab95.turnRight();
        assertTrue(saab95.getdY() == -1 && saab95.getdX() == 0);
    }




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
        assertEquals(4, car.getNrDoors());
    }

    @Test
    public void speedAfterBrakeTest(){
        Volvo240 volvo240 = new Volvo240();
        Saab95 saab95 = new Saab95();
        volvo240.startEngine();
        saab95.startEngine();
        volvo240.gas(1);
        saab95.gas(1);
        volvo240.brake(0.1);
        saab95.brake(0.1);
        assertTrue(volvo240.currentSpeed == 1.225 && saab95.currentSpeed == 1.225);
    }





}
