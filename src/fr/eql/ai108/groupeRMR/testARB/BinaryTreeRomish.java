package fr.eql.ai108.groupeRMR.testARB;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import fr.eql.ai108.groupeRMR.model.Intern;

public class BinaryTreeRomish {

	static Node root;
	static BinaryTreeRomish bt = new BinaryTreeRomish();
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

	private static BinaryTreeRomish createBinaryTree() {
		
		//TO DO insérer le fichier d'entrée ici 
		bt.add("Hello");
		bt.add("Bonjour");
		bt.add("Demain");
		bt.add("Pourquoi");
		bt.add("Méchant");
		bt.add("Musique");
		bt.add("Zoo");
		bt.add("Fléau");
		bt.add("Yen");
		bt.add("Aujourd'hui");

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


//	//Suppression 
//
//	private static int findSmallestValue(Node root) {
//		return root.left == null ? root.value : findSmallestValue(root.left);
//	}
//
//	private static Node deleteRecursive(Node current, String value) {
//		if (current == null) {
//			return null;
//		}
//
//		if (value == current.value) {
//			// Case 1: no children
//			if (current.left == null && current.right == null) {
//				return null;
//			}
//
//			// Case 2: only 1 child
//			if (current.right == null) {
//				return current.left;
//			}
//
//			if (current.left == null) {
//				return current.right;
//			}
//
//			// Case 3: 2 children
//			int smallestValue = findSmallestValue(current.right);
//			current.value = smallestValue;
//			current.right = deleteRecursive(current.right, smallestValue);
//			return current;
//		}
//		if (value.compareTo(current.value) >0) {
//			current.left = deleteRecursive(current.left, value);
//			return current;
//		}
//
//		current.right = deleteRecursive(current.right, value);
//		return current;
//	}
//
//	public static void delete(String value) {
//		root = deleteRecursive(root, value);
//	}
	
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
		System.out.println(containsNode("3"));
		traverseInOrder(root);
			}
}
