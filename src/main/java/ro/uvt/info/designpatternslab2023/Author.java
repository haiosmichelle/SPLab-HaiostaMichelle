package ro.uvt.info.designpatternslab2023;

public class Author {
    public String name;
    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                '}';
    }

    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void print()
    {
        System.out.println(name);
    }
}
