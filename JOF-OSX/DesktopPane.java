import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JDesktopPane;
public class DesktopPane extends JDesktopPane
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void paintComponent(Graphics g)
	{
		int k=0;
		try
		{
			Font font=new Font("Lucida Sans", Font.BOLD,15);
			g.setFont(font);
			g.setColor(Color.blue);
			Image img = ImageIO.read (new File("bureau.jpg"));
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			Image icone = ImageIO.read (new File("fichier4.jpg"));
			for(int i=0; i<FilesSystem.getSystemFile().size();i++)
			{
				if(FilesSystem.getSystemFile().get(i).getRepertoire()==0)
				{
					g.drawImage(icone, 50, 50 + k*60, 25, 30, this);
					g.setColor(Color.WHITE);
					g.drawString(FilesSystem.getSystemFile().get(i).getNom(), 35, 100 + k*60);
					k++;
				}
			}
		}
		catch(Exception e)
		{
		}
	}
}