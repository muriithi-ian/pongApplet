package pong;

import java.awt.*;

public interface Paddle {
    public void draw(Graphics g);

    public void move();

    public int getY();

    public int getScore();

    public void setScore();

    public void setUpAccel(boolean b);

    public void setDownAccel(boolean b);
}
