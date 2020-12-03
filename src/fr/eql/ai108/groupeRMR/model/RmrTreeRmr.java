package fr.eql.ai108.groupeRMR.model;

import java.io.BufferedReader;
import java.io.File;
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
	private static long childLeftAdress =278;
	private static long childRightAdress = 278;
	private static int nbOcc = 1;
	private static int lengthOfRecord = ImportFileToBinary.getLengthOfRecords();
	private static int index;
	private static int childLength = ImportFileToBinary.getChildLeftLengh();
	private static int lineLengthBeforeChildLeft = ImportFileToBinary.getLengthOfRecords() 
			- ImportFileToBinary.getChildLeftLengh()
			- ImportFileToBinary.getChildRightLengh() - 2; // 2 = quantity of ";" to erase
	private static int lineLengthBeforeChildRight = ImportFileToBinary.getLengthOfRecords() 
			- ImportFileToBinary.getChildRightLengh() - 1 ; // 1 = quantity of ";" to erase
	private static String file = "C:/Users/formation/Desktop/intern.bin"; //raf qui lit
		private static String writingFile = "C:/Users/formation/Desktop/internTree.bin"; // raf1 qui écrit
private static int nbOfInterns = 0;
		private static long pos = 278;
		
	public static void main(String[] args) {
		RandomAccessFile raf;
		RandomAccessFile raf1;


		try {
			raf = new RandomAccessFile(file, "rw"); //fichier intern
			raf.seek(0);
			raf1 = new RandomAccessFile(writingFile, "rw"); //fichier tree
			raf1.seek(0);
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
			raf.seek(0);
			byte[] b = new byte[278];
			raf.read(b);
			raf1.seek(0);
			raf1.write(b);
			nbOfInterns = 1;
			raf.seek(260);
			childLeftAdress = raf.readLong();
			raf.seek(269);
			childRightAdress = raf.readLong();
			
			
			while(raf1.length() < raf.length()) {
			raf.seek(278*nbOfInterns);
				 b = new byte[278];
			raf.read(b);
			
			long end = raf1.length();
			raf1.seek(end);
			raf1.write(b);
			insertAdress(raf1, readInternLine(raf, nbOfInterns),0, pos);
			nbOfInterns ++;

			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	public static void insertAdress(RandomAccessFile raf1, String newString, int n, long pos) throws IOException {
		
		long positionNewString = raf1.length();
		long positionOldString = pos;
		//raf.seek(0);
		
		
		if((newString.compareTo(readInternLineInternTree(raf1, pos)) < 0)) { //fer vs lep
			raf1.seek(positionOldString-18);
			byte [] b = new byte [1];
			raf1.read(b);
			String bString = new String(b);
			
			if (bString.equals("0")) {
				childLeftAdress = positionNewString;
				raf1.seek(positionOldString-18);
				raf1.writeLong(childLeftAdress);
				raf1.seek(positionOldString-18);
				long verif =raf1.readLong();
				raf1.seek(positionOldString-18);
				System.out.println( raf1.readLong() + "gauche" + verif);
			}else{
				raf1.seek(positionOldString-18);
				pos = raf1.readLong() ;
				raf1.seek(pos);
				n ++;
				insertAdress(raf1, newString, n, pos);
			}

		}
		
		else if((newString.compareTo(readInternLineInternTree(raf1, pos)) > 0)) {
			raf1.seek(positionOldString-9);
			byte [] b = new byte [1];
			raf1.read(b);
			String bString = new String(b);
			
			if (bString.equals("0")) {
				childRightAdress = positionNewString;
				raf1.seek(positionOldString-9);
				raf1.writeLong(childRightAdress);
				raf1.seek(positionOldString-9);
				long verif =raf1.readLong();
				raf1.seek(positionOldString-9);
				System.out.println(raf1.readLong() + " droite  " +  verif);
			}else {
				raf1.seek(positionOldString-9);
				pos = raf1.readLong();
				raf1.seek(pos);
				n ++;
				insertAdress(raf1, newString, n, pos);
			}
		}
		System.out.println("Fin méthode Insert Adress");

	}

	public static String readInternLine(RandomAccessFile raf, int o) {
		
		String internLine = "";
		long positionOldString = o*278 + 278;
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
	public static String readInternLineInternTree(RandomAccessFile raf, long m) {
		
		String internLine = "";
		
		try {	
			raf.seek(m-278);
			byte [] tabBytes = new byte [278];
			raf.read(tabBytes);
			internLine = new  String(tabBytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("retour ReadInternLine Tree  "  + internLine);
		return internLine;
	}
//
//	public static void writeInternLine(RandomAccessFile raf, String internLine , long index)	{
//		try {
//			int size = lengthOfRecord;
//			long offset = size * index;
//			raf.seek(offset);	
//			raf.writeBytes(internLine);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	public static String readChildLeftAdress (RandomAccessFile raf, long index) {
//		int size = childLength;	
//		long offset = lengthOfRecord * index + lineLengthBeforeChildLeft;
//		String childLeftAdress = "";
//		try {
//			raf.seek(offset);
//			byte [] tabBytes = new byte [size];
//			raf.read(tabBytes);
//			childLeftAdress = new String(tabBytes);
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return childLeftAdress;
//	}
//
//	public static String readChildRightAdress (RandomAccessFile raf, long index) {
//		int size = childLength;	
//		long offset = lengthOfRecord * index + lineLengthBeforeChildRight;
//		String childRightAdress = "";
//		try {
//			raf.seek(offset);
//			byte [] tabBytes = new byte [size];
//			raf.read(tabBytes);
//			childRightAdress = new String(tabBytes);
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return childRightAdress;
//	}
//
//	public static void writeChildLeftAdress(RandomAccessFile raf, String childLeftAdress, long index) {
//		long offset  = lengthOfRecord * index + lineLengthBeforeChildLeft;
//		//String childLeftAdressString = "";
//		try {
//			raf.seek(offset);				
//			raf.writeBytes(childLeftAdress);
//			//System.out.println("ce que l'on écrit" + childLeftAdress);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//
//	public static void writeChildRightAdress(RandomAccessFile raf, String childRightAdress, long index) {
//		long offset  = lengthOfRecord * index + lineLengthBeforeChildRight;
//		//String childLeftAdressString = "";
//		try {
//			raf.seek(offset);				
//			raf.writeBytes(childRightAdress);
//			System.out.println("ce que l'on ï¿½crit" + childRightAdress);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
}
