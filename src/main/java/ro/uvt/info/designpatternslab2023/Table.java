package ro.uvt.info.designpatternslab2023;

public class Table {
    public String title;
    public Table(String title)
    {
        this.title=title;
    }

    @Override
    public String toString() {
        return "Table{" +
                "title='" + title + '\'' +
                '}';
    }

    public Table()
    {
        this.title="";
    }
    public void print()
    {
        System.out.println(title);
    }
}
