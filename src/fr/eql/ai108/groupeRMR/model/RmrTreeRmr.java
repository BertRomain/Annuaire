package fr.eql.ai108.groupeRMR.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

import com.sun.org.apache.bcel.internal.util.ByteSequence;

import fr.eql.ai108.groupeRMR.Import.ImportFileToBinary;


import java.io.IOException;
import java.io.RandomAccessFile;

import fr.eql.ai108.groupeRMR.Import.ImportFileToBinary;

public class RmrTreeRmr {
	private static String internLine;
	//private static String childLeftAdress;
	private static String childRightAdress;
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
			String internString = "";
			internString = readInternLine(raf, (long) 3);			
			insertAdress(raf, internString, (long) 2);


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void insertAdress(RandomAccessFile raf, String internString, Long position) throws IOException {
		String childLeftAdress = "";
		long childLeftAdressLong;
		if((internString.compareTo(readInternLine(raf, position)) < 0)) {
			childLeftAdressLong = position + 278;
			childLeftAdress = String.valueOf(childLeftAdressLong);
			raf.seek(raf.length()-18);
			raf.writeBytes(childLeftAdress);
			
		}

	}

	public static String readInternLine(RandomAccessFile raf, Long index) {
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

	public static void writeInternLine(RandomAccessFile raf, String internLine , long index)	{
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

	public static String readChildLeftAdress (RandomAccessFile raf, long index) {
		int size = childLength;	
		long offset = lengthOfRecord * index + lineLengthBeforeChildLeft;
		String childLeftAdress = "";
		try {
			raf.seek(offset);
			byte [] tabBytes = new byte [size];
			raf.read(tabBytes);
			childLeftAdress = new String(tabBytes);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return childLeftAdress;
	}

	public static String readChildRightAdress (RandomAccessFile raf, long index) {
		int size = childLength;	
		long offset = lengthOfRecord * index + lineLengthBeforeChildRight;
		String childRightAdress = "";
		try {
			raf.seek(offset);
			byte [] tabBytes = new byte [size];
			raf.read(tabBytes);
			childRightAdress = new String(tabBytes);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return childRightAdress;
	}

	public static void writeChildLeftAdress(RandomAccessFile raf, String childLeftAdress, long index) {
		long offset  = lengthOfRecord * index + lineLengthBeforeChildLeft;
		//String childLeftAdressString = "";
		try {
			raf.seek(offset);				
			raf.writeBytes(childLeftAdress);
			//System.out.println("ce que l'on écrit" + childLeftAdress);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void writeChildRightAdress(RandomAccessFile raf, String childRightAdress, long index) {
		long offset  = lengthOfRecord * index + lineLengthBeforeChildRight;
		//String childLeftAdressString = "";
		try {
			raf.seek(offset);				
			raf.writeBytes(childRightAdress);
			System.out.println("ce que l'on ï¿½crit" + childRightAdress);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
