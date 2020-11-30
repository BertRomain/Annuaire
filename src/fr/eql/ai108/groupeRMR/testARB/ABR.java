package fr.eql.ai108.groupeRMR.testARB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;


public class ABR {
	private NodeOld racine;

	public ABR() {}

	public ABR(String nomFichier)  throws IOException {
		construire(nomFichier);	
	}

	public void inserer(String mot) {
		racine = inserer(racine, mot);
	}

	public NodeOld inserer(NodeOld rac, String mot ) {
		if (rac == null) {
			NodeOld nouveau = new NodeOld(mot);
			return nouveau;
		}
		if (mot.compareTo(rac.getMot()) < 0) rac.setFg(inserer(rac.getFg(), mot));
		else if (mot.compareTo(rac.getMot()) == 0) rac.setNbOcc(rac.getNbOcc() + 1);
		else rac.setFd(inserer(rac.getFd(), mot));
		return rac;
	}

	public void construire(String nomFichier) throws IOException {
		Scanner lecteur = new Scanner(new File(nomFichier));

		while(lecteur.hasNext()) inserer(lecteur.next());
	}

	public int hauteur() {
		return hauteur(racine);
	}

	private int hauteur(NodeOld rac) {
		if (rac == null) return -1;
		int hg = hauteur(rac.getFg());
		int hd = hauteur(rac.getFd());
		if (hg < hd) return hd + 1;
		return hg + 1;
	}

	public void ecrireListeTriee() {
		ecrireListeTriee(racine);
	}

	public void ecrireListeTriee(NodeOld rac) {
		if (rac != null) {
			ecrireListeTriee(rac.getFg());
			System.out.println(rac.getMot() + " (" + rac.getNbOcc() + " fois)");
			ecrireListeTriee(rac.getFd());
		}		
	}
	
	static File interns = new File("C:/Users/Formation/Desktop/intern.bin");
	public void ecrireFichierTrie() {
ecrireFichierTrie(racine, raf);
	}
	RandomAccessFile raf = null;
	public File ecrireFichierTrie(NodeOld rac, RandomAccessFile raf) {
	
		if (interns.exists()) {
			return interns ;
		}
		if (rac != null) {
			try {
				ecrireFichierTrie(rac.getFg(), raf);
				raf.writeBytes(rac.getMot());
				raf.writeBytes("\r\n");
				System.out.println(rac.getMot() + " (" + rac.getNbOcc() + " fois)");
				ecrireFichierTrie(rac.getFd(), raf);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return interns; 
	}
}
