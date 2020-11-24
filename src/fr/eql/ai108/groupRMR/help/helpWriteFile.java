package fr.eql.ai108.groupRMR.help;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.RandomAccessFile;

public class helpWriteFile {
	private static File ecritureFichier(File lesVins) {

		FileReader in=null;
		BufferedReader br = null;
		RandomAccessFile raf = null;
		String ligne = "";
		File retour = new File(lesVins.getParent()+"/VINSbin.DON");



		if (retour.exists()) {
			return retour ;
		}
		try {
			in = new FileReader(lesVins);
			br = new BufferedReader(in);
			ligne = br.readLine();
			raf = new RandomAccessFile(retour,"rw");
			while(ligne!= null) {

				byte[] tabBytes = ligne.getBytes();



				int indexCol = 1;
				int finLigne = tabBytes.length - 1;
				int nbCaractere=0;


				for (int i = 0; i < tabBytes.length; i++) {

					//si on detecte un caractÃ¨re on Ã©crit le caractÃ¨re
					//puis nbCaractere++
					if (tabBytes[i]!='\t') {
						raf.write(tabBytes[i]);
						nbCaractere++;


						// des que l'on detecte un \t on vÃ©rifie le nb d'espace manquants
						// on les Ã©crits avec le RAF puis on change de colone
					} else if ((tabBytes[i]=='\t') ) {
						int nbespace= structure[indexCol]-nbCaractere;
						for (int j = 0; j < nbespace; j++) {
							raf.write('-');
						}
						indexCol++;
						nbCaractere=0;


						// une fois arrivÃ© au dernier caractÃ¨re du tableau
						// on calcul le nombre d'espace manquant
						//puis on les imprime dans le fichier
					} else if (i == finLigne) {
						for (int j = 0; j < (structure[indexCol]-nbCaractere); j++) {
							raf.write('@');
						}
					}

				}
				ligne = br.readLine();
			}	
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
				in.close();
				raf.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}



		}



		return retour ;
	}
}
