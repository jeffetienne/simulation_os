import java.util.ArrayList;

public class FilesSystem
{ 
	private static int nbreFolder = 0;
	private static int nbreFiles = 0;
	private static Fichier file;
	private static Folder dossier;
	private static Folder disque = new Folder("C:/");
	private static Folder bureau = new Folder("Desktop");
	private static Folder documents = new Folder("Documents");
	private static Folder music = new Folder("Music");
	private static Folder images = new Folder("Picture");
	private static Folder video = new Folder("Video");
	private static ArrayList<Fichier> systemFile = new ArrayList<Fichier>();
	private static ArrayList<Folder> systemFolder = new ArrayList<Folder>(); 
	private static ArrayList<Fichier> openedFile = new ArrayList<Fichier>();
	private static ReadFile lireFichier = new ReadFile();
	private static boolean temoin =false;//false pour copie, true pour deplacement
		
	public static void init()
	{
		try
		{    
			systemFolder.add(disque);
			disque.getFolder().add(bureau);
			systemFolder.add(bureau);
		    disque.getFolder().add(documents);
		    systemFolder.add(documents);
		    disque.getFolder().add(images);
		    systemFolder.add(images);
		    disque.getFolder().add(music);
		    systemFolder.add(music);
		    disque.getFolder().add(video);
		    systemFolder.add(video);
		    disque.setId(-1);
		    bureau.setId(0);bureau.setChemin(disque.getNom());
		    documents.setId(1);documents.setChemin(disque.getNom());
		    music.setId(3);music.setChemin(disque.getNom());
		    images.setId(2);images.setChemin(disque.getNom());
		    video.setId(4);video.setChemin(disque.getNom());
		    disque.setRepertoire(-1);
			bureau.setRepertoire(-1);
			documents.setRepertoire(-1);
			images.setRepertoire(-1);
			music.setRepertoire(-1);
			video.setRepertoire(-1);
			file = Traitement_Interruption.creerFile(0);
			file.setNom("JOF_OSX");
			file.setRepertoire(-1);
		    disque.getFichier().add(file);
		    systemFile.add(file);
		    Disk.ajouterFichier(file.getTaille());
		}
		catch(Exception e)
		{
			
		}
	}

	public static void CreerFichier()
	{
		try
		{
			if(Disk.getCapacite() >= 420)
			   {
				    int nbre = (int)(Math.random()*systemFolder.size());
				    System.out.print("nbre=" + nbre);
				    file = Traitement_Interruption.creerFile(nbre);
				 	if(nbre == 0)
					{   
						file.setChemin(disque.getNom());
						file.setRepertoire(-1);
				    	disque.getFichier().add(file);
				    	Traitement_Interruption.chavant = "Creation d'un fichier " + file.getNom() + " de taille " + file.getTaille() + " ko " + " dans " + disque.getNom();
					}
				    else
				    { 
				    	nbre--;
				    	file.setChemin(disque.getFolder().get(nbre).getChemin() + "/" + disque.getFolder().get(nbre).getNom());
				    	file.setRepertoire(nbre);
			    	    disque.getFolder().get(nbre).getFichier().add(file);
			    	    Traitement_Interruption.chavant = "Creation d'un fichier " +  file.getNom() + " de taille " + file.getTaille() +" ko, dans " + disque.getFolder().get(nbre).getNom();
			    	    //if(nbre == 0)
			    	    	Bureau.getDesktop().repaint();
				    }
				   systemFile.add(file);
					Traitement_Interruption.chapres ="Operation reussie";
					WinFolder.mustUpdate =true;
					Disk.ajouterFichier(file.getTaille());
			   }
			else
				Traitement_Interruption.chapres = "Espace memoire restant insuffisant";
		}
		catch(Exception e)
		{
			
		}//*/
		
	}
	
