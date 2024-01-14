package ro.uvt.info.designpatternslab2023.models;


import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;
@Entity

public class Section extends BaseElement implements  Visitee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    public String getTitle() {
        return title;
    }

    public List<Element> getEl() {
        return el;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEl(List<Element> el) {
        this.el = el;
    }

    @OneToMany(targetEntity = BaseElement.class)
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
    public void setType(String type) {

    }

    public Section(){}
    @Override
    public void add(Element a) {
        el.add(a);
    }

    @Override
    public Element get(int nr) {
        return null;
    }

    @Override
    public String getType() {
        return "section";
    }

    @Override
    public void remove(Element a) {

    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitSection(this);
//        for (Visitee element : vis) {
//            element.accept(visitor);
//    }
    }
}
