package fr.umontpellier.iut.exercice1;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

@SuppressWarnings("Duplicates")
public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private IntegerProperty nbFois;

    private StringProperty message;

    private StringProperty couleurPanneau;

    private Label texteDuHaut;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private Button disco;

    private BorderPane root;
    private Pane panneau;
    private HBox boutons;

    private Label texteDuBas;


    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();

        nbFois = new SimpleIntegerProperty();
        message = new SimpleStringProperty();
        couleurPanneau = new SimpleStringProperty("#000000");


        texteDuHaut = new Label();
        texteDuHaut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        BorderPane.setAlignment(texteDuHaut, Pos.CENTER);

        panneau = new Pane();
        panneau.setPrefSize(400, 200);

        VBox bas = new VBox();
        boutons = new HBox(10);
        boutons.setAlignment(Pos.CENTER);
        boutons.setPadding(new Insets(10, 5, 10, 5));
        texteDuBas = new Label();
        bas.setAlignment(Pos.CENTER_RIGHT);
        bas.getChildren().addAll(boutons, texteDuBas);

        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");
        disco = new Button("Disco");


        /* VOTRE CODE ICI */
        vert.setOnAction(actionEvent -> {
            nbVert++;
            nbFois.set(nbVert);
            message.set("nbFois : " + nbFois.get());
            couleurPanneau.set("-fx-background-color: green");
            texteDuHaut.textProperty().bind(message);
            texteDuBas.setText(message.get());
            texteDuBas.styleProperty().bind(couleurPanneau);
            panneau.styleProperty().bind(couleurPanneau);
        });

        rouge.setOnAction(actionEvent -> {
            nbRouge++;
            nbFois.set(nbRouge);
            message.set("nbFois : " + nbFois.get());
            couleurPanneau.set("-fx-background-color: red");
            texteDuHaut.textProperty().bind(message);
            texteDuBas.setText(message.get());
            texteDuBas.styleProperty().bind(couleurPanneau);
            panneau.styleProperty().bind(couleurPanneau);
        });

        bleu.setOnAction(actionEvent -> {
            nbBleu++;
            nbFois.set(nbBleu);
            message.set("nbFois : " + nbFois.get());
            couleurPanneau.set("-fx-background-color: blue");
            texteDuHaut.textProperty().bind(message);
            texteDuBas.setText(message.get());
            texteDuBas.styleProperty().bind(couleurPanneau);
            panneau.styleProperty().bind(couleurPanneau);
        });

        //quand le button disco est cliqué, faire clignoter les couleurs en boucles toutes les 1 seconde
        disco.setOnAction(actionEvent -> {
            new Thread(() -> {
                boolean fusible = false;
                while (true) {
                    try {
                        int time = 10;
                        if(time< 500 && !fusible){
                            time++;
                        }
                        if(time==500){
                            fusible = true;
                        }
                        if(time<=500 && fusible){
                            time--;
                        }
                        if(time==10){
                            fusible = false;
                        }
                        Thread.sleep(time);
                        couleurPanneau.set("-fx-background-color: blue");
                        panneau.styleProperty().bind(couleurPanneau);
                        Thread.sleep(time);
                        couleurPanneau.set("-fx-background-color: red");
                        panneau.styleProperty().bind(couleurPanneau);
                        Thread.sleep(time);
                        couleurPanneau.set("-fx-background-color: green");
                        panneau.styleProperty().bind(couleurPanneau);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        });


        boutons.getChildren().addAll(vert, rouge, bleu, disco);

        root.setCenter(panneau);
        root.setTop(texteDuHaut);
        root.setBottom(bas);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

