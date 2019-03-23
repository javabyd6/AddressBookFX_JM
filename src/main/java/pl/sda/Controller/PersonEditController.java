package pl.sda.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.sda.Model.Person;



/**
 * @author Juliusz Mueller
 */
public class PersonEditController {

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


    @FXML
    private void initialize() {
    }
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }


    public void setPerson(Person person) {
        this.person = person;
        nameField.setText(person.getName());
        lastnameField.setText(person.getLastname());
        adressField.setText(person.getAdress());
        postcodeField.setText(person.getPostelCode());
        cityField.setText(person.getCity());
        telField.setText(person.getTel());
    }
    public boolean isOkClicked() {
        return okClicked;
    }
    @FXML
    private void handleOk() {

            person.setName(nameField.getText());
            person.setLastname(lastnameField.getText());
            person.setAdress(adressField.getText());
            person.setPostelCode(postcodeField.getText());
            person.setCity(cityField.getText());
            person.setTel(telField.getText());

            okClicked = true;
            dialogStage.close();
        }


    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
}
