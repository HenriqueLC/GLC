package clientregistrationform;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
        gridPane.getColumnConstraints().add(new ColumnConstraints());
        gridPane.getColumnConstraints().add(new ColumnConstraints(500));

        // Tipo de pessoa
        Text tipoDePessoaText = new Text();
        tipoDePessoaText.setId("tipo-de-pessoa-text");
        tipoDePessoaText.setText("Tipo de pessoa:");
        gridPane.add(tipoDePessoaText, 0, 1);
        ChoiceBox<String> tipoDePessoaChoiceBox = new ChoiceBox<>();
        tipoDePessoaChoiceBox.setItems(FXCollections.observableArrayList("Física", "Jurídica", "Órgão Público"));
        gridPane.add(tipoDePessoaChoiceBox, 1, 1, 2, 1);

        // CPF/CNPJ
        Text CpfCnpjText = new Text();
        CpfCnpjText.setId("CPF-CNPJ-text");
        CpfCnpjText.setText("CPF");
        gridPane.add(CpfCnpjText, 0, 2);
        MaskField CpfCnpjMaskField = new MaskField();
        CpfCnpjMaskField.setId("CPF-CNPJ-mask-field");
        CpfCnpjMaskField.setMask("DDD.DDD.DDD-DD");
        Label CpfCnpjErroLabel = new Label();
        CpfCnpjErroLabel.setId("erro-label");
        CpfCnpjErroLabel.setText("Número já cadastrado");
        //CpfCnpjErroLabel.setVisible(false);
        VBox CpfCnpjVBox = new VBox();
        CpfCnpjVBox.setId("excecao-vbox");
        CpfCnpjVBox.getChildren().addAll(CpfCnpjMaskField, CpfCnpjErroLabel);
        gridPane.add(CpfCnpjVBox, 1, 2, 2, 1);

        // Nome completo/Razão social *
        Text nomeCompletoRazaoSocialText = new Text();
        nomeCompletoRazaoSocialText.setId("nome-completo-razao-social-text");
        nomeCompletoRazaoSocialText.setText("Nome completo");
        Label nomeCompletoRazaoSocialRedAsterisk = new Label(" *");
        nomeCompletoRazaoSocialRedAsterisk.setId("red-asterisk-text");
        HBox nomeCompletoRazaoSocialTextHBox = new HBox();
        nomeCompletoRazaoSocialTextHBox.setId("text-hbox");
        nomeCompletoRazaoSocialTextHBox.getChildren().addAll(nomeCompletoRazaoSocialText, nomeCompletoRazaoSocialRedAsterisk);
        gridPane.add(nomeCompletoRazaoSocialTextHBox, 0, 3);
        TextField nomeCompletoRazaoSocialTextField = new TextField();
        Label nomeCompletoRazaoSocialErroLabel = new Label();
        nomeCompletoRazaoSocialErroLabel.setId("aviso-label");
        nomeCompletoRazaoSocialErroLabel.setText("Nome já cadastrado");
        //nomeCompletoRazaoSocialErroLabel.setVisible(false);
        VBox nomeCompletoRazaoSocialVBox = new VBox();
        nomeCompletoRazaoSocialVBox.setId("excecao-vbox");
        nomeCompletoRazaoSocialVBox.getChildren().addAll(nomeCompletoRazaoSocialTextField, nomeCompletoRazaoSocialErroLabel);
        gridPane.add(nomeCompletoRazaoSocialVBox, 1, 3, 2, 1);

        // Endereço
        ToggleGroup group = new ToggleGroup();
        RadioButton button1 = new RadioButton("Usar endereço");
        button1.setToggleGroup(group);
        button1.setSelected(true);
        RadioButton button2 = new RadioButton("Não usar endereço");
        button2.setToggleGroup(group);
        button2.setSelected(true);
        HBox endereçoHBox = new HBox();
        endereçoHBox.setId("endereco-hbox");
        endereçoHBox.getChildren().addAll(button1, button2);
        gridPane.add(endereçoHBox, 1, 4, 2, 1);

        // CEP *
        Text CepText = new Text();
        CepText.setId("CEP-text");
        CepText.setText("CEP");
        CepText.setStyle("-fx-font-family: Sans Serif; -fx-font-size: 12px; -fx-font-weight: bold;");
        Label CepRedAsterisk = new Label(" *");
        CepRedAsterisk.setId("red-asterisk-text");
        HBox CepTextHBox = new HBox();
        CepTextHBox.setId("text-hbox");
        CepTextHBox.getChildren().addAll(CepText, CepRedAsterisk);
        gridPane.add(CepTextHBox, 0, 5);
        MaskField CepMaskField = new MaskField();
        CepMaskField.setId("Cep-mask-field");
        CepMaskField.setMask("DDDDD-DDD");
        gridPane.add(CepMaskField, 1, 5, 2, 1);

        // UF *
        Text UfText = new Text();
        UfText.setId("UF-text");
        UfText.setText("UF");
        Label estadoRedAsterisk = new Label(" *");
        estadoRedAsterisk.setId("red-asterisk-text");
        HBox estadoTextHBox = new HBox();
        estadoTextHBox.setId("text-hbox");
        estadoTextHBox.getChildren().addAll(UfText, estadoRedAsterisk);
        gridPane.add(estadoTextHBox, 0, 6);
        AutoCompleteComboBox<String> estadoComboBox = new AutoCompleteComboBox<>();
        estadoComboBox.setId("estado-combo-box");
        estadoComboBox.setItems(FXCollections.observableArrayList("AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"));
        estadoComboBox.setComparisonMethod((typedText, itemToCompare) -> itemToCompare.toLowerCase().contains(typedText.toLowerCase()));
        estadoComboBox.setMaxNumChars(2);
        estadoComboBox.initialize();
        gridPane.add(estadoComboBox, 1, 6, 2, 1);

        // Município *
        Text municipioText = new Text();
        municipioText.setId("municipio-text");
        municipioText.setText("Município");
        Label municipioRedAsterisk = new Label(" *");
        municipioRedAsterisk.setId("red-asterisk-text");
        HBox municipioTextHBox = new HBox();
        municipioTextHBox.setId("text-hbox");
        municipioTextHBox.getChildren().addAll(municipioText, municipioRedAsterisk);
        gridPane.add(municipioTextHBox, 0, 7);
        AutoCompleteComboBox<String> municipioComboBox = new AutoCompleteComboBox<>();
        municipioComboBox.setComparisonMethod((typedText, itemToCompare) -> itemToCompare.toLowerCase().contains(typedText.toLowerCase()));
        municipioComboBox.setMaxWidth(Double.MAX_VALUE);
        municipioComboBox.initialize();
        municipioComboBox.getEditor().setStyle("-fx-font-family: Sans Serif; -fx-font-size: 12px;");
        gridPane.add(municipioComboBox, 1, 7, 2, 1);

        // Bairro *
        Text bairroText = new Text();
        bairroText.setId("bairro-text");
        bairroText.setText("Bairro");
        Label bairroRedAsterisk = new Label(" *");
        bairroRedAsterisk.setId("red-asterisk-text");
        HBox bairroTextHBox = new HBox();
        bairroTextHBox.setId("text-hbox");
        bairroTextHBox.getChildren().addAll(bairroText, bairroRedAsterisk);
        gridPane.add(bairroTextHBox, 0, 8);
        AutoCompleteComboBox<String> bairroComboBox = new AutoCompleteComboBox<>();
        bairroComboBox.setComparisonMethod((typedText, itemToCompare) -> itemToCompare.toLowerCase().contains(typedText.toLowerCase()));
        bairroComboBox.setMaxWidth(Double.MAX_VALUE);
        bairroComboBox.initialize();
        bairroComboBox.getEditor().setStyle("-fx-font-family: Sans Serif; -fx-font-size: 12px;");
        gridPane.add(bairroComboBox, 1, 8, 2, 1);

        // Logradouro *
        Text logradouroText = new Text();
        logradouroText.setId("logradouro-text");
        logradouroText.setText("Logradouro");
        Label logradouroRedAsterisk = new Label(" *");
        logradouroRedAsterisk.setId("red-asterisk-text");
        HBox logradouroTextHBox = new HBox();
        logradouroTextHBox.setId("text-hbox");
        logradouroTextHBox.getChildren().addAll(logradouroText, logradouroRedAsterisk);
        gridPane.add(logradouroTextHBox, 0, 9);
        AutoCompleteComboBox<String> logradouroComboBox = new AutoCompleteComboBox<>();
        logradouroComboBox.setComparisonMethod((typedText, itemToCompare) -> itemToCompare.toLowerCase().contains(typedText.toLowerCase()));
        logradouroComboBox.setMaxWidth(Double.MAX_VALUE);
        logradouroComboBox.initialize();
        logradouroComboBox.getEditor().setStyle("-fx-font-family: Sans Serif; -fx-font-size: 12px;");
        logradouroComboBox.setPromptText("Ex.: Av. Brasil");
        gridPane.add(logradouroComboBox, 1, 9, 1, 1);

        // Número *
        Text numeroText = new Text();
        numeroText.setId("numero-text");
        numeroText.setText("Nº");
        Label numeroRedAsterisk = new Label(" *");
        numeroRedAsterisk.setId("red-asterisk-text");
        HBox numeroTextHBox = new HBox();
        numeroTextHBox.setId("text-hbox");
        numeroTextHBox.getChildren().addAll(numeroText, numeroRedAsterisk);
        MaskField numeroMaskField = new MaskField();
        numeroMaskField.setMask("DDDDD");
        numeroMaskField.setStyle("-fx-font-family: Sans Serif; -fx-font-size: 12px; -fx-pref-width: 50px;");
        HBox numeroHBox = new HBox();
        numeroHBox.setId("numero-hbox");
        numeroHBox.getChildren().addAll(numeroTextHBox, numeroMaskField);
        gridPane.add(numeroHBox, 2, 9, 1, 1);

        // Complemento *
        Text complementoText = new Text();
        complementoText.setId("complemento-text");
        complementoText.setText("Complemento");
        gridPane.add(complementoText, 0, 10);
        TextField complementoTextField = new TextField();
        complementoTextField.setPromptText("Ex.: Ap. 51");
        gridPane.add(complementoTextField, 1, 10, 2, 1);

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