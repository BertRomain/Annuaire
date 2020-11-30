package fr.eql.ai108.groupeRMR.testARB;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BinaryTreeRomishCopy {
	private Boolean treeEmpty;
	private String mot;
	private int nbOcc = 0;
	private BinaryTreeRomishCopy treeL, treeR;

	public BinaryTreeRomishCopy() {
		treeEmpty = true;
	}

	public BinaryTreeRomishCopy(String nomFichier)  throws IOException {
		this();
		build(nomFichier);	
	}

	public void insert(String mot) {
		if(treeEmpty) {
			treeEmpty = false;
			this.mot = mot;
			nbOcc = 1;
			treeL = new BinaryTreeRomishCopy();
			treeR = new BinaryTreeRomishCopy();
		}
		else if (mot.compareTo(this.mot) < 0) treeL.insert(mot);
		else if (mot.compareTo(this.mot) > 0) treeR.insert(mot);
		else nbOcc ++;
	}
	public void build(String nomFichier) throws IOException {
		Scanner lecteur = new Scanner(new File(nomFichier));		
		while(lecteur.hasNext()) insert(lecteur.next());		
	}
	public void ecrireListeTriee() {
		if (!treeEmpty) {
			treeL.ecrireListeTriee();
			System.out.println(mot + " (" + nbOcc + " fois)");
			treeR.ecrireListeTriee();
		}
	}
	public int hauteur() {
		int hg, hd;
		if (treeEmpty) return -1;
		hg = treeL.hauteur();
		hd = treeR.hauteur();
		if (hg >= hd) return hg + 1;
		return hd + 1;

	}

}
