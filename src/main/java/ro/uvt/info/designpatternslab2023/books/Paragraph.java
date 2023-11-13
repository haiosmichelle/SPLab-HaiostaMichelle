package ro.uvt.info.designpatternslab2023.books;

public class Paragraph implements Element {
    public String text;
    public AlignStrategy textAlignment;

    public Paragraph(String text) {
        this.text = text;
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
}
