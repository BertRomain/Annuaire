package fr.eql.ai108.groupeRMR.testARB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Comparator;

​public class NewBinaryTree {

	static File interns = new File("C:/Users/Formation/Desktop/intern.bin");
	//	private static int lengthOfRecord = 260;
	//	private static int index = 0;
	static Node root;
	static NewBinaryTree bt = new NewBinaryTree();

	private static void writeFile(File interns, Node current) {

		RandomAccessFile raf = null;

		try {
			byte[] b= nodeToByte(current);
			raf = new RandomAccessFile(interns, "rw");
			raf.write(b);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public static void traverseInOrder(Node node) {

		if (node != null) {
			traverseInOrder(node.left);
			writeFile(interns, node);
			System.out.println(nodeToString(node));
			traverseInOrder(node.right);
			writeFile(interns, node);
			System.out.println(nodeToString(node));
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
			raf = new RandomAccessFile(fileInterns, "rw");
			//			long offset = index*lengthOfRecord;

 		while (br.ready()) {
				line = br.readLine();
				NewBinaryTree.add(line);
				//				index ++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				br.close();
				in.close();
				//				raf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

​	static class Node {

		String internString;
		Node left;
		Node right; 
		Node(String internTab) {
			this.internString = internTab;
			right = null;
			left = null;
		}
		public static Boolean compareTo(Node nodeA, Node nodeB) {
			return nodeA.equals(nodeB);
		}

				Comparator<Node> comparator = new Comparator<NewBinaryTree.Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return 0	;
			}
		};
	}	

	protected static String nodeToString(Node origin) {
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
		if (nodeCompare.compare(current, interString) < 0 ) {
			current.left = addRecursive(current.left, internString);
			System.out.println("plus petit que current");
		} else if (internString.compareTo(nodeToString(current)) > 0 ) {
			current.right = addRecursive(current.right, internString);
			System.out.println("plus grand que current");
		} else {
			return current;
		}
		return current;
	}

	public static void add(String internString) {
		root = addRecursive(root, internString);
	}

	public static NewBinaryTree createBinaryTree() {
		
		readFile(interns);		
		return bt;

	}

	public static void main(String[] args) {
		createBinaryTree();
		traverseInOrder(root);
	}

}
