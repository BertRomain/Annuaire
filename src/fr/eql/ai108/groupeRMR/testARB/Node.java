package fr.eql.ai108.groupeRMR.testARB;

public class Node {
	private String internLine;
	private Node childL, childR;
	private int nbOcc = 1;
	
	public Node(String internLine) {
		this.internLine = internLine;
	}

	public String getInternLine() {
		return internLine;
	}

	public void setInternLine(String internLine) {
		this.internLine = internLine;
	}

	public Node getChildL() {
		return childL;
	}

	public void setChildL(Node childL) {
		this.childL = childL;
	}

	public Node getChildR() {
		return childR;
	}

	public void setChildR(Node childR) {
		this.childR = childR;
	}

	public int getNbOcc() {
		return nbOcc;
	}

	public void setNbOcc(int nbOcc) {
		this.nbOcc = nbOcc;
	}


}
