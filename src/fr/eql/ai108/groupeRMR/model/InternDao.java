package fr.eql.ai108.groupeRMR.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;




public class InternDao {
	
	public static File file = new File("C:/Users/formation/Desktop/intern.bin");
	
	
	private static Intern stringToIntern (String line) {
		
		String[] infos = line.split(";");
		Intern intern = new Intern(infos[0].trim().toUpperCase(),(infos[1].trim().substring(0, 1).toUpperCase() + infos[1].trim().substring(1).toLowerCase()),(infos[2].trim()),
				infos[3].trim(),Integer.parseInt(infos[4].trim()));		
		return intern;
	}
	
	private String internToString(Intern intern) {
		StringBuffer sb = new StringBuffer();
		sb.append(intern.getLastName());
		sb.append(";");
		sb.append(intern.getFirstName());
		sb.append(";");
		sb.append(intern.getDepartment());
		sb.append(";");
		sb.append(intern.getPromotion());
		sb.append(";");
		sb.append(intern.getYear());
		sb.append("\n");
	
		return sb.toString();
	}

//	public List<Intern> getAll() {
//		List<Intern> interns = new ArrayList<Intern>();
//		RandomAccessFile raf = null;
//		FileReader in = null;
//		BufferedReader br = null;
//		try {
//			in = new FileReader(file);
//			br = new BufferedReader(in);
//			String line = "";
//			while((line = br.readLine()) != null ) {
//				Intern intern = stringToIntern(line);
//				interns.add(intern);
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			try {
//				br.close();
//				in.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}	
//		
//		return interns;
//		
//		
//	}
	static int index = 0;
	public static int lengthOfRecord = 260;
	public static int entireLengthOfRecord = 278;
	static long  offset = 0;
	
	 

	
	public List<Intern> getAll2() {
		List<Intern> interns = new ArrayList<Intern>();
		RandomAccessFile raf = null;
		index = 0;

		try {
			raf = new RandomAccessFile(file, "rw");
			int numberOfInterns = (int) (raf.length() / 278);
			
			while(index < numberOfInterns){
			byte[] b = null;	
			String line2 = "";
			raf.seek(index * entireLengthOfRecord);
			b = new byte[lengthOfRecord];
			raf.read(b);
			line2 = new String(b);
			//System.out.println(line2);
			Intern intern2 = stringToIntern(line2);
			interns.add(intern2);
			index ++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{
			try {
				raf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		
		return interns;
		
	}
	
	
	public void Refresh (Intern refreshedIntern) {
		List<Intern> interns = new ArrayList<Intern>();
		try {
			FileWriter fw = new FileWriter(file, false);
			for (Intern intern : interns) {
				if(!intern.getLastName().equals(refreshedIntern.getLastName())){
					fw.write(internToString(intern)+ "\r\n");
				}else{
					fw.write(internToString(intern)+ "\r\n");
				}				
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static String writingFile = "C:/Users/formation/Desktop/internTree.bin";
	
	public static long findLastLeftChild() {
		long pos = 0;
		byte [] b = new byte[1];
		String bString = new String(b);

		try {
	RandomAccessFile raf = new RandomAccessFile(writingFile, "rw");
	raf.seek(260);
	pos = raf.readLong();
	System.out.println(pos);
	raf.seek(260);
	b = new byte [1];
	raf.read(b);
	bString = new String(b);
	System.out.println(bString);
	System.out.println(pos);
	raf.seek(pos - 278);
	byte[] tabByte = new byte[278];

	raf.read(tabByte);
	String name = new String(tabByte);
	System.out.println(name);




	while (bString.equals("0") == false) {
		raf.seek(pos - 18);
		b = new byte [1];
		raf.read(b);
		bString = new String(b);
		raf.seek(pos - 18);
		pos = 0;
		pos = raf.readLong();
		raf.seek(pos);
		System.out.println(bString);
		System.out.println(pos);
	}
	
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


//public static List<Etudiant> getAllOrdre(){
//
//		List<Etudiant> etudiantsOrdre = new ArrayList<Etudiant>();
//		RandomAccessFile raf = null;
//
//		try {
//			raf = new RandomAccessFile(fileArbre, "rw");
//			etudiantsOrdre=getAllOrdreBin(0l, raf);// 0 est l'adresse de la racine dans le fichier
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			try {
//				raf.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//		return etudiantsOrdre;
//
//	}


//private static List<Etudiant> getAllOrdreBin(Long noeud, RandomAccessFile raf) throws IOException {
//		raf.seek(noeud);
//		List<Etudiant> etudiantsOrdre = new ArrayList<Etudiant>();
//
//		String[] etudiant =new String[5];
//		for (int i = 0; i < etudiant.length; i++) {
//			byte[] temp = new byte[structure[i]];
//			raf.read(temp);
//			etudiant[i]=new String (temp, StandardCharsets.ISO_8859_1).trim();
//		}
//		Etudiant etudiantduNoeud = new Etudiant(etudiant[0], etudiant[1], etudiant[2], etudiant[3], etudiant[4]);	
//		Long gauche = raf.readLong();
//
//		Long droite = raf.readLong();
//		if (gauche!=Long.MAX_VALUE) {
//			etudiantsOrdre.addAll(getAllOrdreBin(gauche,raf));
//		}
//		etudiantsOrdre.add(etudiantduNoeud);
//		if (droite!=Long.MAX_VALUE) {
//			etudiantsOrdre.addAll(getAllOrdreBin(droite,raf));
//		}
//		return etudiantsOrdre;
//	}
//	private static Long dernierDescendantBin(Long noeud, RandomAccessFile raf) throws IOException 
//	{
//		raf.seek(noeud+85);
//		Long droite = raf.readLong();
//		if (droite == Long.MAX_VALUE)
//			return noeud;
//		return dernierDescendantBin(droite,raf);
//
//	}




	
	

}
