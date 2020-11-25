package fr.eql.ai108.groupeRMR.ihm;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class FormPannelAdmin extends GridPane {
	
	private Label lblLastName;
	private TextField txtLastName;
	private Label lblFirstName;
	private TextField txtFirstName;
	private Label lblDepartment;
	private ChoiceBox<String> cbDepartment;
	private Label lblPromotion;
	private TextField txtPromotion;
	private Label lblYear;
	private TextField txtYear;
	private Button btnSearch;
	private Button btnAdd;
	private Button btnFullExport;
	private Button btnSelectionExport;
	private Button btnRefresh;
	private Button btnDelete;
	private HBox btnUserBox;
	private HBox btnExportBox;
	private HBox btnAdminBox;
	
	public FormPannelAdmin() {
		super();
		
		
		lblLastName = new Label("Nom ");
		txtLastName = new TextField();
		addRow(0, lblLastName, txtLastName);
		
		lblFirstName = new Label("Prénom ");
		txtFirstName = new TextField();
		addRow(1, lblFirstName, txtFirstName);
		
		lblDepartment = new Label("Département / Pays ");
		cbDepartment = new ChoiceBox<>();
		cbDepartment.getItems().addAll("01","02","03","04","05","06","07","08","09",
				"11","12","13","14","15","16","17","18","19",
				"20","21","22","23","24","25","26","27","28","29",
				"30","31","32","33","34","35","36","37","38","39",
				"40","41","42","43","44","45","46","47","48","49",
				"50","51","52","53","54","55","56","57","58","59",
				"60","61","62","63","64","65","66","67","68","69",
				"70","71","72","73","74","75","76","77","78","79",
				"80","81","82","83","84","85","86","87","88","89",
				"90","91","92","93","94","95",
				"971","972","973","974","976");
		addRow(2, lblDepartment,cbDepartment);
		
		lblPromotion = new Label ("Promotion");
		txtPromotion = new TextField ();
		addRow(3, lblPromotion,txtPromotion);
		
		lblYear = new Label("Année");
		txtYear  = new TextField();
		addRow(4, lblYear,txtYear);		
		
		btnSearch = new Button("Rechercher");
		btnSearch.setPrefSize(250, 100);		
		btnAdd = new Button("Ajouter un stagiaire");
		btnAdd.setPrefSize(250, 100);
		btnUserBox = new HBox(50);
		btnUserBox.getChildren().addAll(btnSearch,btnAdd);
		btnUserBox.setAlignment(Pos.CENTER);
		add(btnUserBox, 0, 10, 2, 1);
		
		btnFullExport = new Button("Exporter Annuaire" + "\n" +"(format Pdf)");
		btnFullExport.setPrefSize(250, 100);
		btnSelectionExport = new Button("Exporter extrait annuaire "+ "\n" +"(format Pdf)");
		btnSelectionExport.setPrefSize(250, 100);
		btnExportBox = new HBox(50);
		btnExportBox.getChildren().addAll(btnSelectionExport,btnFullExport);
		btnExportBox.setAlignment(Pos.CENTER);
		add(btnExportBox, 0, 11, 2, 1);
		
		btnDelete = new Button("Supprimer un stagiaire");
		btnDelete.setPrefSize(250, 100);
		btnRefresh = new Button("Mettre à jour");
		btnRefresh.setPrefSize(250, 100);
		btnAdminBox = new HBox(50);
		btnAdminBox.getChildren().addAll(btnDelete,btnRefresh);
		btnAdminBox.setAlignment(Pos.CENTER);
		add(btnAdminBox, 0, 12, 2, 1);
	
		setVgap(20);
		setPadding(new Insets(20));
		
		

	}
	
	
	

}
