package coe528.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class Manager {
public Manager(){

}
    @FXML
    private Button addcu;

    @FXML
    private Button dele;

    @FXML
    private Button logo;

    @FXML
    private TextField user;

    @FXML
    private TextField pass;

    @FXML
    private TextField ac;

    @FXML
    private Button doo;

    @FXML
    private Label added;

    @FXML
    private TextField userde;

    @FXML
    private Button ffd;

    @FXML
    private Button ba;

    @FXML
    private Label des;

    @FXML
    private Button retu;

    static int i = 0;

    @FXML
    void createCustomer(javafx.event.ActionEvent actionEvent) throws IOException { // adds customers and checks if the usrname is alredy used
        boolean dro = true ;
        Manager m = new Manager();
        Recordclass names = new Recordclass("name");
        names.check(); // makes an array of usernames alredy added
        for(int i =0 ; i < names.userNameCount; i++) {
           if(names.userNameArray[i].equals(user.getText())){
               dro = false;
           }
        }
        if( dro == true) {
            double h = Double.parseDouble("100.00");
            m.addCustomer(h, user.getText(), pass.getText(), Integer.parseInt(ac.getText()));
            names.write(user.getText());
            added.setText("Successfuly Added ");
        }
        else{
            added.setText("username not valid");
        }
    }

    @FXML
    void returnToManagerPage(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent homepage = FXMLLoader.load(getClass().getResource("Manager.fxml"));
        Scene homescene = new Scene(homepage);
        Stage appstage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        appstage.setScene(homescene);
        appstage.show();
    }
    @FXML
        void deleteCustomerPage(javafx.event.ActionEvent actionEvent) throws IOException {
            Parent homepage = FXMLLoader.load(getClass().getResource("Delete.fxml"));
            Scene homescene = new Scene(homepage);
            Stage appstage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            appstage.setScene(homescene);
            appstage.show();

        }
    @FXML
        void addCustomerPage(javafx.event.ActionEvent actionEvent) throws IOException {

            Parent homepage = FXMLLoader.load(getClass().getResource("addcustome.fxml"));
            Scene homescene = new Scene(homepage);
            Stage appstage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            appstage.setScene(homescene);
            appstage.show();

        }
   @FXML
        void logout(javafx.event.ActionEvent actionEvent) throws IOException {
            Parent homepage = FXMLLoader.load(getClass().getResource("Main.fxml"));
            Scene homescene = new Scene(homepage);
            Stage appstage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            appstage.setScene(homescene);
            appstage.show();

        }

    public void addCustomer(double balance, String username, String password, int accountnumber) throws IOException {
        customer c = new customer(balance, username, password,accountnumber);
        Recordclass cc = new Recordclass(username+".txt");
        cc.cleared();
        cc.write(password);
        cc.write(Double.toString(balance));
        cc.write(Integer.toString(accountnumber));
    }


    public void deleteCutomerTextFile(String Username) {
        Recordclass ru = new Recordclass(Username + ".txt");
        ru.deletefile();

    }

    @FXML
    void deleteCustomer(javafx.event.ActionEvent actionEvent) throws IOException {
        deleteCutomerTextFile(userde.getText());
        des.setText("Successfully Deleted");
        Recordclass names = new Recordclass("name");
        names.check();
        names.cleared();
        for(int i =0 ; i < names.userNameCount; i ++){
            if(names.userNameArray[i].equals(userde.getText())){
                names.userNameArray[i] = null;
            }
            if(names.userNameArray[i] != null ){
                names.write(names.userNameArray[i]);
            }
        }

    }




    public static void main(String[] args) {

    }
}