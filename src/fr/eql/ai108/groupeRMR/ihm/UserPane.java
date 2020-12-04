package fr.eql.ai108.groupeRMR.ihm;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class UserPane extends BorderPane {
	private TablePannel tablePannel = new TablePannel();
	private FormPannelUser formPannel = new FormPannelUser();
	private Label titleUser = new Label("	ANNUAIRE EQL");

	public UserPane() {
		super();
		titleUser.setId("titleLabel");
		setTop(titleUser);
		setLeft(formPannel);	
		setCenter(tablePannel);
		setPrefSize(1919, 1008);
		formPannel.setStyle("-fx-background-color: rgb(183,204,229)");
		tablePannel.setStyle("-fx-background-color: rgb(183,204,229)");

	}

	public TablePannel getTablePannel() {
		return tablePannel;
	}

	public void setTablePannel(TablePannel tablePannel) {
		this.tablePannel = tablePannel;
	}

	public FormPannelUser getFormPannel() {
		return formPannel;
	}

	public void setFormPannel(FormPannelUser formPannel) {
		this.formPannel = formPannel;
	}

	public Label getTitleUser() {
		return titleUser;
	}

	public void setTitleUser(Label titleUser) {
		this.titleUser = titleUser;
	}
}
