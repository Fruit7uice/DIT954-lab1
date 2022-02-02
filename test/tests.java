import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;


public class tests {
    Saab95 saab95;
    Volvo240 volvo240;

    @Before
    public void setUp(){
        saab95 = new Saab95();
        volvo240 = new Volvo240();
    }

    @Test
    public void setColorTest() {
        assertSame(saab95.getColor(), Color.red);
        saab95.setColor(Color.blue);
        assertEquals(Color.blue, saab95.getColor());
    }

    @Test
    public void stopEngineSpeed() {
        volvo240.startEngine();
        volvo240.stopEngine();
        assertEquals(0, volvo240.getCurrentSpeed(), 0.0);
    }

    @Test
    public void controlTurning() {
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
    public void testMove() {
        volvo240.startEngine();
        volvo240.setxCord(1);
        volvo240.setyCord(1);
        volvo240.setdX(0);
        volvo240.setdY(1);
        volvo240.gas(1);
        volvo240.move();
        System.out.println(volvo240.getxCord());
        System.out.println(volvo240.getyCord());
        assertTrue(volvo240.getxCord() == 1 && volvo240.getyCord() == 2.35);
    }


    @Test
    public void checkColorOfCars() {
        assertTrue(saab95.getColor() == Color.red && volvo240.getColor() == Color.black);


    }


    @Test
    public void checkEnginePower() {
        assertTrue(saab95.getEnginePower() == 125 && volvo240.getEnginePower() == 100);
    }


    @Test
    public void testEnginePower() {
        assertTrue(volvo240.getEnginePower() < saab95.getEnginePower());
    }


    @Test
    public void speedAtStart() {
        volvo240.startEngine();
        saab95.startEngine();
        assertTrue(volvo240.currentSpeed == 0.1 && saab95.currentSpeed == 0.1);
    }

    @Test
    public void speedAfterGasing() {
        volvo240.startEngine();
        saab95.startEngine();
        saab95.gas(1);
        volvo240.gas(1);
        System.out.println(volvo240.currentSpeed);
        assertTrue(volvo240.currentSpeed == 1.35 && saab95.currentSpeed == 1.35);
    }
    @Test
    public void turnRightTest(){
        volvo240.startEngine();
        saab95.startEngine();
        volvo240.setdX(1);
        volvo240.setdY(0);
        saab95.setdX(1);
        saab95.setdY(0);
        volvo240.turnRight();
        saab95.turnRight();
        assertTrue(volvo240.getdX() == 0 && volvo240.getdY() == -1 &&
                saab95.getdX() == 0 && saab95.getdY() == -1);
    }
    @Test
    public void getNrDoorsTest() {
        assertEquals(4, volvo240.getNrDoors());
    }

    @Test
    public void speedAfterBrakeTest() {
        volvo240.startEngine();
        saab95.startEngine();
        volvo240.gas(1);
        saab95.gas(1);
        volvo240.brake(0.1);
        saab95.brake(0.1);
        assertTrue(volvo240.currentSpeed == 1.225 && saab95.currentSpeed == 1.225);
    }

    @Test
    public void scaniaTest(){
        Scania scania = new Scania();
        scania.startEngine();
        if(scania.getTruckBedAngle() == 40){
            assertEquals(0, scania.getCurrentSpeed(), 0.0);
        }
    }




}
