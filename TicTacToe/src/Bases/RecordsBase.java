package Bases;

import Model.DBConnection;
import Model.Move;
import Model.Record;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import Boards.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class RecordsBase extends AnchorPane {

    protected final TableView <Record>tableView ;
    protected final TableColumn idColumn;
    protected final TableColumn <Record,String>nameColumn;
    protected final TableColumn<Record,String> dateColumn;
    protected final Button backButton;
    protected final Button ReplayButton;
    private static DBConnection recordsConnection;
    private static ObservableList<Record> records;
    private Scene recordScene;
    private ReplyBoardBase replayBoard;
    private static ArrayList<Record> games;

    public RecordsBase() {
        records = FXCollections.observableArrayList();

        tableView = new TableView<>();
        idColumn = new TableColumn();
        nameColumn = new TableColumn();
        dateColumn = new TableColumn();
        backButton = new Button();
        ReplayButton = new Button();
        recordsConnection = new DBConnection();
        getAllGames();

        setPrefHeight(700.0);
        setPrefWidth(1000.0);
        setStyle("-fx-background-color: black;");


        AnchorPane.setLeftAnchor(tableView, 8.0);
        AnchorPane.setRightAnchor(tableView, 8.0);
        AnchorPane.setTopAnchor(tableView, 8.0);
        tableView.setMaxHeight(USE_PREF_SIZE);
        tableView.setMaxWidth(USE_PREF_SIZE);
        tableView.setMinHeight(USE_PREF_SIZE);
        tableView.setMinWidth(USE_PREF_SIZE);
        tableView.setPrefHeight(600.0);
        tableView.setPrefWidth(985.0);
        tableView.setStyle("-fx-background-color: black;");


        idColumn.setEditable(false);
        idColumn.setPrefWidth(328.0);
        idColumn.setStyle("-fx-background-color: Grey;");
        idColumn.setText("Game No.");
        idColumn.setCellValueFactory(new PropertyValueFactory<Record,String>("id"));


        nameColumn.setPrefWidth(328.0);
        nameColumn.setStyle("-fx-background-color: Grey;");
        nameColumn.setText("Game Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("gameName"));


        dateColumn.setPrefWidth(328.0);
        dateColumn.setStyle("-fx-background-color: Grey;");
        dateColumn.setText("Game Date");
        dateColumn.setEditable(true);
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("gameDate"));


        AnchorPane.setBottomAnchor(backButton, 8.0);
        AnchorPane.setLeftAnchor(backButton, 40.0);
        backButton.setLayoutX(28.0);
        backButton.setLayoutY(436.0);
        backButton.setMnemonicParsing(false);
        backButton.setPrefHeight(66.0);
        backButton.setPrefWidth(213.0);
        backButton.setStyle("-fx-background-color: #e1e413; -fx-background-radius: 20px;");
        backButton.setText("Back");
        backButton.setPadding(new Insets(8.0));
        backButton.setFont(new Font("Lucida Bright Regular", 28.0));
        backButton.addEventHandler(ActionEvent.ACTION, event -> Main.getRoot().getChildren().remove(this));

        AnchorPane.setBottomAnchor(ReplayButton, 8.0);
        AnchorPane.setRightAnchor(ReplayButton, 40.0);
        ReplayButton.setLayoutX(448.0);
        ReplayButton.setLayoutY(436.0);
        ReplayButton.setMnemonicParsing(false);
        ReplayButton.setPrefHeight(66.0);
        ReplayButton.setPrefWidth(213.0);
        ReplayButton.setStyle("-fx-background-color: #e1e413; -fx-background-radius: 20px;");
        ReplayButton.setText("Replay");
        ReplayButton.setPadding(new Insets(8.0));
        ReplayButton.setFont(new Font("Lucida Bright Regular", 28.0));
        ReplayButton.addEventHandler(ActionEvent.ACTION,event -> {
            try {
                replay();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });


        tableView.setItems(records);
        //tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tableView.getColumns().addAll(idColumn,nameColumn,dateColumn);
        System.out.println(tableView.getColumns().size());

        getChildren().add(tableView);
        getChildren().add(backButton);
        getChildren().add(ReplayButton);



    }

    private void getAllGames(){

        games = recordsConnection.getAllGames();
        records.addAll(games);
    }

    private void replay() throws FileNotFoundException {
        Record selected = tableView.getSelectionModel().getSelectedItem();
        ArrayList<Move>gameMoves = recordsConnection.getRecordMoves(Integer.parseInt(selected.getId()));
        replayBoard = new ReplyBoardBase(gameMoves,selected.getType());
        recordScene = new Scene(replayBoard);
        Main.getpStage().setScene(recordScene);
    }

    public static void update(){

        games = recordsConnection.getAllGames();
        records.addAll(games);
    }
}
