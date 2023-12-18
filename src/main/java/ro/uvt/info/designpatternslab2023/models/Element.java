package ro.uvt.info.designpatternslab2023.models;

public interface Element extends Visitee{

     void print();

     void add(Element a);

     Element get(int nr);

    void remove(Element a);

}
