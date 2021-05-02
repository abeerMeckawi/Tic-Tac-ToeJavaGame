package Model;

import javafx.beans.property.SimpleStringProperty;

import java.sql.Timestamp;

public class Record {
    private SimpleStringProperty id;
    private SimpleStringProperty gameName;
    private SimpleStringProperty gameDate;
    private String type;




    public Record(int id, String gameName, Timestamp gameDate, String type) {
        this.id = new SimpleStringProperty(Integer.toString(id));
        this.gameName = new SimpleStringProperty(gameName);
        //DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        //String formattedDateTime = gameDate.format(formatter);
        this.gameDate = new SimpleStringProperty(gameDate.toString());
        this.type = type;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getGameName() {
        return gameName.get();
    }

    public SimpleStringProperty gameNameProperty() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName.set(gameName);
    }

    public String getGameDate() {
        return gameDate.get();
    }

    public SimpleStringProperty gameDateProperty() {
        return gameDate;
    }

    public void setGameDate(String gameDate) {
        this.gameDate.set(gameDate);
    }
}
