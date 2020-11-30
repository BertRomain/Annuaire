package fr.eql.ai108.groupeRMR.ihm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TableView;

public class Events {
//	btnRefresh.setOnAction(new EventHandler<ActionEvent>() {
//
//		@Override
//		public void handle(ActionEvent event) {
//			String lastName = txtLastName.getText().toUpperCase();
//			String firstName = txtFirstName.getText();
//			String department = cbDepartment.getSelectionModel().getSelectedItem();
//			String promotion = txtPromotion.getText();
//			int year = Integer.parseInt(txtYear.getText());
//			AdminPane adminPane2 = (AdminPane) getScene().getRoot();
//			TableView<Intern> intern = adminPane2.getTablePannel().getTableView();
//			Intern intern2 = intern.getSelectionModel().getSelectedItem();
//			intern2.setLastName(lastName);
//			intern2.setFirstName(firstName);
//			intern2.setDepartment(department);
//			intern2.setPromotion(promotion);
//			intern2.setYear(year);
//			
//	
//		}
//	});

	
	static File file = new File("C:/Users/formation/Desktop/intern.bin");
	
	
	public static int countInterns(File file) {
		
		RandomAccessFile raf = null;
		int numberOfInterns = 0;
		try {
			raf = new RandomAccessFile(file, "rw");
			numberOfInterns = (int) (raf.length() / 278);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return numberOfInterns;
	}
	
	
	
	public static void rechercher()
	{
		RandomAccessFile raf = null;
		int numberOfInterns = 0;
		try {
			raf = new RandomAccessFile(file, "rw");
			numberOfInterns = (int) (raf.length() / 278);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	System.out.println(numberOfInterns);
	
	
	int end = 0;
		int debut = 0;
		end = numberOfInterns;	
		boolean trouve = false; // flag 
		boolean rechercheTerminee = false; // flag
		String intern = "";
		
		 //traitement :
		do
		{
			int milieu = (debut + end) / 2;
			
			intern = recupererVin(raf, milieu);
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
	public static String recupererVin(RandomAccessFile raf, int index)
	{
		int taille = ;
		String result = "";
		long offset = taille * index;
		try {
			raf.seek(offset);
			byte[] b = new byte[taille];
			raf.read(b);
			result = new String(b);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		rechercher();
		System.out.println(colLastName);
	
	}
}
