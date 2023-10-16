package ro.uvt.info.designpatternslab2023;

import java.util.ArrayList;
import java.util.List;

public class SubChapter {
  public String name;
  public List<Image> image= new ArrayList<Image>();
  public List<Paragraph> paragraph= new ArrayList<Paragraph>();
  public List<Table> table= new ArrayList<Table>();
  public SubChapter() {
    this.name="";
  }

  @Override
  public String toString() {
    return "SubChapter{" +
            "name='" + name + '\'' +
            ", image=" + image +
            ", paragraph=" + paragraph +
            ", table=" + table +
            '}';
  }

  public SubChapter(String nume)
  {
      this.name=name;
  }
  public void createNewParagraph(String pr)
  {Paragraph a= new Paragraph();
    a.text=pr;
    paragraph.add(a);
  }
  public void createNewImage(String img)
  { Image a= new Image();
    a.ImageName=img;
    image.add(a);
  }
  public void createNewTable(String tbl)
  { Table a=new Table();
    a.title=tbl;
    table.add(a);
  }
  public void print()
  {
    System.out.println("Subchapter : "+ this.name);
    for(Paragraph i: paragraph)
    {
      System.out.println("Paragraph : "+ i.text);
    }
    for(Image i: image)
    {
      System.out.println("Image with name:"+ i.ImageName);
    }
    for(Table i: table)
    {
      System.out.println("Table with title: "+ i.title);
    }

  }
}
