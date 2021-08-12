import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Fenetre extends JInternalFrame
{
	private static final long serialVersionUID = 1L;
	private Object[][] obj = new Object[500][4];
	
	public Fenetre(Object[][] o)
	 {  
		String titre[] ={"ID","Priorite","Etat","C.O"};
	    this.obj = o;
        JTable tableau = new JTable(this.obj,titre);	
	    this.setContentPane(new JScrollPane(tableau));
	    this.setTitle("File des processus");
		this.setSize(200, 300);
		Icon icone = new ImageIcon("processus.jpg");
		this.setFrameIcon(icone);
		this.setLocation (10,210);
		this.setResizable(true);
		this.setIconifiable(true);
		this.setVisible(true);
		Bureau.getDesktop().add(this);
	 }
}
