package fr.eql.ai108.groupeRMR.testARB;

import java.io.IOException;

public class TestABR {
	public static void main(String[] arg) {
		ABR abr = new ABR();
		abr.inserer("Patrick");
		abr.inserer("Jean-Claude");
		abr.inserer("Ada");
		abr.inserer("Laurent");
		abr.inserer("Fabrice");
		abr.ecrireListeTriee();
		System.out.println("L'arbre est de hauteur " + abr.hauteur());
		
		System.out.println("\nNouvel arbre");
		try {
			abr = new ABR(arg[0]);
			abr.ecrireListeTriee();
			System.out.println("L'arbre est de hauteur " + abr.hauteur());
		}
		catch(IOException exc) {
			System.out.println("Fichier " + arg[0] + " inexistant ou non correct");
		}
		
	}
}
