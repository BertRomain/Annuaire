package fr.eql.ai108.groupeRMR.ihm;

import fr.eql.ai108.groupeRMR.model.Intern;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class SearchByWord {
//	
//	static TextField txtSearch = FormPannelAdmin.getTxtSearch();
//	static TableView<Intern> tableView = TablePannel.getTableView();
//	static ObservableList<Intern> observableInterns = TablePannel.getObservableInterns();
//	static FilteredList<Intern> filteredInterns = new FilteredList<>(observableInterns, p -> true);
//	
//	public static void InternTableController() {
//	
//		
//		
//		
//		
//	txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
//		filteredInterns.setPredicate(intern -> {
////			if (newValue == null || newValue.isEmpty()) {
////				return true;
////			}
//			
//			String lowerCaseFilter = newValue.toLowerCase();
//			
//			if(intern.getLastName().toLowerCase().contains(lowerCaseFilter)) {
//				return true;
//			}else if (intern.getFirstName().toLowerCase().contains(lowerCaseFilter)) {
//				return true;
//			}else if(intern.getDepartment().toLowerCase().contains(lowerCaseFilter)) {
//				return true;
//			}else if (intern.getPromotion().toLowerCase().contains(lowerCaseFilter)) {
//				return true;
//			}else if (intern.getYear() == Integer.parseInt(newValue)) {
//				return true;
//			}
//			return false;
//		});
//	});
//	
//	
//	SortedList<Intern> sortedInterns = new SortedList<>(filteredInterns);
//	sortedInterns.comparatorProperty().bind(tableView.comparatorProperty());
//	tableView.setItems(sortedInterns);
//	}	
}

