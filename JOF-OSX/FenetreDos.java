import java.util.ArrayList;

import javax.swing.JInternalFrame;


public class FenetreDos extends JInternalFrame
{   static ArrayList<String> chaine =new ArrayList<String>();
     static ArrayList<BoutonClavier> boutons  = new ArrayList<BoutonClavier>();

	public FenetreDos()
	{
		this.setSize(530, 600);
		this.setTitle("Dos");
		this.setContentPane(new PanelDos());
		this.setResizable(true);
		Bureau.getDesktop().add(this);
		initialiserClavier();
		this.setVisible(true);
	}
	public void initialiserClavier()
	{
		BoutonClavier b;
		for(int i =0; i<11;i++)
			{
			  b = new BoutonClavier(""+(char)(48+i));
			  boutons.add(b);
			}
		for(int i =1; i<9;i++)
		{
		  b = new BoutonClavier(""+(char)(64+i));
		  boutons.add(b);
		}
		for(int i =0; i<9;i++)
		{
		  b = new BoutonClavier(""+(char)(73+i));
		  boutons.add(b);
		}
		b = new BoutonClavier("-->");
		boutons.add(b);
		for(int i =0; i<10;i++)
		{
		  b = new BoutonClavier(""+(char)(82+i));
		  boutons.add(b);
		}
		for(int i =0; i<4;i++)
		{
		  b = new BoutonClavier(""+(char)(40+i));
		  boutons.add(b);
		}
		b = new BoutonClavier(" ");
		boutons.add(b);
		for(int i =0; i<3;i++)
		{
		  b = new BoutonClavier(""+(char)(45+i));
		  boutons.add(b);
		}
		
	}
	public void updt(int g) 
	{
	  if(g==28) 	
	  {   String ch ="";
		  chaine.add(ch);
	  }
	  else
	  {  String ch="";
	  if(chaine.size()>0)
	  	{
		  int s =chaine.size()-1;
	       
	      if(chaine.get(s).length()<50)
	      { ch = chaine.get(s);
		    chaine.remove(s);
	      }
	   }
		  ch = ch+boutons.get(g).getContenu();
		  chaine.add(ch);
	  }
	}
}
