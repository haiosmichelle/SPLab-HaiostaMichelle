package ro.uvt.info.designpatternslab2023.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import ro.uvt.info.designpatternslab2023.services.AlignStrategy;
public class Paragraph extends BaseElement implements  Visitee {
    int id;
    public String text;

    public AlignStrategy textAlignment;

    public Paragraph(String text) {
        this.text = text;
    }

    public Paragraph() {

    }

    public String getText() {
        return text;
    }


    public void print() {
        System.out.println("Paragraph: " + text);
    }
   public void setAlignStrategy(AlignStrategy a)
   {
    Context context=new Context(1,58);
    a.render(text,context);
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
        visitor.visitParagraph(this);
    }
}
