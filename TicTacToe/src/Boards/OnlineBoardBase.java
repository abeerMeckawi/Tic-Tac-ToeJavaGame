package Boards;

import Bases.OnlineMultiPlayerBase;
import Dialogues.LostConnectionDialoge;
import Dialogues.saveDialogBase;
import Model.Move;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class OnlineBoardBase extends AnchorPane {
    private String[][] gameArray ={{"","",""},{"","",""},{"","",""}};
    private ArrayList<Move> moves = new ArrayList<>();
    private int turn;
    private int finishTurn;
    private AtomicBoolean online;
    private Socket s;


    private HashMap<String, Label> labelsMap = new HashMap<>();
    private HashMap<String, Button> buttonsMap = new HashMap<>();
    private DataInputStream dis;
    private PrintStream ps;

    private boolean isMyTurn = true;
    private boolean gameFinished = false;

    private String character;

    private ArrayList<Label> celArray = new ArrayList<>();
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

    protected final Label VSLabel;
    protected final Label computerLabel;
    protected final Label userLabel;
    protected final Label turnXLabel;
    protected final Label turnOLabel;


    protected final Label c1;
    protected final Label c2;
    protected final Label c3;
    protected final Label c4;
    protected final Label c5;
    protected final Label c6;
    protected final Label c7;
    protected final Label c8;
    protected final Label c9;
    protected final Label c10;
    protected final Label c11;
    protected final Label c12;
    protected final Label c13;
    protected final Label c14;
    protected final Label c15;
    protected final Label c16;

    protected final Label celebrationLabel;


    private final String type;

    private final Line winningLine = new Line();

    static Stage dialogStage;

    public static Stage getDialogStage() {
        return dialogStage;
    }

    public OnlineBoardBase(String type, Socket s) throws FileNotFoundException {
        this.type = type;
        this.s = s;
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

        c1 = new Label();
        c2 = new Label();
        c3 = new Label();
        c4 = new Label();
        c5 = new Label();
        c6 = new Label();
        c7 = new Label();
        c8 = new Label();
        c9 = new Label();
        celebrationLabel = new Label();
        c10 = new Label();
        c11 = new Label();
        c12 = new Label();
        c13 = new Label();
        c14 = new Label();
        c15 = new Label();
        c16 = new Label();

        celArray.add(c1);
        celArray.add(c2);
        celArray.add(c3);
        celArray.add(c4);
        celArray.add(c5);
        celArray.add(c16);
        celArray.add(c6);
        celArray.add(c7);
        celArray.add(c8);
        celArray.add(c9);
        celArray.add(c10);
        celArray.add(c11);
        celArray.add(c12);
        celArray.add(c13);
        celArray.add(c14);
        celArray.add(c15);




        player1ImageView = new ImageView();
        player2ImageView = new ImageView();
        player1Label = new Label();
        player2Label = new Label();
        homeButton = new Button();
        VSLabel = new Label();
        userLabel = new Label();
        computerLabel = new Label();
        turnOLabel = new Label();
        turnXLabel = new Label();
        online = new AtomicBoolean(true);
        turn = 0;



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
        BoardButton00.addEventHandler(ActionEvent.ACTION,event -> sendMove("00"));


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
        BoardButton10.addEventHandler(ActionEvent.ACTION,event -> sendMove("10"));


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
        BoardButton20.addEventHandler(ActionEvent.ACTION,event -> sendMove("20"));


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
        BoardButton01.addEventHandler(ActionEvent.ACTION,event -> sendMove("01"));


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
        BoardButton02.addEventHandler(ActionEvent.ACTION,event -> {
            System.out.println("pressed");
            sendMove("02");
        });


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
        BoardButton12.addEventHandler(ActionEvent.ACTION,event -> sendMove("12"));


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
        BoardButton22.addEventHandler(ActionEvent.ACTION,event -> sendMove("22"));


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
        BoardButton11.addEventHandler(ActionEvent.ACTION,event -> sendMove("11"));



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
        BoardButton21.addEventHandler(ActionEvent.ACTION,event -> sendMove("21"));


        AnchorPane.setLeftAnchor(player1ImageView, 50.0);
        AnchorPane.setTopAnchor(player1ImageView, 70.0);
        player1ImageView.setFitHeight(100.0);
        player1ImageView.setFitWidth(100.0);
        player1ImageView.setLayoutX(50.0);
        player1ImageView.setLayoutY(62.0);
        player1ImageView.setPickOnBounds(true);
        player1ImageView.setPreserveRatio(true);
        //player1ImageView.setImage(new Image(getClass().getResource("../../../../Downloads/man.png").toExternalForm()));
        FileInputStream input = new FileInputStream("man.png");
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
        player1Label.setText("Player 1");
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

        userLabel.setLayoutX(880.0);
        userLabel.setLayoutY(195.0);
        userLabel.setPrefHeight(60.0);
        userLabel.setPrefWidth(43.0);
        userLabel.setText("O");
        userLabel.setTextFill(javafx.scene.paint.Color.valueOf("#0047fff2"));
        userLabel.setFont(new Font("Lucida Bright Regular", 50.0));

        turnOLabel.setLayoutX(836.0);
        turnOLabel.setLayoutY(277.0);
        turnOLabel.setPrefHeight(60.0);
        turnOLabel.setPrefWidth(135.0);
        turnOLabel.setText("Your Turn ");
        turnOLabel.setTextFill(javafx.scene.paint.Color.valueOf("#0047ff"));
        turnOLabel.setFont(new Font("Lucida Bright Demibold", 17.0));
        turnOLabel.setVisible(false);

        turnXLabel.setLayoutX(25.0);
        turnXLabel.setLayoutY(277.0);
        turnXLabel.setPrefHeight(60.0);
        turnXLabel.setPrefWidth(135.0);
        turnXLabel.setText("Opponent Turn ");
        turnXLabel.setTextFill(Color.RED);
        turnXLabel.setFont(new Font("Lucida Bright Demibold", 17.0));
        turnXLabel.setVisible(false);

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
            leave();

            Main.pStage.setScene(Main.scene);
        });

        celebrationLabel.setLayoutX(11.0);
        celebrationLabel.setLayoutY(309.0);
        celebrationLabel.setPrefHeight(171.0);
        celebrationLabel.setPrefWidth(997.0);
        celebrationLabel.setVisible(false);
        celebrationLabel.setFont(new Font("Lucida Bright Demibold", 70));
        celebrationLabel.setAlignment(Pos.CENTER);

        c1.setLayoutX(132);
        c1.setLayoutY(244);
        c1.setPrefWidth(43);
        c1.setPrefHeight(60);
        c1.setVisible(false);
        c1.setFont(new Font("Lucida Bright Regular", 50.0));

        c2.setLayoutX(57);
        c2.setLayoutY(517);
        c2.setPrefWidth(43);
        c2.setPrefHeight(60);
        c2.setVisible(false);
        c2.setFont(new Font("Lucida Bright Regular", 50.0));

        c3.setLayoutX(193);
        c3.setLayoutY(59);
        c3.setPrefWidth(43);
        c3.setPrefHeight(60);
        c3.setVisible(false);
        c3.setFont(new Font("Lucida Bright Regular", 50.0));

        c4.setLayoutX(304);
        c4.setLayoutY(38);
        c4.setPrefWidth(43);
        c4.setPrefHeight(60);
        c4.setVisible(false);
        c4.setFont(new Font("Lucida Bright Regular", 50.0));

        c5.setLayoutX(656);
        c5.setLayoutY(53);
        c5.setPrefWidth(43);
        c5.setPrefHeight(60);
        c5.setVisible(false);
        c5.setFont(new Font("Lucida Bright Regular", 50.0));

        c6.setLayoutX(782);
        c6.setLayoutY(71);
        c6.setPrefWidth(43);
        c6.setPrefHeight(60);
        c6.setVisible(false);
        c6.setFont(new Font("Lucida Bright Regular", 50.0));

        c7.setLayoutX(816);
        c7.setLayoutY(149);
        c7.setPrefWidth(43);
        c7.setPrefHeight(60);
        c7.setVisible(false);
        c7.setFont(new Font("Lucida Bright Regular", 50.0));

        c8.setLayoutX(736);
        c8.setLayoutY(513);
        c8.setPrefWidth(43);
        c8.setPrefHeight(60);
        c8.setVisible(false);
        c8.setFont(new Font("Lucida Bright Regular", 50.0));

        c9.setLayoutX(946);
        c9.setLayoutY(466);
        c9.setPrefWidth(43);
        c9.setPrefHeight(60);
        c9.setVisible(false);
        c9.setFont(new Font("Lucida Bright Regular", 50.0));

        c10.setLayoutX(515);
        c10.setLayoutY(566);
        c10.setPrefWidth(43);
        c10.setPrefHeight(60);
        c10.setVisible(false);
        c10.setFont(new Font("Lucida Bright Regular", 50.0));

        c11.setLayoutX(312);
        c11.setLayoutY(557);
        c11.setPrefWidth(43);
        c11.setPrefHeight(60);
        c11.setVisible(false);
        c11.setFont(new Font("Lucida Bright Regular", 50.0));

        c12.setLayoutX(247);
        c12.setLayoutY(194);
        c12.setPrefWidth(43);
        c12.setPrefHeight(60);
        c12.setVisible(false);
        c12.setFont(new Font("Lucida Bright Regular", 50.0));


        c13.setLayoutX(400);
        c13.setLayoutY(196);
        c13.setPrefWidth(43);
        c13.setPrefHeight(60);
        c13.setVisible(false);
        c13.setFont(new Font("Lucida Bright Regular", 50.0));

        c14.setLayoutX(541);
        c14.setLayoutY(198);
        c14.setPrefWidth(43);
        c14.setPrefHeight(60);
        c14.setVisible(false);
        c14.setFont(new Font("Lucida Bright Regular", 50.0));

        c15.setLayoutX(644);
        c15.setLayoutY(191);
        c15.setPrefWidth(43);
        c15.setPrefHeight(60);
        c15.setVisible(false);
        c15.setFont(new Font("Lucida Bright Regular", 50.0));

        c16.setLayoutX(832);
        c16.setLayoutY(546);
        c16.setPrefWidth(43);
        c16.setPrefHeight(60);
        c16.setVisible(false);
        c16.setFont(new Font("Lucida Bright Regular", 50.0));





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
        getChildren().add(BoardButton00);
        getChildren().add(BoardButton01);
        getChildren().add(BoardButton02);
        getChildren().add(BoardButton10);
        getChildren().add(BoardButton11);
        getChildren().add(BoardButton12);
        getChildren().add(BoardButton20);
        getChildren().add(BoardButton21);
        getChildren().add(BoardButton22);
        getChildren().add(VSLabel);
        getChildren().add(turnOLabel);
        getChildren().add(turnXLabel);
        getChildren().add(userLabel);
        getChildren().add(computerLabel);
        getChildren().add(celebrationLabel);
        getChildren().addAll(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16);







        switch (type){
            case "SERVER":
                startConnecting();
                character = "O";
                turnOLabel.setVisible(true);
                isMyTurn = true;
                break;

            case "JOIN":
                startConnecting();
                character = "X";
                turnXLabel.setVisible(true);
                isMyTurn = false;
                break;

            default:
                break;
        }
    }



    void playMove(String move) {
        try {
                if (move.equals("close")) {
                    online.set(false);
                    s.close();
                    dis.close();
                    ps.close();

                    if (OnlineMultiPlayerBase.getSv() != null) {
                        if (!OnlineMultiPlayerBase.getSv().getServerSocket().isClosed()) {
                            OnlineMultiPlayerBase.getSv().getServerSocket().close();
                            OnlineMultiPlayerBase.setSv(null);
                        }
                    }
                    if (!gameFinished) {
                        ShowLostConnectionDialoge();
                        Main.pStage.setScene(Main.scene);
                    }
                } else {

                    String mark = move.substring(2, 3);
                    String movePlace = move.substring(0, 2);
                    int i = Integer.parseInt(movePlace.substring(0, 1));
                    int j = Integer.parseInt(movePlace.substring(1, 2));
                    gameArray[i][j] = mark;
                    moves.add(new Move(turn, i, j, mark));
                    turn++;

                    Button pressedButton = buttonsMap.get(movePlace);
                    Label pressedLabel = labelsMap.get(movePlace);
                    if (mark.equals("O")) {
                        pressedLabel.setTextFill(Color.BLUE);
                        if(type.equals("SERVER")) {
                            turnOLabel.setText("Opponent turn");
                        }
                        else{
                            turnXLabel.setText("Your turn");
                        }
                    } else {
                        pressedLabel.setTextFill(Color.RED);
                        if(type.equals("JOIN")) {
                            turnXLabel.setText("Opponent turn");
                        }
                        else{
                            turnOLabel.setText("Your turn");
                        }
                    }
                    pressedLabel.setText(mark);
                    FadeButton(pressedButton);
                    isMyTurn = !isMyTurn;
                    checkWinner();

                    if (turn > 8) {
                        showDialog();
                        finishGame();
                    }

                }
        }

            catch(NullPointerException nE){
                System.out.println("nullException");

                nE.printStackTrace();
            } catch(IOException e){
                e.printStackTrace();
            }




    }

    void sendMove(String move){
        if(isMyTurn&&online.get()) {
            move +=character;
            ps.println(move);

        }
    }

    private void leave(){
        if(online.get()) {
            ps.println("close");
            online.set(false);
        }
    }
    void FadeButton(Button actionButton){
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(1000));
        fade.setFromValue(10);
        fade.setToValue(0);
        fade.setCycleCount(1);
        fade.setAutoReverse(false);
        fade.setNode(actionButton);
        fade.setOnFinished((event ->stopButton(actionButton)));
        fade.play();
    }
    void stopButton(Button b){
        b.setVisible(false);
    }

    void startConnecting(){
        try{
           // s = new Socket("localhost",5005);
            dis = new DataInputStream(s.getInputStream());
            ps = new PrintStream(s.getOutputStream());
            startThread();

        }
        catch (IOException e){
            e.printStackTrace();

        }
        }

    void startThread(){
        new Thread(() -> {
            while(online.get()){
                try{
                    String str = dis.readLine();
                    Platform.runLater(() -> playMove(str));
                }
                catch (IOException e){


                }
            }
        }).start();
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

        if(turn==9){
            turn ++;
        }

    }

    private void drawWinnerLine(Label startLabel, Label endLabel){

        winningLine.setStartX(startLabel.getLayoutX()+(startLabel.getHeight()/2));
        winningLine.setStartY(startLabel.getLayoutY()+(startLabel.getWidth()/2));
        winningLine.setEndX(endLabel.getLayoutX()+(endLabel.getHeight()/2));
        winningLine.setEndY(endLabel.getLayoutY()+(endLabel.getWidth()/2));
        winningLine.setStrokeWidth(5.0);
        winningLine.setStroke(Color.RED);
        System.out.println(this.getChildren());
        this.getChildren().add(winningLine);

            showDialog();



    }

    private void ShowLostConnectionDialoge(){

        LostConnectionDialoge lostConnection = new LostConnectionDialoge();
        dialogStage = new Stage();
        dialogStage.setResizable(false);
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        Scene lostConnectionScene = new Scene(lostConnection);
        dialogStage.setScene(lostConnectionScene);
        dialogStage.show();

    }

    private void showDialog(){
        finishTurn = turn;
        finishGame();
        startCelebOrLos();
        saveDialogBase saveDialog = new saveDialogBase("ONLINE",moves,this);
        dialogStage = new Stage();
        dialogStage.setResizable(false);
        Scene saveDialogScene = new Scene(saveDialog);
        dialogStage.setScene(saveDialogScene);
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.show();

    }

    private void finishGame(){
        leave();
        for(Map.Entry<String,Button> entry:buttonsMap.entrySet()){
            entry.getValue().setVisible(false);
        }

        for(int i =0;i<3;i++){
            for(int j = 0;j<3;j++){
                gameArray[i][j] = "";
            }
        }
        turn = 0;
        gameFinished = true;

    }

    private void startCelebOrLos() {
        String winnerChar = "";
        Color winnerColor;

            if (finishTurn == 9) {
                winnerColor = Color.WHITE;
                celebrationLabel.setText("DRAW");
            } else {
                if(type.equals("SERVER")) {
                    if (finishTurn % 2 == 1) {
                        winnerChar = "O";
                        winnerColor = Color.BLUE;
                        celebrationLabel.setText("WINNER");
                    } else {
                        winnerChar = "X";
                        winnerColor = Color.RED;
                        celebrationLabel.setText("LOSER");
                    }
                }
        else{
                if (finishTurn % 2 == 1) {
                    winnerChar = "O";
                    winnerColor = Color.BLUE;
                    celebrationLabel.setText("LOSER");
                } else {
                    winnerChar = "X";
                    winnerColor = Color.RED;
                    celebrationLabel.setText("WINNER");
                }
            }

            for (Label c : celArray) {
                //c.setVisible(true);

                c.setText(winnerChar);
                c.setTextFill(winnerColor);
                fadeCelebLabel(c);
            }
        }
        celebrationLabel.setTextFill(winnerColor);
        fadeFinalLabel(celebrationLabel);


}

    void fadeCelebLabel(Label targetLabel){
        targetLabel.setVisible(true);
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(1000));
        fade.setFromValue(0);
        fade.setToValue(10);
        fade.setCycleCount(1);
        fade.setAutoReverse(false);
        fade.setNode(targetLabel);
        fade.setOnFinished((event ->setRotate(targetLabel)));
        fade.play();
    }

    void fadeFinalLabel(Label targetLabel){
        targetLabel.setVisible(true);
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(3000));
        fade.setFromValue(0);
        fade.setToValue(10);
        fade.setCycleCount(1);
        fade.setAutoReverse(false);
        fade.setNode(targetLabel);
        fade.setOnFinished((event ->setRotate(targetLabel)));
        fade.play();
    }

    private void setRotate(Label c){

        RotateTransition rt = new RotateTransition(Duration.seconds(5),c);
        rt.setAutoReverse(false);
        rt.setByAngle(360);
        rt.setAxis(Rotate.X_AXIS);
        rt.setDelay(Duration.seconds(0));
        rt.setRate(3);
        rt.setCycleCount(30);
        rt.play();

    }
    }