package fr.eql.ai108.groupeRMR.model;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class RmrATree {
	public static File fileArbre = new File("C:/Users/formation/Desktop/internTest.bin");
	private static int lastNameLength = 100;
	private static int firstNameLength = 100;
	private static int departmentLength = 5;
	private static int promotionLength = 40;
	private static int yearLength = 10;
	private static int childLeftLengh = 8;
	private static int childRightLengh = 8;
	private static int lengthOfRecords = lastNameLength + firstNameLength + departmentLength + promotionLength 
			+ yearLength + childLeftLengh + childRightLengh + 7;
	//length of records 278
	public static void main(String[] args) {
		System.out.println(lengthOfRecords); //278
	}
	
	private static Long insertBin(Intern intern, Long index, RandomAccessFile raf) throws IOException {
		
		raf.seek(index);
		byte[] lastName = new byte[100];
		raf.read(lastName);
		return index;
		
		//String theLastName = new String(lastName, StandardCharsets.UTF_8);

//		if (lastName[0]==35||lastName[0]==42) {
//			raf.seek(raf.getFilePointer()-30);
//			raf.writeBytes(intern.toLargeurFixe());
//			raf.writeLong(Long.MAX_VALUE);
//			raf.writeLong(Long.MAX_VALUE);
//			return index;
//		
//	}
}
}
