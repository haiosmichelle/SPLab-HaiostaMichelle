package ro.uvt.info.designpatternslab2023.books;

public interface Element {

     void print();

     void add(Element a);

     Element get(int nr);

    void remove(Element a);

}
