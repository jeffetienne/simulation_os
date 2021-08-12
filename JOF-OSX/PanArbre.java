//import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
//import javax.swing.tree.TreeModel;
public class PanArbre extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<DefaultMutableTreeNode> folder = new ArrayList<DefaultMutableTreeNode>();
	private ArrayList<DefaultMutableTreeNode> file = new ArrayList<DefaultMutableTreeNode>();
//	private DefaultTreeCellRenderer myRenderer = new DefaultTreeCellRenderer();
	
	public PanArbre()
	{
	}
	
	
	public ArrayList<DefaultMutableTreeNode> getFolder() {
		return folder;
	}

	public void setFolder(ArrayList<DefaultMutableTreeNode> folder) {
		this.folder = folder;
	}

	public ArrayList<DefaultMutableTreeNode> getFile() {
		return file;
	}

	public void setFile(ArrayList<DefaultMutableTreeNode> file) {
		this.file = file;
	}
}
