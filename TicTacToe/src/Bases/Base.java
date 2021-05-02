package Bases;


import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Base extends AnchorPane {



        protected final Circle c1;
        protected final Circle c2;
        protected final Circle c3;
        protected final ImageView imageView;
        protected final Button SPButton;
        protected final Button MPButton;
        protected final Button recordsButton;
        protected final Button exitButton;
        protected final Label titlelabel;
        private SinglePlayerBase singlePlayerRoot;
        private MultiPlayerBase multiPlayerRoot;
        private RecordsBase recordsRoot;


        public Base() throws FileNotFoundException {

            c1 = new Circle();
            c2 = new Circle();
            c3 = new Circle();
            imageView = new ImageView();
            SPButton = new Button();
            MPButton = new Button();
            recordsButton = new Button();
            exitButton = new Button();
            titlelabel = new Label();

            {
                try {
                    singlePlayerRoot = new SinglePlayerBase();
                    multiPlayerRoot = new MultiPlayerBase();
                    recordsRoot = new RecordsBase();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

            setMaxHeight(USE_PREF_SIZE);
            setMaxWidth(USE_PREF_SIZE);
            setMinHeight(USE_PREF_SIZE);
            setMinWidth(USE_PREF_SIZE);
            setPrefHeight(700.0);
            setPrefWidth(1000.0);
            setStyle("-fx-background-color: black;");

            c1.setLayoutX(501.0);
            c1.setLayoutY(342.0);
            c1.setRadius(192.0);
            c1.setStroke(javafx.scene.paint.Color.valueOf("#e1e413"));
            c1.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
            c1.setStrokeWidth(15.0);
            c1.setStyle("-fx-stroke-dash-array: 50;");

            c2.setLayoutX(501.0);
            c2.setLayoutY(342.0);
            c2.setRadius(156.0);
            c2.setStroke(javafx.scene.paint.Color.WHITE);
            c2.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
            c2.setStrokeWidth(10.0);
            c2.setStyle("-fx-stroke-dash-array: 60;");

            c3.setLayoutX(501.0);
            c3.setLayoutY(342.0);
            c3.setRadius(121.0);
            c3.setStroke(javafx.scene.paint.Color.valueOf("#d73636"));
            c3.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
            c3.setStrokeWidth(10.0);
            c3.setStyle("-fx-stroke-dash-array: 60;");

            imageView.setFitHeight(120);
            imageView.setFitWidth(120);
            imageView.setLayoutX(441);
            imageView.setLayoutY(285.0);
            imageView.setPickOnBounds(true);
            imageView.setPreserveRatio(true);
            FileInputStream input = new FileInputStream("tic-tac-toe-2.png");
            Image image = new Image(input);
            imageView.setImage(image);


            AnchorPane.setBottomAnchor(SPButton, 40.0);
            AnchorPane.setLeftAnchor(SPButton, 39.0);
            SPButton.setLayoutX(39.0);
            SPButton.setLayoutY(594.0);
            SPButton.setMnemonicParsing(false);
            SPButton.setPrefHeight(66.0);
            SPButton.setPrefWidth(213.0);
            SPButton.setStyle("-fx-background-color: #e1e413; -fx-background-radius: 20px;");
            SPButton.setText("Single Player");
            SPButton.setFont(new Font("Lucida Bright Regular", 28.0));
            SPButton.addEventHandler(ActionEvent.ACTION, event -> {

                singlePlayerRoot.translateYProperty().set(getHeight());
                getChildren().add(singlePlayerRoot);
                Timeline timeline = new Timeline();
                KeyValue kv = new KeyValue(singlePlayerRoot.translateYProperty(),0, Interpolator.EASE_IN);
                KeyFrame kf = new KeyFrame(Duration.seconds(1),kv);
                timeline.getKeyFrames().add(kf);
                timeline.play();
            });


            AnchorPane.setBottomAnchor(MPButton, 40.0);
            MPButton.setLayoutX(273.0);
            MPButton.setLayoutY(594.0);
            MPButton.setMnemonicParsing(false);
            MPButton.setPrefHeight(66.0);
            MPButton.setPrefWidth(213.0);
            MPButton.setStyle("-fx-background-color: #e1e413; -fx-background-radius: 20px;");
            MPButton.setText("Multi Player");
            MPButton.setFont(new Font("Lucida Bright Regular", 28.0));
            MPButton.addEventHandler(ActionEvent.ACTION,event -> {

                multiPlayerRoot.translateYProperty().set(getHeight());
                getChildren().add(multiPlayerRoot);
                Timeline timeline = new Timeline();
                KeyValue kv = new KeyValue(multiPlayerRoot.translateYProperty(),0, Interpolator.EASE_IN);
                KeyFrame kf = new KeyFrame(Duration.seconds(1),kv);
                timeline.getKeyFrames().add(kf);
                timeline.play();
            });


            AnchorPane.setBottomAnchor(recordsButton, 40.0);
            recordsButton.setLayoutX(516.0);
            recordsButton.setLayoutY(594.0);
            recordsButton.setMnemonicParsing(false);
            recordsButton.setPrefHeight(66.0);
            recordsButton.setPrefWidth(213.0);
            recordsButton.setStyle("-fx-background-color: #e1e413; -fx-background-radius: 20px;");
            recordsButton.setText("Records");
            recordsButton.setFont(new Font("Lucida Bright Regular", 28.0));

            recordsButton.addEventHandler(ActionEvent.ACTION,event -> {
                RecordsBase.update();
                recordsRoot.translateXProperty().set(getWidth());
                getChildren().add(recordsRoot);
                Timeline timeline = new Timeline();
                KeyValue kv = new KeyValue(recordsRoot.translateXProperty(),0, Interpolator.EASE_IN);
                KeyFrame kf = new KeyFrame(Duration.seconds(1),kv);
                timeline.getKeyFrames().add(kf);
                timeline.play();
            });

            AnchorPane.setBottomAnchor(exitButton, 40.0);
            AnchorPane.setRightAnchor(exitButton, 39.0);
            exitButton.setLayoutX(635.0);
            exitButton.setLayoutY(613.0);
            exitButton.setMnemonicParsing(false);
            exitButton.setPrefHeight(66.0);
            exitButton.setPrefWidth(213.0);
            exitButton.setStyle("-fx-background-color: #e1e413; -fx-background-radius: 20px;");
            exitButton.setText("Exit");
            exitButton.setFont(new Font("Lucida Bright Regular", 28.0));
            exitButton.addEventHandler(ActionEvent.ACTION,event -> {

                System.exit(0);
            });

            titlelabel.setLayoutX(370.0);
            titlelabel.setLayoutY(22.0);
            titlelabel.setPrefHeight(75.0);
            titlelabel.setPrefWidth(379.0);
            titlelabel.setText("tic tac toe");
            titlelabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
            titlelabel.setTextFill(javafx.scene.paint.Color.valueOf("#fcfafa"));
            titlelabel.setFont(new Font("Arial Regular", 64.0));

            getChildren().add(c1);
            getChildren().add(c2);
            getChildren().add(c3);
            getChildren().add(imageView);
            getChildren().add(SPButton);
            getChildren().add(MPButton);
            getChildren().add(recordsButton);
            getChildren().add(exitButton);
            getChildren().add(titlelabel);
            play();

        }

    private void play(){
        setRotate(c1,true,360,12);
        setRotate(c2,true,180,18);
        setRotate(c3,true,145,24);

    }



    private void setRotate(Circle c, boolean reverse, int angle, int duration ){

        RotateTransition rt = new RotateTransition(Duration.seconds(duration),c);
        rt.setAutoReverse(reverse);
        rt.setByAngle(angle);
        rt.setDelay(Duration.seconds(0));
        rt.setRate(3);
        rt.setCycleCount(30);
        rt.play();

    }
    }