	public void CreerFolder()
	{
		try
		{
			int nbre = (int)(Math.random()*systemFolder.size());
			dossier = new Folder(nbre);
			systemFolder.get(nbre).setNbreFolders(1);
			System.out.println(" Qui contient maintenant " + systemFolder.get(nbre).getNbreFiles() + " Files et " + systemFolder.get(nbre).getNbreFolders() + " Folders.");
			systemFolder.add(dossier);
		}
		catch(Exception e)
		{
			
		}
	}
	
	
	public static boolean copierFile(int fichierSource, int folderDestination)
	{  
		boolean acces=true;
	     try
			{ 
	    	 	if(!systemFile.get(fichierSource).isInUse() || (systemFile.get(fichierSource).isInUse() && !temoin))
	    	 	{
	    	 		if(systemFile.size() > 0 && Disk.getCapacite() >= 420)//size max d'un fichier
	    	 		{
	    	 			Fichier file1 = new Fichier();
	    	 			file1.setFichier(systemFile.get(fichierSource));
				       int id1;
				       int rept1;
				       int id0=file1.getId();
				       int idd=systemFile.get(fichierSource).getRepertoire();
				       Folder RepertoireDestination ;
				       Folder RepertoireSource;
				       if(idd>=0)
				    	    RepertoireSource = disque.getFolder().get(idd);
				       else 
				    	    RepertoireSource = disque;
				       
				       if(folderDestination == 0)
				     	  RepertoireDestination = disque;
				    	
				       else
				       RepertoireDestination = disque.getFolder().get(folderDestination-1);

				    if(!temoin)Traitement_Interruption.chavant ="Copie de "+file1.getNom()+" de "+RepertoireSource.getNom()+" vers "+RepertoireDestination.getNom();
				         else Traitement_Interruption.chavant ="Deplacement de "+file1.getNom()+" de "+RepertoireSource.getNom()+" vers "+RepertoireDestination.getNom();
	                 for(int i = 0; i < systemFile.size(); i++)
					 {  
	                	 id1=systemFile.get(i).getId();
						   rept1=systemFile.get(i).getRepertoire();
						
						   if(id0==id1&&rept1==RepertoireDestination.getId())
						   {
							   Traitement_Interruption.chapres =" Access denied: il existe deja un fichier de meme nom";
							   acces=false;
						   }
					 }
	                 	   
						if(acces==true)
						{   
							if(fichierSource>0)
					        {  
								if(!temoin)
								{ 
									Traitement_Interruption.chapres="operation reussie";
								    WinFolder.mustUpdate =true;
								} 
							    file1.setRepertoire(RepertoireDestination.getId());
							    RepertoireDestination.getFichier().add(file1);
							    file1.setChemin(RepertoireDestination.getChemin() + RepertoireDestination.getNom());
							    systemFile.add(file1);
								Disk.ajouterFichier(file1.getTaille());
					    		//if(RepertoireDestination.getNom()=="Desktop")
					    			Bureau.getDesktop().repaint();
					        }
							   else {acces =false;Traitement_Interruption.chapres ="ACCES FICHIER INTERDIT";}
					}													
			}
		}
		else {Traitement_Interruption.chapres ="ACCES FICHIER INTERDIT. Il est ouvert";acces =false;}
		}
		catch(Exception e)
		{
			
		}
      return acces;
	}
	
	public static void moveFile(int fichierSource, int folderDestination)
	{  
		temoin =true;  
		  if(copierFile( fichierSource, folderDestination) && !systemFile.get(fichierSource).isInRead())
	           delFile(fichierSource);
	     temoin =false;     
	}
	public static ArrayList<Fichier> getSystemFile() {
		return systemFile;
	}

	public static void setSystemFile(ArrayList<Fichier> systemFile) {
		FilesSystem.systemFile = systemFile;
	}

	public static void delFile(int fichier)
	{    
		if(!systemFile.get(fichier).isInRead())   
	    {	
			int idd=systemFile.get(fichier).getRepertoire();
	        System.out.println("oooooo idd="+idd);
            Folder RepertoireSource;
			if(idd>=0)
  	            	RepertoireSource =disque.getFolder().get(idd);
                else 
  	               	RepertoireSource =disque;
     
			    @SuppressWarnings("unused")
				int indexDansRepertoire=0;
			    Fichier fich = systemFile.get(fichier);
			    if(!temoin)Traitement_Interruption.chavant ="suppression du fichier "+fich.getNom()+"qui se trouve dans "+RepertoireSource.getNom();
	 		
			    for(int i = 0; i < RepertoireSource.getFichier().size(); i++)
					{					
						if(RepertoireSource.getFichier().get(i).getId()==fich.getId())
						{
							indexDansRepertoire =i;
						}
					}
			    if(fichier>0)
		    	{
			    	int taille = systemFile.get(fichier).getTaille();
			    	systemFile.remove(fichier);
	//	          		RepertoireSource.getFichier().remove(indexDansRepertoire);
			    		Traitement_Interruption.chapres="operation reussie";
			    		WinFolder.mustUpdate =true;
			    		Disk.supprimerFichier(taille);
			    		//if(rep==0)
			    			Bureau.getDesktop().repaint();
		    	}
			    else Traitement_Interruption.chapres="ACCES FICHIER INTERDIT";
	       }
	      else Traitement_Interruption.chapres="ACCES FICHIER INTERDIT, le fichier est ouvert";
	}
	 	      	
