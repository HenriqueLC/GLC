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

        // Dados de identificação
        Text text0 = new Text();
        text0.setText("Dados de identificação");
        text0.setId("title-text");
        gridPane.add(text0, 0, 0);

        // Tipo de pessoa (1)
        Text text1 = new Text();
        text1.setText("Tipo de pessoa:");
        text1.setId("standard-text");
        ChoiceBox<String> choiceBox1 = new ChoiceBox<>();
        choiceBox1.setItems(FXCollections.observableArrayList("Física", "Jurídica", "Órgão Público"));
        HBox hBox1 = new HBox();
        hBox1.setId("hbox");
        hBox1.getChildren().addAll(text1, choiceBox1);
        VBox vBox1 = new VBox();
        vBox1.setId("vbox");
        vBox1.getChildren().add(hBox1);
        gridPane.add(vBox1, 0, 1);

        // CPF/CNPJ (2)
        Text text2 = new Text();
        text2.setText("CPF");
        text2.setId("standard-text");
        MaskField maskField2 = new MaskField();
        maskField2.setMask("DDD.DDD.DDD-DD");
        maskField2.setMaxWidth(100);
        VBox vBox2 = new VBox();
        vBox2.setId("vbox");
        vBox2.getChildren().addAll(text2, maskField2);
        gridPane.add(vBox2, 1, 1);

        // Nome completo * (3)
        Text text3 = new Text();
        text3.setText("Nome completo");
        text3.setId("standard-text");
        Label redAsterisk = new Label(" *");
        redAsterisk.setId("red-asterisk-text");
        HBox hBox3 = new HBox();
        hBox3.getChildren().addAll(text3, redAsterisk);
        TextField textField3 = new TextField();
        VBox vBox3 = new VBox();
        vBox3.setId("vbox");
        vBox3.getChildren().addAll(hBox3, textField3);
        gridPane.add(vBox3, 0, 2, 2, 1);

        // Nome abreviado/Apelido (4)
        Text text4 = new Text();
        text4.setText("Nome abreviado/Apelido");
        text4.setId("standard-text");
        TextField textField4 = new TextField();
        VBox vBox4 = new VBox();
        vBox4.setId("vbox");
        vBox4.getChildren().addAll(text4, textField4);
        gridPane.add(vBox4, 0, 3, 2, 1);

        // Adicionar endereço (5)
        Hyperlink hyperlink5 = new Hyperlink();
        hyperlink5.setText("Adicionar Endereço");
        hyperlink5.setId("hyperlink");
        gridPane.add(hyperlink5, 0, 4);

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
