package fr.eql.ai108.groupeRMR.ihm;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HBoxAdminAccessBtn extends HBox {
	private Button btnAdminAccess = new Button("Accès Admin");

	public HBoxAdminAccessBtn() {
		getChildren().add(btnAdminAccess);
		btnAdminAccess.setPrefSize(250, 100);
		setAlignment(Pos.CENTER);
		setPrefSize(1919, 300);

		btnAdminAccess.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				LoginPane root = new LoginPane();
				Scene scene = new Scene(root);	
				scene.getStylesheets().add(getClass().getResource("./RMRstylesheet.css")
						.toExternalForm());
				Stage stage = (Stage) getScene().getWindow();
				stage.setScene(scene);
			}
		});
	}

	public Button getBtnAdminAccess() {
		return btnAdminAccess;
	}

	public void setBtnAdminAccess(Button btnAdminAccess) {
		this.btnAdminAccess = btnAdminAccess;
	}
	
	


}
