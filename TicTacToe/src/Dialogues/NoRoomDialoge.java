package Dialogues;

import Bases.OnlineMultiPlayerBase;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class NoRoomDialoge extends AnchorPane{


        protected final Label label;
        protected final Button okButton;



        public NoRoomDialoge() {

            label = new Label();
            okButton = new Button();


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
            label.setFont(new Font("Monaco", 21.0));
            label.setPrefHeight(33.0);
            label.setPrefWidth(367.0);
            label.setText("Check the room ip you entered");

            okButton.setLayoutX(172.0);
            okButton.setLayoutY(170.0);
            okButton.setMnemonicParsing(false);
            okButton.setStyle("-fx-background-color: #e1e413; -fx-background-radius: 20;");
            okButton.setText("OK");

            okButton.setFont(new Font("Monaco", 13.0));
            okButton.addEventHandler(ActionEvent.ACTION, event -> {

                OnlineMultiPlayerBase.getConnectingStage().close();

            });

            getChildren().add(label);
            getChildren().add(okButton);


        }





}