	public static void ouvrirFile()
	{
		try
		{   
			Traitement_Interruption.chavant ="Ouverture d'un fichier";
			if(systemFile.size()>1)
			{
				String ligne = "";
				PanRead pan = new PanRead();
				int nbre=0;
				while (nbre == 0) nbre=(int)(Math.random()*systemFile.size());
				
				Traitement_Interruption.chavant ="Ouverture du fichier " + systemFile.get(nbre).getNom();
				
				if(!systemFile.get(nbre).isInRead())
				{
					systemFile.get(nbre).setInRead(true);
					for(int i = 0; i < systemFile.get(nbre).getCaractere().size()/50; i++)
					{
						for(int j = i*50; j < i*50 + 50; j++)
						{
							ligne = ligne + systemFile.get(nbre).getCaractere().get(j);
							System.out.print(systemFile.get(nbre).getCaractere().get(j));					
						}
						System.out.println("");
						pan.getContenu().add(ligne);
						ligne = "";
					}
					for(int j = systemFile.get(nbre).getCaractere().size() - systemFile.get(nbre).getCaractere().size()%50; j < systemFile.get(nbre).getCaractere().size(); j++)
					{
						ligne = ligne + systemFile.get(nbre).getCaractere().get(j);
						System.out.print(systemFile.get(nbre).getCaractere().get(j));					
					}
					pan.getContenu().add(ligne);
					ligne = "";
					lireFichier.getOnglet().add(systemFile.get(nbre).getChemin() + "/" + systemFile.get(nbre).getNom(), pan);
					openedFile.add(systemFile.get(nbre));
					Traitement_Interruption.chapres ="Operation reussie";
				}				
				else Traitement_Interruption.chapres ="Le fichier est deja ouvert";
			}
			else Traitement_Interruption.chapres = "Il n'y a aucun fichier";
		}
		catch(Exception e)
		{
			
		}
	}
	
	public static void selectFile()
	{
		try
		{   Traitement_Interruption.chavant ="selection d'un fichier";
		
			if(!openedFile.isEmpty())
			{
				int nbre = (int)(Math.random()*openedFile.size());
				for(int i=0; i<systemFile.size();i++)
				{
					if(i != nbre && systemFile.get(i).isInUse())
					{
						systemFile.get(i).setInUse(false);
						lireFichier.getOnglet().getComponent(i).setEnabled(false);
						break;
					}			
				}
				Traitement_Interruption.chavant="Selection du fichier "+openedFile.get(nbre).getNom();
				
				for(int i=0; i<systemFile.size();i++)
				{
					if(systemFile.get(i).getChemin() == openedFile.get(nbre).getChemin() && systemFile.get(i).getNom() == openedFile.get(nbre).getNom())
					{
						systemFile.get(i).setInUse(true);
						break;
					}
				}
				if(!openedFile.get(nbre).isInUse())
				{
					openedFile.get(nbre).setInUse(true);
					lireFichier.getOnglet().getComponent(nbre).setEnabled(true);
					Traitement_Interruption.chapres ="Operation reussie";
				}
				else Traitement_Interruption.chapres ="le fichier est deja selectionne";
			}
		else Traitement_Interruption.chapres ="Aucun fichier ouvert";
		
		}
		catch(Exception e)
		{
			System.out.println("Erreur : " + e.getMessage());
		}
	}
	
