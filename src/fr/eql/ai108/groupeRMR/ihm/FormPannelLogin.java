package fr.eql.ai108.groupeRMR.ihm;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FormPannelLogin extends GridPane {
	
	private Label lblLogin;
	private TextField txtLogin;
	private Label lblPassword;
	private TextField txtPassword;
	private Button btnValidate;
	private String adminLogin = new String("Admin");
	private String adminPassword = new String("Password");
	private String errorLoginMessage = new String("Erreur d'identifiant ou de mot de passe");
	private String errorPasswordMessage = new String("Veuillez tenter de vous reconnecter");
	
	public FormPannelLogin() {
		
		lblLogin = new Label("LOGIN");
		txtLogin = new TextField();
		txtLogin.setPrefSize(600, 20);
		addRow(0, lblLogin, txtLogin);
		
		lblPassword = new Label("PASSWORD");
		txtPassword = new TextField();
		txtPassword.setPrefSize(600, 20);
		addRow(1, lblPassword, txtPassword);
		
		btnValidate = new Button("VALIDER");
		addRow(2, btnValidate);
		
		setVgap(20);
		setPadding(new Insets(20));
		
		btnValidate.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				
				if(txtLogin.getText().equals(adminLogin) && (txtPassword.getText().equals(adminPassword))) {
				AdminPane root = new AdminPane();
				Scene scene = new Scene(root);	
				scene.getStylesheets().add(getClass().getResource("./RMRstylesheet.css")
						.toExternalForm());
				
				Stage stage = (Stage) getScene().getWindow();
				stage.setScene(scene);
				}else {
					txtLogin.setText(errorLoginMessage);
					txtPassword.setText(errorPasswordMessage);
					
				}
			}
		});
	}

	public Button getBtnValidate() {
		return btnValidate;
	}

	public void setBtnValidate(Button btnValidate) {
		this.btnValidate = btnValidate;
	}

	public Label getLblLogin() {
		return lblLogin;
	}

	public void setLblLogin(Label lblLogin) {
		this.lblLogin = lblLogin;
	}

	public TextField getTxtLogin() {
		return txtLogin;
	}

	public void setTxtLogin(TextField txtLogin) {
		this.txtLogin = txtLogin;
	}

	public Label getLblPassword() {
		return lblPassword;
	}

	public void setLblPassword(Label lblPassword) {
		this.lblPassword = lblPassword;
	}

	public TextField getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(TextField txtPassword) {
		this.txtPassword = txtPassword;
	}
	
	
}
