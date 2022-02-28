package mvc.view;

import main.UpdateAnimation;
import main.Vehicle;
import mvc.Observer;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SpeedometerPanel extends JPanel{

    CarView view;

    public SpeedometerPanel(int width, int height) {
        initPanel(width, height);
    }

    private void initPanel(int x, int y){
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.ORANGE);
    }

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
