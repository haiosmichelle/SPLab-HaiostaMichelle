package ro.uvt.info.designpatternslab2023;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Chapter {
    public String name;
    public List<SubChapter> subChapterList= new ArrayList<>();
    public Chapter(String name)
    {
        this.name=name;
    }
    public Chapter() {
        this.name ="";
    }
    public void print(){System.out.println(name);}
    public int createSubChapter(String nume)
    {
        SubChapter a=new SubChapter();
        a.name=nume;
        subChapterList.add(a);
        return subChapterList.indexOf(a);
    }
    public SubChapter getSubChapter(int nr)
    {
        return subChapterList.get(nr);
    }
    @Override
    public String toString() {
        return "Chapter{" +
                "name='" + name + '\'' +
                ", subChapterList=" + subChapterList +
                '}';
    }
}
