package BrickGame;
import java.awt.*;

public class Brick {
    private int x, y;
    private boolean visible = true;  // Track if the brick is still present

    public Brick(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        if (visible) {
            g.setColor(Color.BLUE);
            g.fillRect(x, y, 60, 20);
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 60, 20);  // Brick's hitbox
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;  // Set brick visibility to false when it's destroyed
    }
}
