package ro.uvt.info.designpatternslab2023.models;

import java.util.ArrayList;
import java.util.List;

public class TableOfContents implements Element, Visitee{
     List<String> entries = new ArrayList<>();

    public void addEntry(String s, int page) {
        entries.add(s);
        System.out.printf("%-50s %d%n",s, page);
        }

//    public void printTableOfContents() {
//        System.out.println("Table of Contents:");
//        for (: entries) {
//            System.out.printf("%-50s %d%n", entry.getContent(), entry.getPage());
//        }
//    }
    @Override
    public void print() {
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
        visitor.visitTableOfContents(this);
    }
}
