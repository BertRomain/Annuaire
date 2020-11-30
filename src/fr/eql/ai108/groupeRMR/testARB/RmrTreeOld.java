package fr.eql.ai108.groupeRMR.testARB;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class RmrTreeOld {
	private Node internNode;
	private static int lineSize = 278;

	public RmrTreeOld() {}

	public RmrTreeOld(String fileName)  throws IOException {
		createFile(fileName);	
	}

	public void insert(String internLine) {
		internNode = insert(internNode, internLine);
	}

	public Node insert(Node internNode, String internLine ) {
		if (internNode == null) {
			Node newInternNode = new Node(internLine);
			return newInternNode;
		}
		if (internLine.compareTo(internNode.getInternLine()) < 0) internNode.setChildL(insert(internNode.getChildL(), internLine));
		else if (internLine.compareTo(internNode.getInternLine()) == 0) internNode.setNbOcc(internNode.getNbOcc() + 1);
		else internNode.setChildR(insert(internNode.getChildR(), internLine));
		return internNode;
	}

	public void createFile(String fileName) throws IOException {
		Scanner reader = new Scanner(new File(fileName));

		while(reader.hasNext()) insert(reader.next());
	}

	public int high() {
		return high(internNode);
	}

	private int high(Node internNode) {
		if (internNode == null) return -1;
		int hl = high(internNode.getChildL());
		int hr = high(internNode.getChildR());
		if (hl < hr) return hr + 1;
		return hl + 1;
	}



	public void writeSortedList() {
		writeSortedList(internNode);
	}
	public 		RandomAccessFile raf = null;
	public String line = "";
	private int lengthOfRecord = 260;
	int index = 0;
	int offset = 0;
	public void writeSortedList(Node internNode) {
		offset = index*lengthOfRecord;
		if (internNode != null) {
			writeSortedList(internNode.getChildL());	
			try {
				raf = new RandomAccessFile("C:/Users/Formation/Desktop/test.bin", "rw");							
				while(raf.readLine() != null) {
					raf.readLine();					
				}
				raf.seek(offset);
				raf.writeBytes(internNode.getInternLine()+ "\r");
				index ++;

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(internNode.getInternLine());
			writeSortedList(internNode.getChildR());
		}		
	}
	public void controlSortedList() {
		controlSortedList(internNode);
	}

	public void controlSortedList(Node internNode) {

		if (internNode != null) {
			controlSortedList(internNode.getChildL());	
			System.out.println(internNode.getInternLine());
			controlSortedList(internNode.getChildR());
		}	
	}

	public static String internLineGet(RandomAccessFile raf, int index)
	{
		
		
		String result = "";
		long offset = lineSize * index;
		try {
			raf.seek(offset);
			byte[] b = new byte[lineSize];
			raf.read(b);
			result = new String(b);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public RandomAccessFile getRaf() {
		return raf;
	}

	public void setRaf(RandomAccessFile raf) {
		this.raf = raf;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public int getLengthOfRecord() {
		return lengthOfRecord;
	}

	public void setLengthOfRecord(int lengthOfRecord) {
		this.lengthOfRecord = lengthOfRecord;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public Node getInternNode() {
		return internNode;
	}
	public void setInternNode(Node internNode) {
		this.internNode = internNode;
	}


}
