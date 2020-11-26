package fr.eql.ai108.groupeRMR.ihm;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FirstPaneWelcome extends BorderPane {
	
	private Button btnWelcome = new Button ("CLIQUEZ ICI POUR CONTINUER");
	private Button btnAdminAccess = new Button("Accès Admin");
	private Label lblWelcome = new Label("	Bienvenue dans l'annuaire des stagiaires EQL");
	
	public FirstPaneWelcome() {
		super();
		lblWelcome.setId("titleLabel");
		setTop(lblWelcome);
		setCenter(btnWelcome);
		setBottom(btnAdminAccess);
		
		setPrefSize(1919, 1008);
		
		btnAdminAccess.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				AdminPane root = new AdminPane();
				Scene scene = new Scene(root);	
				scene.getStylesheets().add(getClass().getResource("./RMRstylesheet.css")
						.toExternalForm());
				Stage stage = (Stage) getScene().getWindow();
				stage.setScene(scene);
//				stage.setMaximized(true);
				
			}
		});
	}

	public Button getBtnWelcome() {
		return btnWelcome;
	}

	public void setBtnWelcome(Button btnWelcome) {
		this.btnWelcome = btnWelcome;
	}

	public Button getBtnAdminAccess() {
		return btnAdminAccess;
	}

	public void setBtnAdminAccess(Button btnAdminAccess) {
		this.btnAdminAccess = btnAdminAccess;
	}

	public Label getLblWelcome() {
		return lblWelcome;
	}

	public void setLblWelcome(Label lblWelcome) {
		this.lblWelcome = lblWelcome;
	}
	
	
	
	

}
