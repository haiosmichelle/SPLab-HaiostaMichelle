package ro.uvt.info.designpatternslab2023;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Book {
    public String title;
    public List<Chapter> ch= new ArrayList<Chapter>();
    public List<Author> au = new ArrayList<Author>();
   public TableOfContents tb;


    public Book(List<Author> au) {
        this.au = au;
    }
    public Book(String title)
    {
        this.title=title;
    }
    public void print(){System.out.println(title);}
    public void addAuthor(Author nume)
    {
        au.add(nume);
    }
    public int createChapter(String nume)
    { Chapter a = new Chapter();
        a.name=nume;
        ch.add(a);
        return ch.indexOf(a);
    }
    public Chapter getChapter(int nr)
    {
        return ch.get(nr);
    }
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", ch=" + ch +
                ", au=" + au +
                ", tb=" + tb +
                '}';
    }

}
