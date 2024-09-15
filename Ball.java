package BrickGame;
import java.awt.*;

public class Ball {
    private int x = 350, y = 530;
    private int xDir = -1, yDir = -2;
    private final int size = 20;

    public void move() {
        x += xDir;
        y += yDir;

        // Check for collision with walls
        if (x < 0 || x > 680) xDir = -xDir;  // Left and right walls
        if (y < 0) yDir = -yDir;  // Top wall
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, size, size);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, size, size);  // Ball's hitbox
    }

    public void bounce() {
        yDir = -yDir;  // Bounce the ball (reverse its direction)
    }
}

