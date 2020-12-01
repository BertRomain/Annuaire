package fr.eql.ai108.groupeRMR.ihm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import fr.eql.ai108.groupeRMR.model.Intern;
import fr.eql.ai108.groupeRMR.model.InternDao;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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
		TextField txtSearch = FormPannelAdmin.getTxtSearch();
		String fileToFind = txtSearch.toString();
		List<Intern> interns = new ArrayList<Intern>();
		
		RandomAccessFile raf = null;
		int index = -1;
		Boolean found = false;
		byte[] b = null;
		String line2 = "";

		try {
			
			raf = new RandomAccessFile(file, "rw");
			int numberOfInterns = (int) (raf.length() / 278);
			do{
				index ++;
				b = null;	
				line2 = "";
				raf.seek(index * InternDao.entireLengthOfRecord);
				b = new byte[InternDao.lengthOfRecord];
				raf.read(b);
				line2 = new String(b);
				//			intern2 = InternDao.stringToIntern(line2);
				if(line2.contains(fileToFind)) {
					found = true;
				}
			}while(found == false && index < numberOfInterns);
			if(found == true) {
				TablePannel.tableView = null;
				raf.seek(index * InternDao.entireLengthOfRecord);
				b = new byte[InternDao.lengthOfRecord];
				raf.read(b);
				line2 = new String(b);
				Intern intern2 = InternDao.stringToIntern(line2);
				AdminPane adminPane = (AdminPane) getScene().getRoot();
				adminPane.getTablePannel().getObservableInterns().add(intern2);
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
		
	}

//
//	int numberOfInterns = 0;
//	try {
//		raf = new RandomAccessFile(file, "rw");
//		numberOfInterns = (int) (raf.length() / 278);
//
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//
//	System.out.println(numberOfInterns);
//}
//
//
//
//int end = 0;
//int debut = 0;
//end = numberOfInterns;	
//boolean trouve = false; // flag 
//boolean rechercheTerminee = false; // flag
//String intern = "";
//
////traitement :
//do
//{
//	int milieu = (debut + end) / 2;
//
//	intern = recupererVin(raf, milieu);
//	String nomMilieu = getNom(vin);
//
//	if (nom.equals(nomMilieu))
//	{
//		trouve = true;
//	}
//
//	if (nomMilieu.compareTo(nom) < 0)
//	{
//		debut = milieu + 1;
//	}
//
//	if (nomMilieu.compareTo(nom) > 0)
//	{
//		fin = milieu;
//	}
//
//	if (fin == -1 || debut == nombreEnregistrements || debut == fin)
//	{
//		rechercheTerminee = true;
//	}
//}
//while(!trouve && !rechercheTerminee);
//
//return vin;
//}
//public static String recupererVin(RandomAccessFile raf, int index)
//{
//	int taille = ;
//	String result = "";
//	long offset = taille * index;
//	try {
//		raf.seek(offset);
//		byte[] b = new byte[taille];
//		raf.read(b);
//		result = new String(b);
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
//	return result;
//}
//
//
//public static void main(String[] args) {
//
//
//}
}
