package controllerview;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.ColorCode;
import model.Model;

import java.io.IOException;

public class Controller {

    private Model m = new Model();

    @FXML
    TextField txt_red = new TextField();
    @FXML
    TextField txt_blue = new TextField();
    @FXML
    TextField txt_green = new TextField();
    @FXML
    Text txt_hex = new Text("#000000");
    @FXML
    Button colorview = new Button();

    //create stage
    public static void show(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("/controllerview/view.fxml"));
            Parent root = fxmlLoader.load();

            stage.setTitle("Color Calculator");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e){
            System.err.println("Something wrong with firstV.fxml: " + e.getMessage());
            e.printStackTrace(System.err);
        }
    }

    @FXML
    public void plusRED(){
        try{
            m.changeColorViaRelativeValue(ColorCode.RED, 10);
            txt_red.setText(Integer.toString(m.getRed()));
            hex();
        }
        catch (Exception ex){
            System.err.println("Error! Try again!");
        }

    }
    @FXML
    public void minusRED(){
        try{
            m.changeColorViaRelativeValue(ColorCode.RED,-10);
            txt_red.setText(Integer.toString(m.getRed()));
            hex();
        }
        catch (Exception ex){
            System.err.println("Error! Try again!");
        }

    }
    @FXML
    public void plusGREEN(){
        try{
            m.changeColorViaRelativeValue(ColorCode.GREEN, 10);
            txt_green.setText(Integer.toString(m.getGreen()));
            hex();
        }
        catch (Exception ex){
            System.err.println("Error! Try again!");
        }

    }
    @FXML
    public void minusGREEN(){
        try{
            m.changeColorViaRelativeValue(ColorCode.GREEN,-10);
            txt_green.setText(Integer.toString(m.getGreen()));
            hex();
        }
        catch (Exception ex){
            System.err.println("Error! Try again!");
        }

    }
    @FXML
    public void plusBLUE(){
        try{
            m.changeColorViaRelativeValue(ColorCode.BLUE, 10);
            txt_blue.setText(Integer.toString(m.getBlue()));
            hex();
        }
        catch (Exception ex){
            System.err.println("Error! Try again!");
        }

    }
    @FXML
    public void minusBLUE(){
        try{
            m.changeColorViaRelativeValue(ColorCode.BLUE,-10);
            txt_blue.setText(Integer.toString(m.getBlue()));
            hex();
        }
        catch (Exception ex){
            System.err.println("Error! Try again!");
        }

    }
    @FXML
    public void absolutRED(){
        try{
            m.changeColorViaAbsoluteValue(ColorCode.RED, txt_red.getText());
            txt_red.setText(Integer.toString(m.getRed()));
            hex();
        }
        catch (Exception ex){
            System.err.println("Es muss eine Zahl eingegeben werden!");
        }
    }
    @FXML
    public void absolutGREEN(){
        try{
            m.changeColorViaAbsoluteValue(ColorCode.GREEN, txt_green.getText());
            txt_green.setText(Integer.toString(m.getGreen()));
            hex();
        }
        catch (Exception ex){
            System.err.println("Es muss eine Zahl eingegeben werden!");
        }

    }
    @FXML
    public void absolutBLUE(){
        try{
            m.changeColorViaAbsoluteValue(ColorCode.BLUE, txt_blue.getText());
            txt_blue.setText(Integer.toString(m.getBlue()));
            hex();
        }
        catch (Exception ex){
            System.err.println("Es muss eine Zahl eingegeben werden!");
        }
    }
    private void hex(){
        txt_hex.setText(m.getHex());
        colorview.setStyle("-fx-background-color:"+m.getHex()+";");
    }
}
