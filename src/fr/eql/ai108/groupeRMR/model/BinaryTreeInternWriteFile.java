package fr.eql.ai108.groupeRMR.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class BinaryTreeInternWriteFile {

	static File interns = new File("C:/Users/Formation/Desktop/inter.bin");
	private static int lengthOfRecord = 260;
	private static int index = 0;
	static Node root;
	static BinaryTreeInternWriteFile bt = new BinaryTreeInternWriteFile();

	private static void writeFile(File interns, Node current) {

		RandomAccessFile raf = null;

		try {
			byte[] b= nodeToByte(current);
			raf = new RandomAccessFile(interns, "w");
			raf.write(b);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				raf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	public static void traverseInOrder(Node node) {
		if (node != null) {
			traverseInOrder(node.left);
			writeFile(interns, node);
			traverseInOrder(node.right);
			writeFile(interns, node);
		}
	}


	private static void readFile(File fileInterns) {

		FileReader in = null;
		BufferedReader br = null;
		RandomAccessFile raf = null;

		try {
			in = new FileReader(fileInterns);
			br = new BufferedReader(in);
			String line;
			raf = new RandomAccessFile(fileInterns, "r");
			long offset = index*lengthOfRecord;

			while (br.ready()) {
				raf.seek(offset);
				line = br.readLine();
				bt.add(line);
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

	private static String nodeToString(Node origin) {
		String nodeValue = origin.toString();
		return nodeValue;
	}
	

	private static byte[] nodeToByte(Node origin) {
		String nodeValue = origin.toString();
		byte[] b = new byte[nodeValue.length()];
		return b;
	}
	
	public static Node addRecursive(Node current, String internString) {

		if (current == null) {
			return new Node(internString);
		}
		if (internString.compareTo(nodeToString(current)) > 0 ) {
			current.left = addRecursive(current.left, internString);
		} else if (internString.compareTo(nodeToString(current)) < 0 ) {
			current.right = addRecursive(current.right, internString);
		} else {
			return current;
		}
		return current;
	}

	public static void add(String internString) {
		root = addRecursive(root, internString);
	}

	public static BinaryTreeInternWriteFile createBinaryTree() {

		readFile(interns);
		
		return bt;

	}



	public static void main(String[] args) {

	}
}
