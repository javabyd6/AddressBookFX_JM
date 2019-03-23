package pl.sda.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.sda.Main;
import pl.sda.Model.Person;

/**
 * @author Juliusz Mueller
 */
public class NewPersonController {

    @FXML
    private Button ok;

    @FXML
    private Button cancel;

    @FXML
    private TextField nameField;

    @FXML
    private TextField lastnameField;

    @FXML
    private TextField adressField;

    @FXML
    private TextField postcodeField;

    @FXML
    private TextField cityField;

    @FXML
    private TextField telField;

    private Main main;

    private Main getMain() {
        return main;
    }

    void setMain(Main main) {
        this.main = main;
    }

    public void handleOk(ActionEvent event) {
        Person person = new Person(nameField.getText(), lastnameField.getText(), adressField.getText(), telField.getText(), postcodeField.getText(), cityField.getText());
        main.getPersonlist().add(person);
        Stage stage = (Stage) ok.getScene().getWindow();
        stage.close();
    }

    public void handleCancel(ActionEvent event) {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }


}
