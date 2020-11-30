package fr.eql.ai108.groupeRMR.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;



public class InternDao {
	
	private File file = new File("C:/Users/formation/Desktop/intern.bin");
	
	
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
	static int lengthOfRecord = 260;
	static int entireLengthOfRecord = 278;
	static long  offset = 0;
	
	 

	
	public List<Intern> getAll2() {
		List<Intern> interns = new ArrayList<Intern>();
		RandomAccessFile raf = null;
		index = 0;
		byte[] c = new byte[entireLengthOfRecord];
		try {
			raf = new RandomAccessFile(file, "rw");
			while(raf.read(c) != -1);{
			byte[] b = null;	
			String line2 = "";
			raf.seek(index * entireLengthOfRecord);
			 b = new byte[lengthOfRecord];
			raf.read(b);
			line2 = new String(b);
			System.out.println(line2);
			Intern intern2 = stringToIntern(line2);
			interns.add(intern2);
			index ++;
//			}while(index < 1314);
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
	

}
