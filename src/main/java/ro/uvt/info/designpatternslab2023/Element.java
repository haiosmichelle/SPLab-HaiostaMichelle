package ro.uvt.info.designpatternslab2023;

import java.util.ArrayList;
import java.util.List;

public interface Element {
    public void print();

    public void add(Element a);

    public Element get(int nr);

    public void remove(Element a);

}
