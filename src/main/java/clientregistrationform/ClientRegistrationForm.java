package clientregistrationform;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import widgets.AutoCompleteComboBox;
import widgets.MaskField;

public class ClientRegistrationForm extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Grid pane
        GridPane gridPane = new GridPane();
        gridPane.setId("grid-pane");

        // Tipo de pessoa
        Text tipoDePessoaText = new Text();
        tipoDePessoaText.setText("Tipo de pessoa:");
        tipoDePessoaText.setStyle("-fx-font-family: Sans Serif; -fx-font-size: 12px; -fx-font-weight: bold;");
        gridPane.add(tipoDePessoaText, 0, 1);
        ChoiceBox<String> tipoDePessoaChoiceBox = new ChoiceBox<>();
        tipoDePessoaChoiceBox.setItems(FXCollections.observableArrayList("Física", "Jurídica", "Órgão Público"));
        gridPane.add(tipoDePessoaChoiceBox, 1, 1);

        // CPF/CNPJ
        Text CpfCnpjText = new Text();
        CpfCnpjText.setText("CPF");
        CpfCnpjText.setStyle("-fx-font-family: Sans Serif; -fx-font-size: 12px; -fx-font-weight: bold;");
        gridPane.add(CpfCnpjText, 0, 2);
        MaskField CpfCnpjMaskField = new MaskField();
        CpfCnpjMaskField.setMask("DDD.DDD.DDD-DD");
        CpfCnpjMaskField.setStyle("-fx-font-family: Sans Serif; -fx-font-size: 12px; -fx-max-width: 112px");
        gridPane.add(CpfCnpjMaskField, 1, 2);

        // Nome completo *
        Text nomeCompletoRazaoSocialText = new Text();
        nomeCompletoRazaoSocialText.setText("Nome completo");
        nomeCompletoRazaoSocialText.setStyle("-fx-font-family: Sans Serif; -fx-font-size: 12px; -fx-font-weight: bold;");
        Label nomeCompletoRazaoSocialRedAsterisk = new Label(" *");
        nomeCompletoRazaoSocialRedAsterisk.setId("red-asterisk-text");
        HBox nomeCompletoRazaoSocialHBox = new HBox();
        nomeCompletoRazaoSocialHBox.getChildren().addAll(nomeCompletoRazaoSocialText, nomeCompletoRazaoSocialRedAsterisk);
        gridPane.add(nomeCompletoRazaoSocialHBox, 0, 3);
        TextField nomeCompletoRazaoSocialTextField = new TextField();
        gridPane.add(nomeCompletoRazaoSocialTextField, 1, 3);

        // Nome abreviado/Apelido
        Text nomeAbreviadoApelidoNomeFantasiaText = new Text();
        nomeAbreviadoApelidoNomeFantasiaText.setText("Nome abreviado/Apelido");
        nomeAbreviadoApelidoNomeFantasiaText.setStyle("-fx-font-family: Sans Serif; -fx-font-size: 12px; -fx-font-weight: bold;");
        gridPane.add(nomeAbreviadoApelidoNomeFantasiaText, 0, 4);
        TextField nomeAbreviadoApelidoNomeFantasiaTextField = new TextField();
        gridPane.add(nomeAbreviadoApelidoNomeFantasiaTextField, 1, 4);

        // Endereço
        ToggleGroup group = new ToggleGroup();
        RadioButton button1 = new RadioButton("Usar endereço");
        button1.setToggleGroup(group);
        button1.setSelected(true);
        RadioButton button2 = new RadioButton("Não usar endereço");
        button2.setToggleGroup(group);
        button2.setSelected(true);
        HBox endereçoHBox = new HBox();
        endereçoHBox.setStyle("-fx-spacing: 10;");
        endereçoHBox.getChildren().addAll(button1, button2);
        gridPane.add(endereçoHBox, 1, 5);

        // CEP *
        Text CepText = new Text();
        CepText.setText("CEP");
        CepText.setStyle("-fx-font-family: Sans Serif; -fx-font-size: 12px; -fx-font-weight: bold;");
        Label CepRedAsterisk = new Label(" *");
        CepRedAsterisk.setId("red-asterisk-text");
        HBox CepHBox = new HBox();
        CepHBox.getChildren().addAll(CepText, CepRedAsterisk);
        gridPane.add(CepHBox, 0, 6);
        MaskField CepMaskField = new MaskField();
        CepMaskField.setMask("DDDDD-DDD");
        CepMaskField.setStyle("-fx-font-family: Sans Serif; -fx-font-size: 12px; -fx-max-width: 74px;");
        gridPane.add(CepMaskField, 1, 6);

        // Estado
        Text estadoText = new Text();
        estadoText.setText("UFº");
        estadoText.setStyle("-fx-font-family: Sans Serif; -fx-font-size: 12px; -fx-font-weight: bold;");
        Label estadoRedAsterisk = new Label(" *");
        estadoRedAsterisk.setId("red-asterisk-text");
        HBox estadoHBox = new HBox();
        estadoHBox.getChildren().addAll(estadoText, estadoRedAsterisk);
        gridPane.add(estadoHBox, 2, 6);
        AutoCompleteComboBox<String> estadoComboBox = new AutoCompleteComboBox<>();
        estadoComboBox.setItems(FXCollections.observableArrayList("AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"));
        estadoComboBox.setComparisonMethod((typedText, itemToCompare) -> itemToCompare.toLowerCase().contains(typedText.toLowerCase()));
        estadoComboBox.setMaxNumChars(2);
        estadoComboBox.initialize();
        gridPane.add(estadoComboBox, 3, 6);

        // Cidade

        // Bairro

        // Logradouro
        Text logradouroText = new Text();
        logradouroText.setText("Logradouro");
        logradouroText.setStyle("-fx-font-family: Sans Serif; -fx-font-size: 12px; -fx-font-weight: bold;");
        Label logradouroRedAsterisk = new Label(" *");
        logradouroRedAsterisk.setId("red-asterisk-text");
        HBox logradouroHBox = new HBox();
        logradouroHBox.getChildren().addAll(logradouroText, logradouroRedAsterisk);
        gridPane.add(logradouroHBox, 0, 7);
        TextField logradouroTextField = new TextField();
        logradouroTextField.setPromptText("Ex.: Av. Brasil");
        gridPane.add(logradouroTextField, 1, 7);

        // Número
        Text numeroText = new Text();
        numeroText.setText("Nº");
        numeroText.setStyle("-fx-font-family: Sans Serif; -fx-font-size: 12px; -fx-font-weight: bold;");
        Label numeroRedAsterisk = new Label(" *");
        numeroRedAsterisk.setId("red-asterisk-text");
        HBox numeroHBox = new HBox();
        numeroHBox.getChildren().addAll(numeroText, numeroRedAsterisk);
        gridPane.add(numeroHBox, 2, 7);
        MaskField numeroMaskField = new MaskField();
        numeroMaskField.setMask("DDDDD");
        numeroMaskField.setStyle("-fx-font-family: Sans Serif; -fx-font-size: 12px; -fx-pref-width: 50px;");
        gridPane.add(numeroMaskField, 3, 7);

        // Complemento
        Text complementoText = new Text();
        complementoText.setText("Complemento");
        complementoText.setStyle("-fx-font-family: Sans Serif; -fx-font-size: 12px; -fx-font-weight: bold;");
        gridPane.add(complementoText, 0, 8);
        TextField complementoTextField = new TextField();
        complementoTextField.setPromptText("Ex.: Ap. 51");
        gridPane.add(complementoTextField, 1, 8);

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