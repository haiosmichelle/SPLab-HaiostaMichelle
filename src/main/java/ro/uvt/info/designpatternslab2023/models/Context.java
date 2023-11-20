package ro.uvt.info.designpatternslab2023.models;

public class Context {
    private int number_row;
   private int number_coll;

    public Context(int number_row, int number_coll) {
        this.number_row = number_row;
        this.number_coll = number_coll;
    }

    public void setNumber_row(int number_row) {
        this.number_row = number_row;
    }

    public void setNumber_coll(int number_coll) {
        this.number_coll = number_coll;
    }

    public int getNumber_row() {
        return number_row;
    }

    public int getNumber_coll() {
        return number_coll;
    }
}
