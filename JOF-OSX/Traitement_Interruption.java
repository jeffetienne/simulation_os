public class Traitement_Interruption extends Thread 
{   int laps=200;
    private FenetreDos dos = new FenetreDos();
    private FenetreOS fenOS =new FenetreOS("debut");
    public static String chavant;
    public static String chapres;
    public Traitement_Interruption()
	{
		
	}
	public void run()
	{  
		Bureau.getDesktop().add(fenOS);
		fenOS.setIconifiable(true);
		FilesSystem.init();
	  while(true)
	   {  int j=indiceIntElu();
	       fenOS.setTitle("Traitement des interruptions");
	     if(j>=0)
	      {  
	    	 try 
	    	   {   // ch ="Traitement de l'interruption ** "+tableInterruption.table.get(j).getDescription()+" ** :";
	    		 chavant=chapres="";
			    	Traitement(tableInterruption.table.get(j));
			    	fenOS.setTexte(chavant+"**"+chapres+"\n");
			    	fenOS.getContentPane().repaint();
			    	fenOS.repainte();
			    	
			   } 
	    	 catch (InterruptedException e) 
	    	   {
				  // TODO Auto-generated catch block
				  e.printStackTrace();
			   }
	         tableInterruption.dechargerTable(j);
	           }
	     else 
	      {  
	    	 Ordonnanceur.Ordonnancer();
		     if(ProcessControlBlock.blockProcessus.size()>0)
	    	  {if(ProcessControlBlock.blockProcessus.get(ProcessControlBlock.indiceProcessusElu).etat==etatProcessus.ELU)
		    	 {ProcessControlBlock.blockProcessus.get(ProcessControlBlock.indiceProcessusElu).compteurOrdinal++;
		          ProcessControlBlock.blockProcessus.get(ProcessControlBlock.indiceProcessusElu).timer-=laps;
		    	 }
	          }
	      }
		try {
			   Traitement_Interruption.sleep(laps);
			} 
		catch (InterruptedException e) 
		    {
			 e.printStackTrace();
			}
	  }
	}
	public int indiceIntElu()
	{   int pos=-1;
	    int prio=-1;
		for(int i=0;i<tableInterruption.table.size();i++)
		 {
			if(tableInterruption.table.get(i).getPriorite()>prio)
			{ pos=i;
			  prio =tableInterruption.table.get(i).getPriorite();
			}
			
		 }
	   return pos;
	}

	//@SuppressWarnings("static-access")
	public synchronized void Traitement(interruption interruption) throws InterruptedException 
	{   if(ProcessControlBlock.blockProcessus.size()>0)
		   Microprocesseur.bloquerProcessus(ProcessControlBlock.indiceProcessusElu);
	       Microprocesseur.setStatut(true);
	     this.wait(interruption.getTimeExec());
    
		if (interruption.getInterruptionId()==1)
		{   FilesSystem.selectFile();
		}
		if(interruption.getInterruptionId()==2)
		    {  	FilesSystem.modifierFile();
		    }	 
		if(interruption.getInterruptionId()==3) 
		  {  FilesSystem.ouvrirFile();
		  }
		if(interruption.getInterruptionId()==4)
			{   int taille= 20+(int)(Math.random()*1000)%200;
			    chavant = "Chargement du processus P"+Processus.idProcessus;
		        Processus pr = new Processus (1000,taille,"P"+Processus.idProcessus);
			   if(!MemoireVive.ChargerProcessus(pr))
					chapres ="Impossible, Memoire vive insuffisante";
				else {
					  Microprocesseur.lancerProcessus(pr);
				      chapres ="Operation reussie";
				      Processus.idProcessus++;
			         }
			}
		if(interruption.getInterruptionId()==5)
		   {
			FilesSystem.CreerFichier();
		   }
		if(interruption.getInterruptionId()==6)
		{  int source = (int)(Math.random()*FilesSystem.getSystemFile().size());
		   int destination = (int)(Math.random()*FilesSystem.getSystemFolder().size());
		   if(FilesSystem.getSystemFile().size()>0)
			FilesSystem.copierFile(source,destination);
		   else {chavant = "copie d'un fichier"; chapres = "Impossible, il n'y a aucun fichier";}
		}
		if(interruption.getInterruptionId()==7)
		{int nbre;
		  if(FilesSystem.getSystemFile().size()>0)
			  {nbre = (int) (Math.random()*FilesSystem.getSystemFile().size());
			    FilesSystem.delFile(nbre);  
			  }
		  
		  else {chavant = "suppression d'un fichier"; chapres = "Impossible, il n'y a aucun fichier";}
		}
		if(interruption.getInterruptionId()==8)
		{  int source = (int)(Math.random()*FilesSystem.getSystemFile().size());
		   int destination = (int)(Math.random()*FilesSystem.getSystemFolder().size());
		   System.out.println(FilesSystem.getSystemFile().size());
			 if(FilesSystem.getSystemFile().size()>0)
			   FilesSystem.moveFile(source,destination);
			 else if(source!=0){chavant = "deplacement d'un fichier"; chapres = "Impossible, il n'y a aucun fichier";}
		}
		if(interruption.getInterruptionId()==9)
	    { 
	      FilesSystem.fermerFile();
	    }
		if(interruption.getInterruptionId() == 10)
		   { if(ProcessControlBlock.blockProcessus.size()>0)
			   { chavant="Arret du processus "+ProcessControlBlock.blockProcessus.get(ProcessControlBlock.indiceProcessusElu).GetIdentite();
			     Ordonnanceur.arreterProcessus();
			      chapres ="Operation reussie";
			   }
		     else {chavant = "Arret d'un processus"; chapres = "Impossible, il n'y a aucun processus dans la file";}
		   }
		if(interruption.getInterruptionId()==11)
			{int a =(int)(Math.random()*FenetreDos.boutons.size());
			  FenetreDos.boutons.get(a).estPresse =true;
			  dos.updt(a);
			  dos.repaint();
			  Thread.sleep(500);
			  FenetreDos.boutons.get(a).estPresse =false;
			  dos.repaint();
			  chavant = "Appui sur une touche du clavier";
			  chapres = "operation reussie";
			 }
		   Microprocesseur.setStatut(false);
		if(ProcessControlBlock.blockProcessus.size()>0)
			ProcessControlBlock.blockProcessus.get(ProcessControlBlock.indiceProcessusElu).etat=etatProcessus.ELU;
	 }

public static Fichier creerFile(int rep)
 {
	Fichier file = new Fichier(rep);
	FilesSystem.setNbreFiles(1);
	return file;
 }

public static Folder creerFolder(int rep)
 {
	Folder dossier = new Folder(rep);
	FilesSystem.setNbreFolder(1);
	
	return dossier;
 }

public static Fichier creerFile()
 {
	Fichier file = new Fichier();
	return file;
 }

public static Fichier copierFile(Fichier original)
 {
	//Fichier copie = new Fichier(original.getNom(), original.getTaille());
	Fichier copie = original;
	return copie;
 }

public static Folder copierFolder(Folder original)
 {
	//Fichier copie = new Fichier(original.getNom(), original.getTaille());
	Folder copie = original;
	return copie;
 }

public static void ouvrirFile()
 {
	
 }

public static void fermerFile()
 {
	
 }

public static void supprimerFile(Fichier fich)
 {
	fich = null;
	System.gc();
 }

public static void lireFile()
 {
	
 }

public static void ecrireFile()
  {
	
  }

}
