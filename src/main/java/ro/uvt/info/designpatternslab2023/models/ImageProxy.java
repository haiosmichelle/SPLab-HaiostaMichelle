package ro.uvt.info.designpatternslab2023.models;

import jakarta.persistence.*;

import java.awt.*;
@Entity
public class ImageProxy extends BaseElement implements Picture, Visitee{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    public String url;
    public Dimension dim;
    @Transient
    Image realImage = null;
    public ImageProxy(String url)
    {
        this.url=url;
    }

    public ImageProxy() {

    }

    private Image loadImage() {

        if (realImage == null) {
            realImage = new Image(url);
        }
        return realImage;
    }

    @Override
    public String url() {
        return null;
    }

    @Override
    public Dimension dim() {
        return null;
    }

    @Override
    public void print() {
        loadImage().print();
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

    @Override
    public void accept(Visitor visitor) {
        visitor.visitImageProxy(this);
    }
}
