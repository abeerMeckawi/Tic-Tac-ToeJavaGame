package Dialogues;

import Bases.OnlineMultiPlayerBase;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import Boards.Main;
import Model.Server;

import java.util.concurrent.atomic.AtomicInteger;

public class waitingDialoge extends AnchorPane {

    protected final Label label;
    private boolean waiting = true;
    private Scene neXtScene;
    protected final Button playButton;
    private String code;



    public waitingDialoge(Scene scene,String code) {
        this.code = code;
        label = new Label();
        playButton = new Button();
        neXtScene = scene;

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(217.0);
        setPrefWidth(388.0);
        setStyle("-fx-background-color: black;");

        label.setLayoutX(14.0);
        label.setLayoutY(100.0);
        label.setTextFill(javafx.scene.paint.Color.valueOf("#e1e413"));
        label.setFont(new Font("Arial", 15));
        label.setPrefHeight(33.0);
        label.setPrefWidth(367.0);
        label.setText("Enter the following code at opponent window\nCODE: "+code);

        playButton.setLayoutX(172.0);
        playButton.setLayoutY(170.0);
        playButton.setMnemonicParsing(false);
        playButton.setStyle("-fx-background-color: #e1e413; -fx-background-radius: 20;");
        playButton.setText("Play");
        playButton.setVisible(false);
        playButton.setFont(new Font("Monaco", 13.0));
        playButton.addEventHandler(ActionEvent.ACTION, event -> {
                Main.getpStage().setScene(neXtScene);
                OnlineMultiPlayerBase.getConnectingStage().close();

        });

        getChildren().add(label);
        getChildren().add(playButton);


    }


   public void startThread(){
        AtomicInteger noOfPlayers = new AtomicInteger();
       new Thread(() -> {

            while(waiting) {
                noOfPlayers.set(Server.getPlayersNo());
                if(noOfPlayers.get() == 2){
                    waiting = false;
                    Platform.runLater(this::changeView);
                }
            }
       }).start();


    }

    void changeView(){


playButton.setVisible(true);


System.out.println("should be out");


    }
}
