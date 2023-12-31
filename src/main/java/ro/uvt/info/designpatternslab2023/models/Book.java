package ro.uvt.info.designpatternslab2023.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Book extends Section implements Visitee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    public String title;
    @ManyToMany
    public List<Author> au = new ArrayList<Author>();
    @JsonCreator

    public Book(String title) {
        super(title);
        this.title = title;
    }

    public Book() {

    }

    public void print() {
        System.out.println("Book: " + title);
        System.out.println();
        System.out.println("Authors:");
        for (Author a : au) {
            a.print();
        }

        System.out.println();
        for (Element et : el) {
            et.print();
        }
    }

    public void addAuthor(Author nume) {
        au.add(nume);
    }

    public void addContent(Element a) {
        el.add(a);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitBook(this);
        for(Element element : el)
        {
            element.accept(visitor);
        }
        //visitor.saveToJson("book_data.json");
    }
//    public int createChapter(String nume)
//    { Chapter a = new Chapter();
//        a.name=nume;
//        ch.add(a);
//        return ch.indexOf(a);
//    }
//    public Chapter getChapter(int nr)
//    {
//        return ch.get(nr);
//    }
}
