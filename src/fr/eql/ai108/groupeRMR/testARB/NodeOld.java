package fr.eql.ai108.groupeRMR.testARB;

public class NodeOld {
	private String mot;
	private NodeOld fg, fd;
	private int nbOcc = 1;
	
	public NodeOld(String mot) {
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

	public NodeOld getFg() {
		return fg;
	}
	public void setFg(NodeOld fg) {
		this.fg = fg;
	}

	public NodeOld getFd() {
		return fd;
	}

	public void setFd(NodeOld fd) {
		this.fd = fd;
	}
}
