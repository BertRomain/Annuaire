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
			raf.seek(0);
//			raf.seek(278);
//			long position = raf.getFilePointer();
//			System.out.println("valeur position    " + position);
//			raf.seek(260);
//			raf.writeLong(position);
//			raf.seek(260);
//			long positionLue;
//			positionLue = raf.readLong();
//			System.out.println("position lue du fichier de persistance " + positionLue);
//			long sizeFile = raf.length();
//			raf.seek(278);
//			raf.writeLong(sizeFile);
//			raf.seek(278);
//			long sizeLue = raf.readLong();
//			System.out.println(sizeLue + "     " +  sizeFile);
			
			insertAdress(raf, readInternLine(raf, 1),0);
			


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void insertAdress(RandomAccessFile raf, String newString, int n) throws IOException {
		
		long positionNewString = raf.length();
		long positionOldString = 278 * n + 278;
		raf.seek(0);
		long childLeftAdress;
		long childRightAdress;
		if((newString.compareTo(readInternLine(raf, n)) < 0)) {
			raf.seek(positionOldString-18);
			byte [] b = new byte [1];
			raf.read(b);
			String bString = new String(b);
			
			if (bString.equals("0")) {
			childLeftAdress = positionNewString;
			raf.seek(positionOldString-18);
			raf.writeLong(childLeftAdress);
			raf.seek(positionOldString-18);
			long verif =raf.readLong();
			raf.seek(positionOldString-18);
			System.out.println( "gauche" + verif);
			}else{
				raf.seek(positionOldString-18);
				insertAdress(raf, newString, n);
			}

		}else if((newString.compareTo(readInternLine(raf, n)) > 0)) {
			childRightAdress = positionNewString;
			raf.seek(positionOldString-9);
			raf.writeLong(childRightAdress);
			raf.seek(positionOldString-9);
			long verif =raf.readLong();
			raf.seek(positionOldString-9);
			System.out.println(raf.readLong() + " droite  " +  verif);
		}
		System.out.println("Fin méthode Insert Adress");

	}

	public static String readInternLine(RandomAccessFile raf, int o) {
		
		String internLine = "";
		long positionOldString = 278 * o + 278;
		try {	
			raf.seek(positionOldString-278);
			byte [] tabBytes = new byte [278];
			raf.read(tabBytes);
			internLine = new  String(tabBytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("retour ReadInternLine  "  + internLine);
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
