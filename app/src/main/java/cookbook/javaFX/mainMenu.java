package cookbook.javaFX;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

import cookbook.Cookbook;
import cookbook.objectControllers.userController;
import cookbook.objects.userObject;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class mainMenu {
  
  @FXML 
  public Button homebtn;
  @FXML 
  public Button addbuttom;
  @FXML 
  public Button inboxbutton;
  @FXML 
  public Button weeklistbutton;
  @FXML 
  public Button helpbutton;
  @FXML 
  public Button adminPanel;
  @FXML 
  public Button quitbutton;
  

  public void homeClick(ActionEvent event) throws SQLException, IOException {
    
    
    
  }

  public void addClick(ActionEvent event) throws SQLException, IOException {
    
    
    
  }
  public void inboxClick(ActionEvent event) throws SQLException, IOException {
    
    
    
  } 
  public void weeklistClick(ActionEvent event) throws SQLException, IOException {
    
    
    
  }

  public void helpClick(ActionEvent event) throws SQLException, IOException {
    
    
    
  }

  public void adminPanelClick(ActionEvent event) throws SQLException, IOException {
    
    userObject loggedUser = userController.loggedInUser;

    if (loggedUser.getAdminPrivelages().equals(false)) {
      Alert error = new Alert(Alert.AlertType.INFORMATION);
      error.setTitle("Big NoNo");
      error.setContentText("You are a peasent <3.");
      error.show();
    }else {
      URL url = new File("src/main/java/cookbook/resources/adminpanel.fxml").toURI().toURL();
      FXMLLoader loader = new FXMLLoader(url);
      Parent root = loader.load();
      Scene adminScene = new Scene(root);

      Stage adminStage = (Stage) adminPanel.getScene().getWindow();
      adminStage.setScene(adminScene);
      adminStage.show();


      // Wait for the admin panel to close
      adminStage.setOnCloseRequest(e -> {
        try {
          URL url2 = new File("src/main/java/cookbook/resources/mainmenu.fxml").toURI().toURL();
          FXMLLoader loader2 = new FXMLLoader(url2);
          Parent root2 = loader2.load();
          Scene mainMenu = new Scene(root2);

          Stage mainMenuStage = new Stage();
          mainMenuStage.setScene(mainMenu);
          mainMenuStage.show();

        } catch (IOException ioException) {
          ioException.printStackTrace();
        }
      });
    } 
  }

  public void exitClick(ActionEvent event) throws SQLException, IOException {
    URL url = new File("src/main/java/cookbook/resources/login.fxml").toURI().toURL();
    FXMLLoader loader = new FXMLLoader(url);
    Parent root = loader.load();
    Scene loginScene = new Scene(root);

    Stage appStage = (Stage) quitbutton.getScene().getWindow();
    appStage.setScene(loginScene);
    appStage.show();
    appStage.setHeight(500);
    appStage.setWidth(650);
    appStage.setResizable(true);
    appStage.centerOnScreen();
    appStage.setTitle("Sign In");
  }
}
