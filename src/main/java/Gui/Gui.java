package Gui;

import javax.swing.*;
import java.awt.*;

public class Gui extends JPanel implements Runnable {
    public final int FPS = 60;
    public final long DELTA_TIME_MILLIS = (long) (1000.0 / FPS);
    public Thread JPadThread;
    public TextCursor textCursor;

    public Gui(){
        setBounds(0,0,500,500);
        setBackground(Color.WHITE);
        textCursor = new TextCursor();
        JPadThread = new Thread(this);
        JPadThread.start();
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double timeLeft = 0;
        long currentTime;
        while (JPadThread != null) {
            currentTime = System.nanoTime();
            timeLeft += (double) (currentTime - lastTime) / DELTA_TIME_MILLIS;
            lastTime = currentTime;

            while (timeLeft >= 1) {
                update();
                repaint();
                timeLeft--;
            }
        }

    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        textCursor.draw(g2d);
    }

    private void update() {
        textCursor.blink();
    }
}
