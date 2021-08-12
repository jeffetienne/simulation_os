public class affichage  extends Thread
{   
	//private WinFolder fen =new WinFolder() ; 
	public void run()
    {    
		FenetreRAM fr = new FenetreRAM();
		WinFolder fenFolder = new WinFolder();
        //fen.setVisible(true);
		while (true)
        {   
			try 
			{
				sleep(100);
		    } 
			catch (InterruptedException e)
			{
				e.printStackTrace();
		    }
			ProcessControlBlock.afficher();
			fenFolder.rebuild();
			fr.repaint();
        }
    }        
}
