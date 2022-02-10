package mvc;

import main.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/*
 * This class represents the Controller part in the MVC pattern.
 * Its responsibilities are to listen to the View and responds in an appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {

    public CarController(List<collideable> walls) {
        this.walls = walls;
    }

    // member fields:
    private List<collideable> walls = new ArrayList<>();

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> vehicles = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        List<collideable> walls = new ArrayList<>();

        walls.add(new Wall(700, 0, 10, 600)); // right wall
        walls.add(new Wall(0, 0, 10, 600)); // Left Wall
        walls.add(new Wall(0, 0, 800, 10)); // Top Wall
        walls.add(new Wall(0, 600, 800, 10)); // Bottom Wall

        // Instance of this class
        CarController cc = new CarController(walls);

        cc.vehicles.add(new Volvo240());
        //cc.vehicles.add(new Saab95());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }


    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : vehicles) {
                checkCollision(vehicle, walls);
                vehicle.move();
                int x = (int) Math.round(vehicle.getXCord());
                int y = (int) Math.round(vehicle.getYCord());
                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    private void checkCollision(Vehicle vehicle, List<collideable> collideables){
        for (collideable v: collideables) {
            if (vehicle.isCollision(v)){
                System.out.println("Collision detected");
                vehicle.stopEngine();
                collisionBehavior(vehicle);
                vehicle.startEngine();
            }
        }
    }

    private void collisionBehavior(Vehicle vehicle) {
        if (vehicle.latestCollision.equals(Vehicle.CollisionDir.ABOVE) ||
                vehicle.latestCollision.equals(Vehicle.CollisionDir.BELOW)){

            vehicle.setdY(-vehicle.getdY());
        }
        if (vehicle.latestCollision.equals(Vehicle.CollisionDir.LEFT) ||
                vehicle.latestCollision.equals(Vehicle.CollisionDir.RIGHT)){

            vehicle.setdX(-vehicle.getdX());
        }
    }


    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount / 100);
        for (Vehicle vehicle : vehicles) {
            vehicle.brake(brake);
        }
    }

    void startEngine() {
        for (Vehicle vehicle : vehicles) {
            vehicle.startEngine();
        }
    }

    void stopEngine() {
        for (Vehicle vehicle : vehicles) {
            vehicle.stopEngine();
        }
    }

    void setTurboOn() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getClass().equals(Saab95.class)) {
                ((Saab95) vehicle).setTurboOn();
            }
        }
    }

    void setTurboOff() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getClass().equals(Saab95.class)) {
                ((Saab95) vehicle).setTurboOn();
            }
        }
    }

    void raiseTruckbed() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getClass().equals((Scania.class))) {
                ((Scania) vehicle).raiseTruckBed();
            }
        }
    }
    void lowerTruckBed() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getClass().equals((Scania.class))) {
                ((Scania) vehicle).lowerTruckBed();
            }
        }
    }




}
