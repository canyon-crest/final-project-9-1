import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GamePanel extends BackgroundPanel {
	private Game game;
	private Image kate;
	private Image yiwen;
	private Image jennifer;
	private Image afina;
	private java.util.List<Point> placedKate = new ArrayList<>();
	private java.util.List<Point> placedYiwen = new ArrayList<>();
	private java.util.List<Point> placedJennifer = new ArrayList<>();
	private java.util.List<Point> placedAfina = new ArrayList<>();
	private int holding = 0;
	private Point mousePoint = null;
	
	private Rectangle kateShop = new Rectangle(40, 450, 60, 60);
	private Rectangle yiwenShop = new Rectangle(100, 450, 60, 60);
	private Rectangle jenniferShop = new Rectangle(160, 450, 60, 60);
	private Rectangle afinaShop = new Rectangle(220, 450, 60, 60);
	private Rectangle shop = new Rectangle(40, 450, 240, 60);
	
	public GamePanel(String imagePath, Game game) {
		super(imagePath);
		this.game = game;
		
		kate = new ImageIcon(getClass().getResource("/images/sleeping-kid-clip-art.png")).getImage();
		yiwen = new ImageIcon(getClass().getResource("/images/sleeping-kid-clip-art.png")).getImage();
		jennifer = new ImageIcon(getClass().getResource("/images/sleeping-kid-clip-art.png")).getImage();
		afina = new ImageIcon(getClass().getResource("/images/sleeping-kid-clip-art.png")).getImage();
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			    Point click = e.getPoint();

			    // Select the image from the shop
			    if (kateShop.contains(click)) {
			        holding = 1;
			    }
			    else if (yiwenShop.contains(click)) {
			        holding = 2;
			    }
			    else if (jenniferShop.contains(click)) {
			        holding = 3;
			    }
			    else if (afinaShop.contains(click)) {
			        holding = 4;
			    }

			    // Place the image outside of the shop
			    else if (!shop.contains(click)) {

			        if (holding == 1) {
			            placedKate.add(click);
			        }
			        else if (holding == 2) {
			            placedYiwen.add(click);
			        }
			        else if (holding == 3) {
			            placedJennifer.add(click);
			        }
			        else if (holding == 4) {
			            placedAfina.add(click);
			        }

			        // Stop holding after placing down the image
			        holding = 0;
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
		
		g.drawImage(kate, kateShop.x, kateShop.y,
                kateShop.width, kateShop.height, this);
		g.drawImage(yiwen, yiwenShop.x, yiwenShop.y,
                yiwenShop.width, yiwenShop.height, this);
		g.drawImage(jennifer, jenniferShop.x, jenniferShop.y,
                jenniferShop.width, jenniferShop.height, this);
		g.drawImage(afina, afinaShop.x, afinaShop.y,
                afinaShop.width, afinaShop.height, this);
		
		
		for (Point p: placedKate) {
			g.drawImage(kate, p.x - 25, p.y - 25, 50, 50, this);
		}
		for (Point p: placedYiwen) {
			g.drawImage(kate, p.x - 25, p.y - 25, 50, 50, this);
		}
		for (Point p: placedJennifer) {
			g.drawImage(kate, p.x - 25, p.y - 25, 50, 50, this);
		}
		for (Point p: placedAfina) {
			g.drawImage(kate, p.x - 25, p.y - 25, 50, 50, this);
		}
		
		if (holding==1 && mousePoint!= null) {
			g.drawImage(kate, mousePoint.x-25, mousePoint.y-25, 50, 50, this);
		}
		if (holding==2 && mousePoint!= null) {
			g.drawImage(yiwen, mousePoint.x-25, mousePoint.y-25, 50, 50, this);
		}
		if (holding==3 && mousePoint!= null) {
			g.drawImage(jennifer, mousePoint.x-25, mousePoint.y-25, 50, 50, this);
		}
		if (holding==4 && mousePoint!= null) {
			g.drawImage(afina, mousePoint.x-25, mousePoint.y-25, 50, 50, this);
		}
	}
}