package Boards;


import Bases.RecordsBase;
import Model.Move;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class ReplyBoardBase extends AnchorPane {
    private HashMap<String, Label> labelsMap = new HashMap<>();
    private HashMap<String, Button> buttonsMap = new HashMap<>();

    private ArrayList<Move>game;
    private int turn = 0;
    private String character = "";

    protected final Rectangle rectangle;
    protected final Line line;
    protected final Line line0;
    protected final Line line1;
    protected final Line line2;
    protected final Line line3;
    protected final Line line4;
    protected final Line line5;
    protected final Line line6;
    protected final Label BoardLabel00;
    protected final Label BoardLabel10;
    protected final Label BoardLabel20;
    protected final Label BoardLabel01;
    protected final Label BoardLabel02;
    protected final Label BoardLabel12;
    protected final Label BoardLabel22;
    protected final Label BoardLabel11;
    protected final Label BoardLabel21;

    protected final Button BoardButton00;
    protected final Button BoardButton01;
    protected final Button BoardButton02;
    protected final Button BoardButton10;
    protected final Button BoardButton11;
    protected final Button BoardButton12;
    protected final Button BoardButton20;
    protected final Button BoardButton21;
    protected final Button BoardButton22;



    protected final ImageView player1ImageView;
    protected final ImageView player2ImageView;
    protected final Label player1Label;
    protected final Label player2Label;
    protected final Button homeButton;
    protected final Button playButton;
    protected final Label userLabel;
    protected final Label computerLabel;
    protected final Label VSLabel;

    Line winningLine = new Line();




    public ReplyBoardBase(ArrayList<Move>game,String type) throws FileNotFoundException {
        this.game = game;
        rectangle = new Rectangle();
        line = new Line();
        line0 = new Line();
        line1 = new Line();
        line2 = new Line();
        line3 = new Line();
        line4 = new Line();
        line5 = new Line();
        line6 = new Line();
        BoardLabel00 = new Label();
        BoardLabel10 = new Label();
        BoardLabel20 = new Label();
        BoardLabel01 = new Label();
        BoardLabel02 = new Label();
        BoardLabel12 = new Label();
        BoardLabel22 = new Label();
        BoardLabel11 = new Label();
        BoardLabel21 = new Label();
        BoardButton00 = new Button();
        BoardButton01 = new Button();
        BoardButton02 = new Button();
        BoardButton10 = new Button();
        BoardButton11 = new Button();
        BoardButton12 = new Button();
        BoardButton20 = new Button();
        BoardButton21 = new Button();
        BoardButton22 = new Button();





        player1ImageView = new ImageView();
        player2ImageView = new ImageView();
        player1Label = new Label();
        player2Label = new Label();
        homeButton = new Button();
        playButton = new Button();

        VSLabel = new Label();
        userLabel = new Label();
        computerLabel = new Label();


        labelsMap.put("00",BoardLabel00);
        labelsMap.put("01",BoardLabel01);
        labelsMap.put("02",BoardLabel02);
        labelsMap.put("10",BoardLabel10);
        labelsMap.put("11",BoardLabel11);
        labelsMap.put("12",BoardLabel12);
        labelsMap.put("20",BoardLabel20);
        labelsMap.put("21",BoardLabel21);
        labelsMap.put("22",BoardLabel22);

        buttonsMap.put("00",BoardButton00);
        buttonsMap.put("01",BoardButton01);
        buttonsMap.put("02",BoardButton02);
        buttonsMap.put("10",BoardButton10);
        buttonsMap.put("11",BoardButton11);
        buttonsMap.put("12",BoardButton12);
        buttonsMap.put("20",BoardButton20);
        buttonsMap.put("21",BoardButton21);
        buttonsMap.put("22",BoardButton22);





        setId("AnchorPane");
        setPrefHeight(700.0);
        setPrefWidth(1000.0);
        setStyle("-fx-background-color: BLACK;");

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setHeight(527.0);
        rectangle.setLayoutX(198.0);
        rectangle.setLayoutY(135.0);
        rectangle.setStroke(javafx.scene.paint.Color.valueOf("#e1e431"));
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setStrokeWidth(5.0);
        rectangle.setWidth(605.0);


        line.setEndX(257.0);
        line.setLayoutX(321.0);
        line.setLayoutY(311.0);
        line.setStartX(-100.0);
        line.setStroke(javafx.scene.paint.Color.valueOf("#e1e413"));
        line.setStrokeWidth(5.0);

        line0.setEndX(257.0);
        line0.setLayoutX(516.0);
        line0.setLayoutY(486.0);
        line0.setStartX(-100.0);
        line0.setStroke(javafx.scene.paint.Color.valueOf("#e1e413"));
        line0.setStrokeWidth(5.0);

        line1.setEndX(67.0);
        line1.setEndY(-22.0);
        line1.setLayoutX(526.0);
        line1.setLayoutY(496.0);
        line1.setStartX(67.0);
        line1.setStartY(-344.0);
        line1.setStroke(javafx.scene.paint.Color.valueOf("#e1e413"));
        line1.setStrokeWidth(5.0);

        line2.setEndX(67.0);
        line2.setEndY(-22.0);
        line2.setLayoutX(332.0);
        line2.setLayoutY(671.0);
        line2.setStartX(67.0);
        line2.setStartY(-344.0);
        line2.setStroke(javafx.scene.paint.Color.valueOf("#e1e413"));
        line2.setStrokeWidth(5.0);

        line3.setEndX(67.0);
        line3.setEndY(-202.0);
        line3.setLayoutX(332.0);
        line3.setLayoutY(496.0);
        line3.setStartX(67.0);
        line3.setStartY(-344.0);
        line3.setStroke(javafx.scene.paint.Color.valueOf("#e1e413"));
        line3.setStrokeWidth(5.0);

        line4.setEndX(67.0);
        line4.setEndY(-202.0);
        line4.setLayoutX(526.0);
        line4.setLayoutY(845.0);
        line4.setStartX(67.0);
        line4.setStartY(-344.0);
        line4.setStroke(javafx.scene.paint.Color.valueOf("#e1e413"));
        line4.setStrokeWidth(5.0);

        line5.setEndX(-23.0);
        line5.setEndY(-275.0);
        line5.setLayoutX(635.0);
        line5.setLayoutY(586.0);
        line5.setStartX(136.0);
        line5.setStartY(-275.0);
        line5.setStroke(javafx.scene.paint.Color.valueOf("#e1e413"));
        line5.setStrokeWidth(5.0);

        line6.setEndX(-23.0);
        line6.setEndY(-275.0);
        line6.setLayoutX(244.0);
        line6.setLayoutY(763.0);
        line6.setStartX(136.0);
        line6.setStartY(-275.0);
        line6.setStroke(javafx.scene.paint.Color.valueOf("#e1e413"));
        line6.setStrokeWidth(5.0);

        BoardLabel00.setLayoutX(217.0);
        BoardLabel00.setLayoutY(150.0);
        BoardLabel00.setPrefHeight(149.0);
        BoardLabel00.setPrefWidth(168.0);
        BoardLabel00.setStyle("-fx-background-color: black;");
        BoardLabel00.setAlignment(Pos.CENTER);;
        BoardLabel00.setFont(new Font("Brush Script MT Italic", 100));

        BoardButton00.setLayoutX(216.0);
        BoardButton00.setLayoutY(149.0);
        BoardButton00.setMnemonicParsing(false);
        BoardButton00.setPrefHeight(150.0);
        BoardButton00.setPrefWidth(170.0);
        BoardButton00.setStyle("-fx-background-color: Black;");







        BoardLabel10.setLayoutX(217.0);
        BoardLabel10.setLayoutY(328.0);
        BoardLabel10.setPrefHeight(149.0);
        BoardLabel10.setPrefWidth(168.0);
        BoardLabel10.setStyle("-fx-background-color: black;");
        BoardLabel10.setAlignment(Pos.CENTER);
        BoardLabel10.setFont(new Font("Brush Script MT Italic", 100));


        BoardButton10.setLayoutX(216.0);
        BoardButton10.setLayoutY(327.0);
        BoardButton10.setMnemonicParsing(false);
        BoardButton10.setPrefHeight(150.0);
        BoardButton10.setPrefWidth(170.0);
        BoardButton10.setStyle("-fx-background-color: BLACK;");





        BoardLabel20.setLayoutX(216.0);
        BoardLabel20.setLayoutY(500.0);
        BoardLabel20.setPrefHeight(149.0);
        BoardLabel20.setPrefWidth(168.0);
        BoardLabel20.setStyle("-fx-background-color: black;");
        BoardLabel20.setAlignment(Pos.CENTER);
        BoardLabel20.setFont(new Font("Brush Script MT Italic", 100));

        BoardButton20.setLayoutX(216.0);
        BoardButton20.setLayoutY(499.0);
        BoardButton20.setMnemonicParsing(false);
        BoardButton20.setPrefHeight(150.0);
        BoardButton20.setPrefWidth(170.0);
        BoardButton20.setStyle("-fx-background-color: BLACK;");


        BoardLabel01.setLayoutX(413.0);
        BoardLabel01.setLayoutY(150.0);
        BoardLabel01.setPrefHeight(149.0);
        BoardLabel01.setPrefWidth(168.0);
        BoardLabel01.setStyle("-fx-background-color: black;");
        BoardLabel01.setAlignment(Pos.CENTER);
        BoardLabel01.setFont(new Font("Brush Script MT Italic", 100));


        BoardButton01.setLayoutX(412.0);
        BoardButton01.setLayoutY(149.0);
        BoardButton01.setMnemonicParsing(false);
        BoardButton01.setPrefHeight(150.0);
        BoardButton01.setPrefWidth(170.0);
        BoardButton01.setStyle("-fx-background-color: BLACK;");


        BoardLabel02.setLayoutX(606.0);
        BoardLabel02.setLayoutY(150.0);
        BoardLabel02.setPrefHeight(149.0);
        BoardLabel02.setPrefWidth(168.0);
        BoardLabel02.setStyle("-fx-background-color: black;");
        BoardLabel02.setAlignment(Pos.CENTER);
        BoardLabel02.setFont(new Font("Brush Script MT Italic", 100));


        BoardButton02.setLayoutX(605.0);
        BoardButton02.setLayoutY(149.0);
        BoardButton02.setMnemonicParsing(false);
        BoardButton02.setPrefHeight(150.0);
        BoardButton02.setPrefWidth(170.0);
        BoardButton02.setStyle("-fx-background-color: BLACK;");


        BoardLabel12.setLayoutX(605.0);
        BoardLabel12.setLayoutY(326.0);
        BoardLabel12.setPrefHeight(149.0);
        BoardLabel12.setPrefWidth(168.0);
        BoardLabel12.setStyle("-fx-background-color: black;");
        BoardLabel12.setAlignment(Pos.CENTER);
        BoardLabel12.setFont(new Font("Brush Script MT Italic", 100));


        BoardButton12.setLayoutX(604.0);
        BoardButton12.setLayoutY(325.0);
        BoardButton12.setMnemonicParsing(false);
        BoardButton12.setPrefHeight(150.0);
        BoardButton12.setPrefWidth(170.0);
        BoardButton12.setStyle("-fx-background-color: BLACK;");


        BoardLabel22.setLayoutX(604.0);
        BoardLabel22.setLayoutY(498.0);
        BoardLabel22.setPrefHeight(149.0);
        BoardLabel22.setPrefWidth(168.0);
        BoardLabel22.setStyle("-fx-background-color: black;");
        BoardLabel22.setAlignment(Pos.CENTER);
        BoardLabel22.setFont(new Font("Brush Script MT Italic", 100));

        BoardButton22.setLayoutX(603.0);
        BoardButton22.setLayoutY(498.0);
        BoardButton22.setMnemonicParsing(false);
        BoardButton22.setPrefHeight(150.0);
        BoardButton22.setPrefWidth(170.0);
        BoardButton22.setStyle("-fx-background-color: BLACK;");


        BoardLabel11.setLayoutX(412.0);
        BoardLabel11.setLayoutY(327.0);
        BoardLabel11.setPrefHeight(149.0);
        BoardLabel11.setPrefWidth(168.0);
        BoardLabel11.setStyle("-fx-background-color: black;");
        BoardLabel11.setAlignment(Pos.CENTER);
        BoardLabel11.setFont(new Font("Brush Script MT Italic", 100));

        BoardButton11.setLayoutX(411.0);
        BoardButton11.setLayoutY(326.0);
        BoardButton11.setMnemonicParsing(false);
        BoardButton11.setPrefHeight(150.0);
        BoardButton11.setPrefWidth(170.0);
        BoardButton11.setStyle("-fx-background-color: BLACK;");



        BoardLabel21.setLayoutX(411.0);
        BoardLabel21.setLayoutY(499.0);
        BoardLabel21.setPrefHeight(149.0);
        BoardLabel21.setPrefWidth(168.0);
        BoardLabel21.setStyle("-fx-background-color: black;");
        BoardLabel21.setAlignment(Pos.CENTER);
        BoardLabel21.setFont(new Font("Brush Script MT Italic", 100));


        BoardButton21.setLayoutX(410.0);
        BoardButton21.setLayoutY(498.0);
        BoardButton21.setMnemonicParsing(false);
        BoardButton21.setPrefHeight(150.0);
        BoardButton21.setPrefWidth(170.0);
        BoardButton21.setStyle("-fx-background-color: BLACK;");




        AnchorPane.setLeftAnchor(player1ImageView, 50.0);
        AnchorPane.setTopAnchor(player1ImageView, 70.0);
        player1ImageView.setFitHeight(100.0);
        player1ImageView.setFitWidth(100.0);
        player1ImageView.setLayoutX(50.0);
        player1ImageView.setLayoutY(62.0);
        player1ImageView.setPickOnBounds(true);
        player1ImageView.setPreserveRatio(true);
        //player1ImageView.setImage(new Image(getClass().getResource("../../../../Downloads/man.png").toExternalForm()));
        FileInputStream input;
        if(type.equals("Single")) {
            input = new FileInputStream("robot-2.png");
        }else{
            input = new FileInputStream("man.png");
        }
        Image image = new Image(input);
        player1ImageView.setImage(image);

        AnchorPane.setRightAnchor(player2ImageView, 50.0);
        AnchorPane.setTopAnchor(player2ImageView, 70.0);
        player2ImageView.setFitHeight(100.0);
        player2ImageView.setFitWidth(100.0);
        player2ImageView.setLayoutX(816.8762817382812);
        player2ImageView.setLayoutY(57.0);
        player2ImageView.setPickOnBounds(true);
        player2ImageView.setPreserveRatio(true);
        input = new FileInputStream("man.png");
        image = new Image(input);
        player2ImageView.setImage(image);

        player1Label.setLayoutX(14.0);
        player1Label.setLayoutY(22.0);
        player1Label.setPrefHeight(31.0);
        player1Label.setPrefWidth(250.0);
        player1Label.setTextFill(Color.RED);
        if(type.equals("Single")) {
            player1Label.setText("RoboPlayer");
        }else{
            player1Label.setText("Player 1");
        }
        player1Label.setFont(new Font("Brush Script MT Italic", 50.0));

        VSLabel.setLayoutX(447.0);
        VSLabel.setLayoutY(29.0);
        VSLabel.setPrefHeight(60.0);
        VSLabel.setPrefWidth(74.0);
        VSLabel.setText("VS");
        VSLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        VSLabel.setFont(new Font("Lucida Bright Demibold", 50.0));


        computerLabel.setLayoutX(80.0);
        computerLabel.setLayoutY(193.0);
        computerLabel.setPrefHeight(60.0);
        computerLabel.setPrefWidth(43.0);
        computerLabel.setText("X");
        computerLabel.setTextFill(javafx.scene.paint.Color.RED);
        computerLabel.setFont(new Font("Lucida Bright Regular", 50.0));

        player2Label.setLayoutX(800.0);
        player2Label.setLayoutY(22.0);
        player2Label.setPrefHeight(31.0);
        player2Label.setPrefWidth(150);
        player2Label.setText("Player 2");
        player2Label.setTextFill(Color.BLUE);
        player2Label.setFont(new Font("Brush Script MT Italic", 50.0));


        homeButton.setLayoutX(36.0);
        homeButton.setLayoutY(616.0);
        homeButton.setMnemonicParsing(false);
        homeButton.setPrefHeight(43.0);
        homeButton.setPrefWidth(55.0);
        homeButton.setStyle("-fx-background-color: #e1e413;");
        FileInputStream homeImageInput = new FileInputStream("homepage.png");
        Image homeImage = new Image(homeImageInput);
        ImageView homeImageView = new ImageView((homeImage));
        homeImageView.setFitHeight(55.0);
        homeImageView.setFitWidth(77.0);
        homeButton.setGraphic(homeImageView);
        homeButton.addEventHandler(ActionEvent.ACTION, event -> {
            RecordsBase.update();
            Main.pStage.setScene(Main.scene);
        });


        playButton.setLayoutX(425.0);
        playButton.setLayoutY(80.0);
        playButton.setMinHeight(28.0);
        playButton.setMnemonicParsing(false);
        playButton.setPrefWidth(120.0);
        playButton.setStyle("-fx-background-color: #e1e413; -fx-background-radius: 20px;");
        playButton.setText("Play");
        playButton.setFont(new Font("Lucida Bright Regular", 13.0));
        playButton.addEventHandler(ActionEvent.ACTION,event -> {
            playRecord();
            playButton.setVisible(false);
        });

        getChildren().add(rectangle);
        getChildren().add(line);
        getChildren().add(line0);
        getChildren().add(line1);
        getChildren().add(line2);
        getChildren().add(line3);
        getChildren().add(line4);
        getChildren().add(line5);
        getChildren().add(line6);
        getChildren().add(BoardLabel00);
        getChildren().add(BoardLabel10);
        getChildren().add(BoardLabel20);
        getChildren().add(BoardLabel01);
        getChildren().add(BoardLabel02);
        getChildren().add(BoardLabel12);
        getChildren().add(BoardLabel22);
        getChildren().add(BoardLabel11);
        getChildren().add(BoardLabel21);
        getChildren().add(player1ImageView);
        getChildren().add(player2ImageView);
        getChildren().add(player1Label);
        getChildren().add(player2Label);
        getChildren().add(homeButton);
        getChildren().add(playButton);
        getChildren().add(BoardButton00);
        getChildren().add(BoardButton01);
        getChildren().add(BoardButton02);
        getChildren().add(BoardButton10);
        getChildren().add(BoardButton11);
        getChildren().add(BoardButton12);
        getChildren().add(BoardButton20);
        getChildren().add(BoardButton21);
        getChildren().add(BoardButton22);




    }

    public void playRecord(){

        for(Move nextMove :game) {
                playMove(nextMove);
            }
            new Thread(() -> {

                        for(Move move:game){
                            String playPlace = getString(move.getRow(),move.getCol());
                            doAnimation(buttonsMap.get(playPlace));
                            try {
                                Thread.sleep(500);

                            }catch (Exception ignored){

                            }

                        }

                        Platform.runLater(this::checkWinner);
            }).start();

    }

     private void playMove(Move currentMove){


         new Thread(() -> Platform.runLater(() -> {


             String playPlace = getString(currentMove.getRow(),currentMove.getCol());
             character = currentMove .getMark();
             Label targetLabel = labelsMap.get(playPlace);
             Color color;
             if(character.equals("O")){
                 color = Color.BLUE;
             }
             else{
                 color = Color.RED;

             }
        ReplyBoardBase.executeMove(targetLabel, character,color);
             turn++;
         })).start();


    }

    private String getString(int indexI, int indexJ){
        String temp = Integer.toString(indexI);
        temp+=Integer.toString(indexJ);
        return temp;
    }


    synchronized static void executeMove(Label pressedLabel,String character, Color color) {

        pressedLabel.setTextFill(color);
        pressedLabel.setText(character);

    }

    synchronized public static void doAnimation(Button pressedButton){

        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(1000));
        fade.setFromValue(10);
        fade.setToValue(0);
        fade.setCycleCount(1);
        fade.setAutoReverse(false);
        fade.setNode(pressedButton);
        fade.setOnFinished((event -> waitAlil()));
        fade.play();
    }



    private static void  waitAlil(){
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }


    void checkWinner(){
        if (BoardLabel00.getText().equals(BoardLabel01.getText())&&BoardLabel00.getText().equals(BoardLabel02.getText())) {
            if (!BoardLabel00.getText().equals("")) {
                BoardLabel00.setStyle("-fx-background-color: #e1e413;");
                BoardLabel01.setStyle("-fx-background-color: #e1e413;");
                BoardLabel02.setStyle("-fx-background-color: #e1e413;");

                drawWinnerLine(BoardLabel00, BoardLabel02);

            }
        }
        else if(BoardLabel10.getText().equals(BoardLabel11.getText()) &&BoardLabel10.getText().equals(BoardLabel12.getText())){
            if(!BoardLabel10.getText().equals("")){
                BoardLabel10.setStyle("-fx-background-color: #e1e413;");
                BoardLabel11.setStyle("-fx-background-color: #e1e413;");
                BoardLabel12.setStyle("-fx-background-color: #e1e413;");

                drawWinnerLine(BoardLabel10, BoardLabel12);

            }
        }
        else if(BoardLabel20.getText().equals(BoardLabel21.getText()) &&BoardLabel20.getText().equals(BoardLabel22.getText())){
            if(!BoardLabel20.getText().equals("")){
                BoardLabel20.setStyle("-fx-background-color: #e1e413;");
                BoardLabel21.setStyle("-fx-background-color: #e1e413;");
                BoardLabel22.setStyle("-fx-background-color: #e1e413;");

                drawWinnerLine(BoardLabel20, BoardLabel22);

            }
        }

        else if(BoardLabel00.getText().equals(BoardLabel10.getText())&&BoardLabel00.getText().equals(BoardLabel20.getText())){
            if(!BoardLabel00.getText().equals("")){
                BoardLabel00.setStyle("-fx-background-color: #e1e413;");
                BoardLabel10.setStyle("-fx-background-color: #e1e413;");
                BoardLabel20.setStyle("-fx-background-color: #e1e413;");

                drawWinnerLine(BoardLabel00, BoardLabel20);


            }
        }

        else if(BoardLabel01.getText().equals(BoardLabel11.getText())&&BoardLabel01.getText().equals(BoardLabel21.getText())){
            if(!BoardLabel01.getText().equals("")){
                BoardLabel01.setStyle("-fx-background-color: #e1e413;");
                BoardLabel11.setStyle("-fx-background-color: #e1e413;");
                BoardLabel21.setStyle("-fx-background-color: #e1e413;");

                drawWinnerLine(BoardLabel01, BoardLabel21);

            }
        }
        else if(BoardLabel02.getText().equals(BoardLabel12.getText())&&BoardLabel02.getText().equals(BoardLabel22.getText())){
            if(!BoardLabel02.getText().equals("")){
                BoardLabel02.setStyle("-fx-background-color: #e1e413;");
                BoardLabel12.setStyle("-fx-background-color: #e1e413;");
                BoardLabel22.setStyle("-fx-background-color: #e1e413;");

                drawWinnerLine(BoardLabel02,BoardLabel22);

            }
        }
        else if(BoardLabel00.getText().equals(BoardLabel11.getText())&&BoardLabel00.getText().equals(BoardLabel22.getText())){
            if(!BoardLabel00.getText().equals("")){
                BoardLabel00.setStyle("-fx-background-color: #e1e413;");
                BoardLabel11.setStyle("-fx-background-color: #e1e413;");
                BoardLabel22.setStyle("-fx-background-color: #e1e413;");

                drawWinnerLine(BoardLabel00, BoardLabel22);

            }
        }
        else if(BoardLabel20.getText().equals(BoardLabel11.getText())&&BoardLabel20.getText().equals(BoardLabel02.getText())){
            if(!BoardLabel20.getText().equals("")){
                BoardLabel20.setStyle("-fx-background-color: #e1e413;");
                BoardLabel11.setStyle("-fx-background-color: #e1e413;");
                BoardLabel02.setStyle("-fx-background-color: #e1e413;");

                drawWinnerLine(BoardLabel20, BoardLabel02);


            }
        }

    }

    void drawWinnerLine(Label startLabel, Label endLabel){

        winningLine.setStartX(startLabel.getLayoutX()+(startLabel.getHeight()/2));
        winningLine.setStartY(startLabel.getLayoutY()+(startLabel.getWidth()/2));
        winningLine.setEndX(endLabel.getLayoutX()+(endLabel.getHeight()/2));
        winningLine.setEndY(endLabel.getLayoutY()+(endLabel.getWidth()/2));
        winningLine.setStrokeWidth(5.0);
        winningLine.setStroke(Color.RED);
        System.out.println(this.getChildren());
        this.getChildren().add(winningLine);

    }




}