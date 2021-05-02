package Bases;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import Boards.BoardBase;
import Boards.Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public  class SinglePlayerBase extends AnchorPane {

    protected final Button Hardb;
    protected final Button Backb;
    protected final Button Easyb;
    protected final Text SinglePlayertext;
    protected final Button Mediumb;
    protected final ImageView UserImage;
    protected final ImageView computerImage;
    protected final Label userLabel;
    protected final Label computerLabel;

    private BoardBase boardBaseRoot;

    public SinglePlayerBase() throws FileNotFoundException {

        Hardb = new Button();
        Backb = new Button();
        Easyb = new Button();
        SinglePlayertext = new Text();
        Mediumb = new Button();
        UserImage = new ImageView();
        computerImage = new ImageView();
        userLabel = new Label();
        computerLabel = new Label();


        setId("AnchorPane");
        setPrefHeight(700.0);
        setPrefWidth(1000.0);
        setStyle("-fx-background-color: Black;");

        Hardb.setLayoutX(390.0);
        Hardb.setLayoutY(406.0);
        Hardb.setMnemonicParsing(false);
        Hardb.setPrefHeight(66.0);
        Hardb.setPrefWidth(213.0);
        Hardb.setStyle("-fx-background-radius: 20px; -fx-background-color: #e1e413;");
        Hardb.setText("Hard");
        Hardb.setFont(new Font("Lucida Bright Regular", 28.0));
        Hardb.setPadding(new Insets(8.0, 0.0, 8.0, 0.0));
        Hardb.addEventHandler(ActionEvent.ACTION,event -> {
            try {
                boardBaseRoot = new BoardBase("Single",'H');
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Scene boardScene = new Scene(boardBaseRoot);
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

        Easyb.setLayoutX(390.0);
        Easyb.setLayoutY(206.0);
        Easyb.setMnemonicParsing(false);
        Easyb.setPrefHeight(66.0);
        Easyb.setPrefWidth(213.0);
        Easyb.setStyle("-fx-background-radius: 20px; -fx-background-color: #e1e413;");
        Easyb.setText("Easy");
        Easyb.setFont(new Font("Lucida Bright Regular", 28.0));
        Easyb.setPadding(new Insets(8.0, 0.0, 8.0, 0.0));
        Easyb.addEventHandler(ActionEvent.ACTION,event -> {try {
            boardBaseRoot = new BoardBase("Single",'E');
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
            Scene boardScene = new Scene(boardBaseRoot);
            Main.getpStage().setScene(boardScene);

        });

        AnchorPane.setTopAnchor(SinglePlayertext, 88.0);
        SinglePlayertext.setFill(javafx.scene.paint.Color.WHITE);
        SinglePlayertext.setLayoutX(261.0);
        SinglePlayertext.setLayoutY(124.0);
        SinglePlayertext.setStrokeWidth(0.0);
        SinglePlayertext.setText("Single Player");
        SinglePlayertext.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        SinglePlayertext.setWrappingWidth(478.0);
        SinglePlayertext.setFont(new Font("Lucida Bright Regular", 48.0));


        Mediumb.setLayoutX(390.0);
        Mediumb.setLayoutY(306.0);
        Mediumb.setMnemonicParsing(false);
        Mediumb.setPrefHeight(66.0);
        Mediumb.setPrefWidth(213.0);
        Mediumb.setStyle("-fx-background-radius: 20px; -fx-background-color: #e1e413;");
        Mediumb.setText("Medium");
        Mediumb.setFont(new Font("Lucida Bright Regular", 28.0));
        Mediumb.setPadding(new Insets(8.0, 0.0, 8.0, 0.0));

        Mediumb.addEventHandler(ActionEvent.ACTION,event -> {
            try {
                boardBaseRoot = new BoardBase("Single",'M');
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Scene boardScene = new Scene(boardBaseRoot);
            Main.getpStage().setScene(boardScene);
        });

        AnchorPane.setRightAnchor(UserImage, 100.0);
        AnchorPane.setTopAnchor(UserImage, 60.0);
        UserImage.setFitHeight(100.0);
        UserImage.setFitWidth(100.0);
        UserImage.setLayoutX(751.0);
        UserImage.setLayoutY(65.0);
        UserImage.setPickOnBounds(true);
        UserImage.setPreserveRatio(true);
        FileInputStream input = new FileInputStream("man.png");
        Image image = new Image(input);
        UserImage.setImage(image);


        computerImage.setFitHeight(100.0);
        computerImage.setFitWidth(100.0);
        computerImage.setLayoutX(100.0);
        computerImage.setLayoutY(60.0);
        computerImage.setPickOnBounds(true);
        computerImage.setPreserveRatio(true);
        //computerImage.setImage(new Image(getClass().getResource("../../../../Downloads/robot-2.png").toExternalForm()));
        FileInputStream robotImageinput = new FileInputStream("robot-2.png");
        Image robotImage = new Image(robotImageinput);
        computerImage.setImage(robotImage);

        AnchorPane.setRightAnchor(userLabel, 130.0);
        AnchorPane.setTopAnchor(userLabel, 196.0);
        userLabel.setLayoutX(870.0);
        userLabel.setLayoutY(196.0);
        userLabel.setPrefHeight(60.0);
        userLabel.setPrefWidth(43.0);
        userLabel.setText("O");
        userLabel.setTextFill(javafx.scene.paint.Color.valueOf("#0047fff2"));
        userLabel.setFont(new Font("Lucida Bright Regular", 50.0));


        AnchorPane.setLeftAnchor(computerLabel, 130.0);
        AnchorPane.setTopAnchor(computerLabel, 196.0);
        computerLabel.setLayoutX(130.0);
        computerLabel.setLayoutY(198.0);
        computerLabel.setPrefHeight(60.0);
        computerLabel.setPrefWidth(43.0);
        computerLabel.setText("X");
        computerLabel.setTextFill(javafx.scene.paint.Color.RED);
        computerLabel.setFont(new Font("Lucida Bright Regular", 50.0));

        getChildren().add(Hardb);
        getChildren().add(Backb);
        getChildren().add(Easyb);
        getChildren().add(SinglePlayertext);
        getChildren().add(Mediumb);
        getChildren().add(UserImage);
        getChildren().add(computerImage);
        getChildren().add(userLabel);
        getChildren().add(computerLabel);

    }
}
