package fr.eql.ai108.groupeRMR.ihm;


import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class LoginPane extends BorderPane {
	
	private Label lblTitleLogin = new Label("	Login Admin");
	private FormPannelLogin formPannelLogin = new FormPannelLogin();

	public LoginPane() {
		lblTitleLogin.setId("titleLabel");
		setTop(lblTitleLogin);
		setCenter(formPannelLogin);
		setPrefSize(1919, 1008);
	}


}
