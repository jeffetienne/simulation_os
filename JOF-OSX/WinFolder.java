import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;

@SuppressWarnings("serial")
public class WinFolder extends JInternalFrame
{
	//private JTree tree;
	private DefaultTreeModel modele;
	private DefaultMutableTreeNode noeud=new DefaultMutableTreeNode("");
	private DefaultMutableTreeNode noeudFils;
	private DefaultMutableTreeNode disk= new DefaultMutableTreeNode("C:\\");
	private JTree tree;
	public static boolean mustUpdate = true;
	 
	public WinFolder()
	{   
		this.setTitle("Systeme de fichiers");
		this.setSize(200, 500);
		try 
		{
			Icon icone = new ImageIcon("folder1.jpg");
			this.setFrameIcon(icone);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		this.setLocation(800, 0);
		this.setResizable(true);
		this.setIconifiable(true);
		rebuild();
		Bureau.getDesktop().add(this);
	}
  
	public void rebuild()
	{ if(mustUpdate)
		{disk.removeAllChildren();
	       for(int i=0;i<FilesSystem.getSystemFolder().size();i++)
			{   if(i>0)
			    { noeud = new DefaultMutableTreeNode(FilesSystem.getSystemFolder().get(i).getNom(),true);
			        
			     }
				for(int j=0;j<FilesSystem.getSystemFile().size();j++)
				{   
					if(FilesSystem.getSystemFile().get(j).getRepertoire()==FilesSystem.getSystemFolder().get(i).getId())
					{
						noeudFils = new DefaultMutableTreeNode(FilesSystem.getSystemFile().get(j).getNom(),false);
						
						if(i>0)noeud.add(noeudFils);
						else disk.add(noeudFils);
					}
				}
				if(i>0) disk.add(noeud);
			}
	       DefaultTreeCellRenderer rendu = new DefaultTreeCellRenderer();
			rendu.setLeafIcon(new ImageIcon("fichier4.jpg"));
			rendu.setClosedIcon(new ImageIcon("dossier4.jpg"));
			rendu.setOpenIcon(new ImageIcon("folder.jpg"));
			tree =new JTree(disk,true);
	        tree.setRootVisible(true);
	        tree.setCellRenderer(rendu);
	        for(int i=0;i<6+FilesSystem.getSystemFile().size();i++)tree.expandRow(i);
			 modele = new DefaultTreeModel(disk);
			 modele.setAsksAllowsChildren(true);
		     this.setContentPane(new JScrollPane(tree));
	   	     this.setVisible(true);
   }
	mustUpdate =false;

	}
}
