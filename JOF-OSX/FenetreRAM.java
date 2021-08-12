import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;


public class FenetreRAM extends JInternalFrame
 { /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public  FenetreRAM()
	{
		this.setTitle("Mémoire vive");
		this.setSize(600, 400);
		this.setIconifiable(true);
		Icon icone = new ImageIcon("ram2.jpg");
		this.setFrameIcon(icone);
		this.setContentPane(new PanelRAM());
		Bureau.getDesktop().add(this);
		this.setVisible(true);
	}
 }
  