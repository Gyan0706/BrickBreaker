package BrickGame;
import java.awt.*;

import java.awt.*;

public class Paddle {
    private int x = 300;
    private final int y = 550;
    private final int width = 100;
    private final int height = 12;
    private final int speed = 20;

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, width, height);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public void moveLeft() {
        if (x - speed >= 0) {
            x -= speed;
        }
    }

    public void moveRight() {
        if (x + width + speed <= 700) {
            x += speed;
        }
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }
}
