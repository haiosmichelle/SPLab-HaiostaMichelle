package ro.uvt.info.designpatternslab2023;

public class Paragraph implements Element {
    public String text;

    public Paragraph(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Paragraph{" +
                "text='" + text + '\'' +
                '}';
    }

    public void print() {
        System.out.println("Paragraph: " + text);
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
}
