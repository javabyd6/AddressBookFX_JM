package pl.sda.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
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

    public void setMain(Main main) {
        this.main = main;
        personTabelView.setItems(main.getPersonlist());

    }

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


    @FXML
    private void handeldelt() {
        int selectedIndex = personTabelView.getSelectionModel().getSelectedIndex();
        personTabelView.getItems().remove(selectedIndex);
    }


    @FXML
    private void editPerson() throws IOException {

        Stage editPerStage = new Stage();
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/EditPerson.fxml"));
        loader.load();

        Parent root = loader.getRoot();

        EditPersonController editPersonController = loader.getController();
        editPersonController.setMain(main);
        editPersonController.setSelectedPerosn(personTabelView.getSelectionModel().getSelectedItem());
        editPersonController.initForm();
        editPerStage.setTitle("Edit Person");
        editPerStage.setScene(new Scene(root));
        editPerStage.show();
    }


    public void newPerson() throws IOException {
        Stage newPerStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/NewPerson.fxml"));
        loader.load();

        Parent root = loader.getRoot();

        NewPersonController newPersonController = loader.getController();
        newPersonController.setMain(main);


        newPerStage.setTitle("Add new Person");
        newPerStage.setScene(new Scene(root));
        newPerStage.show();
    }
}
