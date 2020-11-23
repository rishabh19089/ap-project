package sample;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
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
    void enterGame(ActionEvent event1) throws FileNotFoundException {
        int WIDTH =500, HEIGHT = 650;
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        int jump = 20;
        int y = HEIGHT - 50;
        Pane rootJeu = new Pane(canvas);
        singleCircle circle = new singleCircle(80, 65, HEIGHT);
        singleCircle circle1 = new singleCircle(80, 65, 400);
        Scene sceneJeu = new Scene(rootJeu, WIDTH, HEIGHT);
        GraphicsContext context = canvas.getGraphicsContext2D();

//        Path triangle2 = new Path(new MoveTo(100, 100), new LineTo(100, 150), new LineTo(200, 200), new ClosePath());
//        triangle2.setFill(Color.YELLOW);
//        rootJeu.getChildren().addAll(triangle2);

        Image earth = new Image("/star.png" );
        Ball ball = new Ball(130, HEIGHT);
        ball.setY(600);

        rootJeu.setBackground(new Background(new BackgroundFill(Color.BLACK,CornerRadii.EMPTY, Insets.EMPTY)));

        sceneJeu.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.SPACE) {
                ball.jump(50);
            }});

        circle.draw(rootJeu);
        circle1.draw(rootJeu);
        ball.draw(context, rootJeu);
        AnimationTimer timer = new AnimationTimer() {
            private long lastTime = System.nanoTime();
            @Override
            public void handle(long currentTime) {
                double t = (currentTime - lastTime) / 1000000000.0;
                context.setFill(Color.BLACK);
                context.fillRect(0, 0, WIDTH, HEIGHT);
                //context.drawImage( earth, 150 , 430 );
                ball.move(t);
                circle.rotate(t);
                circle1.rotate(t);
                circle.starCollision(ball.getY(), rootJeu);
                circle1.starCollision(ball.getY(), rootJeu);
                //rootJeu.getChildren().removeAll(circle.getElements());
                lastTime = currentTime; }
        };
        timer.start();
        primaryStage.setScene(sceneJeu);

    }
}