package pl.sda;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import pl.sda.Controller.RootViewController;
import pl.sda.Model.Person;



/**
 * @author Juliusz Mueller
 */
public class Main extends Application {

    private ObservableList<Person> personlist = FXCollections.observableArrayList();


    public Main() {
        personlist.add(new Person("Juliusz", "Mueller", "Street", "58-90", "Byd", "123344"));
        personlist.add(new Person("Anita", "Mueller", "Ulica", "68-90", "Torun", "123344"));
        personlist.add(new Person("Muster", "Mann", "Srasse", "6890", "Berlin", "123344"));
    }


    public ObservableList<Person> getPersonlist() {
        return personlist;


    }

    public void setPersonlist(ObservableList<Person> personlist) {
        this.personlist = personlist;
    }

    public static void main(String[] args) {
        launch(args);
    }




    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage = primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/root.fxml"));

        loader.load();
        Parent root = loader.getRoot();
        RootViewController rootViewController = loader.getController();
        rootViewController.setMain(this);


        //Parent root = FXMLLoader.load(getClass().getResource("/root.fxml"));


        primaryStage.setScene(new Scene(root, 800, 550));
        primaryStage.show();

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Platform.exit();
                System.exit(0);

            }
        });


    }

}




