package pong;

import java.awt.*;

public class HumanPaddle implements Paddle {
    final double GRAVITY = 0.94;
    double y, yVel;
    boolean upAccel, downAccel;
    int player, x;

    public HumanPaddle(int player) {
        y = 210;
        yVel = 0;
        upAccel = false;
        downAccel = false;
        if (player == 1) {
            x = 20;
        } else {
            x = 660;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, (int) y, 20, 80);
    }

    public void move() {
        if (upAccel) {
            yVel -= 2;
        } else if (downAccel) {
            yVel += 2;
        } else if (!upAccel && !downAccel) {
            yVel *= GRAVITY;
        }

        if (yVel >= 5) {
            yVel = 5;
        } else if (yVel <= -5) {
            yVel = -5;
        }
        if (y < 0) {
            y = 0;
        } else if (y > 420) {
            y = 420;
        }
        y += yVel;
    }

    public void setUpAccel(boolean upAccel) {
        this.upAccel = upAccel;
    }

    public void setDownAccel(boolean downAccel) {
        this.downAccel = downAccel;
    }

    public int getY() {
        return (int) y;
    }
}
