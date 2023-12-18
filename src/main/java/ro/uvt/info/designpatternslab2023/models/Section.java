package ro.uvt.info.designpatternslab2023.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Section extends BaseElement implements Visitee {
    @Id
    int id;
    public String title;
    @OneToMany(targetEntity = BaseElement.class)
    public List<Element> el = new ArrayList<>();
     public Section(){}
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

    @Override
    public void accept(Visitor visitor) {
        visitor.visitSection(this);
//        for (Visitee element : vis) {
//            element.accept(visitor);
//    }
    }
}
