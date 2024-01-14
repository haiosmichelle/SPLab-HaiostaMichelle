package ro.uvt.info.designpatternslab2023.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="BookTable")
public class Table extends BaseElement implements  Visitee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    @JsonCreator
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
    public void setType(String type) {

    }

    @Override
    public void add(Element a) {

    }

    @Override
    public Element get(int nr) {
        return null;
    }

    @Override
    public String getType() {
        return "table";
    }

    @Override
    public void remove(Element a) {

    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitTable(this);
    }
}
