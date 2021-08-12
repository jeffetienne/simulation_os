public class interruption 
{  
	private int interruptionId;
	private int priorite;
	private int timeExec;
	private String description;
    public interruption(int id)
      {
	     this.interruptionId=id;
	     this.priorite=attribuerPriorite();
	     this.timeExec=attribuerTempsExec();
	     this.description=attribuerDescription();
      }
	public int attribuerPriorite()
	  {
		
		int prior=0;
		switch(interruptionId)
		{
	       case 1: prior=6;break;
	       case 2: prior=15;break;
	       case 3: prior=3;break;
	       case 4: prior=7;break;
	       case 5: prior=10;break;
	       case 6: prior=9;break;
	       case 7: prior=11;break;
	       
		}
		return prior;
	 }
	public int attribuerTempsExec()
	  { int temps=500;
		switch(interruptionId)
		{
	       case 1: temps=500;break;
	       case 2: temps=600;break;
	       case 3: temps=100;break;
	       case 4: temps=750;break;
	       case 5: temps=800;break;
	       case 6: temps=600;break;
	       case 7: temps=560;break;
	       case 8: temps=100;break;
	       case 9: temps=720;break;
	       case 10: temps=400;break;
	       case 11: temps=300;break;
	       
		}
		
		return temps;
	 }
	
	public String attribuerDescription()
	  { String desc="";
		switch(interruptionId)
		{
	       case 1: desc="Selection d'un Fichier";break;
	       case 2: desc="Modification d'un Fichier";break;
	       case 3: desc="Ouverture d'un Fichier";break;
	       case 4: desc="Lancement d'un Processus";break;
	       case 5: desc="Creation d'un Fichier";break;
	       case 6: desc="Copie d'un Fichier";break;
	       case 7: desc="Suppression d'un Fichier";break;
	       case 8: desc="Deplacement d'un fichier";break;
	       case 9: desc="Fermeture d'un Fichier";break;
	       case 10:desc="Arret d'un processus";break;
	       case 11:desc="Appui sur une touche du clavier";break;
		}
		
		return desc;
	 }
	public String getDescription()
	    {
		    return this.description;
	    }
	public int getInterruptionId() {
		return interruptionId;
	}
	public void setInterruptionId(int interruptionId) {
		this.interruptionId = interruptionId;
	}
	public int getPriorite() {
		return priorite;
	}
	public void setPriorite(int priorite) {
		this.priorite = priorite;
	}
	public int getTimeExec() {
		return timeExec;
	}
	public void setTimeExec(int timeExec) {
		this.timeExec = timeExec;
	}
}
