package fr.eql.ai108.groupeRMR.ihm;

import fr.eql.ai108.groupeRMR.model.Intern;
import fr.eql.ai108.groupeRMR.model.InternDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class TablePannel extends AnchorPane {
	
	private InternDao dao = new InternDao();
	private ObservableList<Intern> observableInterns;
	private TableView<Intern> tableView;
	
	@SuppressWarnings("unchecked")
	public TablePannel() {
		super();

		observableInterns = FXCollections.observableArrayList(dao.getAll());
		
		tableView = new TableView<>(observableInterns);
		
		TableColumn<Intern, String> colLastName = new TableColumn<>("Nom");
		colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		
		TableColumn<Intern, String> colFirstName = new TableColumn<>("Prénom");
		colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		
		TableColumn<Intern, Integer> colDepartment = new TableColumn<>("Département");
		colDepartment.setCellValueFactory(new PropertyValueFactory<>("department"));
		
		TableColumn<Intern, String> colPromotion = new TableColumn<>("Promotion");
		colPromotion.setCellValueFactory(new PropertyValueFactory<>("promotion"));
		
		TableColumn<Intern, Integer> colYear = new TableColumn<>("Année");
		colYear.setCellValueFactory(new PropertyValueFactory<>("yaer"));
		
		tableView.getColumns().addAll(colLastName,colFirstName, colDepartment,colPromotion,colYear);		
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		getChildren().add(tableView);
		
		
		setPrefSize(1000, 500);
		AnchorPane.setTopAnchor(tableView, 5.);
		AnchorPane.setLeftAnchor(tableView, 5.);
		AnchorPane.setRightAnchor(tableView, 5.);
		AnchorPane.setBottomAnchor(tableView, 5.);
		
	}

	
	
	
	

}
