import javax.swing.*;
import java.awt.*;

public class MainPage {

    // Shared game object
    private static Game game = new Game(5, 9);
    private static Timer timer;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Students Vs Hare");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        CardLayout cardLayout = new CardLayout();
        JPanel container = new JPanel(cardLayout);

        JPanel menuPanel = createMenuPanel(cardLayout, container);
        JPanel gamePanel = createGamePanel();
        JPanel howToPanel = createHowToPanel(cardLayout, container);

        container.add(menuPanel, "Menu");
        container.add(gamePanel, "Game");
        container.add(howToPanel, "Instructions");

        // Show menu first
        cardLayout.show(container, "Menu");

        frame.setContentPane(container);
        frame.setVisible(true);

        // GAME LOOP using Swing Timer
        timer = new Timer(1000, e -> {

            game.gameTick();

            gamePanel.repaint();

        });
        
    }

    private static JPanel createMenuPanel(CardLayout layout, JPanel container) {

        BackgroundPanel panel =
                new BackgroundPanel("/images/startPlaceholder.png");

        panel.setLayout(null);

        JButton startButton = new JButton("Start Game");
        startButton.setBounds(300, 400, 150, 50);

        JButton howToPlayButton = new JButton("How to Play");
        howToPlayButton.setBounds(300, 460, 150, 25);

        // Switch to game screen
        startButton.addActionListener(e -> {

            layout.show(container, "Game");

            timer.start();

        });

        // Placeholder for instructions screen
        howToPlayButton.addActionListener(e -> {
            layout.show(container, "Instructions");
        });

        panel.add(startButton);
        panel.add(howToPlayButton);

        return panel;
    }

    private static JPanel createGamePanel() {

        // Pass the shared game object into GamePanel
        GamePanel panel =
                new GamePanel("/images/grid.png", game);

        panel.setLayout(null);

        JLabel label = new JLabel("Game Started!");
        label.setBounds(20, 20, 200, 30);

        panel.add(label);

        return panel;
    }
    
    private static JPanel createHowToPanel(CardLayout layout,
            JPanel container) 
    {
		BackgroundPanel panel =
		new BackgroundPanel("/images/instructions.png");
		
		panel.setLayout(null);
		
		JLabel title = new JLabel("HOW TO PLAY");
		title.setFont(new Font("Arial", Font.BOLD, 32));
		title.setBounds(250, 50, 300, 50);
		
		JTextArea instructions = new JTextArea(
		"""
		INSERT TEXT LATER
		"""
		);
		
		instructions.setEditable(false);
		instructions.setFont(new Font("Arial", Font.PLAIN, 18));
		instructions.setBounds(150, 150, 500, 200);
		instructions.setOpaque(false);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(20, 20, 100, 40);
		
		backButton.addActionListener(e -> {
		layout.show(container, "Menu");
		});
		
		panel.add(title);
		panel.add(instructions);
		panel.add(backButton);
		
		return panel;
	}
}