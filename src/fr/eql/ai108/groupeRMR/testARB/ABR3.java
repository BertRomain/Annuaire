package fr.eql.ai108.groupeRMR.testARB;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ABR3 {
	private NodeOld racine;


	public ABR3() {}

	public ABR3(String nomFichier)  throws IOException {
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
	public 		RandomAccessFile raf = null;
	public String line = "";
	private int lengthOfRecord = 260;
	int index = 0;
	int offset = 0;
	public void ecrireListeTriee(NodeOld rac) {
		offset = index*lengthOfRecord;
		if (rac != null) {
			ecrireListeTriee(rac.getFg());	
			try {
				raf = new RandomAccessFile("C:/Users/Formation/Desktop/test.bin", "rw");							
				while(raf.readLine() != null) {
				raf.readLine();					
				}
				raf.seek(offset);
				raf.writeBytes(rac.getMot()+ "\r");
				index ++;
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println(rac.getMot());
			ecrireListeTriee(rac.getFd());
		}		
	}

	public void ecrireFichierTrie(NodeOld rac) {
		if (rac != null) {
			ecrireFichierTrie(rac.getFg());
//			System.out.println(rac.getMot() + " (" + rac.getNbOcc() + " fois)");
			ecrireFichierTrie(rac.getFd());
		}		
	}
}
