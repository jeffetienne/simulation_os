import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JProgressBar;


public class PanelRAM extends JPanel
	{   private static final long serialVersionUID = 1L;
	    private JProgressBar barre = new JProgressBar();
        private Image img;
		public PanelRAM() 	
			{
			  try 
			  	{
				    img = ImageIO.read (new File("ram.jpg"));
			  	}
			  catch (IOException e)
			  	{
				   e.printStackTrace();
			  	}
			  this.setVisible(true);
			}
		
		public void paintComponent(Graphics g)
			{
			    g.setColor(Color.white);
			    g.fillRect(0, 0, this.getWidth(), this.getHeight());
			    g.drawImage(img, 20, 30, 50, 50, this);
				barre.setSize(300, 20);
				barre.setLocation(80, 50);
				int t = MemoireVive.getEspaceOccupe();
		  		barre.setValue((int)( 100*MemoireVive.getEspaceOccupe()/MemoireVive.getTaille()));
				this.add(barre);
				Font font=new Font("Rosewood Std Regular", Font.BOLD,25);
				g.setFont(font);
				g.setColor(Color.gray);
				g.drawString("RAM", 80, 40);
				g.fillRect(20,100,500,250);
				g.setColor(Color.BLUE);
				for(int i=0; i<50; i++)
				  { for(int j=0; j<100; j++)
					  	{	if(t==0)
					  		g.setColor(Color.MAGENTA);
					  	    g.fillRect(20 + j*5, 100 + i*5, 4, 4);
					  		t--;
					  	}
				  }
			}

	}
