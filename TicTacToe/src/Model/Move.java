package Model;

public class Move {
    private int move_num;
    private int row, col;
    private String mark;

    public Move(int move_num, int row, int col, String mark) {

        this.move_num = move_num;
        this.row = row;
        this.col = col;
        this.mark = mark;
    }

    public int getMove_num() {
        return move_num;
    }

    public void setMove_num(int move_num) {
        this.move_num = move_num;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String toString() {
        return (this.move_num+" "
                + this.row+" "
                + this.col+" "
                + this.mark);
    }
}
