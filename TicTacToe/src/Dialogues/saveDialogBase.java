package Dialogues;


import Model.DBConnection;
import Model.Move;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import Boards.*;

import java.sql.SQLException;
import java.util.ArrayList;

public  class saveDialogBase extends AnchorPane {

    protected final TextField gameName;
    protected final Label label;
    protected final Button yesButton;
    protected final Button noButton;
    protected final Button saveButton;
    private final String type;
    private ArrayList<Move>moves = new ArrayList<>();
    private BoardBase board;
    private OnlineBoardBase onlineBoard;
    private DBConnection saveGameConnection;

    public saveDialogBase(String type,ArrayList moves, BoardBase board) {
        this.board = board;
        gameName = new TextField();
        label = new Label();
        yesButton = new Button();
        noButton = new Button();
        saveButton = new Button();
        this.type = type;
        this.moves = moves;
        initialize();

    }

    public saveDialogBase(String type,ArrayList moves, OnlineBoardBase board) {
        this.onlineBoard = board;
        gameName = new TextField();
        label = new Label();
        yesButton = new Button();
        noButton = new Button();
        saveButton = new Button();
        this.type = type;
        this.moves = moves;
        initialize();

    }

    public void initialize(){

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(217.0);
        setPrefWidth(388.0);
        setStyle("-fx-background-color: black;");

        gameName.setLayoutX(114.0);
        gameName.setLayoutY(73.0);
        gameName.setVisible(false);

        label.setLayoutX(14.0);
        label.setLayoutY(14.0);
        label.setPrefHeight(33.0);
        label.setPrefWidth(367.0);
        label.setStyle("-fx-background-color: black;");
        label.setText("Do you want to save the game?");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#e1e413"));
        label.setFont(new Font("Monaco", 21.0));


        AnchorPane.setLeftAnchor(yesButton, 100.0);
        yesButton.setLayoutX(75.0);
        yesButton.setLayoutY(167.0);
        yesButton.setMnemonicParsing(false);
        yesButton.setPrefWidth(70.0);
        yesButton.setStyle("-fx-background-color: #e1e413; -fx-background-radius: 20;");
        yesButton.setText("Yes");
        yesButton.setFont(new Font("Arial",21));
        yesButton.addEventHandler(ActionEvent.ACTION,event -> {
            yesButton.setVisible(false);
            noButton.setVisible(false);
            gameName.setVisible(true);
            saveButton.setVisible(true);
            saveGameConnection = new DBConnection();
        });

        AnchorPane.setRightAnchor(noButton, 100.0);
        noButton.setLayoutX(220.0);
        noButton.setLayoutY(167.0);
        noButton.setMnemonicParsing(false);
        noButton.setPrefWidth(70.0);
        noButton.setStyle("-fx-background-color: #e1e413; -fx-background-radius: 20;");
        noButton.setText("No");
        noButton.setFont(new Font("Arial",21));
        noButton.addEventHandler(ActionEvent.ACTION,event -> {

            done();
        });

        saveButton.setLayoutX(155.0);
        saveButton.setLayoutY(122.0);
        saveButton.setPrefWidth(80);
        saveButton.setMnemonicParsing(false);
        saveButton.setStyle("-fx-background-color: #e1e413; -fx-background-radius: 20;");
        saveButton.setText("Save");
        saveButton.setFont(new Font("Arial", 21.0));
        saveButton.setVisible(false);
        saveButton.addEventHandler(ActionEvent.ACTION,event -> {
            if(!gameName.getText().equals("")) {

                saveToDataBase();
                done();
            }

        });

        getChildren().add(gameName);
        getChildren().add(label);
        getChildren().add(yesButton);
        getChildren().add(noButton);
        getChildren().add(saveButton);

    }


    private void saveToDataBase(){

        saveGameConnection.addGame(gameName.getText(),type);
        for(Move move :moves){
            try {
              saveGameConnection.setRecordMoves(move.getMove_num(), move.getRow(), move.getCol(),move.getMark());
            } catch (SQLException throwables) {
              throwables.printStackTrace();
            }
        }
    }

    private void done(){
        Main.getpStage().setScene(Main.getScene());
        if(type.equals("ONLINE")) {
            OnlineBoardBase.getDialogStage().close();
        }
        else{
            BoardBase.getSaveDialogStage().close();
        }
    }
}
