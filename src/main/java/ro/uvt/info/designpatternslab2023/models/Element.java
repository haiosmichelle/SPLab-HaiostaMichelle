package ro.uvt.info.designpatternslab2023.models;

public interface Element extends Visitee{

     void print();
    void setType(String type);

     void add(Element a);

     Element get(int nr);
    String getType();
    void remove(Element a);

}
