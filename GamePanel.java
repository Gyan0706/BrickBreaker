package BrickGame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
    private Paddle paddle;
    private Ball ball;
    private Brick[] bricks;
    private boolean gameOver = false;
    private int score = 0;
    private Image backgroundImage;

    public GamePanel() {
        paddle = new Paddle();
        ball = new Ball();
        bricks = new Brick[30];
        for (int i = 0; i < 30; i++) {
            bricks[i] = new Brick((i % 10) * 70 + 50, (i / 10) * 30 + 50);
        }

        ImageIcon imgIcon = new ImageIcon("E:\\Music-Player\\bg10.jpeg");
        backgroundImage = imgIcon.getImage();

        Timer timer = new Timer(10, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);

        // Add a component listener to adjust game elements when resized
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                repaint();
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image scaled to fit the panel
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

        if (!gameOver) {
            paddle.draw(g);
            ball.draw(g);
            for (Brick brick : bricks) {
                brick.draw(g);
            }

            g.setColor(Color.BLACK);
            g.drawString("Score: " + score, getWidth() - 100, 30);
        } else {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Game Over! Score: " + score, getWidth() / 2 - 150, getHeight() / 2);
        }

        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            ball.move();

            if (ball.getBounds().intersects(paddle.getBounds())) {
                ball.bounce();
            }

            for (Brick brick : bricks) {
                if (brick.isVisible() && ball.getBounds().intersects(brick.getBounds())) {
                    ball.bounce();
                    brick.setVisible(false);
                    score += 10;
                }
            }

            if (ball.getBounds().y > getHeight() - 20) {
                gameOver = true;
            }

            repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            paddle.moveLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            paddle.moveRight();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}
}
