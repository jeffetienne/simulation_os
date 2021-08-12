import java.io.IOException;


public class ClassePrincipale
{
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException
	   {
		Bureau desk = new Bureau();
		Disk disque = new Disk();
		FenetreDos dos = new FenetreDos();
		Generateur g = new Generateur();
		Traitement_Interruption tr= new Traitement_Interruption();
		affichage af =new affichage();
		g.start(); 
		tr.start();
		af.start();
	   }
}
