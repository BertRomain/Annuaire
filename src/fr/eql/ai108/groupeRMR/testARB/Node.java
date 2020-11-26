package fr.eql.ai108.groupeRMR.testARB;

public class Node {
	private String mot;
	private Node fg, fd;
	private int nbOcc = 1;
	
	public Node(String mot) {
		this.mot = mot;
	}

	public int getNbOcc() {
		return nbOcc;
	}

	public void setNbOcc(int nbOcc) {
		this.nbOcc = nbOcc;
	}

	public void setMot(String mot) {
		this.mot = mot;
	}

	public String getMot() {
		return mot;
	}

	public void setDonnee(String mot) {
		this.mot = mot;
	}

	public Node getFg() {
		return fg;
	}
	public void setFg(Node fg) {
		this.fg = fg;
	}

	public Node getFd() {
		return fd;
	}

	public void setFd(Node fd) {
		this.fd = fd;
	}
}
