package fr.eql.ai108.groupeRMR.testARB;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;

import fr.eql.ai108.groupeRMR.model.Intern;

public class TestDivers {

	
	
		public static String rechercher(RandomAccessFile raf, String nom)
		{
			int debut = 0;
			int fin = nombreEnregistrements;	
			boolean trouve = false; // flag 
			boolean rechercheTerminee = false; // flag
			String vin = "";
			
			// traitement :
			do
			{
				int milieu = (debut + fin) / 2;
				
				vin = recupererVin(raf, milieu);
				String nomMilieu = getNom(vin);
							
				if (nom.equals(nomMilieu))
				{
					trouve = true;
				}
				
				if (nomMilieu.compareTo(nom) < 0)
				{
					debut = milieu + 1;
				}
				
				if (nomMilieu.compareTo(nom) > 0)
				{
					fin = milieu;
				}
				
				if (fin == -1 || debut == nombreEnregistrements || debut == fin)
				{
					rechercheTerminee = true;
				}
			}
			while(!trouve && !rechercheTerminee);
			
			return vin;
		}
	
	
	
	
	
		
}
