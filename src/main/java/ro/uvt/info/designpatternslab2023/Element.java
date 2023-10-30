package ro.uvt.info.designpatternslab2023;

import java.util.ArrayList;
import java.util.List;

public interface Element {

     void print();

     void add(Element a);

     Element get(int nr);

    void remove(Element a);

}
