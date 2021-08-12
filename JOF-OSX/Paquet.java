
public class Paquet
{
 private int idPaquet;
 private String Contenu="";
 public Paquet(int id)
 {
   this.idPaquet= id;
 }
 public void ChargerPaquet(String contenu)
 {
	 this.Contenu = contenu;
 }
 
 public void LibererPaquet()
 {
	 this.Contenu = "";
 }
 public boolean EtatPaquet()
 {
	 boolean rep=false;
	 if (this.Contenu!="")
		 rep =true;
	 return rep;
 }
 public String GetContenu()
 {return this.Contenu;
 }
 
 public int GetIdPaquet()
 {
	 return this.idPaquet;
 }
}
