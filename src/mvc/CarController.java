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


    private final VehicleBehaviour vehicleBehaviour;
    private List<Positionable> walls;

    public CarController(List<Positionable> walls) {
        this.walls = walls;
        this.vehicleBehaviour = new VehicleBehaviour(vehicles);

    }

    // member fields:


    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    List<Vehicle> vehicles = new ArrayList<>();



    //methods:

    public static void main(String[] args) {
        List<Positionable> walls = new ArrayList<>();

        walls.add(new Wall(750, 0, 1, 600, 0)); // right wall
        walls.add(new Wall(0, 0, 1, 600, 0)); // Left Wall
        walls.add(new Wall(0, 0, 800, 1, 0)); // Top Wall
        walls.add(new Wall(0, 600, 800, 1, 0)); // Bottom Wall

        // Instance of this class
        CarController cc = new CarController(walls);
        cc.vehicles.add(new Volvo240());
        cc.vehicles.add(new Scania());
        cc.vehicles.add(new Saab95());


        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0");


        // Start the timer
        cc.timer.start();
    }


    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {


        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : vehicles) {
                validateCollision(vehicle, walls);
                vehicle.move();
                int x = Math.round(vehicle.getX());
                int y = Math.round(vehicle.getY());
                frame.drawPanel.moveit(vehicle, x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();

            }
        }
    }

    private void validateCollision(Vehicle vehicle, List<Positionable> positionables) {

        if (vehicle.isCollisionWithWalls()) {
            System.out.println("Collision detected");
            vehicle.collisionBehavior(vehicle);
            vehicle.stopEngine();

            vehicle.startEngine();
            System.out.println(vehicle.latestCollision);
        }
    }



    /*
    //TODO THIS IS CONTROLLER BEHAVIOR, CHANGE LATER!

    // This actionListener is for the gas button only
    // TODO: Create more for each component as necessary
        gasButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            vehicleV.gas(gasAmount);
        }
    });

        brakeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            vehicleV.brake(brakeAmount);
        }
    });

        startButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            vehicleV.startEngine();
        }
    });

        stopButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            vehicleV.stopEngine();
        }
    });


        turboOnButton.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            vehicleV.setTurboOn();
        }
    });

        turboOffButton.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            vehicleV.setTurboOff();
        }
    });

        liftBedButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            vehicleV.raiseTruckbed();
        }
    });

        lowerBedButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            vehicleV.lowerTruckBed();
        }
    });

     */


}
