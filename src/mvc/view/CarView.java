package mvc.view;



import main.Vehicle;
import mvc.Observer;
import main.UpdateAnimation;

import javax.swing.*;
import java.awt.*;
import java.util.List;


/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class CarView extends JFrame implements Observer {
    private static final int X = 850;
    private static final int Y = 850;

    List<Vehicle> vehicles;
    // The controller member
    public DrawPanel drawPanel = new DrawPanel(X, Y-240);

    //Object obj = new Object(); // has a
    //String s = new Object().toString(); // Usage dependecie

    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    public int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");

    public JButton gasButton = new JButton("Gas");

    public JButton brakeButton = new JButton("Brake");
    public JButton turboOnButton = new JButton("Saab Turbo on");
    public JButton turboOffButton = new JButton("Saab Turbo off");
    public JButton liftBedButton = new JButton("Scania Lift Bed");
    public JButton lowerBedButton = new JButton("Lower Lift Bed");
    public JButton addCarButton = new JButton("Add car");
    public JButton removeCarButton = new JButton("Remove car");


    public JButton startButton = new JButton("Start all cars");
    public JButton stopButton = new JButton("Stop all cars");


    SpeedometerPanel speedometerPanel;
    // Constructor
    public CarView(String frameName, UpdateAnimation updateAnimation, List<Vehicle> vs){
        this.vehicles = vs;
        speedometerPanel = new SpeedometerPanel(50, 100);
        speedometerPanel.view = this;
        updateAnimation.addObserver(this);
        initComponents(frameName);
    }

    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);

        // SPEEDOMETER

        this.add(speedometerPanel);

        // ENDING OF SPEEDOMETER

        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(e -> gasAmount = (int) ((JSpinner)e.getSource()).getValue());

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(4,2));


        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.add(addCarButton, 6);
        controlPanel.add(removeCarButton, 7);
        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(stopButton);

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void notifyUpdate(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
        drawPanel.updateVehicleList(vehicles);
        drawPanel.repaint();

        //Speedometer
        updateSpeedometer();

    }

    public void updateSpeedometer() {
        //speedometerPanel.panel.removeAll();
        //speedometerPanel.updateLabels();
        speedometerPanel.repaint();
    }
}