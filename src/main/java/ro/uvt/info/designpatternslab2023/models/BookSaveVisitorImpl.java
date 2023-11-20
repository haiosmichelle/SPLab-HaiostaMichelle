package ro.uvt.info.designpatternslab2023.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class BookSaveVisitorImpl implements BookSaveVisitor{
    private ArrayNode jsonElements = new ObjectMapper().createArrayNode();
    @Override
    public void saveToJson(String filename) {
        try {
            new ObjectMapper().writeValue(new File(filename), jsonElements);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void saveElementToJson(String type, String data) {
        ObjectNode elementNode = new ObjectMapper().createObjectNode();
        elementNode.put("type", type);
        elementNode.put("data", data);
        jsonElements.add(elementNode);
    }
    @Override
    public void visitBook(Book book) {
        saveElementToJson(book.getClass().getSimpleName(), book.title);
    }

    @Override
    public void visitSection(Section section) {
        ObjectNode sectionNode = new ObjectMapper().createObjectNode();
        sectionNode.put("type", section.getClass().getSimpleName());
        sectionNode.put("title", section.title);

        ArrayNode elementsNode = new ObjectMapper().createArrayNode();
        for (Visitee element : section.vis) {
            if (element instanceof Paragraph || element instanceof ImageProxy ||
                    element instanceof Image || element instanceof Table) {
                element.accept(this);
                elementsNode.add(jsonElements.get(jsonElements.size() - 1));
            }
    }
        sectionNode.set("elements", elementsNode);
        jsonElements.add(sectionNode);}

    @Override
    public void visitTableOfContents(TableOfContents table) {
    }

    @Override
    public void visitParagraph(Paragraph paragraph) {
        saveElementToJson(paragraph.getClass().getSimpleName(), paragraph.getText());
    }

    @Override
    public void visitImageProxy(ImageProxy imageProxy) {
        saveElementToJson(imageProxy.getClass().getSimpleName(), imageProxy.url);
    }

    @Override
    public void visitImage(Image image) {
        saveElementToJson(image.getClass().getSimpleName(), image.ImageName);
    }

    @Override
    public void visitTable(Table table) {
        saveElementToJson(table.getClass().getSimpleName(), table.title);
    }
}
