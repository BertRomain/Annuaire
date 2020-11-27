package fr.eql.ai108.groupeRMR.testARB;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ABR2 {
	private Node racine;

	public ABR2() {}

	public ABR2(String nomFichier)  throws IOException {
		construire(nomFichier);	
	}

	public void inserer(String mot) {
		racine = inserer(racine, mot);
	}

	public Node inserer(Node rac, String mot ) {
		if (rac == null) {
			Node nouveau = new Node(mot);
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

	private int hauteur(Node rac) {
		if (rac == null) return -1;
		int hg = hauteur(rac.getFg());
		int hd = hauteur(rac.getFd());
		if (hg < hd) return hd + 1;
		return hg + 1;
	}

	public void ecrireListeTriee() {
		ecrireListeTriee(racine);
	}
	public 		RandomAccessFile raf = null;
	public String line = "";
	public void ecrireListeTriee(Node rac) {

		if (rac != null) {
			ecrireListeTriee(rac.getFg());	
			try {
				raf = new RandomAccessFile("C:/Users/Formation/Desktop/test.bin", "rw");							
				while(raf.readLine() != null) {
				raf.readLine();					
				}
				raf.writeBytes(rac.getMot() + "\r\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(rac.getMot());
			ecrireListeTriee(rac.getFd());
		}		
	}

	public void ecrireFichierTrie(Node rac) {
		if (rac != null) {
			ecrireFichierTrie(rac.getFg());
//			System.out.println(rac.getMot() + " (" + rac.getNbOcc() + " fois)");
			ecrireFichierTrie(rac.getFd());
		}		
	}
}
