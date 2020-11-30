package fr.eql.ai108.groupeRMR.model;


import java.io.IOException;
import java.io.RandomAccessFile;

public class RmrTree {
	private static String internLine;
	private static double childLeftAdress;
	private static double childRightAdress;
	private static int nbOcc = 1;
	private static int lengthOfRecord = 278;
	private static int index;

	private static String readingFile = "C:/Users/formation/Desktop/internTest.bin";
	private static String writingFile = "C:/Users/formation/Desktop/internTree.bin";

	public static void main(String[] args) {
		RandomAccessFile raf;


		try {
			raf = new RandomAccessFile(readingFile, "rw");
			index = 0;
			for (index = 0 ; index < 1 ; index ++) {
				writeInternLine(raf, internLine, index);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void readInternLine(RandomAccessFile raf, String internLine, int index) {
		try {
			raf.seek(lengthOfRecord*index);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void writeInternLine(RandomAccessFile raf, String internLine, int index)	{
		try {
			raf.seek(lengthOfRecord*index);
			byte [] b = internLine.getBytes();
			raf.write(b);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
