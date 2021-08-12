import java.util.ArrayList;
public class ProcessControlBlock
{  
	static  ArrayList<Processus> blockProcessus=new ArrayList<Processus>();
   public static int indiceProcessusElu=0;
   private static Object [][] contenu=new Object[500][4];
   private static Fenetre pcb = new Fenetre(contenu);
   
   public static void addProcessus(Processus p)
   {
	   blockProcessus.add(p);   
   }
   public static void deleteProcessus(int position)
   {
	   blockProcessus.remove(position);
   }
   public static void afficher()
   { 
	   for (int i=0; i<500;i++)
         {  
	   		contenu [i][0]="";
            contenu [i][1]="";
            contenu [i][2]="";
            contenu [i][3]="";
         }
       for (int i=0; i<blockProcessus.size();i++)
	        {
    	   		contenu [i][0]=blockProcessus.get(i).GetIdentite();
             contenu [i][1]=blockProcessus.get(i).priorite;
             contenu [i][2]=blockProcessus.get(i).etat;
             contenu [i][3]=blockProcessus.get(i).compteurOrdinal;
	        }
       pcb.repaint();
   }
   
}
