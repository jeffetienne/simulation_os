import java.util.ArrayList;
public class Folder 
{	
	private String chemin = "";
	private String nom;
	private int id;
	private int taille = 0;
	private int nbreFiles = 0;
	private int nbreFolders = 0;
	private int repertoire = 0;
	private static int c=0;
	private ArrayList<Folder> folder = new ArrayList<Folder>();
	private ArrayList<Fichier> fichier = new ArrayList<Fichier>();
	public ArrayList<Folder> getFolder()
	 {
		return folder;
	 }

	public void setFolder(Folder fold)
	 {
		this.id = fold.id;
		this.nom =fold.nom;
		this.repertoire = fold.getRepertoire();
		Fichier fich =new Fichier();
		for(int i =0; i < fold.getFichier().size();i++)
		{    fich.setFichier(fold.getFichier().get(i));
			 this.fichier.add(fich);
		}
		Folder fol= new Folder();
		for(int j=0;j<this.folder.size();j++)
		{
			fol.setFolder(fold.getFolder().get(j));
			this.folder.add(fol);
		}
	 }
    public void setId(int ID)
    {
    	this.id=ID;
    }
    public int getId()
    {
    	return this.id;
    }
	public ArrayList<Fichier> getFichier()
	 {
		return fichier;
	 }

	public void setFichier(ArrayList<Fichier> fichier) 
	 {
		this.fichier = fichier;
	 }

	
	public Folder()
	 {
		
	 }
	
	public Folder(int repertoire)
	 {
		try
		{	this.id= c;		
			this.nom = "Rep" +c; 
			this.taille = 0; 
			this.nbreFiles = 0; 
			this.nbreFolders = 0;
			this.repertoire = repertoire;
			c++;
		}
		catch(Exception e)
		{
			
		}
	}

	public Folder(String nom)
	{
		this.nom = nom;
		//FilesSystem.setNbreFolder(1);
	}
	
	public Folder(String nom, int adresse)
	{
		this.nom = nom;
		this.repertoire = adresse;
	}
	
	public void supprimer(Fichier file)
	{
		//System.out.println("Le fichier " + file.getNom() + " qui contenait " + (file.getNFileParFolder()+ file.getNFolderParFolder()) + " elements: " + file.getNFileParFolder() + " fichiers et " + file.getNFolderParDisk() + " dossiers, a ete supprime"); 
		file = null;
	}
			
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public int getNbreFiles() {
		return nbreFiles;
	}

	public void setNbreFiles(int nbreFiles) {
		this.nbreFiles += nbreFiles;
	}

	public int getNbreFolders() {
		return nbreFolders;
	}

	public void setNbreFolders(int nbreFolders) {
		this.nbreFolders += nbreFolders;
	}
	/*
	public ArrayList<Folder> getAdresse() {
		return adresse;
	}

	public void setAdresse(ArrayList<Folder> adresse) {
		this.adresse = adresse;
	}

	public ArrayList<Fichier> getDossierFile() {
		return dossierFile;
	}

	public void setDossierFile(Fichier file) {
		this.dossierFile.add(file);
		this.setNbreFiles(1);
	}

	public ArrayList<Folder> getDossierFolder() {
		return dossierFolder;
	}

	public void setDossierFolder(Folder dossier) {
		this.dossierFolder.add(dossier);
		this.setNbreFolders(1);
	}//*/

	public int getRepertoire() {
		return repertoire;
	}

	public void setRepertoire(int repertoire) {
		this.repertoire = repertoire;
	}

	public void supprimer()
	{
		
	}

	public String getChemin() {
		return chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}
}
