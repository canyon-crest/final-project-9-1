import javax.swing.*;
import java.awt.*;

public class MainPage {
    public static void main(String[] args) {
        JFrame frame = new JFrame("PvZ Game");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        JPanel container = new JPanel(cardLayout);

        // Create screens
        JPanel menuPanel = createMenuPanel(cardLayout, container);
        JPanel gamePanel = createGamePanel();

        // Add screens to container
        container.add(menuPanel, "Menu");
        container.add(gamePanel, "Game");

        frame.setContentPane(container);
        frame.setVisible(true);
    }
    
    private static JPanel createMenuPanel(CardLayout layout, JPanel container) {
        BackgroundPanel panel = new BackgroundPanel("/images/startPlaceholder.png");
        panel.setLayout(null);

        JButton startButton = new JButton("Start Game");
        startButton.setBounds(300, 400, 150, 50);
        JButton howToPlayButton = new JButton("How to Play");
        howToPlayButton.setBounds(300, 460, 150, 25);

        // switch
        startButton.addActionListener(e -> {
            layout.show(container, "Game");
        });
        
        howToPlayButton.addActionListener(e -> {
        	layout.show(container, "Instructions");
        });

        panel.add(startButton);
        panel.add(howToPlayButton);
        return panel;
    }
    
    private static JPanel createGamePanel() {
        BackgroundPanel panel1 = new BackgroundPanel("/images/grid.png"); // placeholder
        panel1.setLayout(null);
        JLabel label = new JLabel("Game Started!");
        panel1.add(label);

        return panel1;
    }
}