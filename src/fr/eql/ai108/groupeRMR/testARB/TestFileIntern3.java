package fr.eql.ai108.groupeRMR.testARB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TestFileIntern3 {
	static File interns = new File("C:/Users/Formation/Desktop/intern.bin");
public static void main(String[] args) {
	ABR3 abr = new ABR3();
	FileReader in = null;
	BufferedReader br = null;
	String line = null;
	try {
		in = new FileReader(interns);
		br = new BufferedReader(in);
		
		while(br.ready()) {
			line = br.readLine();
			abr.inserer(line);
			
		}
		System.out.println("L'arbre est de hauteur " + abr.hauteur());
	//abr.ecrireListeTriee();
		
		
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
