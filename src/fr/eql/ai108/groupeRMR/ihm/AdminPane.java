package fr.eql.ai108.groupeRMR.ihm;


import javafx.scene.layout.BorderPane;


public class AdminPane extends BorderPane {
	
	private TablePannel tablePannel = new TablePannel();
	private FormPannelAdmin formPannel = new FormPannelAdmin();
	
	public AdminPane() {
		super();
		setLeft(formPannel);
		setCenter(tablePannel);
		setPrefSize(1800, 900);
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
