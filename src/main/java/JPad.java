import Gui.Gui;

import javax.swing.*;
import java.awt.*;

public class JPad extends JFrame {
    public final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    public final double SCREEN_WIDTH = SCREEN_SIZE.getWidth();
    public final double SCREEN_HEIGHT = SCREEN_SIZE.getHeight();
    public final int STARTUP_SIZE = 600;

    public JPad() {
        super("JPad");
        setLocation((int) (SCREEN_WIDTH - STARTUP_SIZE) / 2, (int) (SCREEN_HEIGHT - STARTUP_SIZE) / 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(STARTUP_SIZE, STARTUP_SIZE);
        setPreferredSize(new Dimension(STARTUP_SIZE, STARTUP_SIZE));
        setResizable(true);
        add(new Gui());
    }
}
