package fr.eql.ai108.groupeRMR.testARB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TestFileIntern {
	
	
public static void main(String[] args) {
	File interns = new File("C:/Users/Formation/Desktop/internbis.bin");
	try {
		RandomAccessFile raf = new RandomAccessFile(interns, "rw");
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	ABR abr = new ABR();
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
		abr.ecrireListeTriee();
		abr.ecrireFichierTrie();
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
}
