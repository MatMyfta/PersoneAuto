package personeauto;

import java.util.Optional;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PersoneAuto extends Application {
    
    @Override
    public void start(Stage primaryStage) {
	
	HBox root = new HBox();
	
	VBox boxPersone = new VBox();
	boxPersone.setAlignment(Pos.TOP_RIGHT);
	boxPersone.prefWidthProperty().bind(root.widthProperty());
	VBox boxAuto = new VBox();
	boxAuto.prefWidthProperty().bind(root.widthProperty());
	
	TextArea textFieldPersone = new TextArea();
	textFieldPersone.setMinHeight(100);
	textFieldPersone.setEditable(false);
	
	TextArea textFieldAuto = new TextArea();
	textFieldAuto.setMinHeight(100);
	textFieldAuto.setEditable(false);
	
	Button mescolaPersone = new Button("Mescola");
	Button mescolaAuto = new Button("Mescola");
	
	Button ordinaPersone = new Button("Ordina");
	Button ordinaAuto = new Button("Ordina");
	
	Button contaPersone = new Button("Conta");
	Button contaAuto = new Button("Conta");
	
	Button ordinaPersoneAnno = new Button("Ordina per anno");
	Button ordinaAutoPrezzo = new Button("Ordina per prezzo");
	
	Button nuovaPersona = new Button("New Person'");
	Button nuovaAuto = new Button("New Auto'");
	nuovaPersona.setAlignment(Pos.BOTTOM_CENTER);
	nuovaAuto.setAlignment(Pos.BOTTOM_CENTER);
	
	boxPersone.getChildren().addAll(textFieldPersone, mescolaPersone, ordinaPersone, contaPersone, ordinaPersoneAnno, nuovaPersona);
	boxAuto.getChildren().addAll(textFieldAuto, mescolaAuto, ordinaAuto, contaAuto, ordinaAutoPrezzo, nuovaAuto);
	
	mescolaPersone.setOnAction((ActionEvent event) -> {
	    Persona.mescolaPersone();
	    textFieldPersone.setText(Persona.stampaPersone());
	});
	
	contaPersone.setOnAction((ActionEvent event) -> {
	    System.out.println(Persona.contaPersone());
	});
	
	ordinaPersoneAnno.setOnAction((ActionEvent event) -> {
	    //Persona.ordinaPerAnno();
	    textFieldPersone.setText(Persona.stampaPersone());
	});
	
	nuovaPersona.setOnAction((ActionEvent event) -> {
	
	    Dialog inserisciPersona = new Dialog();
	    inserisciPersona.setTitle("Inserisci una nuova Persona");
	    
	    GridPane pane = new GridPane();
	    pane.setHgap(5);
	    pane.setVgap(5);
	    
	    Label lNome = new Label("Nome");
	    Label lCognome = new Label("Cognome");
	    Label lAnno = new Label("Anno");
	    
	    TextField insNome = new TextField();
	    TextField insCognome = new TextField();
	    TextField insAnno = new TextField();
	    
	    Button okButton = new Button("Controlla e Inserisci");
	    
	    pane.add(lNome, 0, 1);
	    pane.add(insNome, 1, 1);
	    pane.add(lCognome, 0, 2);
	    pane.add(insCognome, 1, 2);
	    pane.add(lAnno, 0, 3);
	    pane.add(insAnno, 1, 3);
	    pane.add(okButton, 0,4);
	    
	    okButton.setOnAction((ActionEvent e) -> {
		String nome = new String(insNome.getText());
		String cognome = new String(insCognome.getText());
		Integer anno = Integer.valueOf(insAnno.getText());
		Persona nuovo = new Persona(nome,cognome,anno);
		
		if (!nuovo.isPresent() && !nuovo.isEmpty()) {
		    Persona.listaPersone.add(nuovo);
		    inserisciPersona.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);
		    inserisciPersona.close();
		}
		else {
		    System.err.println("error");
		}
		System.out.println(Persona.stampaPersone());
		textFieldPersone.setText(Persona.stampaPersone());
	    });
	    
	    inserisciPersona.getDialogPane().setContent(pane);
	    
	    Optional<String> s = inserisciPersona.showAndWait();
	    
	});
	
	root.getChildren().addAll(boxPersone,boxAuto);
	
	Scene scene = new Scene(root, 600, 300);
	
	primaryStage.setTitle("Hello World!");
	primaryStage.setScene(scene);
	primaryStage.show();
    }
    
    public static void main(String[] args) {
	launch(args);
    }
    
}
