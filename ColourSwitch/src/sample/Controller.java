package sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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

    private double[] cord(double x, double y, double sr1, double sr2){
        double[] points = new double[20];
        for (int i=0; i<20; i+=4){
            int t = i/4;
            points[i] = x - sr1*Math.cos(Math.toRadians(90+(72*t)));
            points[i+1] = y - sr1*Math.sin(Math.toRadians(90+(72*t)));
            points[i+2] = x -sr2*Math.cos(Math.toRadians(126+(72*t)));
            points[i+3] = y - sr2*Math.sin(Math.toRadians(126+(72*t))); }
        return points; }

    void exit(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            primaryStage.setScene(new Scene(root)); }
        catch (IOException e) {
            System.out.println("FXML not found!"); }
    }

    @FXML
    void enterGame(ActionEvent event1) throws FileNotFoundException {
        int WIDTH =500, HEIGHT = 650, jump = 160;
        Game game = new Game("Rishabh", HEIGHT, WIDTH, jump);
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        Pane rootJeu = new Pane(canvas);
        Scene sceneJeu = new Scene(rootJeu, WIDTH, HEIGHT);
        final boolean[] started = {false};
        final boolean[] gameOver = {false};
        Text text = new Text(5, 40, "0"); Font font = Font.loadFont(new FileInputStream(new File("resources/fonts/stencil.ttf")), 40); text.setFont(font);
        text.setFill(Color.WHITE);
        Star st = new Star(cord(52, 28, 18, 9)); st.get().setFill(Color.WHITE);
        User user = game.getUser();
        Ball ball = user.getBall();

        singleCircle circle = new singleCircle(80, 65, -750, 90, true);
        singleCircle circle1 = new singleCircle(130, 105, 320, 120, false);
        singleCircle circle2 = new singleCircle(90, 70, 320, 120, true);
        Square square = new Square(175 , 380, 150, 20, true, 90);
        horizontalBar bar = new horizontalBar(-200, WIDTH, 15, 200, 50);
        Plus plus = new Plus(120, -600, 110, 15, 255, 90, true, true);
        Plus plus1 = new Plus(390, -600, 110, 15, 255, 90, false, false);

        MagicColourBox mcb = new MagicColourBox(250, 300);
        MagicColourBox mcb1 = new MagicColourBox(250, -90);
        MagicColourBox mcb2 = new MagicColourBox(250, -400);
        MagicColourBox mcb3 = new MagicColourBox(250, -780);

        ArrayList<Obstacles> obstacles = new ArrayList<>();
        obstacles.add(circle1); obstacles.add(circle2); obstacles.add(square);
        obstacles.add(plus); obstacles.add(plus1); obstacles.add(bar); obstacles.add(circle);
        ArrayList<MagicColourBox> boxes = new ArrayList<>();
        boxes.add(mcb); boxes.add(mcb1); boxes.add(mcb2); boxes.add(mcb3);

        rootJeu.setBackground(new Background(new BackgroundFill(Color.BLACK,CornerRadii.EMPTY, Insets.EMPTY)));

        sceneJeu.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.SPACE){
                    ball.jump();
                    started[0] = true; } }});

        for (Obstacles o: obstacles){
            o.draw(rootJeu); }

        for (MagicColourBox box : boxes){
            box.draw(rootJeu); }

        ArrayList<obj> objects = new ArrayList<>();
        objects.addAll(obstacles); objects.addAll(boxes);
        rootJeu.getChildren().add(text);
        st.draw(rootJeu);

        ball.draw(rootJeu);
        AnimationTimer timer = new AnimationTimer() {
            private long lastTime = System.nanoTime();
            private long startTime = System.nanoTime();
            private double scroll = 0; private double totalScroll = 0;
            @Override
            public void handle(long currentTime) {
                double t = (currentTime - lastTime) / 1000000000.0;
                double timeSinceStart = (currentTime - startTime)/1e9;
                ball.move(t, started[0]);

                double ballY = ball.getY();

                if (ballY<=HEIGHT/2){
                    scroll = HEIGHT/2 - ballY; }
                else if (ballY>=HEIGHT-10){
                    scroll = HEIGHT-10-ballY; }

                totalScroll += scroll;

                if ((started[0]) && (ballY>=HEIGHT-10) && (totalScroll<=0)){
                    exit(); stop(); }


                for (obj objs: objects){
                    objs.move(scroll); }

                scroll = 0;

                for (Obstacles o: obstacles){
                    o.rotate(t);
                    if (o.collision(ball, timeSinceStart)){
                        exit(); stop();}
                    o.starCollision(user, rootJeu); }

                for (MagicColourBox box: boxes){
                    box.handleCollision(user, rootJeu); }

                if (user.getScore()>=10) st.get().setTranslateX(17);
                text.setText(""+ user.getScore());

                lastTime = currentTime; }
        };
        timer.start();
        primaryStage.setScene(sceneJeu);

    }
}