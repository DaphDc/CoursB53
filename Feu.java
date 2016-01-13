package feuCirculation;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Feu extends JFrame {
	private SurfaceDessin sd;
	private Ecouteur ecouteur;
	private Timer t;
	private Color jaune = new Color(255, 255, 0, 255);
	private Color vert = new Color(0, 255, 0, 255);
	private Color rouge = new Color(255, 0, 0, 255);
	private int compteur = 0;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Feu frame = new Feu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Feu() {
		setBounds(100, 100, 613, 504);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		sd = new SurfaceDessin();
		sd.setSize(200, 250);
		getContentPane().add(sd);
		
	
		ecouteur = new Ecouteur();
	
		t = new Timer(1000, ecouteur);
		t.start();

		
	}
	
	public class SurfaceDessin extends JPanel
	{
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
			
			if(compteur % 3 == 0)
			{
				g2.setColor(jaune);
				g2.fillOval(100, 30, 90, 60);
				g2.setColor(new Color(0, 255, 0, 50));
				g2.fillOval(100, 90, 90, 60);
				g2.setColor( new Color(255, 0, 0, 50));
				g2.fillOval(100, 150, 90, 60);
			
			
			}
			else if (compteur % 3 == 1)
			{
				g2.setColor(vert);
				g2.fillOval(100, 90, 90, 60);
				g2.setColor(new Color(255, 255, 51, 50));
				g2.fillOval(100, 30, 90, 60);
				g2.setColor( new Color(255, 0, 0, 50));
				g2.fillOval(100, 150, 90, 60);
			
		
			}
			else if (compteur % 3 == 2)
			{
				g2.setColor(rouge);
				g2.fillOval(100, 150, 90, 60);
				g2.setColor(new Color(255, 255, 51, 50));
				g2.fillOval(100, 30, 90, 60);
				g2.setColor(new Color(0, 255, 0, 50));
				g2.fillOval(100, 90, 90, 60);
			}
		}
	}
	
	public class Ecouteur implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(arg0.getSource() == t)
			{
				compteur++;
				
				repaint();
			}
			
		}
		
	}
}
