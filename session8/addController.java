package session8;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

import java.io.IOException;

public class addController {
    public TextField fullname;
    public TextField email;
    public TextField age;
    public Text error;

    public void submit(){
        try {
            if(fullname.getText().isEmpty() || email.getText().isEmpty() || age.getText().isEmpty()){
                throw new Exception("Please fill all the field");
            }
            Person p = new Person(fullname.getText(),email.getText(),Integer.parseInt(age.getText()));
            Main.personList.add(p);
            fullname.setText("");
            email.setText("");
            age.setText("");
            this.error.setText("Thêm thành công");
            this.error.setFill(Paint.valueOf("BLUE"));
            this.error.setVisible(true);
        }catch (NumberFormatException e){
            this.error.setVisible(true);
            this.error.setText("Age must be an integer");
            this.error.setFill(Paint.valueOf("RED"));
        }catch (Exception e){
            this.error.setText(e.getMessage());
            this.error.setVisible(true);
            this.error.setFill(Paint.valueOf("RED"));
        }
    }

    public void listScreen() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("list.fxml"));
        Main.rootStage.setScene(new Scene(root,800,600));
    }
}
