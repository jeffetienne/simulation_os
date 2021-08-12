import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Generateur extends Thread 
{  
	private static String chaineG="ki";
	private FenetreOS fenGen = new FenetreOS("Fenetre generateur d'evenement");
	public  void run()
	{   
		int t;
	    int temps=3750;
	    fenGen.setLocation(0,0);
	    fenGen.setTitle("Generateur d'evenement");
		Icon icone = new ImageIcon("generateur1.jpg");
		fenGen.setFrameIcon(icone);
		Bureau.getDesktop().add(fenGen);
		fenGen.setIconifiable(true);
	 while(true)
	   {temps=1450;
	    t= (int) (Math.random()*100)%18+1;
	    if(t>=12&&t<=15) t =11;
	    if(t>=16&&t<=17) t =4;
	    if(t==18)  t =5;
	   
	    interruption in= new interruption(t);
		chaineG=in.getDescription();
		fenGen.setTexte(chaineG + "\n");
		fenGen.getContentPane().repaint();
		fenGen.repainte();
    	tableInterruption.chargerTable(in);
		
		try {
			Generateur.sleep(temps);
			} 
		catch (InterruptedException e) 
		    {
			 e.printStackTrace();
			}
	  }
		
	}
	
}
