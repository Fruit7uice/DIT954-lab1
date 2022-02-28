package mvc.controller;

import mvc.view.CarView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventHandler{

    CarController cc;
    CarView view;
    public EventHandler(CarController cc, CarView view) {
        this.cc = cc;
        this.view = view;
        this.addActionsToButtons();
    }



    private void addActionsToButtons() {

        cc.frame.gasButton.addActionListener(e -> cc.vehicleBehaviour.gas(view.gasAmount));

        cc.frame.brakeButton.addActionListener(e -> cc.vehicleBehaviour.brake(view.gasAmount));

        cc.frame.startButton.addActionListener(e -> cc.vehicleBehaviour.startEngine());

        cc.frame.stopButton.addActionListener(e -> cc.vehicleBehaviour.stopEngine());

        cc.frame.turboOnButton.addActionListener(e -> cc.vehicleBehaviour.setTurboOn());

        cc.frame.turboOffButton.addActionListener(e -> cc.vehicleBehaviour.setTurboOff());

        cc.frame.liftBedButton.addActionListener(e -> cc.vehicleBehaviour.raiseTruckbed());

        cc.frame.lowerBedButton.addActionListener(e -> cc.vehicleBehaviour.lowerTruckBed());

        cc.frame.lowerBedButton.addActionListener(e -> cc.vehicleBehaviour.setTurboOff());

        cc.frame.addCarButton.addActionListener(e -> cc.vehicleBehaviour.addCar());

        cc.frame.removeCarButton.addActionListener(e -> cc.vehicleBehaviour.removeCar());


    }

}
