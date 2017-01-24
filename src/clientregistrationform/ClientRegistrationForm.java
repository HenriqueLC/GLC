package clientregistrationform;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import widgets.MaskField;

public class ClientRegistrationForm extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Grid pane
        GridPane gridPane = new GridPane();
        gridPane.setId("grid-pane");

        // Dados de identificação (1)
        Text text1 = new Text();
        text1.setText("Dados de identificação");
        text1.setId("title-text");
        gridPane.add(text1, 0, 0);

        // Tipo de pessoa (2)
        Text text2 = new Text();
        text2.setText("Tipo de pessoa:");
        ChoiceBox<String> choiceBox2 = new ChoiceBox<>();
        choiceBox2.setItems(FXCollections.observableArrayList("Física", "Jurídica", "Órgão Público"));
        HBox hBox2 = new HBox();
        hBox2.setStyle("-fx-spacing: 10; -fx-alignment: center-left;");
        hBox2.getChildren().addAll(text2, choiceBox2);
        VBox vBox2 = new VBox();
        vBox2.setStyle("-fx-spacing: 5; -fx-alignment: bottom-left;");
        vBox2.getChildren().add(hBox2);
        gridPane.add(vBox2, 0, 1);

        // CPF/CNPJ (3)
        Text text3 = new Text();
        text3.setText("CPF");
        MaskField maskField3 = new MaskField();
        maskField3.setMask("DDD.DDD.DDD-DD");
        maskField3.setStyle("-fx-font-family: Sans Serif; -fx-font-size: 12px; -fx-max-width: 112px;");
        VBox vBox3 = new VBox();
        vBox3.setStyle("-fx-spacing: 5; -fx-alignment: bottom-left;");
        vBox3.getChildren().addAll(text3, maskField3);
        gridPane.add(vBox3, 1, 1);

        // Nome completo * (4)
        Text text4 = new Text();
        text4.setText("Nome completo");
        Label redAsterisk = new Label(" *");
        redAsterisk.setId("red-asterisk-text");
        HBox hBox4 = new HBox();
        hBox4.getChildren().addAll(text4, redAsterisk);
        TextField textField4 = new TextField();
        VBox vBox4 = new VBox();
        vBox4.setStyle("-fx-spacing: 5; -fx-alignment: bottom-left;");
        vBox4.getChildren().addAll(hBox4, textField4);
        gridPane.add(vBox4, 0, 2, 2, 1);

        // Nome abreviado/Apelido (5)
        Text text5 = new Text();
        text5.setText("Nome abreviado/Apelido");
        TextField textField5 = new TextField();
        VBox vBox5 = new VBox();
        vBox5.setStyle("-fx-spacing: 5; -fx-alignment: bottom-left;");
        vBox5.getChildren().addAll(text5, textField5);
        gridPane.add(vBox5, 0, 3, 2, 1);

        // Endereço (6)
        ToggleGroup group = new ToggleGroup();
        RadioButton button1 = new RadioButton("Usar endereço");
        button1.setToggleGroup(group);
        button1.setSelected(true);
        RadioButton button2 = new RadioButton("Não usar endereço");
        button2.setToggleGroup(group);
        button2.setSelected(true);
        HBox hBox6 = new HBox();
        hBox6.setStyle("-fx-spacing: 10;");
        hBox6.getChildren().addAll(button1, button2);
        gridPane.add(hBox6, 0, 4);

        // CEP (7)
        Text text7 = new Text();
        text7.setText("CEP");
        MaskField maskField7 = new MaskField();
        maskField7.setMask("DDDDD-DDD");
        maskField7.setStyle("-fx-font-family: Sans Serif; -fx-font-size: 12px; -fx-max-width: 84px;");
        VBox vBox7 = new VBox();
        vBox7.setStyle("-fx-spacing: 5; -fx-alignment: bottom-left;");
        vBox7.getChildren().addAll(text7, maskField7);
        gridPane.add(vBox7, 0, 5);

        // Logradouro (8)
        Text text8 = new Text();
        text8.setText("Logradouro");
        TextField textField8 = new TextField();
        textField8.setPromptText("Ex.: Av. Brasil");
        VBox vBox8 = new VBox();
        vBox8.setStyle("-fx-spacing: 5; -fx-alignment: bottom-left;");
        vBox8.getChildren().addAll(text8, textField8);
        gridPane.add(vBox8, 0, 6, 1, 1);

        // Número (9)
        Text text9 = new Text();
        text9.setText("Número");
        MaskField maskField9 = new MaskField();
        maskField9.setMask("DDDDDD");
        maskField9.setStyle("-fx-font-family: Sans Serif; -fx-font-size: 12px; -fx-pref-width: 72px;");
        VBox vBox9 = new VBox();
        vBox9.setStyle("-fx-spacing: 5; -fx-alignment: bottom-left;");
        vBox9.getChildren().addAll(text9, maskField9);
        //gridPane.add(vBox9, 1, 7);

        // Scroll pane
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        scrollPane.setContent(gridPane);

        Scene scene = new Scene(scrollPane);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(ClientRegistrationForm.class.getResource("ClientRegistrationForm.css").toExternalForm());
        primaryStage.show();


    }
    public static void main(String[] args) {
        launch(args);
    }
}
