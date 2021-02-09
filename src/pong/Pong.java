package pong;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Pong extends Applet implements Runnable, KeyListener {
    final int WIDTH = 700, HEIGHT = 500;
    Thread thread;
    HumanPaddle p1;
    HumanPaddle p2;
    Ball b1;
    boolean gameStarted, gameOver;
    Graphics gfx;
    Image img;

    public void init() {
        this.resize(WIDTH, HEIGHT);
        gameStarted = false;
        this.addKeyListener(this);
        gameOver = false;
        p1 = new HumanPaddle(1);
        p2 = new HumanPaddle(2);
        b1 = new Ball();
        img = createImage(WIDTH, HEIGHT);
        gfx = img.getGraphics();

        thread = new Thread(this);
        thread.start();
    }

    public void paint(Graphics g) {
        gfx.setColor(Color.BLACK);
        gfx.fillRect(0, 0, WIDTH, HEIGHT);
        gfx.setColor(Color.white);
        String p1Score ="PLAYER 1: " + p1.getScore();
        String p2Score ="PLAYER 2: " + p2.getScore();
        gfx.drawString(p1Score, 30,50);
        gfx.drawString(p2Score, 600, 50);
        if (b1.getX() < -10 || b1.getX() > 710) {
            gameOver = true;
            gfx.setColor(Color.WHITE);
            String winner;
            if(p1.getScore()>p2.getScore()){
                winner = "Game over!!!\nPlayer 1 wins";
            }else{
                winner = "Game over!!!\nPlayer 2 wins";
            }
            gfx.drawString(winner, 320, 250);
            gameStarted = false;
        }

        p1.draw(gfx);
        p2.draw(gfx);
        b1.draw(gfx);

        if(!gameStarted){
            gfx.setColor(Color.WHITE);
            gfx.drawString("Pongg", 340, 100);
            gfx.drawString("Press enter to start...", 310, 130);
        }
    g.drawImage(img, 0, 0, this);

    }

    public void update(Graphics g) {
        paint(g);
    }

    public void run() {
        for (; ; ) {

            if (gameStarted && !gameOver) {
                p1.move();
                p2.move();
                b1.move();
                b1.checkForCollision(p1, p2);
            }

            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            p2.setUpAccel(true);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            p2.setDownAccel(true);
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            p1.setUpAccel(true);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            p1.setDownAccel(true);
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            gameStarted = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            p2.setUpAccel(false);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            p2.setDownAccel(false);
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            p1.setUpAccel(false);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            p1.setDownAccel(false);
        }
    }
}
