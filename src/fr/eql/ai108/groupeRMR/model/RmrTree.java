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
	private static String readingFile = "C:/Users/formation/Desktop/internTest.bin";
	private static String writingFile = "C:/Users/formation/Desktop/internTree.bin";

	public static void main(String[] args) {
		RandomAccessFile raf;



		try {
			raf = new RandomAccessFile(readingFile, "rw");



//			internLine = readInternLine(raf, 0);
//			System.out.println(internLine);
//			writeInternLine(raf, internLine, 0);
//			internLine = readInternLine(raf, 1);
//			System.out.println(internLine);
//			childLeftAdress = 
//			readChildLeftAdress(raf, 0);
			System.out.println(readChildLeftAdress(raf, 0));
//			System.out.println("adress right " + readChildRightAdress(raf, 0));
//			System.out.println(readInternLine(raf, 0));
//			if (internLine.compareTo(readInternLine(raf, 0)) > 0) {
//
//			}


			System.out.println(readChildLeftAdress(raf, 0));


			System.out.println(readChildLeftAdress(raf, 0));


			System.out.println(readChildLeftAdress(raf, 0));


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

	public static void writeInternLine(RandomAccessFile raf, String internLine, int index)	{
		try {
			raf.seek(lengthOfRecord*index);
			byte [] tabBytes = internLine.getBytes();		
			raf.write(tabBytes);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void writeChildLeftAdress(RandomAccessFile raf, String childLeftLine, int childLeftInt) {
		String childLeft = readInternLine(raf, childLeftInt);		
	}	
	public static Long readChildLeftAdress (RandomAccessFile raf, int index) {
		int size = childLength;
		String childLeftAdressString = "";
		long result = 0;
		long offset = lengthOfRecord * index + lineLengthBeforeChildLeft;
		try {
			raf.seek(offset);
			byte [] tabBytes = new byte [size];
			raf.read(tabBytes);
			childLeftAdressString = new  String(tabBytes);
			result = new Long(childLeftAdressString);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	public static Long readChildRightAdress (RandomAccessFile raf, int index) {
		int size = childLength;
		String childRightAdressString = "";		
		long offset = lengthOfRecord * index + lineLengthBeforeChildRight;
		try {
			raf.seek(offset);
			byte [] tabBytes = new byte [size];
			raf.read(tabBytes);
			childRightAdressString = new  String(tabBytes);
			long childRightAdress = Long.valueOf(childRightAdressString);
			System.out.println("adresse right depuis methode" + childRightAdress);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return childRightAdress;
		
	}


}

