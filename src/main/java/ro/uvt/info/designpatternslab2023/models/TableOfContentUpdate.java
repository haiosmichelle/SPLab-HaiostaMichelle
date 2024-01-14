package ro.uvt.info.designpatternslab2023.models;

public class TableOfContentUpdate implements Visitor{
    private TableOfContents tableOfContents = new TableOfContents();
    private static int currentPage = 0;
    @Override
    public void visitBook(Book book) {
        System.out.println("TableOfContent");
    }

    @Override
    public void visitSection(Section section) {
        tableOfContents.addEntry(section.getTitle(), currentPage+1);
            for (Element element : section.el) {
            element.accept(this);
        }
    }

    @Override
    public void visitTableOfContents(TableOfContents table) {

    }

    @Override
    public void visitParagraph(Paragraph paragraph) {
        currentPage++;
    }

    @Override
    public void visitImageProxy(ImageProxy imageProxy) {
        currentPage++;
    }

    @Override
    public void visitImage(Image image) {
        currentPage++;
    }

    @Override
    public void visitTable(Table table) {
        currentPage++;
    }

    @Override
    public void saveToJson(String filename) {

    }

    public Visitee getToC() {
        return tableOfContents;
    }
}
