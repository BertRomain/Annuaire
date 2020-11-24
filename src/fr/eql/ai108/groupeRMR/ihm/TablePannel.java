package fr.eql.ai108.groupeRMR.ihm;

import fr.eql.ai108.groupeRMR.model.Intern;
import fr.eql.ai108.groupeRMR.model.InternDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class TablePannel extends AnchorPane {
	
	private InternDao dao = new InternDao();
	private ObservableList<Intern> observableInterns;
	private TableView<Intern> tableView;
	
	public TablePannel() {
		super();

		observableInterns = FXCollections.observableArrayList(dao.getAll());
		
	}

	
	
	
	

}
