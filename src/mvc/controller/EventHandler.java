package mvc.controller;

public class EventHandler {


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
}
