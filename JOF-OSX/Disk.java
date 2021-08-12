import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;


public class Disk extends JInternalFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int nbrePlateaux = 20;
	private static int nbrePlateauxOccupes = 0;
	private static ArrayList<PanDisk> disque = new ArrayList<PanDisk>();
	private static int sizeSecteur = 1024;
	private static int capacite = 0;
	private static JTabbedPane onglet = new JTabbedPane();
	
	public Disk()
	{
		for(int i=0; i<nbrePlateaux; i++)
		{
			disque.add(new PanDisk(i));
			onglet.add("Plateau No " + i,disque.get(i));
		}
		capacite=nbrePlateaux*50*100;//en kilo octets
		this.setTitle("Disque dur");
		this.setSize(600, 500);
		this.setLocation(100, 200);
		Icon icone = new ImageIcon("Disk10.jpg");
		this.setFrameIcon(icone);
		this.setResizable(true);
		this.getContentPane().add(onglet);
		this.setIconifiable(true);
		Bureau.getDesktop().add(this);
		this.setVisible(true);
	}
	
	public static void ajouterFichier(int taille)
	{
		try
		{
			if(capacite>taille)
			{
	    		onglet.getComponent(3).setEnabled(true);
				capacite-=taille;
				for(int i=0; i<Disk.getDisque().size(); i++)
			    {
			    	if(!Disk.getDisque().get(i).isBusy())
			    	{
			    		for(int j=0; j<50; j++)
			    		{
			    			for(int k=0; k<100; k++)
			    			{
			    				if(!Disk.getDisque().get(i).getPlateau()[j][k])
			    				{
			    					Disk.getDisque().get(i).getPlateau()[j][k]=true;
			    					taille--;
			    					Disk.getDisque().get(i).setNbreSecteursOccupes(1);
			    					if(taille<=0 && (k+1)%4==0)
			    					{
			    						k=100;j=50;i=Disk.getDisque().size();
			    					}
			    				}
			    				Disk.getDisque().get(i).repaint();
			    			}
			    		}
			    		if(Disk.getDisque().get(i).getPlateau()[49][99])
			    		{
			    			Disk.getDisque().get(i).setBusy(true);
			    			nbrePlateauxOccupes++;
			    		}
			    	}
			    }
			}			
		}
		catch(Exception e)
		{
			
		}
	}

	public static void supprimerFichier(int taille)
	{
		try
		{   int cap=capacite;
		    cap+=taille;
			for(int i=0; i<disque.size(); i++)
			{
				disque.get(i).initialise();
			}
            capacite=100000;
			ajouterFichier(100000-cap);
		}
		catch(Exception e)
		{
			
		}
	}
	
	public static void modifier(int lireOuEcrire, int nbreCar)
	{
		if(lireOuEcrire == 0)
		{
			ajouterFichier(nbreCar);
		}

		if(lireOuEcrire == 1)
		{
			supprimerFichier(nbreCar);
		}
	}
	
	public static int getCapacite() 
	{
		return capacite;
	}

	public static void setCapacite(int capacite) 
	{
		Disk.capacite += capacite;
	}

	public static int getNbrePlateaux() {
		return nbrePlateaux;
	}

	public static void setNbrePlateaux(int nbrePlateaux) {
		Disk.nbrePlateaux = nbrePlateaux;
	}

	public static int getSizeSecteur() {
		return sizeSecteur;
	}

	public static void setSizeSecteur(int sizeSecteur) {
		Disk.sizeSecteur = sizeSecteur;
	}
	
	public static int getNbrePlateauxOccupes() {
		return nbrePlateauxOccupes;
	}
	
	public static void setNbrePlateauxOccupes(int nbrePlateauxOccupes) {
		Disk.nbrePlateauxOccupes = nbrePlateauxOccupes;
	}
	
	public static ArrayList<PanDisk> getDisque() {
		return disque;
	}
	
	public static void setDisque(ArrayList<PanDisk> disque) {
		Disk.disque = disque;
	}

	public static JTabbedPane getOnglet() {
		return onglet;
	}

	public static void setOnglet(JTabbedPane onglet) {
		Disk.onglet = onglet;
	}
}