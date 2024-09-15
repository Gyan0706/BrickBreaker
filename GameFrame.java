package BrickGame;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class GameFrame extends JFrame {

    public GameFrame() {
        setTitle("Brick Breaker Game");
        setSize(700, 600);
        setResizable(true);
        setLayout(new BorderLayout());
        
        // Create and add the game panel
        GamePanel gamePanel = new GamePanel(); // Initialize the GamePanel
        add(gamePanel, BorderLayout.CENTER);  // Add the GamePanel to the frame
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);  // Make the frame visible
    }

    public static void main(String[] args) {
        new GameFrame();  // Launch the game
    }
}
