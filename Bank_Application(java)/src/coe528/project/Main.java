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
import javafx.scene.control.TextField;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;


public class Main extends Application {


    @FXML
    private Label err;
    @FXML
    private TextField diposit;
    @FXML
    private TextField role;
    @FXML
    private TextField username;
    @FXML
    private Label bank;
    @FXML
    private TextField password;
    @FXML
    private Button Login;
    @FXML
    private Label name;
    @FXML
    private Label acn;
    @FXML
    private Label aba;
    @FXML
    private Label state;
    @FXML
    private Button impo;
    @FXML
    private TextField with;

    @FXML
    private TextField op;
    @FXML
    private Button logout;

    @FXML
    private Button oop;

    @FXML
    private Button takout;
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        primaryStage.setTitle("Bank");
        primaryStage.setScene(new Scene(root, 600, 300));
        primaryStage.show();
    }
   static String user ;
    static String passw;
    boolean isCustomer;
    public void validate(String f) {
        Recordclass userNameRecord = new Recordclass("name");
        userNameRecord.check();
            if(Arrays.asList(userNameRecord.userNameArray).contains(f)){
                isCustomer = true;

        }
    }



        @FXML
        void Display(javafx.event.ActionEvent actionEvent) throws IOException {
        isCustomer = false;
        validate(username.getText());
        if( role.getText().equals("manager")) {
            if ((username.getText()).equals("admin") && (password.getText()).equals("admin")) {
                Parent homepage = FXMLLoader.load(getClass().getResource("Manager.fxml"));
                Scene homescene = new Scene(homepage);
                Stage appstage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                appstage.setScene(homescene);
                appstage.show();


            }
            else{
                err.setText("invalid manager login");
            }
        }
        else if (role.getText().equals("customer")) {
            if (isCustomer == true) {
                user = username.getText() + ".txt";
                passw = password.getText();
                Recordclass re = new Recordclass(username.getText() + ".txt");
                double h = (Double.parseDouble(re.readamount()));
                customer cus = new customer(h, username.getText(), re.read(), Integer.parseInt(re.readanum()));
                cus.set();
                String status = cus.getCurrent().toString();


                if (password.getText().equals(re.read())) {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("customer.fxml"));
                    Parent homepage = loader.load();
                    Scene homescene = new Scene(homepage);
                    Stage appstage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    appstage.setScene(homescene);
                    appstage.show();
                    Main main = loader.getController();
                    main.name.setText(username.getText());
                    main.acn.setText(re.readanum());
                    main.aba.setText(re.readamount());
                    main.state.setText(status);
                } else {
                    err.setText("invalid login");
                }

            } else {
                err.setText("invalid login");


            }
        }
        else{
            err.setText("Not a specified role");
        }
           // acn.setText("hello");
        }
    @FXML
    void deposit(javafx.event.ActionEvent actionEvent) throws IOException {
       double f = (Double.parseDouble(diposit.getText()));
        Recordclass record = new Recordclass(user);
        System.out.println(user);
        double amount =(Double.parseDouble(record.readamount()));
       customer Customer = new customer(amount,user,record.read(),Integer.parseInt(record.readanum()));
       Customer.deposit(f);
       Customer.set();
       String status = Customer.getCurrent().toString();
        //state.setText(user);
        record.cleared();
        record.write(Customer.getPassword());
        record.write(Double.toString(Customer.getBalance()));
        record.write(Integer.toString(Customer.getAccountnum()));
        state.setText(status);
        aba.setText(Double.toString(Customer.getBalance()));





    }
    @FXML
    void lout(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent homepage = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene homescene = new Scene(homepage);
        Stage appstage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        appstage.setScene(homescene);
        appstage.show();

    }

    @FXML
    void subtract(javafx.event.ActionEvent actionEvent) throws IOException {
        double amount = (Double.parseDouble(with.getText()));
        Recordclass re = new Recordclass(user);
        double h =(Double.parseDouble(re.readamount()));
        customer Customer = new customer(h,user,re.read(),Integer.parseInt(re.readanum()));
        Customer.withdraw(amount);
        Customer.set();
        String ggfd = Customer.getCurrent().toString();
        //state.setText(user);
        re.cleared();
        re.write(Customer.getPassword());
        re.write(Double.toString(Customer.getBalance()));
        re.write(Integer.toString(Customer.getAccountnum()));
        state.setText(ggfd);
        aba.setText(Double.toString(Customer.getBalance()));

    }
    @FXML
    private Label oer;
    @FXML
    void onlineOrder(javafx.event.ActionEvent actionEvent) throws IOException {
        double f = (Double.parseDouble(op.getText()));
        Recordclass re = new Recordclass(user);
        if(f >= 50) {
            double h = (Double.parseDouble(re.readamount()));
            customer Customer = new customer(h, user, re.read(), Integer.parseInt(re.readanum()));
            Customer.set();
            Customer.onlinepurchases(f);
            Customer.set();
            String ggfd = Customer.getCurrent().toString();
            //state.setText(user);
            re.cleared();
            re.write(Customer.getPassword());
            re.write(Double.toString(Customer.getBalance()));
            re.write(Integer.toString(Customer.getAccountnum()));
            state.setText(ggfd);
            aba.setText(Double.toString(Customer.getBalance()));
           oer.setText("Purchase successful");
        }
        else{
            oer.setText("input value should be 50 or more");
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}
