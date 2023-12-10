package com.example.chatbox;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ChatBoxController implements Initializable {
  @FXML
  ScrollPane chatBoxArea;

  @FXML
  BorderPane mainPane;

  @FXML
  TextArea messageBox;

  @FXML
  VBox chatArea;

  public void sendMessage() {
    if (!messageBox.getText().isBlank()) {
      Label message = new Label(messageBox.getText().trim());
      messageBox.clear();
      message.setWrapText(true);
      message.setMaxWidth(200);
      message.setFont(new Font(15));
      message.setPadding(new Insets(10, 10, 10, 10));
      double setMargin = 150;
      if (message.getText().length() < 15) {
        setMargin = 180 + ((double) (15 - message.getText().length()) * 8);
      }
      message.setAlignment(Pos.CENTER);
      message.setStyle(
          "-fx-background-color: skyblue; -fx-background-radius: 20; -fx-text-fill: white;");

      chatArea.getChildren().add(message);
      chatArea.setMargin(message, new Insets(0, 5, 0, setMargin));
    }
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    messageBox.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
      @Override
      public void handle(KeyEvent key) {
        if (key.getCode() == KeyCode.ENTER && !messageBox.getText().isBlank()) {
          sendMessage();
        }
      }
    });
  }
}
