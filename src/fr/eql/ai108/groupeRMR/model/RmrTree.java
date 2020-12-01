package fr.eql.ai108.groupeRMR.model;


import java.io.IOException;
import java.io.RandomAccessFile;

import fr.eql.ai108.groupeRMR.Import.ImportFileToBinary;

public class RmrTree {
	private static String internLine;
	private static long childLeftAdress;
	private static long childRightAdress;
	private static int nbOcc = 1;
	private static int lengthOfRecord = ImportFileToBinary.getLengthOfRecords();
	private static int index;
	private static int childLength = ImportFileToBinary.getChildLeftLengh();
	private static int lineLengthBeforeChildLeft = ImportFileToBinary.getLengthOfRecords() 
			- ImportFileToBinary.getChildLeftLengh()
			- ImportFileToBinary.getChildRightLengh() - 2; // 2 = quantity of ";" to erase
	private static int lineLengthBeforeChildRight = ImportFileToBinary.getLengthOfRecords() 
			- ImportFileToBinary.getChildRightLengh() - 1 ; // 1 = quantity of ";" to erase
	private static String file = "C:/Users/formation/Desktop/internTest.bin";
	//	private static String writingFile = "C:/Users/formation/Desktop/internTree.bin";

	public static void main(String[] args) {
		RandomAccessFile raf;

		try {
			raf = new RandomAccessFile(file, "rw");
			System.out.println(readChildLeftAdress(raf, 0));
			System.out.println(readChildRightAdress(raf, 0));
			writeChildLeftAdress(raf, readChildLeftAdress(raf, 0), 1);



		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String readInternLine(RandomAccessFile raf, int index) {
		int size = lengthOfRecord;
		String internLine = "";
		long offset = size * index;	
		try {	
			raf.seek(offset);
			byte [] tabBytes = new byte [size];
			raf.read(tabBytes);
			internLine = new  String(tabBytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return internLine;
	}

	public static void writeInternLine(RandomAccessFile raf, String internLine , int index)	{
		try {
			int size = lengthOfRecord;
			long offset = size * index;
			raf.seek(offset);	
			raf.writeBytes(internLine);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Long readChildLeftAdress (RandomAccessFile raf, int index) {
		int size = childLength;		
		long childLeftAdress = 0;
		long offset = lengthOfRecord * index + lineLengthBeforeChildLeft;
		String childLeftAdressString = "";
		try {
			raf.seek(offset);
			byte [] tabBytes = new byte [size];
			raf.read(tabBytes);
			childLeftAdressString = new String(tabBytes);
			childLeftAdress = new Long(childLeftAdressString);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return childLeftAdress;
	}
	
	public static Long readChildRightAdress (RandomAccessFile raf, int index) {
		int size = childLength;		
		long chilRightAdress = 0;
		long offset = lengthOfRecord * index + lineLengthBeforeChildRight;
		String childRightAdressString = "";
		try {
			raf.seek(offset);
			byte [] tabBytes = new byte [size];
			raf.read(tabBytes);
			childRightAdressString = new String(tabBytes);
			chilRightAdress = new Long(childRightAdressString);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return chilRightAdress;
	}

	public static void writeChildLeftAdress(RandomAccessFile raf, Long childLeftAdress, int index) {
		int size = childLength;
		long offset  = lengthOfRecord * index + lineLengthBeforeChildLeft;
		String childLeftAdressString = "";
		try {
			raf.seek(offset);			
			raf.writeLong(childLeftAdress);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}

