/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Administrator
 */
public class FXMLDocumentController implements Initializable {
    

    @FXML
    private FontAwesomeIcon btn_close;
    @FXML
    private Button btn_login;
    
    @FXML
    private AnchorPane main_form;
    
    @FXML
    private PasswordField tf_password;
    
    @FXML
    private TextField tf_username;
    
//    DBUtils
    private Connection connect;
    private PreparedStatement preparedSTM;
    private ResultSet resultS;
    
    
    
    public void close(){
        System.exit(0);
    }

    public void loginAdmin(){
        String sql="SELECT * FROM admin WHERE username = ? AND pswd = ?";
        
        connect=database.connectDB();
        
        try{
//Check empty field
                Alert alert;
            if(tf_username.getText().isEmpty()||tf_password.getText().isEmpty()){
                alert=new Alert(AlertType.ERROR);
                alert.setTitle("Error message");
                alert.setHeaderText(null);
                alert.setContentText("Fill in all the blank");
                alert.showAndWait();
            }else{
                preparedSTM=connect.prepareStatement(sql);
                preparedSTM.setString(1,tf_username.getText());
                preparedSTM.setString(2,tf_password.getText());

                resultS=preparedSTM.executeQuery();
                if(resultS.next()){
//Proceed to dashboard
                    alert=new Alert(AlertType.INFORMATION);
                    alert.setTitle("Infomation message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully logged in");
                    alert.showAndWait();

//Hide the loginForm
                    btn_login.getScene().getWindow().hide();
//Linking dashboard
                    Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
                    Stage stage=new Stage();
                    Scene scene=new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else {
                    alert=new Alert(AlertType.ERROR);
                    alert.setTitle("Error message");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong credentials");
                    alert.showAndWait();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