	public static void modifierFile()
	{
	try
	  { Traitement_Interruption.chavant = "Modification d'un fichier";
		if(!openedFile.isEmpty())
		{
			String ligne = "";
			PanRead pan = new PanRead();
			int nbre = lireFichier.getOnglet().getSelectedIndex();
			System.out.println("Taille: " + openedFile.get(nbre).getCaractere().size() + "o");
			System.out.println("Contenu: ");
			for(int i = 0; i < openedFile.get(nbre).getCaractere().size()/100; i++)
			{
				for(int j = i*100; j < i*100 + 100; j++)
				{
					System.out.print(openedFile.get(nbre).getCaractere().get(j));					
				}
				System.out.println("");
			}
			for(int j = openedFile.get(nbre).getCaractere().size() - openedFile.get(nbre).getCaractere().size()%100; j < openedFile.get(nbre).getCaractere().size(); j++)
			{
				System.out.print(openedFile.get(nbre).getCaractere().get(j));					
			}
			System.out.println("");
			int indice = (int)(Math.random()*openedFile.get(nbre).getCaractere().size());
			int nbreCar = (int)(Math.random()*10 + 1);
			System.out.println("Indice: " + indice);
			Traitement_Interruption.chavant="Modification du fichier " + openedFile.get(nbre).getNom();
			int lireOuEcrire = (int)(Math.random()*2);
			for(int k=0; k<systemFile.size();k++)
			{
				if(systemFile.get(k).getChemin() == openedFile.get(nbre).getChemin() && systemFile.get(k).getNom() == openedFile.get(nbre).getNom())
				{
					switch(lireOuEcrire)
					{
						case 0:
						{
							int nbre2 = 0;
							char car = 'c';
							for(int i=0; i<nbreCar; i++)
							{
								nbre2 = (int)(Math.random()*26 + 65);
								car = (char)(nbre2);
								systemFile.get(k).getCaractere().add(indice+i, car);
								systemFile.get(k).setTaille(1);
							}
							Disk.modifier(0, nbreCar);
							System.out.println("Ajout du caractere: " + nbre2 + "," + car);
						}break;
						case 1:
						{
							if(systemFile.get(k).getTaille()>=nbreCar)
							{
								try
								{
									System.out.println("Suppression du caractere: " + systemFile.get(k).getCaractere().get(indice));
									for(int i=0; i<nbreCar; i++)
									{
										systemFile.get(k).getCaractere().remove(indice+i);
										systemFile.get(k).setTaille(-1);
									}
									Disk.modifier(1, nbreCar);
								}
								catch(Exception e)
								{
									System.out.println("Erreur : " + e.getMessage());
								}
							}
						}break;
					}
					//Fichier fileAModifier = openedFile.get(nbre);
					lireFichier.getOnglet().removeTabAt(nbre);
					openedFile.remove(nbre);
					System.out.println("Taille: " + systemFile.get(k).getCaractere().size() + "o");
					System.out.println("Contenu: ");
					for(int i = 0; i < systemFile.get(k).getCaractere().size()/50; i++)
					{
						for(int j = i*50; j < i*50 + 50; j++)
						{
							ligne = ligne + systemFile.get(k).getCaractere().get(j);
							System.out.print(systemFile.get(k).getCaractere().get(j));					
						}
						System.out.println("");
						pan.getContenu().add(ligne);
						ligne = "";
					}
					for(int j = systemFile.get(k).getCaractere().size() - systemFile.get(k).getCaractere().size()%50; j < systemFile.get(k).getCaractere().size(); j++)
					{
						ligne = ligne + systemFile.get(k).getCaractere().get(j);
						System.out.print(systemFile.get(k).getCaractere().get(j));					
					}
					pan.getContenu().add(ligne);
					ligne = "";
					lireFichier.getOnglet().insertTab(systemFile.get(k).getChemin() + "/" + systemFile.get(k).getNom(), null, pan, null, nbre);
					openedFile.add(nbre, systemFile.get(k));
					break;
				}
			}
			 Traitement_Interruption.chapres ="operation reussie";
			
		}
		else Traitement_Interruption.chapres ="aucun fichier ouvert";
		
	  }
		catch(Exception e)
		{
			
		}
	}
	
	public static void fermerFile()
	{
		try
		{
			Traitement_Interruption.chavant = "Fermeture d'un fichier";
			if(!openedFile.isEmpty())
			{
				int nbre = (int)(Math.random()*openedFile.size());
				for(int i=0; i<systemFile.size();i++)
				{
					if(systemFile.get(i).getChemin() == openedFile.get(nbre).getChemin() && systemFile.get(i).getNom() == openedFile.get(nbre).getNom())
					{
						systemFile.get(i).setInRead(false); 
						Traitement_Interruption.chavant ="fermeture du fichier " + systemFile.get(i).getNom();	
						break;
					}
				}
				lireFichier.getOnglet().removeTabAt(nbre);
				openedFile.remove(nbre);
			}
			else Traitement_Interruption.chapres ="aucun fichier ouvert";
			
		}
		catch(Exception e)
		{
			System.out.println("Erreur : " + e.getMessage());
		}
	}
	
	public static int getNbreFolder()
	{
		return nbreFolder;
	}
	
	public static int getNbreFiles()
	{
		return nbreFiles;
	}
	
	public static void setNbreFolder(int nbre)
	{
		nbreFolder += nbre;
	}
	
	public static void setNbreFiles(int nbre)
	{
		nbreFiles += nbre;
	}

	
	public static ArrayList<Folder> getSystemFolder()
	{
		// TODO Auto-generated method stub
		return systemFolder;
	}
	public static ReadFile getLireFichier() {
		return lireFichier;
	}
	public static void setLireFichier(ReadFile lireFichier) {
		FilesSystem.lireFichier = lireFichier;
	}

	public static Folder getBureau() {
		return bureau;
	}

	public static void setBureau(Folder bureau) {
		FilesSystem.bureau = bureau;
	}	
}
