package fr.eql.ai108.groupeRMR.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRomishFile {
	private static int lastNameLength;
	private static int firstNameLength;
	private static int departmentLength;
	private static int promotionLength;
	private static int yearLength;
	
	static Node root;
	static BinaryTreeRomishFile bt = new BinaryTreeRomishFile();
	static List<Intern> interns = new ArrayList<Intern>();

	//création arbre binaire 
	class Node {
		String value;
		Node left;
		Node right;

		Node(String value) {
			this.value = value;
			right = null;
			left = null;
		}

	}

	private Node addRecursive(Node current, String value) {
		if (current == null) {
			return new Node(value);
		}

		if (value.compareTo(current.value)<0) {
			current.left = addRecursive(current.left, value);
		} else if (value.compareTo(current.value)>0) {
			current.right = addRecursive(current.right, value);
		} else {
			//value already exists
			return current;
		}

		return current;
	}

	public void add(String value) {
		root = addRecursive(root, value);
	}

	private static BinaryTreeRomishFile createBinaryTree() {
		
		File binaryFile = new File("C:/Users/formation/Desktop/intern.bin");
		File testFile = new File("C:/Users/formation/Desktop/test.bin");
		RandomAccessFile raf = null;
		FileReader in = null;
		BufferedReader br = null;
		try {
			in = new FileReader(binaryFile);
			br = new BufferedReader(in);			
			raf = new RandomAccessFile(testFile,"rw");
			String line = "";
			while(br.ready()) {
				
				line = br.readLine();
				char[] tableau = line.toCharArray();
				
				raf.write(line.getBytes());
		
				System.out.println(line);
				for( int i = 0 ; i < 260 ; i++)
				{
					raf.seek(260*i);
					line = raf.readLine();
				bt.add(line);
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
				in.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
//		bt.add("Hello");
//		bt.add("Bonjour");
//		bt.add("Demain");
//		bt.add("Pourquoi");
//		bt.add("Méchant");
//		bt.add("Musique");
//		bt.add("Zoo");
//		bt.add("Fléau");
//		bt.add("Yen");
//		bt.add("Aujourd'hui");

		return bt;
	}

	//recherche arbre binaire 
	private static boolean containsNodeRecursive(Node current, String value) {
		if (current == null) {
			return false;
		}
		if (value == current.value) {
			return true;
		}
		return value.compareTo(current.value) >0
				? containsNodeRecursive(current.left, value)
						: containsNodeRecursive(current.right, value);
	}

	public static boolean containsNode(String value) {
		return containsNodeRecursive(root, value);
	}



	public static void traverseInOrder(Node node) {
		if (node != null) {
			traverseInOrder(node.left);
			System.out.print(" " + node.value);
			//methode RAF
			traverseInOrder(node.right);
		}
	}



	public static void write(Node mainNode, PrintWriter w)
	{
		if(mainNode != null){
			write(mainNode.left, w);
			w.print(mainNode);
			write(mainNode.right, w);	
		}
	}


	public static void main(String[] args) {
		createBinaryTree();
		System.out.println(containsNode("3"));
		//traverseInOrder(root);
			}
}
