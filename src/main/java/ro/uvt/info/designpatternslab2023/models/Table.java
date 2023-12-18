package ro.uvt.info.designpatternslab2023.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Table extends BaseElement implements Visitee {
    @Id
    int id;
    public String title;

    public Table(String title) {
        this.title = title;
    }

    public Table() {
        this.title = "";
    }

    public void print() {
        System.out.println("Table with name : " + title);
    }

    @Override
    public void add(Element a) {

    }

    @Override
    public Element get(int nr) {
        return null;
    }

    @Override
    public void remove(Element a) {

    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitTable(this);
    }
}
