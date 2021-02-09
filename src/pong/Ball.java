package pong;

import java.awt.*;

public class Ball {
    double xVel, yVel, x, y;

    public Ball() {
        x = 350;
        y = 250;
        xVel = getRandomSpeed() * getRandomDirection();
        yVel = getRandomSpeed() * getRandomDirection();
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval((int) x - 10, (int) y - 10, 20, 20);
    }

    public void move() {
        x += xVel;
        y += yVel;
        if (y < 10) {
            yVel = -yVel;
        } else if (y > 490) {
            yVel = -yVel;
        }
    }

    public double getRandomSpeed() {
        return (Math.random() * 3 + 2);
    }

    public int getRandomDirection() {
        int rand = (int) Math.random() * 2;
        if (rand == 1) {
            return 1;
        } else {
            return -1;
        }
    }

    public void checkForCollision(HumanPaddle p1, HumanPaddle p2) {
        if (x <= 50) {
            if (y >= p1.getY() && y <= p1.getY() + 80) {
                xVel = -xVel;
                p1.setScore();
            }
        } else if (x >= 650) {
            if (y >= p2.getY() && y <= p2.getY() + 80) {
                xVel = -xVel;
                p2.setScore();
            }
        }
    }


    public int getX() {
        return (int) x;
    }

    public int getY() {
        return (int) y;
    }
}
