import java.util.ArrayList;

public class Fichier 
{
	private String chemin = "";
	private String nom;
	private int taille = 0;
	private int repertoire = 0;
	private int numPlateau = -1;
	private int numPiste = -1;
	private int numSecteur = -1;
	private ArrayList<Character> caractere = new ArrayList<Character>();
	private boolean inRead = false;
	private boolean inUse = false;
	private int id; 
	private static int k=0;
	private String caracteres="";
	private ArrayList<String> contenu = new ArrayList<String>();
	

	public Fichier()
	{
		
	}

	public Fichier(int repertoire)
	{
		try
		{
			int nbre = (int)(Math.random()*1000000)%1000+50;
			this.id = k;
			if(k==0)
				nbre = 6000;
			this.nom = "fichier" +k;
			this.taille = nbre;//en kilo octets
			this.repertoire = repertoire;
			if(nbre > 0 && k>0)
			{
				int nbre1 = (int)(Math.random()*nbre);
				for(int i = 0; i < nbre1; i++)
				{
					nbre = (int)(Math.random()*26 + 65);
					caractere.add((char)(nbre));
					caracteres += (char)(nbre);
				}				
			}
			k++;
		}
		catch(Exception e)
		{
			
		}
	}
	
	public String getCaracteres() {
		return caracteres;
	}

	public void setCaracteres(String caracteres) {
		this.caracteres = caracteres;
	}

	public Fichier(String nom, int taille)
	{
		this.nom = nom;
		this.taille = taille;
	}
	
	public int getRepertoire()
	{
		return repertoire;
	}

	public void setRepertoire(int repertoire) 
	{
		this.repertoire = repertoire;
	}

	public void supprimer(Fichier file)
	{
		//System.out.println("Le fichier " + file.getNom() + " se trouvant dans "  + " , a ete supprime"); 
		file = null;
	}
	
	public synchronized void setTaille(int nbre)
	{
		this.taille += nbre; 
	}
	
	public synchronized int getTaille()
	{
		return this.taille;
	}
	
	public String getNom()
	{
		return this.nom;
	}
	
	public ArrayList<Character> getCaractere() {
		return caractere;
	}

	public void setCaractere(ArrayList<Character> caractere) {
		this.caractere = caractere;
	}

	public boolean isInRead() 
	{
		return inRead;
	}

	public void setInRead(boolean inRead) 
	{
		this.inRead = inRead;
	}

	public boolean isInUse() 
	{
		return inUse;
	}

	public void setInUse(boolean inUse) 
	{
		this.inUse = inUse;
	}

		public int getId()
	{
		return this.id;
	}
	
	public void setNom(String nom)
	{
		this.nom = nom;
	}	
	public void setFichier(Fichier fichier)
	{
		this.id=fichier.getId();
		this.nom=fichier.getNom();
		this.taille=fichier.getTaille();
		this.caracteres = fichier.getCaracteres();
		this.repertoire = fichier.getRepertoire();
		this.caractere = fichier.getCaractere();
	}

	public String getChemin() {
		return chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	public int getNumPlateau() {
		return numPlateau;
	}

	public void setNumPlateau(int numPlateau) {
		this.numPlateau = numPlateau;
	}

	public int getNumPiste() {
		return numPiste;
	}

	public void setNumPiste(int numPiste) {
		this.numPiste = numPiste;
	}

	public int getNumSecteur() {
		return numSecteur;
	}

	public void setNumSecteur(int numSecteur) {
		this.numSecteur = numSecteur;
	}

	public ArrayList<String> getContenu() {
		return contenu;
	}

	public void setContenu(ArrayList<String> contenu) {
		this.contenu = contenu;
	}
}
