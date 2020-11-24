package fr.eql.ai108.groupeRMR.ihm;


import javafx.scene.layout.BorderPane;


public class AdminPane extends BorderPane {
	
	private TablePannel tablePannel = new TablePannel();
	private FormPannel formPannel = new FormPannel();
	
	public AdminPane() {
		super();
		setLeft(formPannel);
		setCenter(tablePannel);
	}

	public TablePannel getTablePannel() {
		return tablePannel;
	}

	public void setTablePannel(TablePannel tablePannel) {
		this.tablePannel = tablePannel;
	}

	public FormPannel getFormPannel() {
		return formPannel;
	}

	public void setFormPannel(FormPannel formPannel) {
		this.formPannel = formPannel;
	}
	
	



}
