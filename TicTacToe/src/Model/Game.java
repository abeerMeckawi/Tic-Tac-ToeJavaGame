package Model;


import java.sql.Timestamp;

public class Game {
    private int id;
    private String gameName;
    private String gameType;
    private Timestamp created;

    public Game(String gameName, Timestamp created, String gameType) {
        this.gameName = gameName;
        this.created = created;
        this.gameType = gameType;
    }

    public String toString() {
        return (this.id +" "
                +this.gameName + " "
                +this.gameType + " "
                + this.created);
    }
}
