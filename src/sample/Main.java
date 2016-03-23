package sample;

import com.aspose.words.Document;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * This project is a GUI based invoice system without the use of a DB
 *
 * The GUI is made by using Scene Builder with the amazing template for GUI by Jfoenix
 * The System is limited to 5 items per invoice
 * Later i'll integrate the .DOCX support to create invoice and shipping slip using Aspose
 */

public class Main extends Application {

    String resource = "layout/invoice.fxml";

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource(getResource()));
        primaryStage.setTitle("Invoice");
        primaryStage.setScene(new Scene(root, 1260, 800));
        primaryStage.show();
    }


    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public String getResource() {
        return resource;
    }

}
