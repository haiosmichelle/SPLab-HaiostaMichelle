package ro.uvt.info.designpatternslab2023;

import java.util.ArrayList;
import java.util.List;

public class Section implements Element {
    public String title;
    public List<Element> el = new ArrayList<>();

    public Section(String title) {
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println(title);
        for (Element e : el) {
            e.print();
        }
    }

    @Override
    public void add(Element a) {
        el.add(a);
    }

    @Override
    public Element get(int nr) {
        return null;
    }

    @Override
    public void remove(Element a) {

    }
}
