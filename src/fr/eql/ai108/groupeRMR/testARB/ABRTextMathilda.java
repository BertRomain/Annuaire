package fr.eql.ai108.groupeRMR.testARB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ABRTextMathilda {
	private static String writingFile = "C:/Users/formation/Desktop/internTree.bin";
	
	public static long findLastLeftChild() {
		long pos = 0;
		byte [] b = new byte[1];
		String bString = new String(b);

		try {
	RandomAccessFile raf = new RandomAccessFile(writingFile, "rw");
//	int n = 0;
	raf.seek(89794 -9);
	pos = raf.readLong();
	System.out.println(pos);
//	raf.seek(260);
//	b = new byte [1];
//	raf.read(b);
//	bString = new String(b);
//	System.out.println(bString);
//	System.out.println(pos);
	raf.seek(pos - 278);
	byte[] tabByte = new byte[278];
	
	raf.read(tabByte);
	String name = new String(tabByte);
	System.out.println(name);
	
	
	
//	
//	if (bString.equals("0") == false) {
//		raf.seek(pos - 18);
//		b = new byte [1];
//		raf.read(b);
//		bString = new String(b);
//		raf.seek(pos - 18);
//		pos = 0;
//		pos = raf.readLong();
//		raf.seek(pos);
//		System.out.println(bString);
//		System.out.println(pos);
//	}if (bString.equals("0") == false) {
//		raf.seek(pos - 18);
//		b = new byte [1];
//		raf.read(b);
//		bString = new String(b);
//		raf.seek(pos - 18);
//		pos = 0;
//		pos = raf.readLong();
//		System.out.println(bString);
//		System.out.println(pos);
//	}
	
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		return pos;
		
	}
	public static void main(String[] args) {
//		String str1 = "RICARDE                                                                                             ;Christophe                                                                                          ;95   ;AI 81                                   ;2011      ;00000000;00000000;";
//		String str2 = "SLIVCA                                                                                              ;Diana                                                                                               ;95   ;AI 84                                   ;2012      ;00000000;00000000;";
//		System.out.println(str1.compareTo(str2));
//		
		
		findLastLeftChild();
		
	}
	
}
