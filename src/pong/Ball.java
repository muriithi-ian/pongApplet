package pong;

import java.awt.*;

public class Ball {
    double xVel, yVel, x, y;

    public Ball() {
        x = 350;
        y = 250;
        xVel = -2;
        yVel = 1;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval((int) x - 10, (int) y - 10, 20, 20);
    }

    public void move() {
        x += xVel;
        y += yVel;
        if(y<10){
            yVel = -yVel;
        }
        else if(y>490){
            yVel = -yVel;
        }
    }

    public int getX() {
        return (int) x;
    }

    public int getY() {
        return (int) y;
    }
}
