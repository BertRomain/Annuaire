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
		
	}
	
	private static int lastNameLength;
	private static int firstNameLength;
	private static int departmentLength;
	private static int promotionLength;
	private static int yearLength;
	//private static int lengthOfRecords = 260;
	
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
						raf.writeByte('\r');
					} // end of if y
					line = br.readLine();
					
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
	

}
