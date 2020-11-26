package fr.eql.ai108.groupeRMR.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class BinaryTreeInternWriteFile {

	static File interns = new File("C:/Users/Formation/Desktop/inter.bin");
	private static int lengthOfRecord = 260;
	private static int index = 0;
	static Node root;

	private static File writeFile(File fileInterns) {
		File sortedInterns = new File(fileInterns.getParent()+ "/sortedInterns.bin");
		if (sortedInterns.exists()) {
			return sortedInterns;
		}

		FileReader in = null;
		BufferedReader br = null;
		RandomAccessFile raf = null;

		try {
			in = new FileReader(fileInterns);
			br = new BufferedReader(in);
			String line;
			raf = new RandomAccessFile(sortedInterns, "rw");
			long offset = index*lengthOfRecord;

			while (br.ready()) {
				raf.seek(offset);
				line = br.readLine();
				byte[] internsTab = new byte[lengthOfRecord];
				raf.write(internsTab);
				index ++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				in.close();
				raf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return sortedInterns;
	}

	class Node {

		String internString;
		Node left;
		Node right; 
		Node(String internTab) {
			this.internString = internTab;
			right = null;
			left = null;
		}
	}
	
	private Node addRecursive(Node current, String internString) {
		if (current == null) {
			return new Node(internString);
		}
		if (internString.) {
			
		}
		
		return current;
	}

	public static void main(String[] args) {

	}
}
