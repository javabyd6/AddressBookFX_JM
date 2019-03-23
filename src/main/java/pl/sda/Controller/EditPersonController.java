package pl.sda.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.sda.Main;
import pl.sda.Model.Person;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * @author Juliusz Mueller
 */
public class EditPersonController implements Initializable {

    private Person selectedPerson;
    private Main main;

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

    public void setSelectedPerosn(Person selectedPerosn) {
        this.selectedPerson = selectedPerosn;
    }
    public void initForm(){
        if(selectedPerson!=null){
            nameField.setText(selectedPerson.getName());
            lastnameField.setText(selectedPerson.getLastname());
            adressField.setText(selectedPerson.getAdress());
            postcodeField.setText(selectedPerson.getPostelCode());
            cityField.setText(selectedPerson.getCity());
            telField.setText(selectedPerson.getTel());

        }

    }

    @FXML
    void saveEdit() {
        Person person = new Person(nameField.getText(),//
                lastnameField.getText(),//
                adressField.getText(),//
                postcodeField.getText(),//
                cityField.getText(), //
                telField.getText());//

        main.getPersonlist().set(main.getPersonlist().indexOf(selectedPerson), person);

        Stage stage = (Stage) ok.getScene().getWindow();
        stage.close();
    }


    public void cancel() {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }


    private Main getMain() {
        return main;
    }

    void setMain(Main main) {
        this.main = main;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
