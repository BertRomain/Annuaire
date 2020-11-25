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
		
		TableColumn<Intern, String> colFirstName = new TableColumn<>("Pr�nom");
		colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		
		TableColumn<Intern, Integer> colDepartment = new TableColumn<>("D�partement" + "\n" + "Pays");
		colDepartment.setCellValueFactory(new PropertyValueFactory<>("department"));
		
		TableColumn<Intern, String> colPromotion = new TableColumn<>("Promotion");
		colPromotion.setCellValueFactory(new PropertyValueFactory<>("promotion"));
		
		TableColumn<Intern, Integer> colYear = new TableColumn<>("Ann�e");
		colYear.setCellValueFactory(new PropertyValueFactory<>("year"));
		//colYear.setMaxWidth(50);
		
		tableView.getColumns().addAll(colLastName,colFirstName, colDepartment,colPromotion,colYear);		
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		getChildren().add(tableView);
		
		
		//setPrefSize(1000, 900);
		AnchorPane.setTopAnchor(tableView, 5.);
		AnchorPane.setLeftAnchor(tableView, 5.);
		AnchorPane.setRightAnchor(tableView, 5.);
		AnchorPane.setBottomAnchor(tableView, 5.);
		
	}

	
	
	
	

}
