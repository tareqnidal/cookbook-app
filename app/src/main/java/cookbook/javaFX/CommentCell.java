package cookbook.javaFX;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;

import cookbook.objectControllers.userController;
import cookbook.objects.CommentObject;
import javafx.scene.control.ListCell;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;


public class CommentCell extends ListCell<CommentObject> {
  
  @FXML
  private Label commentUser;
  
  @FXML
  private Label commentText;
  
  @FXML
  private GridPane gridPane;
  private FXMLLoader loader;
  
  
  @Override
  protected void updateItem(CommentObject commentObject, boolean empty) {
    super.updateItem(commentObject, empty);
    if (empty || commentObject == null || commentObject.getText() == null) {
      ;
    } else {
      if (loader == null) {
        try {
          URL url = new File("src/main/java/cookbook/resources/commentCell.fxml").toURI().toURL();
          loader = new FXMLLoader(url);
        } catch (MalformedURLException e) {
          System.out.println("Error lol" + e);
        }
        loader.setController(this);
        
        try {
          loader.load();
        } catch (IOException e) {
          e.printStackTrace();
        }
        
        commentText.setText(commentObject.getText());
        try {
          commentUser.setText(userController.searchFromId(commentObject.getUserId()).getName());
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      setText(null);
      setGraphic(gridPane);
      
    }
    
  }
}
  