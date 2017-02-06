package widgets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Objects;
import java.util.stream.Collectors;

public class FxUtilTest {

    public interface AutoCompleteComparator<T> {
        boolean matches(String typedText, T objectToCompare);
    }

    public static<T> void autoCompleteComboBoxPlus(ComboBox<T> comboBox, AutoCompleteComparator<T> comparatorMethod) {
        ObservableList<T> items = comboBox.getItems();
        final ObservableList<T> suggestions = FXCollections.observableArrayList();
        suggestions.addAll(items);
        comboBox.setEditable(true);

        // Whenever the combo box button is clicked and the options are displayed
        comboBox.armedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (!comboBox.isShowing()) {
                    int size = suggestions.size() > 10 ? 10 : suggestions.size();
                    comboBox.setVisibleRowCount(size);
                    comboBox.show();
                }
            }
        });

        // Whenever any item is selected
        comboBox.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            if (!comboBox.getSelectionModel().isEmpty()) {
                comboBox.getEditor().positionCaret(comboBox.getSelectionModel().getSelectedItem().toString().length());
            }
        });

        comboBox.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.DOWN) {
                if (!comboBox.isShowing() && !suggestions.isEmpty()) {
                    int size = suggestions.size() > 10 ? 10 : suggestions.size();
                    comboBox.setVisibleRowCount(size);
                    comboBox.show();
                }
            }
        });

        comboBox.addEventHandler(KeyEvent.KEY_RELEASED, event -> {
            // Clear the selection
            if (event.getCode() != KeyCode.DOWN && event.getCode() != KeyCode.UP && !comboBox.getSelectionModel().isEmpty()) {
                String typedText = comboBox.getEditor().getText();
                int caretPosition = comboBox.getEditor().getCaretPosition();
                comboBox.getSelectionModel().clearSelection();
                comboBox.getEditor().setText(typedText);
                comboBox.getEditor().positionCaret(caretPosition);
            }
            // Show new suggestions
            if (event.getCode() != KeyCode.ENTER && event.getCode() != KeyCode.LEFT && event.getCode() != KeyCode.RIGHT && !event.getCode().equals(KeyCode.SHIFT) && !event.getCode().equals(KeyCode.CONTROL) && !event.isControlDown() && event.getCode() != KeyCode.HOME && event.getCode() != KeyCode.END && event.getCode() != KeyCode.TAB && event.getCode() != KeyCode.UP && event.getCode() != KeyCode.DOWN) {
                // Update the suggestions
                String typedText = comboBox.getEditor().getText();
                suggestions.clear();
                if (typedText.trim().isEmpty()) {
                    suggestions.addAll(items);
                }
                else {
                    suggestions.addAll(items.stream().filter(item -> item != null && comparatorMethod.matches(typedText, item)).collect(Collectors.toList()));
                }
                comboBox.setItems(suggestions);
                if (typedText.trim().isEmpty() || suggestions.isEmpty()) {
                    comboBox.hide();
                }
                else {
                    int size = suggestions.size() > 10 ? 10 : suggestions.size();
                    comboBox.hide();
                    comboBox.setVisibleRowCount(size);
                    comboBox.show();
                }
            }
        });

        // Whenever focus is lost
        comboBox.getEditor().focusedProperty().addListener((arg0, oldPropertyValue, newPropertyValue) -> {
            // Out focus
            if (!newPropertyValue) {
                String typedText = comboBox.getEditor().getText();
                items.stream().filter(item -> item != null && typedText != null && !typedText.trim().isEmpty() && Objects.equals(item.toString().toLowerCase(), typedText.toLowerCase())).forEach(item -> comboBox.getSelectionModel().select(item));
            }
        });
    }

    public static<T> T getComboBoxValue(ComboBox<T> comboBox){
        if (comboBox.getSelectionModel().getSelectedIndex() < 0) {
            return null;
        } else {
            return comboBox.getItems().get(comboBox.getSelectionModel().getSelectedIndex());
        }
    }

}