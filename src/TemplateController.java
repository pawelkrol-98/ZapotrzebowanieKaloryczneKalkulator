import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.*;
import java.text.DecimalFormat;

public class TemplateController {

    ObservableList<String> activityBoxList = FXCollections.observableArrayList("Siedzacy, trening silowy okolo 3 razy" +
            " w tygodniu.", "Umiarkowanie aktywny, trening silowy okolo 3 razy w tygodniu.", "Aktywny, trening " +
            "silowy okolo 3 razy w tygodniu.", "Bardzo aktywny, trening silowy okolo 3 razy w tygodniu.");

    @FXML
    private TextField textField;
    @FXML
    private TextArea textArea;
    @FXML
    private ChoiceBox<String> choiceBox;


    private double waga;
    private double zapotrzebowanie;
    private DecimalFormat df = new DecimalFormat("#");

    @FXML
    public void obliczZapotrzebowanie() {

        if (textField.getText().isEmpty()) {
            textArea.setText("Podaj swoja wage.");
        } else {
            waga = Double.parseDouble(textField.getText());
            zapotrzebowanie = waga * 22;

            if (choiceBox.getValue() == null) {
                textArea.setText("Wybierz poziom aktywnosci.");
            } else if (choiceBox.getValue() == "Umiarkowanie aktywny, trening silowy okolo 3 razy w tygodniu.") {
                zapotrzebowanie = zapotrzebowanie * 1.7;
                textArea.setText(String.valueOf("Twoje przyblizone zapotrzebowanie dziennie wynosi: " + df.format(zapotrzebowanie) + " Kcal"));
            } else if (choiceBox.getValue() == "Aktywny, trening silowy okolo 3 razy w tygodniu.") {
                zapotrzebowanie = zapotrzebowanie * 1.9;
                textArea.setText(String.valueOf("Twoje przyblizone zapotrzebowanie dziennie wynosi: " + df.format(zapotrzebowanie) + " Kcal"));
            } else if (choiceBox.getValue() == "Bardzo aktywny, trening silowy okolo 3 razy w tygodniu.") {
                zapotrzebowanie = zapotrzebowanie * 2.1;
                textArea.setText(String.valueOf("Twoje przyblizone zapotrzebowanie dziennie wynosi: " + df.format(zapotrzebowanie) + " Kcal"));
            } else {
                zapotrzebowanie = zapotrzebowanie * 1.5;
                textArea.setText(String.valueOf("Twoje przyblizone zapotrzebowanie dziennie wynosi: " + df.format(zapotrzebowanie) + " Kcal"));
            }
        }

    }

    @FXML
    private void initialize() {
        choiceBox.setItems(activityBoxList);

    }

}


