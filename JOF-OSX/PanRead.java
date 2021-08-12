import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


@SuppressWarnings("serial")
public class PanRead extends JPanel
{
	private ArrayList<String> contenu = new ArrayList<String>();
	private ArrayList<JTabbedPane> onglet = new ArrayList<JTabbedPane>();
	
	public void paintComponent(Graphics g)
	{
		int i = 0, j = 0;
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.BLUE);
		g.setFont(new Font("Lucida Sans", Font.BOLD, 20));
		while(i<contenu.size())
		{
			g.drawString(contenu.get(i), 10, 60 + j);
			i++;
			j+=30;
		}
	}

	public ArrayList<String> getContenu() {
		return contenu;
	}

	public void setContenu(ArrayList<String> contenu) {
		this.contenu = contenu;
	}

	public ArrayList<JTabbedPane> getOnglet() {
		return onglet;
	}

	public void setOnglet(ArrayList<JTabbedPane> onglet) {
		this.onglet = onglet;
	}
}
