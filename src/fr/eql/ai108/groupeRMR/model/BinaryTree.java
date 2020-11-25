package fr.eql.ai108.groupeRMR.model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

	static Node root;
	static BinaryTree bt = new BinaryTree();
	static List<Intern> interns = new ArrayList<Intern>();

	//création arbre binaire 
	class Node {
		int value;
		Node left;
		Node right;

		Node(int value) {
			this.value = value;
			right = null;
			left = null;
		}

	}

	private Node addRecursive(Node current, int value) {
		if (current == null) {
			return new Node(value);
		}

		if (value < current.value) {
			current.left = addRecursive(current.left, value);
		} else if (value > current.value) {
			current.right = addRecursive(current.right, value);
		} else {
			//value already exists
			return current;
		}

		return current;
	}

	public void add(int value) {
		root = addRecursive(root, value);
	}

	private static BinaryTree createBinaryTree() {
		
		//TO DO insérer le fichier d'entrée ici 
		bt.add(6);
		bt.add(4);
		bt.add(8);
		bt.add(131);
		bt.add(5);
		bt.add(7);
		bt.add(10);
		bt.add(23);
		bt.add(54);
		bt.add(81);

		return bt;
	}

	//recherche arbre binaire 
	private static boolean containsNodeRecursive(Node current, int value) {
		if (current == null) {
			return false;
		}
		if (value == current.value) {
			return true;
		}
		return value < current.value
				? containsNodeRecursive(current.left, value)
						: containsNodeRecursive(current.right, value);
	}

	public static boolean containsNode(int value) {
		return containsNodeRecursive(root, value);
	}


	//Suppression 

	private static int findSmallestValue(Node root) {
		return root.left == null ? root.value : findSmallestValue(root.left);
	}

	private static Node deleteRecursive(Node current, int value) {
		if (current == null) {
			return null;
		}

		if (value == current.value) {
			// Case 1: no children
			if (current.left == null && current.right == null) {
				return null;
			}

			// Case 2: only 1 child
			if (current.right == null) {
				return current.left;
			}

			if (current.left == null) {
				return current.right;
			}

			// Case 3: 2 children
			int smallestValue = findSmallestValue(current.right);
			current.value = smallestValue;
			current.right = deleteRecursive(current.right, smallestValue);
			return current;
		}
		if (value < current.value) {
			current.left = deleteRecursive(current.left, value);
			return current;
		}

		current.right = deleteRecursive(current.right, value);
		return current;
	}

	public static void delete(int value) {
		root = deleteRecursive(root, value);
	}
	
	public static void traverseInOrder(Node node) {
		if (node != null) {
			traverseInOrder(node.left);
			System.out.print(" " + node.value);
			//methode RAF
			traverseInOrder(node.right);
		}
	}

//	public static void writeFile(Node mainNode)
//	{
//		FileOutputStream outputStream = null;
//		PrintWriter printWriter = null;
//		String path = "c:\\DossierAI108\\bt.bin";
//		try	{
//			outputStream = new FileOutputStream(path);
//			printWriter = new PrintWriter(outputStream); 
//
//			write(mainNode, printWriter);
//
//			printWriter.flush();
//
//		} catch(IOException e) {
//			System.out.println("An error occured");
//			printWriter.close();
//		}
//	}

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
		System.out.println(containsNode(3));
		traverseInOrder(root);
			}
}
