package Bases;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import Boards.BoardBase;
import Boards.Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MultiPlayerBase extends AnchorPane {

    protected final Button Onlineb;
    protected final Button Backb;
    protected final Text Multiplayertext;
    protected final Button Offlineb;
    protected final ImageView player1ImageView;
    protected final ImageView player2ImageView;
    private BoardBase boardBaseRoot;
    private OnlineMultiPlayerBase OnlineMenuRoot;

    public MultiPlayerBase() throws FileNotFoundException {

        Onlineb = new Button();
        Backb = new Button();
        Offlineb = new Button();
        Multiplayertext = new Text();
        player1ImageView = new ImageView();
        player2ImageView = new ImageView();


        setId("AnchorPane");
        setPrefHeight(700.0);
        setPrefWidth(1000.0);
        setStyle("-fx-background-color: Black;");

        Onlineb.setLayoutX(390.0);
        Onlineb.setLayoutY(323.0);
        Onlineb.setMnemonicParsing(false);
        Onlineb.setPrefHeight(66.0);
        Onlineb.setPrefWidth(213.0);
        Onlineb.setStyle("-fx-background-radius: 20px; -fx-background-color: #e1e413;");
        Onlineb.setText("Online");
        Onlineb.setFont(new Font("Lucida Bright Regular", 28.0));
        Onlineb.setPadding(new Insets(8.0, 0.0, 8.0, 0.0));
        Onlineb.addEventHandler(ActionEvent.ACTION,event ->  {
            OnlineMenuRoot = new OnlineMultiPlayerBase();
            Scene boardScene = new Scene(OnlineMenuRoot);
                    Main.getpStage().setScene(boardScene);
                });

        Backb.setLayoutX(390.0);
        Backb.setLayoutY(569.0);
        Backb.setMnemonicParsing(false);
        Backb.setPrefHeight(66.0);
        Backb.setPrefWidth(213.0);
        Backb.setStyle("-fx-background-radius: 20px; -fx-background-color: #e1e413;");
        Backb.setText("Back");
        Backb.setFont(new Font("Lucida Bright Regular", 28.0));
        Backb.setPadding(new Insets(8.0, 0.0, 8.0, 0.0));
        Backb.addEventHandler(ActionEvent.ACTION, event -> Main.getRoot().getChildren().remove(this));

        AnchorPane.setTopAnchor(Multiplayertext, 88.0);
        Multiplayertext.setFill(javafx.scene.paint.Color.WHITE);
        Multiplayertext.setLayoutX(261.0);
        Multiplayertext.setLayoutY(124.0);
        Multiplayertext.setStrokeWidth(0.0);
        Multiplayertext.setText("Multiplayer ");
        Multiplayertext.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        Multiplayertext.setWrappingWidth(478.0);
        Multiplayertext.setFont(new Font("Lucida Bright Regular", 48.0));

        Offlineb.setLayoutX(390.0);
        Offlineb.setLayoutY(213.0);
        Offlineb.setMnemonicParsing(false);
        Offlineb.setPrefHeight(66.0);
        Offlineb.setPrefWidth(213.0);
        Offlineb.setStyle("-fx-background-radius: 20px; -fx-background-color: #e1e413;");
        Offlineb.setText("Offline");
        Offlineb.setFont(new Font("Lucida Bright Regular", 28.0));
        Offlineb.setPadding(new Insets(8.0, 0.0, 8.0, 0.0));
        Offlineb.addEventHandler(ActionEvent.ACTION,event ->  {
            try {
                boardBaseRoot = new BoardBase("Multi",'F');
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Scene boardScene = new Scene(boardBaseRoot);
            Main.getpStage().setScene(boardScene);
        });

        AnchorPane.setRightAnchor(player1ImageView, 100.0);
        AnchorPane.setTopAnchor(player1ImageView, 60.0);
        player1ImageView.setFitHeight(100.0);
        player1ImageView.setFitWidth(100.0);
        player1ImageView.setLayoutX(751.0);
        player1ImageView.setLayoutY(65.0);
        player1ImageView.setPickOnBounds(true);
        player1ImageView.setPreserveRatio(true);
        //player1ImageView.setImage(new Image(getClass().getResource("WhatsApp%20Image%202021-01-03%20at%2011.27.43%20PM.jpeg").toExternalForm()));
        FileInputStream input = new FileInputStream("man.png");
        Image image = new Image(input);
        player1ImageView.setImage(image);

        player2ImageView.setFitHeight(100.0);
        player2ImageView.setFitWidth(100.0);
        player2ImageView.setLayoutX(100.0);
        player2ImageView.setLayoutY(60.0);
        player2ImageView.setPickOnBounds(true);
        player2ImageView.setPreserveRatio(true);
        //player2ImageView.setImage(new Image(getClass().getResource("WhatsApp%20Image%202021-01-03%20at%2011.27.43%20PM.jpeg").toExternalForm()));
        FileInputStream input2 = new FileInputStream("man.png");
        Image image2 = new Image(input2);
        player2ImageView.setImage(image2);

        getChildren().add(Onlineb);
        getChildren().add(Backb);
        getChildren().add(Multiplayertext);
        getChildren().add(Offlineb);
        getChildren().add(player1ImageView);
        getChildren().add(player2ImageView);

    }
}
