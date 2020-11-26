package fr.eql.ai108.groupeRMR.ihm;


import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class LoginPane extends BorderPane {
	
	private Label lblTitleLogin = new Label("	Login Admin");

	public LoginPane() {
		lblTitleLogin.setId("titleLabel");
		setTop(lblTitleLogin);
		
		setPrefSize(1919, 1008);
	}


}
