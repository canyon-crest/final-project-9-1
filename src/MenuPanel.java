import javax.swing.*;

public class MenuPanel {
	public static void main(String[] args) {
        JFrame frame = new JFrame("Game UI");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        BackgroundPanel panel = new BackgroundPanel("/images/startPlaceholder.png");

        // Example button
        JButton startButton = new JButton("Start Game");

        // Make button blend better with background
        startButton.setFocusPainted(false);

        // Add button to bottom (like a menu bar)
        panel.setLayout(null);
        startButton.setBounds(300, 400, 120, 50);
        panel.add(startButton);

        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}