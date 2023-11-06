package ro.uvt.info.designpatternslab2023;

import java.awt.*;

public class ImageProxy implements Picture,Element{
    public String url;
    public Dimension dim;
    Image realImage = null;
    public ImageProxy(String url)
    {
        this.url=url;
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
}
