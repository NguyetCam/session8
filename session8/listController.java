package session8;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class listController implements Initializable {
    public TableView<Person> tbView;
    public TableColumn <Person,String> cName;
    public TableColumn <Person,String> cEmail;
    public TableColumn <Person,Integer> cAge;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cName.setCellValueFactory(new PropertyValueFactory<Person,String>("name"));
        cEmail.setCellValueFactory(new PropertyValueFactory<Person,String>("email"));
        cAge.setCellValueFactory(new PropertyValueFactory<Person,Integer>("age"));
        tbView.setItems(Main.personList);
    }

    public void addScreen() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("add.fxml"));
        Main.rootStage.setScene(new Scene(root,500,600));
    }
}
