package ro.uvt.info.designpatternslab2023;

public class Paragraph {
    public String text;
    public Paragraph(String text)
    {
        this.text=text;
    }

    @Override
    public String toString() {
        return "Paragraph{" +
                "text='" + text + '\'' +
                '}';
    }

    public Paragraph()
    {
        this.text="";
    }
    public void print()
    {
        System.out.println(text);
    }
}
