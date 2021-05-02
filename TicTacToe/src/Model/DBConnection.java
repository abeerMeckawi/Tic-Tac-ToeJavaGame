package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author kokym
 */
public class DBConnection {

    private Statement stmt;
    private String query;
    private Connection con;

    public DBConnection() {
        //add Database connection
        try {
            //DriverManager.registerDriver(new Driver());
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictactoe", "root", "root");
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    //executeUpdate Function
    private int dbUpdate(String query) {
        int ret = -1;
        try {
            ret = stmt.executeUpdate(query);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ret;
    }

    // add New Game
    public void addGame(String gameName, String gameType) {

        Date today = new Date();
        java.sql.Timestamp startDate = new java.sql.Timestamp(today.getTime());
        String query = "insert into game (game_name,created,game_type) values('" + gameName + "','" + startDate + "','" + gameType + "')";
        dbUpdate(query);


    }

    //to remove game
    void removeGame(int gameId) {

        query = "delete from game"
                + " where id = " + gameId + " ";
        dbUpdate(query);
    }

    //get game details by id
    ArrayList<Game> retriveGame(int idGame) {

        ResultSet rs;
        Game game;
        ArrayList<Game> gamesArray = new ArrayList<>();
        query = "select * from game"
                + " where id = " + idGame + " ";

        try {
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                //game = new Game(rs.getInt("id"), rs.getString("game_name"), rs.getTimestamp("created"));
                String gameName = rs.getString("game_name");
                Timestamp gameDate = rs.getTimestamp("created");
                String type = rs.getString("game_type");


                game = new Game(gameName,gameDate,type);

                gamesArray.add(game);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return gamesArray;

    }

    //get the lastId in table game
    int getLastGame() {
        int id = 0;
        ResultSet rs;
        query = "select MAX(id) from game";

        try {
            rs = stmt.executeQuery(query);
            rs.next();
            id = rs.getInt("max(id)");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    }

    //get the game Type
    String getGameType(int gameId) {
        String gameType = " ";
        ResultSet rs;
        query = "select game_type from game"
                + " where id = " + gameId + " ";

        try {
            rs = stmt.executeQuery(query);
            rs.next();
            gameType = rs.getString("game_type");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return gameType;
    }

    //record the moves
    public void setRecordMoves(int moveNum, int row, int col, String mark) throws SQLException {
        //char[] myMark = mark.toCharArray();
        int gameId = getLastGame();
        query = "insert into move (gameId,move_num,move.row,col,mark) values('" + gameId + "','" + moveNum + "','" + row + "','" + col + "','" + mark + "')";
//        query = "insert into move (gameId,move_num,row,col,mark)"+"values(?,?,?,?,?)";
//
//        PreparedStatement preparedStmt = con.prepareStatement(query);
//        preparedStmt.setInt(1,gameId);
//        preparedStmt.setInt(2,moveNum);
//        preparedStmt.setInt(3,row);
//        preparedStmt.setInt(4,col);
//        preparedStmt.setString(5,mark);
        dbUpdate(query);
    }

    //to remove records of the game
    void removeRecordMoves(int gameId) {

        query = "delete from move"
                + " where gameId = " + gameId + " ";
        dbUpdate(query);
    }

public ArrayList<Record> getAllGames(){
        ArrayList<Record> games = new ArrayList<>();
        query = "SELECT * FROM game";
        ResultSet rs;
        Record game;

    try {
        rs = stmt.executeQuery(query);
        while (rs.next()) {
            //game = new Game(rs.getInt("id"), rs.getString("game_name"), rs.getTimestamp("created"));
            String gameName = rs.getString("game_name");
            Timestamp gameDate = rs.getTimestamp("created");
            int id = rs.getInt("id");
            String type = rs.getString("game_type");


            game = new Record(id,gameName,gameDate,type);

            games.add(game);
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return games;



}
    //get moves was recorded
    public ArrayList<Move> getRecordMoves(int idGame) {
        ResultSet rs;
        Move move;
        ArrayList<Move> movesArray = new ArrayList<>();
        query = "select * from move"
                + " where gameId = " + idGame + " ";

        try {
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                move = new Move(rs.getInt("move_num"), rs.getInt("row"), rs.getInt("col"), rs.getString("mark"));

                movesArray.add(move);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return movesArray;
    }
/*
    public static void main(String[] args) {
        DBConnection db = new DBConnection();
        //db.addGame("game2","single");
        //System.out.println(db.getGameType(3));
        //db.recordMoves(3,0,1,'O');
        // ArrayList<Move> recordMoves = db.getRecordMoves(1);
        //ArrayList<Game> games = db.retriveGame(2);
        //for (Game game : games) {
       //     System.out.println(game);
       // }
        //  for (Move recordMove: recordMoves) {
        //    System.out.println(recordMove);
        //}

       // db.removeRecordMoves(1);
      // db.removeGame(1);

    }*/
}

