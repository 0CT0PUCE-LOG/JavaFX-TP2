package fr.umontpellier.iut.exercice6;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConvertisseurTemperatures extends Application {

    @Override
    public void start(Stage primaryStage) {
        //crée un curseur verical gradué de 0 à 100
        Slider sliderCelsius = new Slider(0, 100, 0);
        sliderCelsius.setOrientation(Orientation.VERTICAL);
        sliderCelsius.setShowTickMarks(true);
        sliderCelsius.setShowTickLabels(true);
        sliderCelsius.setMinorTickCount(3);
        sliderCelsius.setBlockIncrement(0.10);
        sliderCelsius.setSnapToTicks(true);
        sliderCelsius.setMinHeight(500);
        sliderCelsius.setMaxHeight(1000);
        //crée un curseur verical gradué de 32 à 212
        Slider sliderFahrenheit = new Slider(0, 212, 32);
        sliderFahrenheit.setOrientation(Orientation.VERTICAL);
        sliderFahrenheit.setShowTickMarks(true);
        sliderFahrenheit.setShowTickLabels(true);
        sliderFahrenheit.setMinorTickCount(3);
        sliderFahrenheit.setBlockIncrement(0.10);
        sliderFahrenheit.setSnapToTicks(true);
        sliderFahrenheit.setMinHeight(500);
        sliderFahrenheit.setMaxHeight(1000);

        VBox panneauCelsius = new VBox(30);
        VBox panneauFahrenheit = new VBox(30);

        Label labelCelsius = new Label("°C");
        Label labelFahrenheit = new Label("°F");

        TextField textFieldCelsius = new TextField();
        TextField textFieldFahrenheit = new TextField();

        panneauCelsius.getChildren().addAll(labelCelsius);
        panneauCelsius.getChildren().addAll(sliderCelsius);
        panneauCelsius.getChildren().addAll(textFieldCelsius);

        panneauFahrenheit.getChildren().addAll(labelFahrenheit);
        panneauFahrenheit.getChildren().addAll(sliderFahrenheit);
        panneauFahrenheit.getChildren().addAll(textFieldFahrenheit);


        sliderCelsius.valueProperty().addListener((observable, oldValue, newValue) -> {
            sliderFahrenheit.valueProperty().setValue(newValue.doubleValue() * (9.0 / 5.0) + 32.0);
            textFieldFahrenheit.setText(String.format("%.2f", sliderFahrenheit.getValue()));
        });
        sliderFahrenheit.valueProperty().addListener((observable, oldValue, newValue) -> {
            sliderCelsius.valueProperty().setValue((newValue.doubleValue() - 32.0) * 5.0 / 9.0);
            textFieldCelsius.setText(String.format("%.2f", sliderCelsius.getValue()));
        });

        HBox root = new HBox(30, panneauCelsius, panneauFahrenheit);
        root.setPadding(new Insets(20));

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}