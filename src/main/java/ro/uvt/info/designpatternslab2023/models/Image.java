package ro.uvt.info.designpatternslab2023.models;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Image implements Element,Picture, Visitee {
   private String ImageName;

    public void setImageName(String imageName) {
        ImageName = imageName;
    }

    public String getImageName() {
        return ImageName;
    }

    public Image(String name) {
        ImageName = name;
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void print() {
        System.out.println("Image with name : " +this.ImageName);
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
    public String url() {
        return null;
    }

    @Override
    public Dimension dim() {
        return null;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitImage(this);
    }
}
