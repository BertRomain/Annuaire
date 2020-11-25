package fr.eql.ai108.groupeRMR.ihm;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {



	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		AdminPane root = new AdminPane();
		stage.setTitle("TP Annuaire");
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("./RMRstylesheet.css")
				.toExternalForm());
		stage.setScene(scene);
		//stage.sizeToScene();
		stage.setMaximized(true);
		stage.show();
		
	}

}
