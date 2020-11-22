package sample;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class Controller {
    private Game game;

    public void spaceTyped() {

    }

    public void serialize() throws IOException {
        //object of Game
        //after save call this method
    }

    public void deserialize() throws IOException, ClassNotFoundException {

    }
    @FXML
    private Button newG;

    @FXML
    private AnchorPane page;

    @FXML
    private AnchorPane page2;

    @FXML
    private AnchorPane page3;

    @FXML
    private AnchorPane page4;

    @FXML
    private Button back2;

    @FXML
    private Button ResGame;

    @FXML
    private Button exit;

    @FXML
    private Button help;

    @FXML
    private Button back1;

    @FXML
    private Button back3;

    @FXML
    public void displayNewGame(ActionEvent event) {
        //System.out.println("clicked");
        FxmlLoader newGameScreen = new FxmlLoader();
        Pane view= newGameScreen.switchPage("newGame");
        page.getChildren().setAll(view);

    }
    @FXML
    public void displayExitMenu(ActionEvent event) {
        FxmlLoader newGameScreen = new FxmlLoader();
        Pane view= newGameScreen.switchPage("Exit");
        page.getChildren().setAll(view);
    }

    @FXML
    public void displayResumeGame(ActionEvent event) {
        FxmlLoader newGameScreen = new FxmlLoader();
        Pane view= newGameScreen.switchPage("ResumeGame");
        page.getChildren().setAll(view);
    }
    @FXML
    void displayMainMenu(ActionEvent event) {
        FxmlLoader newGameScreen = new FxmlLoader();
        Pane view= newGameScreen.switchPage("sample");
        page2.getChildren().setAll(view);
    }
    @FXML
    void displayMainMenu2(ActionEvent event) {
        FxmlLoader newGameScreen = new FxmlLoader();
        Pane view= newGameScreen.switchPage("sample");
        page3.getChildren().setAll(view);
    }
    @FXML
    void displayHelpMenu(ActionEvent event) {
        FxmlLoader newGameScreen = new FxmlLoader();
        Pane view= newGameScreen.switchPage("help");
        page.getChildren().setAll(view);
    }

    @FXML
    void displayMainMenu3(ActionEvent event) {
        FxmlLoader newGameScreen = new FxmlLoader();
        Pane view= newGameScreen.switchPage("sample");
        page4.getChildren().setAll(view);
    }
}
