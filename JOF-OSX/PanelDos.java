import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;
public class PanelDos extends JPanel
{
	private static final long serialVersionUID = 1L;
    public void paintComponent(Graphics g)
	{   int k =0;
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.BLACK);
		g.fillRect(10, 10, 500, 300);
		g.setColor(Color.GRAY);
		g.fillRect(10, 320, 500, 230);
		g.setColor(Color.white);
		for(int i =0; i< FenetreDos.chaine.size();i++)g.drawString(FenetreDos.chaine.get(i), 20,20+20*i);
		for(int i=0; i<11; i++)
		{
			g.setColor(Color.DARK_GRAY);
			if(FenetreDos.boutons.get(k).estPresse)g.setColor(Color.BLUE);
			g.fillRect(13 + 45*i, 322, 44, 44);
			g.setColor(Color.WHITE);
			g.drawString(""+(char)(48+i), 28 + 45*i, 340);
			k++;
		}
		g.setColor(Color.DARK_GRAY);
		g.fillRect(13, 367, 66, 44);
		g.setColor(Color.WHITE);
		g.drawString("Shift",28 ,387 );
		for(int i=1; i<9; i++)
		{   g.setColor(Color.DARK_GRAY);
		    if(FenetreDos.boutons.get(k).estPresse)g.setColor(Color.BLUE);
		    g.fillRect(35 + 45*i, 367, 44, 44);
			g.setColor(Color.white);
			g.drawString(""+(char)(64+i), 50 + 45*i, 382);
			k++;
		}
		g.setColor(Color.DARK_GRAY);
		g.fillRect(440, 367, 66, 44);
		g.setColor(Color.white);
		g.drawString("Shift",455 ,387 );
		for(int i=0; i<9; i++)
		{   g.setColor(Color.darkGray);
		if(FenetreDos.boutons.get(k).estPresse)g.setColor(Color.BLUE);
		g.fillRect(13 + 45*i, 412, 44, 44);
			g.setColor(Color.white);
			g.drawString(""+(char)(73+i),28 + 45*i,427);
			k++;
		}
		g.setColor(Color.darkGray);
		if(FenetreDos.boutons.get(k).estPresse)g.setColor(Color.BLUE);
		g.fillRect(418, 412, 88, 44);
		g.setColor(Color.white);
		g.drawString("Enter", 438, 432);
		k++;
		g.setColor(Color.darkGray);
		g.fillRect(13, 457, 66, 44);
		g.setColor(Color.white);
		g.drawString("Caps Lock", 18 , 472);
		for(int i=0; i<9; i++)
		{
			g.setColor(Color.darkGray);
			if(FenetreDos.boutons.get(k).estPresse)g.setColor(Color.BLUE);
			g.fillRect(80 + 45*i, 457, 44, 44);
			g.setColor(Color.white);
			g.drawString(""+(char)(82+i), 95 + 45*i, 472);
			k++;
		}
		
		g.setColor(Color.darkGray);
		if(FenetreDos.boutons.get(k).estPresse)g.setColor(Color.BLUE);
		g.fillRect(440, 457, 66, 44);
		g.setColor(Color.white);
		g.drawString("Z", 455 , 472);
		k++;
		for(int i=0; i<4; i++)
		{
			g.setColor(Color.darkGray);
			if(FenetreDos.boutons.get(k).estPresse)g.setColor(Color.BLUE);
			g.fillRect(13 + 45*i, 502, 44, 44);
			g.setColor(Color.white);
			g.drawString(""+(char)(40+i), 28 + 45*i, 517);
			k++;
		}
		g.setColor(Color.darkGray);
		if(FenetreDos.boutons.get(k).estPresse)g.setColor(Color.BLUE);
		g.fillRect(193, 502, 180, 44);
		g.setColor(Color.white);
		g.drawString("Space", 250 , 522);
		k++;
		for(int i=0; i<3; i++)
		{
			g.setColor(Color.darkGray);
			if(FenetreDos.boutons.get(k).estPresse)g.setColor(Color.BLUE);
			g.fillRect(374 + 45*i, 502, 44, 44);
			g.setColor(Color.white);
			g.drawString(""+(char)(45+i), 390 + 45*i, 517);
			k++;
		}
	}
    
}
