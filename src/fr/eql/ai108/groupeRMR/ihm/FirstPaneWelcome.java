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
	private HBoxAdminAccessBtn hBoxAdminAccessBtn = new HBoxAdminAccessBtn();
	private Label lblWelcome = new Label("	Bienvenue dans l'annuaire des stagiaires EQL");
	
	public FirstPaneWelcome() {
		super();
		lblWelcome.setId("titleLabel");
		setTop(lblWelcome);
		btnWelcome.setPrefSize(350, 100);
		setCenter(btnWelcome);
		setBottom(hBoxAdminAccessBtn);		
		setPrefSize(1919, 1008);
				
		btnWelcome.setOnAction(new EventHandler<ActionEvent>() {

			
			@Override
			public void handle(ActionEvent event) {
				UserPane root = new UserPane();
				Scene scene = new Scene(root);	
				scene.getStylesheets().add(getClass().getResource("./RMRstylesheet.css")
						.toExternalForm());
				Stage stage = (Stage) getScene().getWindow();
				stage.setScene(scene);
			}
		});
		
	}

	public Button getBtnWelcome() {
		return btnWelcome;
	}

	public void setBtnWelcome(Button btnWelcome) {
		this.btnWelcome = btnWelcome;
	}


	public HBoxAdminAccessBtn gethBoxAdminAccessBtn() {
		return hBoxAdminAccessBtn;
	}

	public void sethBoxAdminAccessBtn(HBoxAdminAccessBtn hBoxAdminAccessBtn) {
		this.hBoxAdminAccessBtn = hBoxAdminAccessBtn;
	}

	public Label getLblWelcome() {
		return lblWelcome;
	}

	public void setLblWelcome(Label lblWelcome) {
		this.lblWelcome = lblWelcome;
	}
	
	
	
	

}
