package ro.uvt.info.designpatternslab2023.models;

public class BookStatistics  implements  Visitor{
 private static int nr_Image = 0;
 private static int nr_Table = 0;
 private static int nr_Paragraph = 0;

 public int getNr_Image(){
     return nr_Image;
 }
 public int getNr_Table(){
        return nr_Table;
    }
    public int getNr_Paragraph(){
        return nr_Paragraph;
    }

    @Override
    public void visitBook(Book book) {

    }

    @Override
    public void visitSection(Section section) {

    }

    @Override
    public void visitTableOfContents(TableOfContents table) {

    }

    @Override
    public void visitParagraph(Paragraph paragraph) {
    nr_Paragraph++;
    }

    @Override
    public void visitImageProxy(ImageProxy imageProxy) {
    nr_Image++;
    }

    @Override
    public void visitImage(Image image) {
   nr_Image++;
    }

    @Override
    public void visitTable(Table table) {
    nr_Table++;
    }

    @Override
    public void saveToJson(String filename) {

    }

    public void printStatistics() {
        System.out.println("Book Statistics:");
        System.out.println("*** Number of images: " + nr_Image);
        System.out.println("*** Number of tables: " + nr_Table);
        System.out.println("*** Number of paragraphs: " + nr_Paragraph);
    }
}
