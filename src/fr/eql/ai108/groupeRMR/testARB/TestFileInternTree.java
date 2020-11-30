package fr.eql.ai108.groupeRMR.testARB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TestFileInternTree {
	static File interns = new File("C:/Users/Formation/Desktop/intern.bin");
	static int lineSize = 278;
	static int index;
	static int internNumbers = 1315;
	static long internPositionLong;
	static long childLPosition;
	static long childRPosition;
	
	
	public static void main(String[] args) {
		
		RmrTreeOld tree = new RmrTreeOld();
		RandomAccessFile raf = null;
		BufferedReader br = null;
		String internLine = null;
		Node internNode = new Node(internLine);
		String childLeftAdress = " ";
		String childRightAdress =" ";
		
		
		

		
			try {
				raf = new RandomAccessFile(interns,"rw");
				for (index = 0 ; index < 13 ; index++) {				
					internLine = internLineGet(raf, index);
				tree.insert(internLine);
				System.out.println(internLine);
				if (index >0) {
				System.out.println("child      " + tree.getInternNode().getInternLine());
//					internLine = internLineGet(raf, index);
//					tree.insert(internLine);
//					String child = tree.getInternNode().getInternLine();
//					System.out.println("child" + child);
				}
				
				}
		
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				System.out.println("lecture liste triée");	
				System.out.println("******************");
				tree.controlSortedList();
			

			
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
	public static long internPosition (RandomAccessFile raf, String internLine) {
		long position = 0;
		internLine = internLineGet(raf, index);
		try {
			position = raf.getFilePointer() - lineSize;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return position;
	}
	
	public static File getInterns() {
		return interns;
	}
	public static void setInterns(File interns) {
		TestFileInternTree.interns = interns;
	}
	public static int getLineSize() {
		return lineSize;
	}
	public static void setLineSize(int lineSize) {
		TestFileInternTree.lineSize = lineSize;
	}
	public static int getIndex() {
		return index;
	}
	public static void setIndex(int index) {
		TestFileInternTree.index = index;
	}
	public static int getInternNumbers() {
		return internNumbers;
	}
	public static void setInternNumbers(int internNumbers) {
		TestFileInternTree.internNumbers = internNumbers;
	}
	public static long getInternPosition() {
		return internPositionLong;
	}
	public static void setInternPosition(long internPosition) {
		TestFileInternTree.internPositionLong = internPosition;
	}
	public static long getChildLPosition() {
		return childLPosition;
	}
	public static void setChildLPosition(long childLPosition) {
		TestFileInternTree.childLPosition = childLPosition;
	}
	public static long getChildRPosition() {
		return childRPosition;
	}
	public static void setChildRPosition(long childRPosition) {
		TestFileInternTree.childRPosition = childRPosition;
	}
}
