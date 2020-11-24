package sample;

import java.io.IOException;
import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class Controller {
    private Game game;
    public static Stage primaryStage;

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
    private Button resumeButton;
    @FXML
    private AnchorPane page5;
    @FXML
    private Button quit2;

    @FXML
    private AnchorPane page6;

    @FXML
    private Button newGameOver;

    @FXML
    private Button quit4;

    @FXML
    void displayMainMenu5(ActionEvent event) {
        FxmlLoader newGameScreen = new FxmlLoader();
        Pane view= newGameScreen.switchPage("sample");
        page6.getChildren().setAll(view);
    }

    @FXML
    void startNewGame(ActionEvent event) {

    }

    @FXML
    void displayMainMenu4(ActionEvent event) {
        FxmlLoader newGameScreen = new FxmlLoader();
        Pane view= newGameScreen.switchPage("sample");
        page5.getChildren().setAll(view);
    }

    @FXML
    void startAgainGame(ActionEvent event) {

    }
    @FXML
    public void displayNewGame(ActionEvent event) {
        //System.out.println("clicked");
        FxmlLoader newGameScreen = new FxmlLoader();
        Pane view= newGameScreen.switchPage("newGame");
        page.getChildren().setAll(view); }
    @FXML
    public void displayExitMenu(ActionEvent event) {
        FxmlLoader newGameScreen = new FxmlLoader();
        Pane view= newGameScreen.switchPage("Exit");
        page.getChildren().setAll(view); }
    @FXML
    public void displayResumeGame(ActionEvent event) {
        FxmlLoader newGameScreen = new FxmlLoader();
        Pane view= newGameScreen.switchPage("ResumeGame");
        page.getChildren().setAll(view); }
    @FXML
    void displayMainMenu(ActionEvent event) {
        FxmlLoader newGameScreen = new FxmlLoader();
        Pane view= newGameScreen.switchPage("sample");
        page2.getChildren().setAll(view); }
    @FXML
    void displayMainMenu2(ActionEvent event) {
        FxmlLoader newGameScreen = new FxmlLoader();
        Pane view= newGameScreen.switchPage("sample");
        page3.getChildren().setAll(view); }
    @FXML
    void displayHelpMenu(ActionEvent event) {
        FxmlLoader newGameScreen = new FxmlLoader();
        Pane view= newGameScreen.switchPage("help");
        page.getChildren().setAll(view); }

    @FXML
    void displayMainMenu3(ActionEvent event) {
        FxmlLoader newGameScreen = new FxmlLoader();
        Pane view= newGameScreen.switchPage("sample");
        page4.getChildren().setAll(view); }

    @FXML
    void enterGame(ActionEvent event1){
        int WIDTH =500, HEIGHT = 650, jump = 140;
        Game game = new Game("Rishabh", HEIGHT, jump);
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        int y = HEIGHT - 50;
        Pane rootJeu = new Pane(canvas);
        Scene sceneJeu = new Scene(rootJeu, WIDTH, HEIGHT);
        GraphicsContext context = canvas.getGraphicsContext2D();

        User user = game.getUser();
        Ball ball = user.getBall();

        singleCircle circle = new singleCircle(80, 65, HEIGHT, 90, true);
        singleCircle circle1 = new singleCircle(80, 65, 390, 120, false);
        singleCircle circle2 = new singleCircle(55, 40, 390, 120, true);
        Square square = new Square(175 , 400, 150, 20, true, 90);

        ArrayList<Obstacles> obstacles = new ArrayList<>();
        obstacles.add(circle1); obstacles.add(circle2); obstacles.add(square);

        rootJeu.setBackground(new Background(new BackgroundFill(Color.BLACK,CornerRadii.EMPTY, Insets.EMPTY)));

        sceneJeu.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.SPACE) {
                ball.jump(); }});

        //circle.draw(rootJeu);
        for (Obstacles o: obstacles){
            o.draw(rootJeu); }

        ball.draw(context, rootJeu);
        AnimationTimer timer = new AnimationTimer() {
            private long lastTime = System.nanoTime();
            private long startTime = System.nanoTime();
            @Override
            public void handle(long currentTime) {
                double t = (currentTime - lastTime) / 1000000000.0;
                double timeSinceStart = (currentTime - startTime)/1e9;
                ball.move(t);
                for (Obstacles o: obstacles){
                    o.rotate(t);
                    if (o.collision(ball, timeSinceStart)){
                        primaryStage.close(); }
                    o.starCollision(ball.getY(), rootJeu); }
                lastTime = currentTime; }
        };
        timer.start();
        primaryStage.setScene(sceneJeu);

    }
}