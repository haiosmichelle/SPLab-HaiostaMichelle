package ro.uvt.info.designpatternslab2023;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Book extends Section{
    public String title;
    public List<Author> au = new ArrayList<Author>();
    public TableOfContents tb;

    public Book(String title) {
        super(title);
        this.title = title;
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
