package ro.uvt.info.designpatternslab2023;

public class Image {
    public String ImageName;
    public Image(String ImageName)
    {
        this.ImageName=ImageName;
    }

    @Override
    public String toString() {
        return "Image{" +
                "ImageName='" + ImageName + '\'' +
                '}';
    }

    public Image()
    {
        this.ImageName="";
    }
    public void print(){
        System.out.println(ImageName);
    }
}
