/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsystem;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author cstuser
 */
public class StudentSystem extends Application {
    
    final ArrayList<Student> students = new ArrayList<Student>() ;
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Load");
        Label label = new Label("Enter student file path");
        TextField textField = new TextField();
//        ObservableList<String> names = FXCollections.observableArrayList(
//          "Julia", "Ian", "Sue", "Matthew", "Hannah", "Stephan", "Denise");
        ListView<Student> listView = new ListView<Student>();
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
                final StudentLoader stLoader = new StudentLoader();
//                final String pathStr = "C:\\Users\\cstuser\\Desktop\\students.txt";
                final String pathStr = textField.getText();
                    
                try {
                    students.clear();
                    students.addAll( stLoader.load(Paths.get(pathStr)));
                    ObservableList<Student> studentList = FXCollections.observableArrayList(students);
                    listView.setItems(studentList);

//                    StudentLoader.testLoad(pathStr);
                    
                } catch (IOException ex) {
                    // TODO recover from wrong file path.
                    Logger.getLogger(StudentSystem.class.getName()).log(Level.SEVERE, null, ex);
                    Alert fileNotFound = new Alert(Alert.AlertType.WARNING, "Please endter correct path", ButtonType.OK);
                    fileNotFound.showAndWait();
                }
                
            }
        });
        
        Button ascButton = new Button("Sort Ascending");
        ascButton.setOnAction( (e)->{ Sort.sort( students, true);
     
        listView.setItems(null);
            listView.setItems(FXCollections.observableArrayList(students));
        });
        Button descButton = new Button("Sort Descending");
        descButton.setOnAction( (e)->{
            Sort.sort( students, false);
            listView.setItems(null);
            listView.setItems(FXCollections.observableArrayList(students));
        });
        
        GridPane.setConstraints(label, 0, 0);
        GridPane.setConstraints(textField, 0, 1);
        GridPane.setConstraints(btn, 0, 2);
        GridPane.setConstraints(ascButton, 0, 3);
         GridPane.setConstraints(descButton, 0, 4);
        GridPane.setConstraints(listView, 1, 0, 1, 8);

        GridPane root = new GridPane();      
        root.getChildren().add(btn);
        root.getChildren().add(ascButton);
        root.getChildren().add(descButton);
        root.getChildren().add(textField);
        root.getChildren().add(label);
        root.getChildren().add(listView);
        

        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
