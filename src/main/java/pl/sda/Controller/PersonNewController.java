package pl.sda.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.sda.Model.Person;

/**
 * @author Juliusz Mueller
 */
public class PersonNewController {

    @FXML
    private TextField nameField;

    @FXML
    private  TextField lastnameField;

    @FXML
    private  TextField adressField;

    @FXML
    private TextField postcodeField;

    @FXML
    private  TextField cityField;

    @FXML
    private TextField telField;

    private Stage dialogStage;
    private Person person;
    private boolean okClicked = false;



}
