package mvc.view;

import main.UpdateAnimation;
import main.Vehicle;
import mvc.Observer;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SpeedometerPanel extends JPanel{

    //JPanel panel = new JPanel();
    CarView view;
    //GridLayout grid = new GridLayout(3,1);

    public SpeedometerPanel(int width, int height) {
        initPanel(width, height);
    }

    void initPanel(int x, int y){
        //panel.setLayout(grid);
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.ORANGE);
    }

    /*
    void updateLabels(){
         // TODO REMOVES ALL TO FAST FIX THIS
        //panel.removeAll();
        grid.setRows(view.vehicles.size());
        grid.setColumns(1);
        panel.setLayout(grid);
        for (Vehicle v:view.vehicles) {
            JLabel vehicleSpeed = new JLabel(v.modelName + ": " + v.currentSpeed);
            System.out.println(v.currentSpeed);
            panel.add(vehicleSpeed);
        }
        //panel.repaint();

    }

     */

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //updateLabels();
        int y = 10;
        for (Vehicle v: view.vehicles) {
            g.drawString(String.valueOf(v.currentSpeed), 0, y);
            y += 10;
        }
    }


}
