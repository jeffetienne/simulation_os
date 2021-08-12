import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Bureau extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static DesktopPane desktop = new DesktopPane();
	public Bureau() throws IOException
	{
		this.setTitle("Desktop");
		this.setSize(1400, 768);
		this.setResizable(false);
		Image img = ImageIO.read (new File("bureau5.jpg"));
		this.setIconImage(img);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		//Icon icone = new ImageIcon("dos.jpg");
		//this.setIconImage(icone);
		this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){              
                 new JOptionPane();                
                    String[] confirm = {"Oui", "Non"};                
                    int option = JOptionPane.showOptionDialog(null, "Voulez-vous arrêter la simulation ?", "Confirmation d'arrêt de la simulation",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,confirm, confirm[1]);
                    if(option == JOptionPane.YES_OPTION )
                      {
                        System.exit(0);
                      }
                }
              });

		this.getContentPane().add(desktop);
		this.setVisible(true);
	}

	public static DesktopPane getDesktop() 
	{
		return desktop;
	}

	public static void setDesktop(DesktopPane desktop) 
	{
		Bureau.desktop = desktop;
	}
	
}