import java.util.ArrayList;

public  class MemoireVive
{   
	public static ArrayList<Paquet> memoireVive=new ArrayList<Paquet>();
	private static int  espaceOccupe=300;
	private static int taille = 5000;
   public static boolean ChargerProcessus(Processus p)	
    {  boolean rep=false;
	     Paquet pq =new Paquet(0);
	     pq.ChargerPaquet(p.GetIdentite());
			if(espaceOccupe+p.taille<taille)
					  {espaceOccupe+=p.GetTaille();
					   memoireVive.add(pq);
					   rep = true;
					  }
		return rep;
	}
	public static void libererProc(Processus Proc)
	{
		for(int i=0; i<memoireVive.size();i++)
			if(memoireVive.get(i).GetContenu()==Proc.GetIdentite())
			 {    memoireVive.remove(i);
			      espaceOccupe-=Proc.GetTaille();
			      
			 }
	}
	public static int getEspaceOccupe()
	{
		return espaceOccupe;
	}
	public static int getTaille() 
	 {
		return taille;
	 }
}