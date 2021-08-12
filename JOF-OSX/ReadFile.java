import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;


@SuppressWarnings("serial")
public class ReadFile extends JInternalFrame
{
	private JTabbedPane onglet = new JTabbedPane();
	public ReadFile()
	{
		this.setTitle("JOF Note");
		this.setSize(700,500);
		this.setLocation(400, 0);
		this.setResizable(true);
		try 
		{
			Icon icone = new ImageIcon("fichier.jpg");
			this.setFrameIcon(icone);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//this.setLocationRelativeTo(null);
		this.getContentPane().add(onglet);
		this.setIconifiable(true);
		this.setMaximizable(true);
		this.setVisible(true);		
		Bureau.getDesktop().add(this);
	}
	public JTabbedPane getOnglet() {
		return onglet;
	}
	public void setOnglet(JTabbedPane onglet) {
		this.onglet = onglet;
	}
}
