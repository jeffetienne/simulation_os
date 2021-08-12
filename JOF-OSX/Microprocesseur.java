
public class Microprocesseur
{ public static boolean isBusy;
  public Microprocesseur()
  	{
	  
  	}
 
  public static void ArreterProcessus(int ind)
  	{
	  ProcessControlBlock.blockProcessus.get(ind).etat=etatProcessus.TERMINE;
	  MemoireVive.libererProc(ProcessControlBlock.blockProcessus.get(ind));
  	}
  public static void lancerProcessus(Processus p)
  	{
	  p.etat = etatProcessus.PRET;
	  ProcessControlBlock.addProcessus(p);
	}
  public static void bloquerProcessus(int ind)
  	{
	  ProcessControlBlock.blockProcessus.get(ind).etat=etatProcessus.BLOQUE;
	  
  	}
  
  public static boolean getStatut()
  	{
	  return  isBusy;
  	}
  public static void setStatut(boolean b)
  	{
	  isBusy = b;
  	}

 
}