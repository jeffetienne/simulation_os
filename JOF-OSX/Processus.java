
public class Processus
{String identite;
 static int nbreDeProcessus;
 int periode;
 etatProcessus etat;
 int priorite;
 int taille;
 int compteurOrdinal=0;
 int nombreDInstructions;
 int timer=0;
 static int idProcessus=1;
 public Processus(int periode,int taille,String identity)
 { this.taille=taille;
   this.identite=identity;
   this.periode=periode;  
   this.timer=periode;
   this.nombreDInstructions=taille;
 }
 public int GetTaille()
 {
	 return this.taille;
 }
 public String GetIdentite()
 {
	 return this.identite;
 }
 public Processus()
 {
	 
 }
}
