package clientregistrationform;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
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
        gridPane.add(tipoDePessoaChoiceBox, 1, 1, 2, 1);

        // CPF/CNPJ
        Text CpfCnpjText = new Text();
        CpfCnpjText.setText("CPF");
        CpfCnpjText.setStyle("-fx-font-family: Sans Serif; -fx-font-size: 12px; -fx-font-weight: bold;");
        gridPane.add(CpfCnpjText, 0, 2);
        MaskField CpfCnpjMaskField = new MaskField();
        CpfCnpjMaskField.setMask("DDD.DDD.DDD-DD");
        CpfCnpjMaskField.setStyle("-fx-font-family: Sans Serif; -fx-font-size: 12px; -fx-max-width: 115px");
        gridPane.add(CpfCnpjMaskField, 1, 2, 2, 1);

        // Nome completo/Razão social *
        Text nomeCompletoRazaoSocialText = new Text();
        nomeCompletoRazaoSocialText.setText("Nome completo");
        nomeCompletoRazaoSocialText.setStyle("-fx-font-family: Sans Serif; -fx-font-size: 12px; -fx-font-weight: bold;");
        Label nomeCompletoRazaoSocialRedAsterisk = new Label(" *");
        nomeCompletoRazaoSocialRedAsterisk.setId("red-asterisk-text");
        HBox nomeCompletoRazaoSocialTextHBox = new HBox();
        nomeCompletoRazaoSocialTextHBox.getChildren().addAll(nomeCompletoRazaoSocialText, nomeCompletoRazaoSocialRedAsterisk);
        nomeCompletoRazaoSocialTextHBox.setStyle("-fx-spacing: 0; -fx-alignment: center-left;");
        gridPane.add(nomeCompletoRazaoSocialTextHBox, 0, 3);
        TextField nomeCompletoRazaoSocialTextField = new TextField();
        gridPane.add(nomeCompletoRazaoSocialTextField, 1, 3, 3, 1);

        // Nome abreviado/Apelido
        Text nomeAbreviadoApelidoNomeFantasiaText = new Text();
        nomeAbreviadoApelidoNomeFantasiaText.setText("Nome abreviado/Apelido");
        nomeAbreviadoApelidoNomeFantasiaText.setStyle("-fx-font-family: Sans Serif; -fx-font-size: 12px; -fx-font-weight: bold;");
        gridPane.add(nomeAbreviadoApelidoNomeFantasiaText, 0, 4);
        TextField nomeAbreviadoApelidoNomeFantasiaTextField = new TextField();
        gridPane.add(nomeAbreviadoApelidoNomeFantasiaTextField, 1, 4, 3, 1);

        // Endereço
        ToggleGroup group = new ToggleGroup();
        RadioButton button1 = new RadioButton("Usar endereço");
        button1.setToggleGroup(group);
        button1.setSelected(true);
        RadioButton button2 = new RadioButton("Não usar endereço");
        button2.setToggleGroup(group);
        button2.setSelected(true);
        HBox endereçoHBox = new HBox();
        endereçoHBox.setStyle("-fx-spacing: 10; -fx-alignment: center-left;");
        endereçoHBox.getChildren().addAll(button1, button2);
        gridPane.add(endereçoHBox, 1, 5, 3, 1);

        // CEP *
        Text CepText = new Text();
        CepText.setText("CEP");
        CepText.setStyle("-fx-font-family: Sans Serif; -fx-font-size: 12px; -fx-font-weight: bold;");
        Label CepRedAsterisk = new Label(" *");
        CepRedAsterisk.setId("red-asterisk-text");
        HBox CepTextHBox = new HBox();
        CepTextHBox.getChildren().addAll(CepText, CepRedAsterisk);
        CepTextHBox.setStyle("-fx-spacing: 0; -fx-alignment: center-left;");
        gridPane.add(CepTextHBox, 0, 6);
        MaskField CepMaskField = new MaskField();
        CepMaskField.setMask("DDDDD-DDD");
        CepMaskField.setStyle("-fx-font-family: Sans Serif; -fx-font-size: 12px; -fx-max-width: 85px;");
        gridPane.add(CepMaskField, 1, 6, 1, 1);

        // Estado *
        Text estadoText = new Text();
        estadoText.setText("UF");
        estadoText.setStyle("-fx-font-family: Sans Serif; -fx-font-size: 12px; -fx-font-weight: bold;");
        Label estadoRedAsterisk = new Label(" *");
        estadoRedAsterisk.setId("red-asterisk-text");
        HBox estadoTextHBox = new HBox();
        estadoTextHBox.getChildren().addAll(estadoText, estadoRedAsterisk);
        estadoTextHBox.setAlignment(Pos.CENTER_LEFT);
        AutoCompleteComboBox<String> estadoComboBox = new AutoCompleteComboBox<>();
        estadoComboBox.setItems(FXCollections.observableArrayList("AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"));
        estadoComboBox.setComparisonMethod((typedText, itemToCompare) -> itemToCompare.toLowerCase().contains(typedText.toLowerCase()));
        estadoComboBox.setMaxNumChars(2);
        estadoComboBox.initialize();
        estadoComboBox.getEditor().setStyle("-fx-font-family: Sans Serif; -fx-font-size: 12px;");
        estadoComboBox.setStyle("-fx-max-width: 65px;");
        HBox estadoHBox = new HBox();
        estadoHBox.getChildren().addAll(estadoTextHBox, estadoComboBox);
        estadoHBox.setStyle("-fx-spacing: 10; -fx-alignment: center-left;");
        gridPane.add(estadoHBox, 2, 6, 1, 1);

        // Município *
        Text municipioText = new Text();
        municipioText.setText("Município");
        municipioText.setStyle("-fx-font-family: Sans Serif; -fx-font-size: 12px; -fx-font-weight: bold;");
        Label municipioRedAsterisk = new Label(" *");
        municipioRedAsterisk.setId("red-asterisk-text");
        HBox municipioTextHBox = new HBox();
        municipioTextHBox.getChildren().addAll(municipioText, municipioRedAsterisk);
        municipioTextHBox.setStyle("-fx-spacing: 0; -fx-alignment: center-left;");
        gridPane.add(municipioTextHBox, 0, 7);
        AutoCompleteComboBox<String> municipioComboBox = new AutoCompleteComboBox<>();
        municipioComboBox.setItems(FXCollections.observableArrayList("Nossa Senhora da Purificação do Desemboque e do Sagrado Sacramento", "Campinas", "Jundiaí", "Cabreúva"));
        municipioComboBox.setComparisonMethod((typedText, itemToCompare) -> itemToCompare.toLowerCase().contains(typedText.toLowerCase()));
        municipioComboBox.initialize();
        municipioComboBox.getEditor().setStyle("-fx-font-family: Sans Serif; -fx-font-size: 12px;");
        //municipioComboBox.setStyle("-fx-pref-width: 500px;");
        gridPane.add(municipioComboBox, 1, 7, 3, 1);

        // Logradouro *
        Text logradouroText = new Text();
        logradouroText.setText("Logradouro");
        logradouroText.setStyle("-fx-font-family: Sans Serif; -fx-font-size: 12px; -fx-font-weight: bold;");
        Label logradouroRedAsterisk = new Label(" *");
        logradouroRedAsterisk.setId("red-asterisk-text");
        HBox logradouroTextHBox = new HBox();
        logradouroTextHBox.getChildren().addAll(logradouroText, logradouroRedAsterisk);
        logradouroTextHBox.setStyle("-fx-spacing: 0; -fx-alignment: center-left;");
        gridPane.add(logradouroTextHBox, 0, 8);
        TextField logradouroTextField = new TextField();
        logradouroTextField.setPromptText("Ex.: Av. Brasil");

        // Número *
        Text numeroText = new Text();
        numeroText.setText("Nº");
        numeroText.setStyle("-fx-font-family: Sans Serif; -fx-font-size: 12px; -fx-font-weight: bold;");
        Label numeroRedAsterisk = new Label(" *");
        numeroRedAsterisk.setId("red-asterisk-text");
        HBox numeroTextHBox = new HBox();
        numeroTextHBox.getChildren().addAll(numeroText, numeroRedAsterisk);
        numeroTextHBox.setStyle("-fx-spacing: 0; -fx-alignment: center-left;");
        MaskField numeroMaskField = new MaskField();
        numeroMaskField.setMask("DDDDD");
        numeroMaskField.setStyle("-fx-font-family: Sans Serif; -fx-font-size: 12px; -fx-pref-width: 50px;");
        HBox numeroHBox = new HBox();
        numeroHBox.getChildren().addAll(numeroTextHBox, numeroMaskField);
        numeroHBox.setStyle("-fx-spacing: 10; -fx-alignment: center-left;");

        // Logradouro e número (adição ao painel)
        HBox logradouroNumeroHBox = new HBox();
        logradouroNumeroHBox.getChildren().addAll(logradouroTextField, numeroHBox);
        //HBox.setHgrow(logradouroTextField, Priority.ALWAYS);
        logradouroNumeroHBox.setStyle("-fx-spacing: 10; -fx-alignment: center-left;");
        //gridPane.add(logradouroNumeroHBox, 1, 8, 3, 1);

        // Complemento *
        Text complementoText = new Text();
        complementoText.setText("Complemento");
        complementoText.setStyle("-fx-font-family: Sans Serif; -fx-font-size: 12px; -fx-font-weight: bold;");
        gridPane.add(complementoText, 0, 9);
        TextField complementoTextField = new TextField();
        complementoTextField.setPromptText("Ex.: Ap. 51");
        gridPane.add(complementoTextField, 1, 9, 3, 1);

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