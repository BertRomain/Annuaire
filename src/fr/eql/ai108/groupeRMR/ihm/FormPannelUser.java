package fr.eql.ai108.groupeRMR.ihm;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import fr.eql.ai108.groupeRMR.model.ExportPdf;
import fr.eql.ai108.groupeRMR.model.Intern;
import fr.eql.ai108.groupeRMR.model.InternDao;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FormPannelUser extends GridPane {
	private Label lblLastName;
	private TextField txtLastName;
	private Label lblFirstName;
	private TextField txtFirstName;
	private Label lblDepartment;
	private ComboBox<String> cbDepartment;
	private Label lblPromotion;
	private TextField txtPromotion;
	private Label lblYear;
	private TextField txtYear;
	private Label lblSearch;
	private TextField txtSearch;
	private Button btnSearch;
	private Button btnAdd;
	private Button btnFullExport;
	private Button btnSelectionExport;
	private Button btnReturn;
	private Button btnDoc;
	private HBox btnUserBox;
	private HBox btnExportBox;
	private HBox btnAdminBox;
	private HBox btnReturnWelcomeBox;
	private HBox btnDocBox;
	
	public FormPannelUser() {
		super();
		
		lblLastName = new Label("Nom ");
		txtLastName = new TextField();
		addRow(0, lblLastName, txtLastName);

		lblFirstName = new Label("Prénom ");
		txtFirstName = new TextField();
		addRow(1, lblFirstName, txtFirstName);

		lblDepartment = new Label("Département / Pays ");
		cbDepartment = new ComboBox<>();
		cbDepartment.getItems().addAll("Choisir","01","02","03",
				"04","05","06","07","08","09",
				"11","12","13","14","15","16","17","18","19",
				"20","21","22","23","24","25","26","27","28","29",
				"30","31","32","33","34","35","36","37","38","39",
				"40","41","42","43","44","45","46","47","48","49",
				"50","51","52","53","54","55","56","57","58","59",
				"60","61","62","63","64","65","66","67","68","69",
				"70","71","72","73","74","75","76","77","78","79",
				"80","81","82","83","84","85","86","87","88","89",
				"90","91","92","93","94","95",
				"971","972","973","974","976", "Ya", "VE", "US", "SU", "BR", "DZ",
				"TN", "MA");
		addRow(2, lblDepartment,cbDepartment);
		cbDepartment.setVisibleRowCount(10);
		cbDepartment.getSelectionModel().select(0);;
		//cbDepartment.setId(".background");

		lblPromotion = new Label ("Promotion");
		txtPromotion = new TextField ();
		addRow(3, lblPromotion,txtPromotion);

		lblYear = new Label("Année");
		txtYear  = new TextField();
		addRow(4, lblYear,txtYear);		
		
		lblSearch = new Label("Rechercher un stagiaire par mot clé");
		txtSearch = new TextField();
		addRow(5, lblSearch, txtSearch);
		
		
		btnSearch = new Button("Rechercher");
		btnSearch.setPrefSize(270, 100);	
		
		btnReturn = new Button("Retour à l'accueil");
		btnReturn.setPrefSize(590, 100);
		btnReturnWelcomeBox = new HBox(50);
		btnReturnWelcomeBox.getChildren().add(btnReturn);
		btnReturnWelcomeBox.setAlignment(Pos.CENTER);
		add(btnReturnWelcomeBox, 0, 13, 2, 1);
		
		btnDoc = new Button("Documentation utilisateur (page web)");
		btnDoc.setPrefSize(590, 100);
		btnDocBox = new HBox(50);
		btnDocBox.getChildren().add(btnDoc);
		btnDocBox.setAlignment(Pos.CENTER);
		add(btnDocBox, 0, 14, 2, 1);
		
		btnDoc.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				BrowserControl.displayURL("https://github.com/BertRomain/Annuaire/blob/main/README.md");
				
			}
		});

		btnReturn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				FirstPaneWelcome root = new FirstPaneWelcome();
				Scene scene = new Scene(root);	
				scene.getStylesheets().add(getClass().getResource("./RMRstylesheet.css")
						.toExternalForm());
				Stage stage = (Stage) getScene().getWindow();
				stage.setScene(scene);
				
			}
		});
		
		btnAdd = new Button("Ajouter un stagiaire");
		btnAdd.setPrefSize(270, 100);

		btnAdd.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String lastName = txtLastName.getText().toUpperCase();
				String firstName = txtFirstName.getText();
				String department = cbDepartment.getSelectionModel().getSelectedItem();
				String promotion = txtPromotion.getText();
				int year = Integer.parseInt(txtYear.getText());
				Intern intern = new Intern(lastName, firstName, department, promotion, year);

				AdminPane adminPane = (AdminPane) getScene().getRoot();
				adminPane.getTablePannel().getObservableInterns().add(intern);

			}
		});


		btnUserBox = new HBox(50);
		btnUserBox.getChildren().addAll(btnSearch,btnAdd);
		btnUserBox.setAlignment(Pos.CENTER);
		add(btnUserBox, 0, 10, 2, 1);

		btnFullExport = new Button("Exporter annuaire entier\r             (en PDF) ");
		btnFullExport.setPrefSize(270, 100);
	
		btnSelectionExport = new Button("Exporter extrait annuaire\r           (en PDF)");
		btnSelectionExport.setPrefSize(270, 100);
		btnExportBox = new HBox(50);
		btnExportBox.getChildren().addAll(btnSelectionExport,btnFullExport);
		btnExportBox.setAlignment(Pos.CENTER);
		
		add(btnExportBox, 0, 12, 2, 1);
		btnSelectionExport.setOnAction(e -> {
			try {
				String export = txtSearch.getText().toString();
				ExportPdf.toFile(TablePannel.tableView, "c:/Annuaire_EQL/annuaire_exporté_extrait_"+ export + ".pdf");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		btnFullExport.setOnAction(e -> {
			RandomAccessFile raf = null;
			int index = 0;
			File file = InternDao.file;
			int entireLengthOfRecord = InternDao.entireLengthOfRecord;
			int lengthOfRecord = InternDao.lengthOfRecord;
			TableView<Intern> tableView = TablePannel.tableView;
			tableView.getItems().clear();
			
			try {
				raf = new RandomAccessFile(file, "rw");
				int numberOfInterns = (int) (raf.length() / 278);
				index =0;
				while(index < numberOfInterns){
				byte[] b = null;	
				String line2 = "";
				raf.seek(index * entireLengthOfRecord);
				b = new byte[lengthOfRecord];
				raf.read(b);
				line2 = new String(b);
				Intern intern2 = stringToIntern(line2);		
				AdminPane adminPane = (AdminPane) FormPannelUser.this.getScene().getRoot();
				adminPane.getTablePannel().getObservableInterns().add(intern2);
				index ++;
				}
				ExportPdf.toFile(TablePannel.tableView, "c:/Annuaire_EQL/annuaire_exporté_entier.pdf");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	});
		setVgap(20);
		setPadding(new Insets(20));
	}
	
	private static Intern stringToIntern (String line) {
		
		String[] infos = line.split(";");
		Intern intern = new Intern(infos[0].trim().toUpperCase(),(infos[1].trim().substring(0, 1).toUpperCase() + infos[1].trim().substring(1).toLowerCase()),(infos[2].trim()),
				infos[3].trim(),Integer.parseInt(infos[4].trim()));		
		return intern;
	}
}
