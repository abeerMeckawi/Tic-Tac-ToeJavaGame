package Bases;

import Dialogues.NoRoomDialoge;
import Dialogues.waitingDialoge;


import Model.Server;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import Boards.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class OnlineMultiPlayerBase extends AnchorPane {

    public static Stage getConnectingStage() {
        return connectingStage;
    }

    static Stage connectingStage;
    private Scene onlineBoardScene;

    protected final Button createGameButton;
    protected final Button joinGameButton;
    protected final TextField gameIpField;
    protected final Button joinButton;
    protected final Button backButton;
    protected final Text Multiplayertext;
    protected final ImageView player1ImageView;
    protected final ImageView player2ImageView;
    protected final Label computerLabel;
    protected final Label userLabel;
    static Server sv;

    private OnlineBoardBase onlineboard;

    public OnlineMultiPlayerBase(){
        createGameButton = new Button();
        joinButton = new Button();
        joinGameButton = new Button();
        gameIpField = new TextField();
        backButton = new Button();
        Multiplayertext = new Text();
        player1ImageView = new ImageView();
        player2ImageView = new ImageView();
        computerLabel = new Label();
        userLabel = new Label();



        setId("AnchorPane");
        setPrefHeight(700.0);
        setPrefWidth(1000.0);
        setStyle("-fx-background-color: Black;");

        AnchorPane.setTopAnchor(Multiplayertext, 88.0);
        Multiplayertext.setFill(javafx.scene.paint.Color.WHITE);
        Multiplayertext.setLayoutX(261.0);
        Multiplayertext.setLayoutY(124.0);
        Multiplayertext.setStrokeWidth(0.0);
        Multiplayertext.setText("MultiPlayer");
        Multiplayertext.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        Multiplayertext.setWrappingWidth(478.0);
        Multiplayertext.setFont(new Font("Lucida Bright Regular", 48.0));


        AnchorPane.setLeftAnchor(computerLabel, 120.0);
        AnchorPane.setTopAnchor(computerLabel, 196.0);
        computerLabel.setLayoutX(118.0);
        computerLabel.setLayoutY(198.0);
        computerLabel.setPrefHeight(60.0);
        computerLabel.setPrefWidth(43.0);
        computerLabel.setText("X");
        computerLabel.setTextFill(javafx.scene.paint.Color.RED);
        computerLabel.setFont(new Font("Lucida Bright Regular", 50.0));


        AnchorPane.setRightAnchor(userLabel, 120.0);
        AnchorPane.setTopAnchor(userLabel, 196.0);
        userLabel.setLayoutX(839.0);
        userLabel.setLayoutY(196.0);
        userLabel.setPrefHeight(60.0);
        userLabel.setPrefWidth(43.0);
        userLabel.setText("O");
        userLabel.setTextFill(javafx.scene.paint.Color.valueOf("#0047fff2"));
        userLabel.setFont(new Font("Lucida Bright Regular", 50.0));


        player1ImageView.setFitHeight(100.0);
        player1ImageView.setFitWidth(100.0);
        player1ImageView.setLayoutX(100.0);
        player1ImageView.setLayoutY(60.0);
        player1ImageView.setPickOnBounds(true);
        player1ImageView.setPreserveRatio(true);

        FileInputStream input = null;
        try {
            input = new FileInputStream("man.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert input != null;
        Image image = new Image(input);
        player1ImageView.setImage(image);

        AnchorPane.setRightAnchor(player2ImageView, 100.0);
        AnchorPane.setTopAnchor(player2ImageView, 60.0);
        player2ImageView.setFitHeight(100.0);
        player2ImageView.setFitWidth(100.0);
        player2ImageView.setLayoutX(751.0);
        player2ImageView.setLayoutY(65.0);
        player2ImageView.setPickOnBounds(true);
        player2ImageView.setPreserveRatio(true);
        FileInputStream input2 = null;
        try {
            input2 = new FileInputStream("man.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert input2 != null;
        Image image2 = new Image(input2);
        player2ImageView.setImage(image2);


        joinGameButton.setLayoutX(390.0);
        joinGameButton.setLayoutY(306.0);
        joinGameButton.setMnemonicParsing(false);
        joinGameButton.setPrefHeight(66.0);
        joinGameButton.setPrefWidth(213.0);
        joinGameButton.setStyle("-fx-background-radius: 20px; -fx-background-color: #e1e413;");
        joinGameButton.setText("Join Game");
        joinGameButton.setFont(new Font("Lucida Bright Regular", 28.0));
        joinGameButton.setPadding(new Insets(8.0, 0.0, 8.0, 0.0));
        joinGameButton.addEventHandler(ActionEvent.ACTION,event -> {
            createGameButton.setVisible(false);
            joinButton.setVisible(true);
            gameIpField.setVisible(true);
            joinGameButton.setVisible(false);
        });



        backButton.setLayoutX(390.0);
        backButton.setLayoutY(569.0);
        backButton.setMnemonicParsing(false);
        backButton.setPrefHeight(66.0);
        backButton.setPrefWidth(213.0);
        backButton.setStyle("-fx-background-radius: 20px; -fx-background-color: #e1e413;");
        backButton.setText("Back");
        backButton.setFont(new Font("Lucida Bright Regular", 28.0));
        backButton.setPadding(new Insets(8.0, 0.0, 8.0, 0.0));
        backButton.addEventHandler(ActionEvent.ACTION, event -> Main.getpStage().setScene(Main.getScene()));


        createGameButton.setLayoutX(390.0);
        createGameButton.setLayoutY(206.0);
        createGameButton.setMnemonicParsing(false);
        createGameButton.setPrefHeight(66.0);
        createGameButton.setPrefWidth(213.0);
        createGameButton.setStyle("-fx-background-radius: 20px; -fx-background-color: #e1e413;");
        createGameButton.setText("Create Game");
        createGameButton.setFont(new Font("Lucida Bright Regular", 28.0));
        createGameButton.setPadding(new Insets(8.0, 0.0, 8.0, 0.0));
        createGameButton.addEventHandler(ActionEvent.ACTION,event -> {
            try {
                sv = new Server();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
           Socket s = sv.getMySocket();


            try {
                onlineboard = new OnlineBoardBase("SERVER",s);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            onlineBoardScene = new Scene(onlineboard);
                checkIfConnected();

        });


        gameIpField.setLayoutX(274.0);
        gameIpField.setLayoutY(306.0);
        gameIpField.setPrefHeight(66.0);
        gameIpField.setPrefWidth(213.0);
        gameIpField.setVisible(false);
        gameIpField.setPromptText("Enter game Name");


        joinButton.setLayoutX(560.0);
        joinButton.setLayoutY(306.0);
        joinButton.setMnemonicParsing(false);
        joinButton.setPrefHeight(66.0);
        joinButton.setPrefWidth(213.0);
        joinButton.setStyle("-fx-background-radius: 20px; -fx-background-color: #e1e413;");
        joinButton.setText("Join");
        joinButton.setFont(new Font("Lucida Bright Regular", 28.0));
        joinButton.setPadding(new Insets(8.0, 0.0, 8.0, 0.0));
        joinButton.setVisible(false);
        joinButton.addEventHandler(ActionEvent.ACTION,event -> {
            Socket s = null;
            try {

                if(!gameIpField.getText().equals("")){
                    String ip = gameIpField.getText();

                    s = new Socket(ip,5005);
                    //s.setSoTimeout(2000);
                    System.out.println(s);

                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
                gameIpField.setText("WRONG IP ADRESS");
            } catch (IOException e) {
                e.printStackTrace();

            }
            if (s != null) {
                try {
                    onlineboard = new OnlineBoardBase("JOIN",s);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                onlineBoardScene = new Scene(onlineboard);
                Main.getpStage().setScene(onlineBoardScene);
            }
            else{

                NoRoomDialoge nrDialoge = new NoRoomDialoge();
                Scene nrScene = new Scene(nrDialoge);
                connectingStage = new Stage();
                connectingStage.setResizable(false);
                connectingStage.setScene(nrScene);
                connectingStage.show();

            }


        });


        getChildren().add(createGameButton);
        getChildren().add(joinGameButton);
        getChildren().add(backButton);
        getChildren().add(Multiplayertext);
        getChildren().add(player1ImageView);
        getChildren().add(player2ImageView);
        getChildren().add(gameIpField);
        getChildren().add(joinButton);

    }

    public static Server getSv() {
        return sv;
    }

    public static void setSv(Server sv) {
        OnlineMultiPlayerBase.sv = sv;
    }

    private void checkIfConnected(){
        waitingDialoge wd = new waitingDialoge(onlineBoardScene,sv.getIpAdress());
        connectingStage = new Stage();
        connectingStage.setResizable(false);
        Scene connectingScene = new Scene(wd);
        connectingStage.setScene(connectingScene);
        connectingStage.initModality(Modality.APPLICATION_MODAL);
        connectingStage.setOnShowing(event -> wd.startThread());
        //connectingStage.setOnCloseRequest(event -> Main.pStage.setScene(onlineBoardScene));
        connectingStage.show();


    }
}
