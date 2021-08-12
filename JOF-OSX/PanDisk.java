import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class PanDisk extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int nbrePisteParPlateau = 50;
	private int nbreSecteurParPiste = 100;
	private int nbreSecteursOccupes = 0;
	private boolean plateau[][] = new boolean[nbrePisteParPlateau][nbreSecteurParPiste];
	private int numPlateau = 0;
	private boolean busy = false;
	private JProgressBar barre = new JProgressBar();

	public PanDisk(int numPlateau)
	{
		this.numPlateau = numPlateau;
		initialise();
	}
	
	public void initialise()
	{
		for(int j=0; j<50; j++)
		{
			for(int k=0; k<100; k++)
			{
				this.plateau[j][k]=false;
			}
		}			
		this.setBusy(false);
	}
	
	public void paintComponent(Graphics g)
	{
		try
		{
			int capacite = Disk.getCapacite();
			int pourcent = capacite/1000;
			barre.setValue(100-pourcent);
			g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			Image img = ImageIO.read (new File("disk15.jpg"));
			g.drawImage(img, 20, 30, 50, 50, this);
			barre.setSize(300, 20);
			barre.setLocation(80, 50);
			this.add(barre);
			Font font=new Font("Rosewood Std Regular", Font.BOLD,25);
			g.setFont(font);
			g.setColor(Color.black);
			g.drawString("Local Disk (C:)", 80, 40);
			g.setColor(Color.MAGENTA);
			g.fillRect(20,100,500,250);
			for(int i=0; i<50; i++)
			{
				for(int j=0; j<100; j++)
				{
					if(Disk.getDisque().get(this.numPlateau).getPlateau()[i][j])
					{
						g.setColor(Color.BLUE);
						g.fillRect(20 + j*5, 100 + i*5, 5, 5);
					}	
					else
					{
						g.setColor(Color.MAGENTA);
						g.fillRect(20 + j*5, 100 + i*5, 5, 5);						
					}
				}
			}
			for(int i=0; i<50; i++)
			{
				for(int j=0; j<100; j++)
				{
					g.setColor(Color.GRAY);
					g.drawRect(20 + j*5, 100 + i*5, 5, 5);
				}
			}
		}	
		catch(Exception e)
		{
		}		
	}

	public int getNbrePisteParPlateau() {
		return nbrePisteParPlateau;
	}

	public void setNbrePisteParPlateau(int nbrePisteParPlateau) {
		this.nbrePisteParPlateau = nbrePisteParPlateau;
	}

	public int getNbreSecteurParPiste() {
		return nbreSecteurParPiste;
	}

	public void setNbreSecteurParPiste(int nbreSecteurParPiste) {
		this.nbreSecteurParPiste = nbreSecteurParPiste;
	}

	public boolean[][] getPlateau() {
		return plateau;
	}

	public void setPlateau(boolean value, int piste, int secteur) {
		plateau[piste][secteur] = value;
	}	

	public boolean isBusy() {
		return busy;
	}

	public void setBusy(boolean busy) {
		this.busy = busy;
	}

	public int getNumPlateau() {
		return numPlateau;
	}

	public void setNumPlateau(int numPlateau) {
		this.numPlateau = numPlateau;
	}

	public JProgressBar getBarre() {
		return barre;
	}

	public void setBarre(int value) {
		this.barre.setValue(value);
	}

	public void setPlateau(boolean[][] plateau) {
		this.plateau = plateau;
	}

	public int getNbreSecteursOccupes() {
		return nbreSecteursOccupes;
	}

	public void setNbreSecteursOccupes(int nbreSecteursOccupes) {
		this.nbreSecteursOccupes += nbreSecteursOccupes;
	}
}
