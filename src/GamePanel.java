import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GamePanel extends BackgroundPanel {
	private Image Student;
	private java.util.List<Point> placedStudent = new ArrayList<>();
	private boolean holding = false;
	private Point mousePoint = null;
	
	private Rectangle shop = new Rectangle(40, 450, 60, 60);
	
	public GamePanel(String imagePath) {
		super(imagePath);
		
		Student = new ImageIcon(getClass().getResource("/images/sleeping-kid-clip-art.png")).getImage();
		addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	Point click = e.getPoint();
                if (!holding) {
                	if(shop.contains(click)) {
                		holding = true; // pick up
                	}
                } else {
                    if(!shop.contains(click)) {
                    	placedStudent.add(click); // place
                        holding = false;
                    }
                	
                }
                repaint();
            }
        });
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				mousePoint = e.getPoint();
				repaint();
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(Student, shop.x, shop.y,
                shop.width, shop.height, this);
		
		for (Point p: placedStudent) {
			g.drawImage(Student, p.x - 25, p.y - 25, 50, 50, this);
		}
		
		if (holding && mousePoint!= null) {
			g.drawImage(Student, mousePoint.x-25, mousePoint.y-25, 50, 50, this);
		}
	}
}