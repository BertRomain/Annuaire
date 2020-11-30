package fr.eql.ai108.groupeRMR.Import;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ImportFileToBinary {
	static File stagiaires = new File("C:/Users/formation/Desktop/stagiaires.txt");
	public static void main(String[] args) {
		writeFile(stagiaires);
		System.out.println("ok");
		
	}
	
	private static int lastNameLength = 100;
	private static int firstNameLength = 100;
	private static int departmentLength = 5;
	private static int promotionLength = 40;
	private static int yearLength = 10;
	private static int childLeftLengh = 8;
	private static int childRightLengh = 8;
	private static int lengthOfRecords = lastNameLength + firstNameLength + departmentLength + promotionLength 
			+ yearLength + childLeftLengh + childRightLengh + 7;
	
	public static int getLengthOfRecords() {
		return lengthOfRecords;
	}

	public static void setLengthOfRecords(int lengthOfRecords) {
		ImportFileToBinary.lengthOfRecords = lengthOfRecords;
	}

	private static File writeFile(File fileInterns) {

		File binaryFile = new File(fileInterns.getParent()+"/intern.bin");

		if (binaryFile.exists()) {
			return binaryFile ;
		}
		
		try {
			FileReader in = new FileReader(fileInterns);
			BufferedReader br = new BufferedReader(in);
			String line ;
			RandomAccessFile raf = new RandomAccessFile(binaryFile,"rw");
			while(br.ready()) {
				lastNameLength = 100;
				firstNameLength = 100;
				departmentLength = 5;
				promotionLength = 40;
				yearLength = 10;
				childLeftLengh = 8;
				childRightLengh = 8;
				
				try {
					int y = 0;
					int i = 0;
					line = br.readLine();
					byte[] tabBytes = line.getBytes();
					for (i = 0; i < tabBytes.length; i++) {
						raf.writeByte(tabBytes[i]);
						lastNameLength --;
					} // end of for i
					for(y =0; y < lastNameLength; y ++) {
						raf.writeByte(' ');
					} // end of for y
					if(y == lastNameLength) {
						raf.writeByte(';');
					} // end of if y
					
					line = br.readLine();
					byte[] tabBytes1 = line.getBytes();
					for (i = 0; i < tabBytes1.length; i++) {
						raf.writeByte(tabBytes1[i]);
						firstNameLength --;
					} // end of for i
					for(y =0; y < firstNameLength; y ++) {
						raf.writeByte(' ');
					} // end of for y
					if(y == firstNameLength) {
						raf.writeByte(';');
					} // end of if y
					
					line = br.readLine();
					byte[] tabBytes2 = line.getBytes();
					for (i = 0; i < tabBytes2.length; i++) {
						raf.writeByte(tabBytes2[i]);
						departmentLength --;
					} // end of for i
					for(y =0; y < departmentLength; y ++) {
						raf.writeByte(' ');
					} // end of for y
					if(y == departmentLength) {
						raf.writeByte(';');
					} // end of if y
					
					line = br.readLine();
					byte[] tabBytes3 = line.getBytes();
					for (i = 0; i < tabBytes3.length; i++) {
						raf.writeByte(tabBytes3[i]);
						promotionLength --;
					} // end of for i
					for(y =0; y < promotionLength; y ++) {
						raf.writeByte(' ');
					} // end of for y
					if(y == promotionLength) {
						raf.writeByte(';');
					} // end of if y
					
					line = br.readLine();
					byte[] tabBytes4 = line.getBytes();
					for (i = 0; i < tabBytes4.length; i++) {
						raf.writeByte(tabBytes4[i]);
						yearLength --;
					} // end of for i
					for(y =0; y < yearLength; y ++) {
						raf.writeByte(' ');
					} // end of for y
					if(y == yearLength) {
						raf.writeByte(';');
					} // end of if y
					line = br.readLine();
					
					for(i=0; i < childLeftLengh; i++) {
						raf.writeByte('0');
					}
					raf.writeByte(';');
					
					for(i=0; i < childRightLengh; i++) {
						raf.writeByte('0');
					}
					raf.writeByte(';');
					
					
				} catch (IOException e) {
					e.printStackTrace();
				}

			}	//end of while
			br.close();
			in.close();
			raf.close();
		} //end of try
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // end of catch
		
		

		return binaryFile ;
	}

	public static int getLastNameLength() {
		return lastNameLength;
	}

	public static void setLastNameLength(int lastNameLength) {
		ImportFileToBinary.lastNameLength = lastNameLength;
	}

	public static int getFirstNameLength() {
		return firstNameLength;
	}

	public static void setFirstNameLength(int firstNameLength) {
		ImportFileToBinary.firstNameLength = firstNameLength;
	}

	public static int getDepartmentLength() {
		return departmentLength;
	}

	public static void setDepartmentLength(int departmentLength) {
		ImportFileToBinary.departmentLength = departmentLength;
	}

	public static int getPromotionLength() {
		return promotionLength;
	}

	public static void setPromotionLength(int promotionLength) {
		ImportFileToBinary.promotionLength = promotionLength;
	}

	public static int getYearLength() {
		return yearLength;
	}

	public static void setYearLength(int yearLength) {
		ImportFileToBinary.yearLength = yearLength;
	}

	public static int getChildLeftLengh() {
		return childLeftLengh;
	}

	public static void setChildLeftLengh(int childLeftLengh) {
		ImportFileToBinary.childLeftLengh = childLeftLengh;
	}

	public static int getChildRightLengh() {
		return childRightLengh;
	}

	public static void setChildRightLengh(int childRightLengh) {
		ImportFileToBinary.childRightLengh = childRightLengh;
	}
	

}
