package fr.eql.ai108.groupeRMR.ihm;


import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;


public class AdminPane extends BorderPane {
	
	private TablePannel tablePannel = new TablePannel();
	private FormPannelAdmin formPannel = new FormPannelAdmin();
	private Label titreAdmin = new Label("	ANNUAIRE EQL Page Admin");
	
	public AdminPane() {
		super();
		titreAdmin.setId("titleLabel");
		setTop(titreAdmin);
		setLeft(formPannel);	
		setCenter(tablePannel);
		setPrefSize(1919, 1008);
		
	}

	public TablePannel getTablePannel() {
		return tablePannel;
	}

	public void setTablePannel(TablePannel tablePannel) {
		this.tablePannel = tablePannel;
	}

	public FormPannelAdmin getFormPannel() {
		return formPannel;
	}

	public void setFormPannel(FormPannelAdmin formPannel) {
		this.formPannel = formPannel;
	}
	
	



}
