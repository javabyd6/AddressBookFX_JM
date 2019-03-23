package pl.sda.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.sda.Main;
import pl.sda.Model.Person;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Juliusz Mueller
 */
public class RootViewController implements Initializable {

    @FXML
    private TableView<Person> personTabelView;

    @FXML
    private TableColumn<Person, String> nameCol;

    @FXML
    private TableColumn<Person, String> lastnameCol;

    @FXML
    private Label name;

    @FXML
    private Label lastname;

    @FXML
    private Label adress;

    @FXML
    private Label postelcode;

    @FXML
    private Label city;

    @FXML
    private Label tel;

    @FXML
    private Button newPerson;

    @FXML
    private Button edit;

    @FXML
    private Button delte;

    @FXML
    private Button save;

    private Main main;

    public RootViewController() {

    }

    private void showPersonDetails(Person person) {
        if (person != null) {
            name.setText(person.getName());
            lastname.setText(person.getLastname());
            adress.setText(person.getAdress());
            postelcode.setText(person.getPostelCode());
            city.setText(person.getCity());
            tel.setText(person.getTel());
        } else {
            name.setText("");
            lastname.setText("");
            adress.setText("");
            postelcode.setText("");
            city.setText("");
            tel.setText("");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        nameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        lastnameCol.setCellValueFactory(cellData -> cellData.getValue().lastnameProperty());

        showPersonDetails(null);
        personTabelView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showPersonDetails(newValue));
    }


    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
        personTabelView.setItems(main.getPersonlist());

    }

    @FXML
    private void handeldelt() {
        int selectedIndex = personTabelView.getSelectionModel().getSelectedIndex();
        personTabelView.getItems().remove(selectedIndex);
    }
    @FXML
    private void newPerson() throws IOException {
        Person tempPerson = new Person();
        boolean okClicked = main.showPersonEditDialog(tempPerson);
        if (okClicked) {
            main.getPersonlist().add(tempPerson);
        }
    }

    @FXML
    private void editPerson() throws IOException {
        Person selectedPerson = personTabelView.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = main.showPersonEditDialog(selectedPerson);
            if (okClicked) {
                showPersonDetails(selectedPerson);
            }

        }
    }
}
