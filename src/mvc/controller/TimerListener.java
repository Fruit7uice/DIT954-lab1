package mvc.controller;

import main.Vehicle;
import mvc.Observer;
import mvc.view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TimerListener implements Observer {

    List<Observer> observers = new ArrayList<Observer>();
    CarController controller;
    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    //DrawPanel drawPanel;

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener(controller));

    public TimerListener(CarController controller) {
        this.controller = controller;
        this.frame = controller.frame;
        //this.drawPanel = frame.drawPanel;
    }

    public void actionPerformed() {
        for (Vehicle vehicle : controller.vehicles) {
            controller.validateCollision(vehicle, controller.walls);
            vehicle.move();
            int x = Math.round(vehicle.getX());
            int y = Math.round(vehicle.getY());
            frame.drawPanel.moveit(vehicle, x, y);
            // repaint() calls the paintComponent method of the panel
            //frame.drawPanel.repaint();

        }
    }

    @Override
    public void notifyListeners() {

    }

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    private void notifyObservers() {
        for (Observer o:observers) {
            o.notifyListeners();
        }
    }


}





