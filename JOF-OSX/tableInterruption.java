import java.util.ArrayList;


public class tableInterruption 
{
  public static ArrayList<interruption> table = new ArrayList<interruption>();
  public synchronized static void chargerTable(interruption inter)
    { 
	  table.add(inter);
	}
  public synchronized static void dechargerTable(int position)
    { 
	  if(position < table.size())
		  table.remove(position);
	}
  
  
}
