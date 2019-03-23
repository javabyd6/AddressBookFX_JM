package pl.sda.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

import javax.swing.text.TableView;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Juliusz Mueller
 */
public class RootController implements Initializable {


    @FXML
    TableColumn name;

    @FXML
    TableColumn lastname;

    @FXML
    Button newPerson;

    @FXML
    Button edit;

    @FXML
    Button delete;

    @FXML
    Button save;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
}
