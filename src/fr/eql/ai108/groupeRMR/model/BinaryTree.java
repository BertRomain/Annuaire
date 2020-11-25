package fr.eql.ai108.groupeRMR.model;


public class BinaryTree {

	static Node root;
	
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
		BinaryTree bt = new BinaryTree();

		bt.add(6);
		bt.add(4);
		bt.add(8);
		bt.add(3);
		bt.add(5);
		bt.add(7);
		bt.add(9);
		
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
	
//	@Test
//	public void givenABinaryTree__WhenAddingElements__ThenTreeContainsThoseElements() {
//	    BinaryTree bt = createBinaryTree();
//
//	    assertTrue(bt.containsNode(6));
//	    assertTrue(bt.containsNode(4));
//
//	    assertFalse(bt.containsNode(1));
//	}
	
	
	public static void main(String[] args) {
		createBinaryTree();
		System.out.println(containsNode(1));
	}
}
