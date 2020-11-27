package fr.eql.ai108.groupeRMR.ihm;

import fr.eql.ai108.groupeRMR.model.Intern;
import fr.eql.ai108.groupeRMR.model.InternDao;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
		
		TableColumn<Intern, Integer> colDepartment = new TableColumn<>("Département" + "\n" + "Pays");
		colDepartment.setCellValueFactory(new PropertyValueFactory<>("department"));
		
		TableColumn<Intern, String> colPromotion = new TableColumn<>("Promotion");
		colPromotion.setCellValueFactory(new PropertyValueFactory<>("promotion"));
		
		TableColumn<Intern, Integer> colYear = new TableColumn<>("Année");
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
		
		tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Intern>() {

			@Override
			public void changed(ObservableValue<? extends Intern> observable, Intern oldValue, Intern newValue) {
				AdminPane root = (AdminPane) TablePannel.this.getScene().getRoot();
				FormPannelAdmin formPannelAdmin = root.getFormPannel();
				if(newValue != null) {
					formPannelAdmin.getTxtLastName().setText(newValue.getLastName());
					formPannelAdmin.getTxtFirstName().setText(newValue.getFirstName());
					for (String str : formPannelAdmin.getCbDepartment().getItems()){
						 
						if(str.startsWith(newValue.getDepartment())){
							formPannelAdmin.getCbDepartment().getSelectionModel().select(str);
						}
					}
					formPannelAdmin.getTxtPromotion().setText(newValue.getPromotion());
					formPannelAdmin.getTxtYear().setText(Integer.toString(newValue.getYear()));
					
				}
			}
		});
		
	}

	public InternDao getDao() {
		return dao;
	}

	public void setDao(InternDao dao) {
		this.dao = dao;
	}

	public ObservableList<Intern> getObservableInterns() {
		return observableInterns;
	}

	public void setObservableInterns(ObservableList<Intern> observableInterns) {
		this.observableInterns = observableInterns;
	}

	public TableView<Intern> getTableView() {
		return tableView;
	}

	public void setTableView(TableView<Intern> tableView) {
		this.tableView = tableView;
	}

}
