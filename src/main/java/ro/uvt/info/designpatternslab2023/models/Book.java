package ro.uvt.info.designpatternslab2023.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Book extends Section implements Visitee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="title")
    public String title;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", au=" + au +
                '}';
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    public List<Author> au = new ArrayList<Author>();



    public Book(String title) {
        super(title);
        this.title = title;
    }
    @Override
    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

    public List<Author> getAu() {
        return au;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAu(List<Author> au) {
        this.au = au;
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

    @Override
    public String getType() {
        return null;
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
