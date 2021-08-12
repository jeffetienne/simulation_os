import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class FenetreOS extends JInternalFrame
   {
      /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea jt ;
      private String text="";
      public FenetreOS(String texte)
      {
    	  this.setTitle("Traitement");
			Icon icone = new ImageIcon("traitement.jpg");
			this.setFrameIcon(icone);
         this.text = texte;
         jt = new JTextArea(text);
         this.setContentPane(new JScrollPane(jt));
         this.setSize(200,200);
         this.setLocation(200, 0);
         this.setResizable(true);
         this.setVisible(true);
         //repainte();
     	//Bureau.getDesktop().add(this);  
      }
      public void setPosition(int p)
      {
      }
      public void setTexte(String s)
      {
    	  this.text=s;
      }
      public void repainte ()
      {    // this.text = "new chiane\n";
           // this.jt.setText(text);
           this.jt.insert(text, 0);
         //  this.jt.repaint();
        //  this.repaint();
      }
   }
