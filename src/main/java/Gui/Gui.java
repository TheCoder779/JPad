package Gui;

import javax.swing.*;
import java.awt.*;

public class Gui extends JPanel implements Runnable {
    public final int FPS = 60;
    public Thread JPadThread;
    public TextCursor textCursor;
    public int blinkTicks = 30;
    public int blinkTicksCounter = 0;

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
        double delta = 1000000000.0 / FPS;
        double timeLeft = 0;

        while (JPadThread != null) {
            long currentTime = System.nanoTime();
            timeLeft += (currentTime - lastTime) / delta;
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
        if(blinkTicksCounter >= blinkTicks) {
            textCursor.blink();
            blinkTicksCounter = 0;
        }
        else {
            blinkTicksCounter++;
        }
    }
}
