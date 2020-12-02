package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class Controller {
    private Game game;
    public static Stage primaryStage;
    private int WIDTH, HEIGHT, jump;

    public Controller() {
        WIDTH =500; HEIGHT = 700; jump = 200;
        this.game = new Game("Unknown", HEIGHT, WIDTH, jump); }

    public void spaceTyped() {

    }

    public void serialize(String name) throws IOException {
        File f = new File(name+".txt");
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(game); }

    public void deserialize(String name) {
        try {
            FileInputStream fis = new FileInputStream(name + ".txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            game = (Game) ois.readObject();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void load(String s){
        try {
            Pane root = FXMLLoader.load(getClass().getResource(s+".fxml"));
            primaryStage.setScene(new Scene(root)); }
        catch (IOException e) {
            System.out.println("FXML not found!"); } }

    private Font loadFont(int size){
        Font font = Font.loadFont("file:resources/fonts/stencil.ttf", size);
        return font; }

    private void getText(Pane root){
        Color[] colour = new Color[]{Color.RED, Color.YELLOWGREEN, Color.LIGHTSKYBLUE};
        Font font = loadFont(85);
        int[] pos = new int[] {15, 137, 253, 165, 215, 295, 325, 375, 430};
        String[] text = new String[] {"C", "L", "R", "S", "W", "I", "T", "C", "H"};
        Text[] texts = new Text[9];
        for (int i=0; i<9; i++){
            if (i<3) {
                texts[i] = new Text(pos[i], 90, text[i]); texts[i].setFont(font); texts[i].setFill(Color.WHITE); }
            else{
                texts[i] = new Text(pos[i], 185, text[i]); texts[i].setFont(font);
                if (i%2!=0) texts[i].setFill(Color.WHITE);
                else texts[i].setFill(colour[(i-4)/2]); } }
        root.getChildren().addAll(texts); }

    private void drawInfinity(Pane root){
        SVGPath svg = new SVGPath();
        svg.setFill(Color.TRANSPARENT);
        svg.setContent("M 787.49,150 C 787.49,203.36 755.56,247.27 712.27,269.5 S 622.17,290.34 582.67,279.16 508.78,246.56 480,223.91 424.93,174.93 400,150 348.85,98.79 320,76.09 256.91,32.03 217.33,20.84 130.62,8.48 87.73,30.5 12.51,96.64 12.51,150 44.44,247.27 87.73,269.5 177.83,290.34 217.33,279.16 291.22,246.56 320,223.91 375.07,174.93 400,150 451.15,98.79 480,76.09 543.09,32.03 582.67,20.84 669.38,8.48 712.27,30.5 787.49,96.64 787.49,150 z");
        double originalWidth = svg.prefWidth(-1);
        double originalHeight = svg.prefHeight(originalWidth);
        double scaleX = 110 / originalWidth;
        double scaleY = 60 / originalHeight;
        svg.setScaleX(scaleX); svg.setScaleY(scaleY);
        svg.setStrokeWidth(80.0); svg.setStroke(Color.WHITE);
        svg.setLayoutX(-150); svg.setLayoutY(255);
        root.getChildren().add(svg); }


    private void addButtons(Pane root) {
        String[] bt = new String[]{"newGame", "ResumeGame", "help", "Exit"};
        Button button1= new Button(); button1.setMinSize(120,85);
        Button button2= new Button(); button2.setMinSize(120,65);
        Button button3= new Button(); button3.setMinSize(120,70);
        Button button4= new Button(); button4.setMinSize(100,60);
        Button[] buttons = new Button[] {button1, button2, button3, button4};
        for (int i=0; i<4; i++){
            buttons[i].setOpacity(0);
            int finalI = i;
            if (i==0) buttons[i].setOnAction((event) -> enterGame());
            else if(i == 1) buttons[i].setOnAction((event) -> displayResumeGame());
            else if (i!=3) buttons[i].setOnAction((event) -> load(bt[finalI]));
            else buttons[i].setOnAction((event) -> primaryStage.close()) ;}
        button1.setLayoutX(190);button1.setLayoutY(360);
        button2.setLayoutX(190);button2.setLayoutY(615);
        button3.setLayoutX(20); button3.setLayoutY(615);
        button4.setLayoutX(400);button4.setLayoutY(615);
        root.getChildren().addAll(buttons); }

    private ImageView addImage(Pane root, String name, int x, int y, int width, int height){
        Image image = new Image("file:resources/images/"+name);
        ImageView im = new ImageView(image);
        im.setX(x); im.setY(y); im.setFitWidth(width);im.setFitHeight(height);
        root.getChildren().add(im);
        return im;}

    private Pane loadPane() {
        Pane root = new Pane();
        root.setBackground(new Background(new BackgroundFill(Color.BLACK,CornerRadii.EMPTY, Insets.EMPTY)));
        return root; }

    private void display(Pane root) {
        Scene sc = new Scene(root, 500,700);
        primaryStage.setScene(sc);
        primaryStage.show(); }


    public void mainmenu() {
          Pane root = loadPane();
          primaryStage.setTitle("Colour Switch Game");
          getText(root);
          singleCircle c = new singleCircle(250, 255, 555, 130, 120, false, false);
          singleCircle c0 = new singleCircle(250, 275,535, 110, 100, false, true);
          singleCircle c1= new singleCircle(250, 295,515, 90, 80, false, false);
          singleCircle c2= new singleCircle(103, 30,95, 20, 150, false, false);
          singleCircle c3= new singleCircle(222, 30,95, 22, 150, false, true);
          Plus plus = new Plus(90, 120, 220, 10, 0, 120, false, true);
          Square sq = new Square(380, 30, 100, 7, false, 120);
          ArrayList<Obstacles> arr = new ArrayList<>(List.of(c, c0, c1, c2, c3, plus, sq));
          arr.forEach(el -> el.draw(root));
          drawInfinity(root);
          addImage(root, "qn.jpg", 10, 595, 140, 90);
          addImage(root, "res1.png", 190, 585, 130, 130);
          addImage(root,"back3.png", 380, 590, 110, 110);
          addButtons(root);
          AnimationTimer timer = new AnimationTimer() {
              private long lastTime = System.nanoTime();
              private long startTime = System.nanoTime();
              @Override
              public void handle(long currentTime) {
                  double t = (currentTime - lastTime) / 1000000000.0;
                  arr.forEach(el -> el.rotate(t));
                  lastTime = currentTime; }};
          timer.start();
          display(root);}


    public void displayExitMenu() {
        Pane root = loadPane();
        Font font = loadFont(60);
        Text text = new Text(30, 70, "Do you want to \nsave the game?");
        text.setFont(font); text.setFill(Color.WHITE);
        addImage(root, "save1.png", 175, 255, 140, 140);
        addImage(root,"cancel.png", 160, 485, 170, 170);
        Button b = new Button(); b.setLayoutX(175); b.setLayoutY(255); b.setMinWidth(140); b.setMinHeight(140);
        b.setOnAction(event -> { saveGame(false); }); b.setOpacity(0);
        Button b1 = new Button(); b1.setLayoutX(160); b1.setLayoutY(485); b1.setMinWidth(170); b1.setMinHeight(170);
        b1.setOnAction(event -> mainmenu()); b1.setOpacity(0);
        root.getChildren().addAll(text, b, b1);
        display(root); }

    public void displayResumeGame() {
        try {
            deserialize("saved/"+game.getUser().getName()+"/"+game.getUser().getSavedGames());
            enterGame(); }
        catch (Exception e){
            e.printStackTrace(); } }

    public void saveGame(boolean contin){
        try{
            game.getUser().incrementSaved();
            serialize("saved/"+game.getUser().getName()+"/"+game.getUser().getSavedGames());
        if(!contin) mainmenu();}
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Error in Serializing."); } }


    public void displayMainMenu(ActionEvent event) {
        mainmenu(); }

    void displayHelpMenu(ActionEvent event) {
        load("help"); }

    void displayPauseMenu(Scene scene, AnimationTimer timer){
        try {
            Pane root = FXMLLoader.load(getClass().getResource("pauseMenu.fxml"));
            Button b = new Button(); b.setOpacity(0);
            b.setLayoutX(166); b.setLayoutY(271); b.setMinWidth(167); b.setMinHeight(157);
            b.setOnAction(event -> resumeGame(scene, timer));
            Button b1 = new Button(); b1.setOpacity(0);
            b1.setLayoutX(166); b1.setLayoutY(521); b1.setMinWidth(167); b1.setMinHeight(157);
            b1.setOnAction(event -> displayExitMenu());
            root.getChildren().addAll(b, b1);
            primaryStage.setScene(new Scene(root)); }
        catch (IOException e) {
            System.out.println("FXML not found!"); } }

    void resumeGame(Scene scene, AnimationTimer timer){
        timer.start();
        primaryStage.setScene(scene); }

    private double[] cord(double x, double y, double sr1, double sr2){
        double[] points = new double[20];
        for (int i=0; i<20; i+=4){
            int t = i/4;
            points[i] = x - sr1*Math.cos(Math.toRadians(90+(72*t)));
            points[i+1] = y - sr1*Math.sin(Math.toRadians(90+(72*t)));
            points[i+2] = x -sr2*Math.cos(Math.toRadians(126+(72*t)));
            points[i+3] = y - sr2*Math.sin(Math.toRadians(126+(72*t))); }
        return points; }

    private void revive(Pane pane, double pos) {
        if(game.getUser().getScore() >= 2){
            deserialize("saved/temp");
            if(pos > 0) game.getUser().getBall().setY(pos+ 70);
            else game.getUser().getBall().setY(630);
            game.getUser().setScore(game.getUser().getScore() - 2);
            enterGame(); }
        else {
            Text text1 = new Text(80, 470, "Minimum 5 Stars Needed"); Font font1 = loadFont(30); text1.setFont(font1); text1.setFill(Color.WHITE);
            pane.getChildren().add(text1);
            new AnimationTimer() {
                private long lastTime = System.nanoTime();
                private long startTime = System.nanoTime();
                @Override
                public void handle(long currentTime) {
                    double t = (currentTime - startTime) / 1000000000.0;
                    if(t> 2) {pane.getChildren().remove(text1); stop();} }}.start(); } }

    void exit(AnimationTimer timer, Scene scene, double pos){
        try {
            serialize("saved/temp");
            timer.stop();
            Pane root = FXMLLoader.load(getClass().getResource("GameOver.fxml"));
            ArrayList<ImageView> ImArr= new ArrayList<>();
            Text text;
            Text text1 = new Text(17, 90, "Game Over!!"); Font font1 = loadFont(80); text1.setFont(font1); text1.setFill(Color.RED);
            ImArr.addAll(List.of(addImage(root, "heart.png", 140,384,223,188 ), addImage(root, "star.png", 206,503,24,24 ), addImage(root, "star.png", 206,528,24,24 ), addImage(root, "star.png", 226,523,18,18 ), addImage(root, "star.png", 221,546,18,24 ),
                    addImage(root, "star.png", 244,542,12,11 ), addImage(root, "star.png", 246,558,11,11 ), addImage(root, "star.png", 261,526,18,18 ), addImage(root, "star.png", 278,510,24,24 ), addImage(root, "star.png", 289,535,33,24 )));
            Star st = new Star(cord(250, 250, 90, 50)); st.get().setFill(Color.LIGHTGOLDENRODYELLOW);
            st.draw(root);
            Button btn = new Button();btn.setMinSize(223,180);btn.setLayoutY(390);btn.setLayoutX(140);btn.setOpacity(0);
            btn.setOnAction((event) -> revive(root, pos));
            if(game.getUser().getScore() > 9) {
                text = new Text(215, 270, String.valueOf(game.getUser().getScore())); Font font = loadFont(65); text.setFont(font); }
            else {
                text = new Text(230, 270, String.valueOf(game.getUser().getScore())); Font font = loadFont(65); text.setFont(font); }
            text.setFill(Color.INDIGO);
            Arc arc = new Arc(250, 470, 125, 125, 90, 360); arc.setStroke(Color.LIGHTBLUE); arc.setFill(Color.TRANSPARENT); arc.setType(ArcType.OPEN);
            root.getChildren().addAll(text1, text,arc, btn);
            AnimationTimer timer1 = new AnimationTimer() {
                private long lastTime = System.nanoTime();
                private long startTime = System.nanoTime();
                @Override
                public void handle(long currentTime) {
                    double t = (currentTime - startTime) / 1000000000.0;
                    ImArr.forEach(el -> el.setOpacity(1- (0.2 * t)));
                    arc.setLength(360-72*t);
                    if(t> 5) {root.getChildren().removeAll(btn, arc); stop();} }};
            timer1.start();
            primaryStage.setScene(new Scene(root)); }
        catch (IOException e) {
            System.out.println("FXML not found!"); }

    }


    @FXML
    void enterGame(){
        final boolean[] started = {false};
        Pane root = new Pane();
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        Text text = new Text(5, 40, "0"); Font font = loadFont(40); text.setFont(font); text.setFill(Color.WHITE);
        Star st = new Star(cord(52, 28, 18, 9));
        User user = game.getUser(); Ball ball = user.getBall();
        ArrayList<Obstacles> obstacles = game.getObstArray().getObstArray();
        ArrayList<MagicColourBox> boxes = game.getBoxes();

        root.setBackground(new Background(new BackgroundFill(Color.BLACK,CornerRadii.EMPTY, Insets.EMPTY)));

        game.draw(root);
        root.getChildren().add(text);
        st.draw(root); st.get().setFill(Color.WHITE);
        ImageView im = addImage(root, "select1.png", 233, (int) game.getHandY(), 40, 40);

        ArrayList<obj> objects = game.getObjects();

        AnimationTimer timer = new AnimationTimer() {
            private long lastTime = System.nanoTime();
            private long startTime = System.nanoTime();
            private double scroll = 0; private double totalScroll = 0;

            @Override
            public void start() {
                lastTime = System.nanoTime();
                super.start(); }

            @Override
            public void handle(long currentTime) {
                double t = (currentTime - lastTime) / 1e9;
                double timeSinceStart = (currentTime - startTime)/1e9;
                ball.move(t, started[0]);

                double ballY = ball.getY();

                if (ballY<=HEIGHT/2){
                    scroll = HEIGHT/2 - ballY; }
                else if (ballY>=HEIGHT-10){
                    scroll = HEIGHT-10-ballY; }

                totalScroll += scroll;

                if ((started[0]) && (ballY>=HEIGHT) && (totalScroll<=0)){
                    exit(this, scene, -1); }

                for (obj objs: objects){
                    objs.move(scroll); }

                game.scrollHand(scroll);
                im.setY(game.getHandY());

                scroll = 0;

                for (Obstacles o: obstacles){
                    if (o.collision(ball, timeSinceStart)){
                        exit(this, scene, o.getyBottom());}
                    o.rotate(t);
                    o.starCollision(user, root); }

                for (MagicColourBox box: boxes){
                    box.handleCollision(user, root); }

                if (user.getScore()>=10) st.get().setTranslateX(17);
                text.setText(""+ user.getScore());

                lastTime = currentTime; }};
        timer.start();

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP){
                    ball.jump();
                    started[0] = true; }
                else if(event.getCode() == KeyCode.ESCAPE){
                    timer.stop();
                    displayPauseMenu(scene, timer); }
                else if (event.getCode() == KeyCode.S){
                        saveGame(true); } }});

        primaryStage.setScene(scene);

    }



    
}