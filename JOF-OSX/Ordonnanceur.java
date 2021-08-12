public class Ordonnanceur
{   public Ordonnanceur() 
    {
		
    }
		
	public static void Ordonnancer()
	{
		try
		{
			if(ProcessControlBlock.blockProcessus.size()>0) 
			  {    
		       for(int i=0;i<ProcessControlBlock.blockProcessus.size();i++)
		        {
		        	ProcessControlBlock.blockProcessus.get(i).priorite++;
		        }
		       if(ProcessControlBlock.blockProcessus.get(ProcessControlBlock.indiceProcessusElu).compteurOrdinal>=ProcessControlBlock.blockProcessus.get(ProcessControlBlock.indiceProcessusElu).nombreDInstructions-1)
		        {
		    	   arreterProcessus();
		        }
		        if(ProcessControlBlock.blockProcessus.get(ProcessControlBlock.indiceProcessusElu).timer<=0)      
		        {   	 
		        	ProcessControlBlock.blockProcessus.get(ProcessControlBlock.indiceProcessusElu).etat=etatProcessus.PRET;//qu'il passe a l'etar pret
		        	ProcessControlBlock.blockProcessus.get(ProcessControlBlock.indiceProcessusElu).priorite=0;//et que sa priorite devienne 0
		        	ProcessControlBlock.blockProcessus.get(ProcessControlBlock.indiceProcessusElu).timer=ProcessControlBlock.blockProcessus.get(ProcessControlBlock.indiceProcessusElu).periode;
		                 elireProcessus();
		        }
			  }  			
		}
		catch(Exception e)
		{
			
		}
	}
	public static void arreterProcessus()
	{
		ProcessControlBlock.blockProcessus.get(ProcessControlBlock.indiceProcessusElu).etat=etatProcessus.TERMINE;//qu'il passe a l'etar pret
    	MemoireVive.libererProc(ProcessControlBlock.blockProcessus.get(ProcessControlBlock.indiceProcessusElu));
    	ProcessControlBlock.deleteProcessus(ProcessControlBlock.indiceProcessusElu);
    	elireProcessus();
	}
	public static void elireProcessus()
	{  if(ProcessControlBlock.blockProcessus.size()>0)
	   {
		 int PlusGrandePriorite=0;
         int j,positionDansLeBlock=0;
          for(int i=0;i<ProcessControlBlock.blockProcessus.size();i++)//parcours du block des processus
          {     j=ProcessControlBlock.blockProcessus.get(i).priorite;
     	     if(j>PlusGrandePriorite && ProcessControlBlock.blockProcessus.get(i).etat==etatProcessus.PRET)
     	     {
     	    	 PlusGrandePriorite=j;
     	    	 positionDansLeBlock=i;
     	     }
          }
          ProcessControlBlock.blockProcessus.get(positionDansLeBlock).etat=etatProcessus.ELU;
          ProcessControlBlock.indiceProcessusElu=positionDansLeBlock;
            
	   }
	}
	
}
